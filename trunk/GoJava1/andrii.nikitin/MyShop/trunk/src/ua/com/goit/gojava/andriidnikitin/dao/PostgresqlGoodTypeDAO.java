package ua.com.goit.gojava.andriidnikitin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ua.com.goit.gojava.andriidnikitin.dao.util.MyShopDAOException;
import ua.com.goit.gojava.andriidnikitin.model.GoodType;

public class PostgresqlGoodTypeDAO implements GenericDAO<GoodType> {
	
	private Connection connection;

    public PostgresqlGoodTypeDAO(Connection connection) {
        this.connection = connection;
    }

	@Override
	public Integer create(GoodType arg) throws MyShopDAOException {
		String sql = "INSERT INTO \"GoodType\"(name, parent_id) VALUES ( ?, ?) RETURNING type_id;";
	    PreparedStatement stm;
	    Integer typeId;
		try {
			stm = connection.prepareStatement(sql);		
		    stm.setString(1, arg.getName());
		    GoodType parent = arg.getParent();
		    stm.setInt(2, parent.getId());
		    ResultSet rs = stm.executeQuery();
		    rs.next();
		    typeId = rs.getInt("type_id");	
		    return typeId;
		} catch (SQLException e) {
			throw new MyShopDAOException(e);
		}	    
	}

	@Override
	public GoodType read(Integer key) throws MyShopDAOException {
		if (key == null){
			return null;
		}
		GoodType result = new GoodType();
		GoodTypeRecord temp = readRecord(key);
		Integer parentID =  temp.getParentId();
		result.setId(temp.getId());
		result.setName(temp.getName());
		result.setParent(null);
		if ((parentID != null) && (parentID != 0)) {			
			result.setParent(read(parentID));
		}
		return result;
	}
	
	private GoodTypeRecord readRecord(Integer key) throws MyShopDAOException {
        GoodTypeRecord rec = null;
		String name = null;
	    Integer typeId = null;
	    Integer parentId = null;
		try {
	        String sql = "SELECT * FROM \"GoodType\" WHERE type_id=?;";
	        PreparedStatement stm = connection.prepareStatement(sql);
	        stm.setInt(1, key);
	        ResultSet rs = stm.executeQuery();
	        rs.next();
	        name = rs.getString("name");
	        typeId = rs.getInt("type_id");
	        try { 
	        	parentId = rs.getInt("parent_id");
	        } catch (Exception e){
	        	parentId = null;
	        }
	        rec = new GoodTypeRecord();
	        rec.setId(typeId);
	        rec.setName(name);
	        rec.setParentId(parentId);	 
		} catch (SQLException e) {
			if ((typeId == null)  || (name == null)){		
				throw new MyShopDAOException(e);		
			} 
		}		       
        return rec;		
	}

	@Override
	public void update(GoodType unit) throws MyShopDAOException {
		try {
			int key = unit.getId();
			GoodType parent = unit.getParent();
			Integer parentKey = parent.getId();				
			String name = unit.getName();
			String sql;
			PreparedStatement stm;
			if (parentKey!= null){
				sql = "UPDATE \"GoodType\" SET name=?, parent_id=? WHERE type_id = ?;";	
			    stm = connection.prepareStatement(sql);
			    stm.setString(1, name);
			    stm.setInt(2, parentKey);
			    stm.setInt(3, key);
			}
			else {
				sql = "UPDATE \"GoodType\" SET name=? WHERE type_id = ?;";		
			    stm = connection.prepareStatement(sql);
			    stm.setString(1, name);
			    stm.setInt(2, key);	
			}
		    stm.executeUpdate();	
	    } catch (SQLException e) {
			throw new MyShopDAOException(e);
		}

	}

	@Override
	public void delete(GoodType unit) throws MyShopDAOException {
		try {
			int key = unit.getId();
			String sql = "DELETE FROM \"GoodType\" WHERE type_id = ?;";
		    PreparedStatement stm = connection.prepareStatement(sql);
		    stm.setInt(1, key);
		    stm.executeUpdate();		
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
	        List<Integer> listInts = new ArrayList<Integer>();
	        List<GoodType> list = new ArrayList<GoodType>();
	        while (rs.next()) {
	            Integer typeId = rs.getInt("type_id");
	            listInts.add(typeId);
	        }
	        for (Integer id: listInts){

	            list.add(read(id));
	        }
	        return list;
        } catch (SQLException e) {
			throw new MyShopDAOException(e);
		}
	}
	
	private class GoodTypeRecord{
		private String name;
		private Integer id;
		private Integer parentId;
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public Integer getParentId() {
			return parentId;
		}
		public void setParentId(Integer parentId) {
			this.parentId = parentId;
		}
		
	}

}
