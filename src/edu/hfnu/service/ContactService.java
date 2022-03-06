package edu.hfnu.service;

import java.sql.SQLException;
import java.util.List;

import edu.hfnu.DBUtilsDao.ContactDao;
import edu.hfnu.model.Contact1Table;
import edu.hfnu.model.Contact2Table;

public class ContactService {
	ContactDao dao = new ContactDao();
	
	public List<Contact1Table> findAllContact1() throws SQLException{
		return dao.findAllContact1();
	}
	
	public List<Contact2Table> findAllContact2() throws SQLException{
		return dao.findAllContact2();
	}
	
	public int countAllContact1() throws SQLException{
		return dao.countAllContact1();
	}
	
	public int countAllContact2() throws SQLException{
		return dao.countAllContact2();
	}
	
	public boolean insertContact1(Contact1Table obj) throws SQLException{
		return dao.insertContact1(obj);
	}
	
	public boolean insertContact2(Contact2Table obj) throws SQLException{
		return dao.insertContact2(obj);
	}
}
