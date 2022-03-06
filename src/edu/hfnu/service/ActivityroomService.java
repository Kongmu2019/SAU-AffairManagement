package edu.hfnu.service;

import java.sql.SQLException;
import java.util.List;

import edu.hfnu.DBUtilsDao.ActivityroomDao;
import edu.hfnu.model.ActivityroomTable;

public class ActivityroomService {
	ActivityroomDao dao = new ActivityroomDao();
	
	public boolean updateReason(int id,String reason) throws SQLException{
		return dao.updateReason(id, reason);
	}
	
	public boolean removeReason(int id) throws SQLException{
		return dao.removeReason(id);
	}
	
	public boolean insert(ActivityroomTable obj) throws SQLException{
		return dao.insert(obj);
	}
	
	public boolean delete(String clubname) throws SQLException{
		return dao.delete(clubname);
	}
	
	public List<ActivityroomTable> findAll() throws SQLException{
		return dao.findAll();
	}
	
	public int countAll() throws SQLException{
		return dao.countAll();
	}
	
	public List<ActivityroomTable> findAll(String status) throws SQLException{
		return dao.findAll(status);
	}
	
	public int countAll(String status) throws SQLException{
		return dao.countAll(status);
	}
	
	public boolean updateStatus(String clubname,String status) throws SQLException {
		return dao.updateStatus(clubname, status);
	}
}
