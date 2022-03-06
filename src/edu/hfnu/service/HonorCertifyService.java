package edu.hfnu.service;

import java.sql.SQLException;
import java.util.List;

import edu.hfnu.DBUtilsDao.HonorCertifyDao;
import edu.hfnu.model.HonorCertifyTable;

/**
 * 荣誉证书审核服务层
 * @author a
 *
 */

public class HonorCertifyService {
	HonorCertifyDao dao = new HonorCertifyDao();
	
	public boolean updateReason1(int id,String reason1) throws SQLException{
		return dao.updateReason1(id, reason1);
	}
	
	public boolean updateReason2(int id,String reason2) throws SQLException{
		return dao.updateReason2(id, reason2);
	}
	
	public boolean removeReason(int id) throws SQLException{
		return dao.removeReason(id);
	}
	
	public boolean addOne(HonorCertifyTable obj) throws SQLException {
		return dao.insert(obj);
	}
	
	public boolean deleteOne(String clubname) throws SQLException {
		return dao.delete(clubname);
	}
	
	public List<HonorCertifyTable> findAll(String status1,String status2) throws SQLException{
		return dao.findAll(status1, status2);
	}
	
	public List<HonorCertifyTable> findAll() throws SQLException{
		return dao.findAll();
	}
	
	public List<HonorCertifyTable> findAllByOne(String status1) throws SQLException{
		return dao.findAllByOne(status1);
	}
	
	public int countAll(String status1,String status2) throws SQLException {
		return dao.countAll(status1, status2);
	}
	
	public int countAll(String status1) throws SQLException {
		return dao.countAll(status1);
	}
	
	public int countAll() throws SQLException {
		return dao.countAll();
	}
	
	public boolean updateStatusForMinister(String clubname,String status1) throws SQLException {
		return dao.updateHonorForMinister(clubname, status1);
	}
	
	public boolean updateStatusForTeacher(String clubname,String status2) throws SQLException {
		return dao.updateHonorForTeacher(clubname, status2);
	}
	
	
}
