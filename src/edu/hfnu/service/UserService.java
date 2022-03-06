package edu.hfnu.service;

import java.sql.SQLException;
import java.util.List;

import edu.hfnu.DBUtilsDao.MinisterDao;
import edu.hfnu.DBUtilsDao.ProprieterDao;
import edu.hfnu.DBUtilsDao.TeacherDao;
import edu.hfnu.model.Minister;
import edu.hfnu.model.Proprieter;
import edu.hfnu.model.Teacher;

public class UserService {
	//分别获取三种类型人员的数据操作对象
	MinisterDao mdao = new MinisterDao();
	TeacherDao tdao = new TeacherDao();
	ProprieterDao pdao = new ProprieterDao();
	
	
	/**
	 * 添加团委老师的服务方法
	 * @param name
	 * @param password
	 * @return
	 * @throws SQLException
	 */
	public boolean addTeacher(String name,String password) throws SQLException {
		Teacher t = new Teacher(name,password);
		return tdao.insertTeacher(t);
	}
	
	/**
	 * 删除团委老师
	 * @param name
	 * @return
	 * @throws SQLException
	 */
	public boolean deleteTeacher(String name) throws SQLException {
		return tdao.deleteTeacher(name);
	}
	
	/**
	 * 新增社联部长用户
	 * @param name
	 * @param password
	 * @param dept
	 * @return
	 * @throws SQLException
	 */
	public boolean addMinister(String name,String password,String dept) throws SQLException {
		Minister m = new Minister(name,password,dept);
		return mdao.insertMinister(m);
	}
	
	/**
	 * 删除一位社联部长用户
	 * @param name
	 * @return
	 * @throws SQLException
	 */
	public boolean deleteMinister(String name) throws SQLException {
		return mdao.deleteMinister(name);
	}
	
	/**
	 * 新增一位社长用户
	 * @param name
	 * @param password
	 * @param club
	 * @return
	 * @throws SQLException
	 */
	public boolean addProprieter(String name,String password,String club) throws SQLException {
		Proprieter p = new Proprieter(name,password,club);
		return pdao.insertProprieter(p);
	}
	
	/**
	 * 删除一位社长用户
	 * @param name
	 * @return
	 * @throws SQLException
	 */
	public boolean deleteProprieter(String name) throws SQLException {
		return pdao.deleteProprieter(name);
	}
	
	/**
	 * 删除所有在任的社联部长信息
	 * @return
	 * @throws SQLException
	 */
	public boolean deleteAllMinister() throws SQLException {
		return mdao.deleteAll();
	}
	
	/**
	 * 查询表中所有记录
	 * @return
	 * @throws SQLException
	 */
	public List<Teacher> findAllTeachers() throws SQLException{
		return tdao.findAllTeachers();
	}
	
	/**
	 * 查询表中所有记录
	 * @return
	 * @throws SQLException
	 */
	public List<Proprieter> findAllProprieters() throws SQLException{
		return pdao.findAllProprieters();
	}
	
	/**
	 * 查询表中所有记录
	 * @return
	 * @throws SQLException
	 */
	public List<Minister> findAllMinisters() throws SQLException{
		return mdao.findAllMinisters();
	}
	
	/**
	 * 返回表中所有的数据条数
	 * @return
	 * @throws SQLException
	 */
	public int countAllTeacher() throws SQLException {
		return tdao.countAll();
	}
	
	/**
	 * 返回表中所有的数据条数
	 * @return
	 * @throws SQLException
	 */
	public int countAllMinister() throws SQLException {
		return mdao.countAll();
	}
	
	/**
	 * 返回表中所有的数据条数
	 * @return
	 * @throws SQLException
	 */
	public int countAllProprieter() throws SQLException {
		return pdao.countAll();
	}
}
