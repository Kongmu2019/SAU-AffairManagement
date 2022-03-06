package edu.hfnu.service;

import java.sql.SQLException;
import java.util.List;

import edu.hfnu.DBUtilsDao.ClubDao;
import edu.hfnu.model.ClubinfoTable;

public class ClubService {
	ClubDao dao = new ClubDao();
	//新建社团
	public boolean newClub(String name,String pname,int credit) throws SQLException {
		return dao.newClub(name, pname, credit);
	}
	//撤销社团
	public boolean dropClub(String name) throws SQLException {
		return dao.dropClub(name);
	}
	
	//组织部-社长换届
	public boolean updateProprieter(String name,String pname) throws SQLException {
		return dao.updateProprieter(name, pname);
	}
	
	//八个部门修改的社团表现记录服务方法
	public boolean updateCredit(String name,int credit) throws SQLException {
		return dao.updateCredit(name, credit);
	}
	
	public List<ClubinfoTable> findAll() throws SQLException{
		return dao.findAll();
	}
	
	public int countAll() throws SQLException {
		return dao.countAll();
	}
}
