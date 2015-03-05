package ua.com.goit.gojava.andriidnikitin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ua.com.goit.gojava.andriidnikitin.model.Good;

public class PostgresqlGoodDao implements GenericDao<Good> {
	
	private final Connection connection;
	
	public PostgresqlGoodDao(Connection connection) {
        this.connection = connection;
    }
	
	@Override
	public Good create(Good parameter) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Good read(int key) throws MyShopDAOException  {
		try{
	        String sql = "SELECT * FROM shop.Good WHERE id = ?;";
	        PreparedStatement stm = connection.prepareStatement(sql);
	        stm.setInt(1, key);
	        ResultSet rs = stm.executeQuery();
	        rs.next();
	        Integer goodId = rs.getInt("id");
	        String name = rs.getString("name");
	        Integer typeId = rs.getInt("typeId");
	        Integer descriptionId =  rs.getInt("descriptionId");
	        return Good.factory(goodId, name, typeId, descriptionId);
		} catch (SQLException e) {
			throw new MyShopDAOException(e);
		}
	}

	@Override
	public void update(Good record) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Good record) throws MyShopDAOException  {
		try{
			int key = record.getId();
			String sql = "DELETE * FROM shop.Good WHERE id = ?;";
		    PreparedStatement stm = connection.prepareStatement(sql);
		    stm.setInt(1, key);
		    stm.executeQuery();
		} catch (SQLException e) {
			throw new MyShopDAOException(e);
		}
	}

	@Override
	public List<Good> getAll() throws MyShopDAOException  {
		try{
        String sql = "SELECT * FROM daotalk.Group;";
        PreparedStatement stm = connection.prepareStatement(sql);
        ResultSet rs = stm.executeQuery();
        List<Good> list = new ArrayList<Good>();
        while (rs.next()) {
            Integer goodId = rs.getInt("id");
            String name = rs.getString("name");
            Integer typeId = rs.getInt("typeId");
            Integer descriptionId =  rs.getInt("descriptionId");
            Good good = Good.factory(goodId, name, typeId, descriptionId);
            list.add(good);
        }
        return list;
		} catch (SQLException e) {
			throw new MyShopDAOException(e);
		}
	}	

}
