package edu.hfnu.service;

import java.sql.SQLException;
import java.util.List;

import edu.hfnu.DBUtilsDao.ItemsDao;
import edu.hfnu.model.ItemsTable;

public class ItemsService {
	ItemsDao dao = new ItemsDao();
	
	public boolean insert(ItemsTable obj) throws SQLException{
		return dao.insert(obj);
	}
	
	public boolean delete(String itemid) throws SQLException{
		return dao.delete(itemid);
	}
	
	public List<ItemsTable> findAll() throws SQLException{
		return dao.findAll();
	}
	
	public int countAll() throws SQLException{
		return dao.countAll();
	}
	
	public boolean updateInventory(int inventory,String itemid) throws SQLException{
		return dao.updateInventory(inventory, itemid);
	}
}
