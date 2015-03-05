package ua.com.goit.gojava.andriidnikitin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ua.com.goit.gojava.andriidnikitin.model.GoodType;

public class PostgresqlGoodTypeDao implements GenericDao<GoodType> {
	
	private final Connection connection;
	
	//TODO - connect with data source
	static public PostgresqlGoodTypeDao getInstance(){
		CatalogDaoFactory<GoodType> daoFactory = new PostgresqlDaoFactory<GoodType>();
		try {
			Connection connection = daoFactory.getConnection();
			return new PostgresqlGoodTypeDao(connection);
		} catch (SQLException e) {
			System.err.println(e);	
			return null;
		}
		
	}
	
	public PostgresqlGoodTypeDao(Connection connection) {
        this.connection = connection;
    }
	
	@Override
	public GoodType create(GoodType arg) throws MyShopDAOException {
		String sql = "INSERT INTO \"GoodType\" VALUES ( ?, ?) RETURNING type_id;";
	    PreparedStatement stm;
	    Integer typeId;
		try {
			stm = connection.prepareStatement(sql);		
		    stm.setString(1, arg.getName());
		    GoodType parent = arg.getParent();
		    System.out.println("parent id is " + parent.getId());
		    stm.setInt(2, parent.getId());
		    ResultSet rs = stm.executeQuery();
		    rs.next();
		    typeId = rs.getInt("type_id");	
		    System.out.println(typeId);
		    return read(typeId);
		} catch (SQLException e) {
			throw new MyShopDAOException(e);
		}	    
	}

	@Override
	public GoodType read(int key) throws MyShopDAOException {
		String name = null;
	    Integer typeId = null;
	    Integer parentId = null;
		try {
	        String sql = "SELECT * FROM \"GoodType\" WHERE type_id = ?;";
	        PreparedStatement stm = connection.prepareStatement(sql);
	        stm.setInt(1, key);
	        ResultSet rs = stm.executeQuery();
	        rs.next();
	        name = rs.getString("name");
	        typeId = rs.getInt("type_id");
	        parentId = rs.getInt("parent_id");
	        sql = "SELECT * FROM \"GoodType\" WHERE type_id = ?;";
	        stm = connection.prepareStatement(sql);
	        stm.setInt(1, parentId);
	        return GoodType.factory(typeId, name, parentId);
		} catch (SQLException e) {
			if ((typeId == null)  || (name == null)){		
				throw new MyShopDAOException(e);		
			} 
		}	
		return null;	        
	}

	@Override
	public void update(GoodType record) throws MyShopDAOException {
		try {
			int key = record.getId();
			GoodType parent = record.getParent();
			int parentKey = parent.getId();				
			String name = record.getName();
			String sql = "UPDATE \"GoodType\" SET name=? parent_id=? WHERE typ_id = ?;";
		    PreparedStatement stm = connection.prepareStatement(sql);
		    stm.setString(1, name);
		    stm.setInt(2, parentKey);
		    stm.setInt(3, key);
		    stm.executeQuery();	
	    } catch (SQLException e) {
			throw new MyShopDAOException(e);
		}
	}

	@Override
	public void delete(GoodType record) throws MyShopDAOException {
		try {
			int key = record.getId();
			String sql = "DELETE FROM \"GoodType\" WHERE type_id = ?;";
		    PreparedStatement stm = connection.prepareStatement(sql);
		    stm.setInt(1, key);
		    stm.executeQuery();		
	    } catch (SQLException e) {
			throw new MyShopDAOException(e);
		}
	}

	@Override
	public List<GoodType> getAll() throws MyShopDAOException {
		try {
	        String sql = "SELECT * FROM \"GoodType\"";
	        PreparedStatement stm = connection.prepareStatement(sql);
	        ResultSet rs = stm.executeQuery();
	        List<GoodType> list = new ArrayList<GoodType>();
	        while (rs.next()) {
	            Integer goodId = rs.getInt("type_id");
	            String name = rs.getString("name");
	            Integer parentId = rs.getInt("parent_id");
	            GoodType good = GoodType.factory(goodId, name, parentId);
	            list.add(good);
	        }
	        return list;
        } catch (SQLException e) {
			throw new MyShopDAOException(e);
		}
	}

}
