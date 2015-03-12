package ua.com.goit.gojava.andriidnikitin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import ua.com.goit.gojava.andriidnikitin.dao.util.MyShopDAOException;
import ua.com.goit.gojava.andriidnikitin.model.Good;
import ua.com.goit.gojava.andriidnikitin.model.GoodType;

public class PostgresqlGoodDAO implements GenericDAO<Good> {
	private Connection connection;

    public PostgresqlGoodDAO(Connection connection) {
        this.connection = connection;
    }

	@Override
	public Integer create(Good arg) throws MyShopDAOException {
		String sql = "INSERT INTO \"Good\"(name, type_id) VALUES ( ?, ?) RETURNING good_id;";
	    PreparedStatement stm;
	    Integer typeId;
		try {
			stm = connection.prepareStatement(sql);		
		    stm.setString(1, arg.getName());
		    GoodType parent = arg.getType();
		    stm.setInt(2, parent.getId());
		    ResultSet rs = stm.executeQuery();
		    rs.next();
		    typeId = rs.getInt("good_id");	
		    return typeId;
		} catch (SQLException e) {
			throw new MyShopDAOException(e);
		}	    
	}

	//TODO - finish
	@Override
	public Good read(Integer key) throws MyShopDAOException {
		if (key == null){
			return null;
		}
		Good result = new Good();
		GoodTypeRecord temp = readRecord(key);
		Integer typeID =  temp.getParentId();
		result.setId(temp.getId());
		result.setName(temp.getName());
		result.setType(null);
		if ((typeID != null) && (typeID != 0)) {			
		//	result.setType(read(typeID));
		}
		return result;
	}
	
	private GoodTypeRecord readRecord(Integer key) throws MyShopDAOException {
        GoodTypeRecord rec = null;
		String name = null;
	    Integer typeId = null;
	    Integer parentId = null;
		try {
	        String sql = "SELECT * FROM \"Good\" WHERE good_id=?;";
	        PreparedStatement stm = connection.prepareStatement(sql);
	        stm.setInt(1, key);
	        ResultSet rs = stm.executeQuery();
	        rs.next();
	        name = rs.getString("name");
	        typeId = rs.getInt("good_id");
	        try { 
	        	parentId = rs.getInt("type_id");
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
	public void update(Good unit) throws MyShopDAOException {
		try {
			int key = unit.getId();
			GoodType type = unit.getType();
			Integer parentKey = type.getId();				
			String name = unit.getName();
			String sql;
			PreparedStatement stm;
			if (parentKey!= null){
				sql = "UPDATE \"Good\" SET name=?, type_id=? WHERE good_id = ?;";	
			    stm = connection.prepareStatement(sql);
			    stm.setString(1, name);
			    stm.setInt(2, parentKey);
			    stm.setInt(3, key);
			}
			else {
				sql = "UPDATE \"Good\" SET name=? WHERE good_id = ?;";		
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
	public void delete(Good unit) throws MyShopDAOException {
		try {
			int key = unit.getId();
			String sql = "DELETE FROM \"Good\" WHERE good_id = ?;";
		    PreparedStatement stm = connection.prepareStatement(sql);
		    stm.setInt(1, key);
		    stm.executeUpdate();		
	    } catch (SQLException e) {
			throw new MyShopDAOException(e);
		}

	}

	@Override
	public List<Good> getAll() throws MyShopDAOException {
		try {
	        String sql = "SELECT \"good_id\" FROM \"Good\"";
	        PreparedStatement stm = connection.prepareStatement(sql);
	        ResultSet rs = stm.executeQuery();
	        List<Integer> listInts = new ArrayList<Integer>();
	        List<Good> list = new ArrayList<Good>();
	        while (rs.next()) {
	            Integer typeId = rs.getInt("good_id");
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
	
	//TODO - delete?
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
