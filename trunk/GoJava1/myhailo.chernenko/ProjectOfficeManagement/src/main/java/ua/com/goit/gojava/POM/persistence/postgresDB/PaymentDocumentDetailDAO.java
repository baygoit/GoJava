package ua.com.goit.gojava.POM.persistence.postgresDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Currency;
import java.util.List;

import org.apache.log4j.Logger;

import ua.com.goit.gojava.POM.dataModel.POMDataModelException;
import ua.com.goit.gojava.POM.dataModel.common.Money;
import ua.com.goit.gojava.POM.dataModel.documents.PaymentDocumentDetail;
import ua.com.goit.gojava.POM.persistence.postgresDB.abstraction.AbstractDAO;

public class PaymentDocumentDetailDAO extends AbstractDAO<PaymentDocumentDetail> {
	
	private static final String CLASS_NAME = "Payment Document Detail"; 
	private static final String CLASS_TABLE = "payment_document_details"; 
	private static final Logger LOG = Logger.getLogger(PaymentDocumentDetailDAO.class);
	
	private ProjectDAO projectDAO;
	private ProjectStageDAO projectStageDAO;
	private CostItemDAO costItemDAO;
	private PaymentDocumentDAO paymentDocumentDAO;
	
	@Override
	protected String getClassName() {
		
		return CLASS_NAME;
	}

	@Override
	protected String getClassTable() {

		return CLASS_TABLE;
	}

	@Override
	protected Logger getLog() {
		
		return LOG;	
	}

	@Override
	protected PaymentDocumentDetail getNewObject() {

		return new PaymentDocumentDetail();	
	}

	@Override
	protected PaymentDocumentDetail getObjectFromRS(ResultSet rs) throws SQLException, POMDataModelException {
		
		PaymentDocumentDetail paymentDocumentDetail = getNewObject();
		
		paymentDocumentDetail.setId(rs.getLong("ID"));
		String currencyCode = rs.getString("currency");
		if(currencyCode != null) {
			Currency currency = Currency.getInstance(currencyCode);
			paymentDocumentDetail.setSum(new Money(rs.getDouble("sum"),currency));
		}
		
		long projectId = rs.getLong("project_id");
		if(projectId != 0) {
			paymentDocumentDetail.setProject(projectDAO.retrieveById(projectId));
		}
		long projectStageId = rs.getLong("project_stage_id");
		if(projectStageId != 0) {
			paymentDocumentDetail.setProjectStage(projectStageDAO.retrieveById(projectStageId));
		}
		long costItemId = rs.getLong("cost_item_id");
		if(costItemId != 0) {
			paymentDocumentDetail.setCostItem(costItemDAO.retrieveById(costItemId));
		}
		long docId = rs.getLong("doc_id");
		if(projectId != 0) {
			paymentDocumentDetail.setDoc(paymentDocumentDAO.retrieveById(docId));
		}
		
		paymentDocumentDetail.setRowNumber(rs.getLong("row_number"));
		
		return paymentDocumentDetail;
		
	}

	@Override
	protected void setId(PaymentDocumentDetail paymentDocumentDetail, long id) {

		paymentDocumentDetail.setId(id);	
	}

	@Override
	protected Long getId(PaymentDocumentDetail paymentDocumentDetail) {
		
		return paymentDocumentDetail.getId();
	}

	@Override
	protected PreparedStatement getCreateStatement(Connection connection, PaymentDocumentDetail paymentDocumentDetail)
			throws SQLException {
		
		String insertTableSQL = "INSERT INTO "+CLASS_TABLE+" ("
				+ " 	 project_id "
				+ " 	,project_stage_id "
				+ " 	,cost_item_id "
				+ " 	,currency "
				+ " 	,sum "
				+ " 	,doc_id "
				+ " 	,row_number "
				+ "	   ) "
				+ " VALUES (?,?,?,?,?,?,?) "
				+ "	RETURNING ID "
			;

		PreparedStatement statement = connection.prepareStatement(insertTableSQL);
		statement.setLong(1, paymentDocumentDetail.getProject().getId());
		statement.setLong(2, paymentDocumentDetail.getProjectStage().getId());
		statement.setLong(3, paymentDocumentDetail.getCostItem().getId());
		statement.setString(4, paymentDocumentDetail.getCurrency().getCurrencyCode());
		statement.setBigDecimal(5, paymentDocumentDetail.getSum().getValue());
		statement.setLong(6, paymentDocumentDetail.getDoc().getId());
		statement.setLong(7, paymentDocumentDetail.getRowNumber());
		
		return statement;
	}

