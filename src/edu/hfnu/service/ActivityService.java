package edu.hfnu.service;

import java.sql.SQLException;
import java.util.List;

import edu.hfnu.DBUtilsDao.ActivityDao;
import edu.hfnu.model.ActivityTable;

public class ActivityService {
	ActivityDao dao = new ActivityDao();
	
	public boolean updateReason(int id,String reason) throws SQLException{
		return dao.updateReason(id, reason);
	}
	
	public boolean removeReason(int id) throws SQLException{
		return dao.removeReason(id);
	}
	
	public boolean insert(ActivityTable obj) throws SQLException{
		return dao.insert(obj);
	}
	
	public boolean delete(String name) throws SQLException{
		return dao.delete(name);
	}
	
	
	public List<ActivityTable> findAll() throws SQLException{
		return dao.findAll();
	}
	
	public int countAll() throws SQLException{
		return dao.countAll();
	}
	
	public List<ActivityTable> findAll(String status) throws SQLException{
		return dao.findAll(status);
	}
	
	public int countAll(String status) throws SQLException{
		return dao.countAll(status);
	}
	
	public boolean updateStatus(String name,String status) throws SQLException {
		return dao.updateStatus(name, status);
	}
}
