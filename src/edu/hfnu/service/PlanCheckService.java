package edu.hfnu.service;

import java.sql.SQLException;
import java.util.List;

import edu.hfnu.DBUtilsDao.PlanCheckDao;
import edu.hfnu.model.PlanCheckTable;

public class PlanCheckService {
	PlanCheckDao dao = new PlanCheckDao();
	
	public boolean updateReason(int id,String reason) throws SQLException{
		return dao.updateReason(id, reason);
	}
	
	public boolean removeReason(int id) throws SQLException{
		return dao.removeReason(id);
	}
	
	public boolean insert(PlanCheckTable obj) throws SQLException {
		return dao.insert(obj);
	}
	
	public boolean delete(int id) throws SQLException {
		return dao.delete(id);
	}
	
	public List<PlanCheckTable> findAllForTeacher(String status) throws SQLException{
		return dao.findAllForTeacher(status);
	}
	
	public int countAll(String status) throws SQLException {
		return dao.countAll(status);
	}
	
	public List<PlanCheckTable> findAll() throws SQLException{
		return dao.findAll();
	}
	
	public int countAll() throws SQLException {
		return dao.countAll();
	}
	
	public boolean updateStatusForTeacher(int id,String status) throws SQLException{
		return dao.updateStatusForTeacher(id, status);
	}
}