	@Override
	protected PreparedStatement getUpdateStatement(Connection connection, PaymentDocumentDetail paymentDocumentDetail)
			throws SQLException {

		String updateTableSQL = "UPDATE "+CLASS_TABLE
				+ " SET "
				+ " 	 project_id = ? "
				+ " 	,project_stage_id = ? "
				+ " 	,cost_item_id = ? "
				+ " 	,currency = ? "
				+ " 	,sum = ? "
				+ " 	,doc_id = ? "
				+ " 	,row_number = ? "
				+ "	WHERE ID = ? "
			;

		PreparedStatement statement = connection.prepareStatement(updateTableSQL);
		statement.setLong(1, paymentDocumentDetail.getProject().getId());
		statement.setLong(2, paymentDocumentDetail.getProjectStage().getId());
		statement.setLong(3, paymentDocumentDetail.getCostItem().getId());
		statement.setString(4, paymentDocumentDetail.getCurrency().getCurrencyCode());
		statement.setBigDecimal(5, paymentDocumentDetail.getSum().getValue());
		statement.setLong(6, paymentDocumentDetail.getDoc().getId());
		statement.setLong(7, paymentDocumentDetail.getDoc().getId());
		
		statement.setLong(8,  paymentDocumentDetail.getRowNumber());
		
		return statement;
		
	}

	public List<PaymentDocumentDetail> retrieveAllByDocId(long docId) throws POMDataModelException {

		List<PaymentDocumentDetail> resultList = new ArrayList<PaymentDocumentDetail>();
		
		ResultSet rs = null;
		PreparedStatement statement = null; 	
		Connection connection = getDBConnection();
		
		String selectTableSQL = "SELECT * FROM "+getClassTable()
							   +" WHERE doc_id = ? "
							   +" ORDER BY row_number"
								;
		
		try {

			statement = connection.prepareStatement(selectTableSQL);
			statement.setLong(1, docId);
			rs = statement.executeQuery();
			 
			while (rs.next()) {
				
				PaymentDocumentDetail tObject = getObjectFromRS(rs);
				
				resultList.add(tObject);
				
			}
			
		} catch (SQLException e) {
 
			getLog().error("Could not retrieve all "+getClassName()+"s by doc ID = "+docId+": "+e.getMessage(), e);
			throw new POMDataModelException("Could not retrieve all "+getClassName()+"s by doc ID: "+e.getMessage(), e);
 
		} finally {
 
			closeDBConnections(rs, statement, connection);
 
		}
		
		return resultList;
	
	}
	
	public ProjectDAO getProjectDAO() {
		return projectDAO;
	}

	public void setProjectDAO(ProjectDAO projectDAO) {
		this.projectDAO = projectDAO;
	}

	public ProjectStageDAO getProjectStageDAO() {
		return projectStageDAO;
	}

	public void setProjectStageDAO(ProjectStageDAO projectStageDAO) {
		this.projectStageDAO = projectStageDAO;
	}

	public CostItemDAO getCostItemDAO() {
		return costItemDAO;
	}

	public void setCostItemDAO(CostItemDAO costItemDAO) {
		this.costItemDAO = costItemDAO;
	}

	public PaymentDocumentDAO getPaymentDocumentDAO() {
		return paymentDocumentDAO;
	}

	public void setPaymentDocumentDAO(PaymentDocumentDAO paymentDocumentDAO) {
		this.paymentDocumentDAO = paymentDocumentDAO;
	}

}
