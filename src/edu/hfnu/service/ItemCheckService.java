package edu.hfnu.service;

import java.sql.SQLException;
import java.util.List;

import edu.hfnu.DBUtilsDao.ItemCheckDao;
import edu.hfnu.model.ItemCheckTable;

public class ItemCheckService {
	ItemCheckDao dao = new ItemCheckDao();
	
	
	public boolean updateReason(int id,String reason) throws SQLException{
		return dao.updateReason(id, reason);
	}
	
	public boolean removeReason(int id) throws SQLException{
		return dao.removeReason(id);
	}
	
	public boolean insert(ItemCheckTable obj) throws SQLException {
		return dao.insert(obj);
	}
	
	public boolean delete(int id) throws SQLException {
		return dao.delete(id);
	}
	
	public List<ItemCheckTable> findAllForTeacher(String status) throws SQLException{
		return dao.findAllForTeacher(status);
	}
	
	public int countAll(String status) throws SQLException {
		return dao.countAll(status);
	}
	
	public boolean updateStatusForTeacher(int id,String status) throws SQLException {
		return dao.updateStatusForTeacher(id, status);
	}
	
	public List<ItemCheckTable> findAll() throws SQLException{
		return dao.findAll();
	}
	
	public int countAll() throws SQLException{
		return dao.countAll();
	}
}
