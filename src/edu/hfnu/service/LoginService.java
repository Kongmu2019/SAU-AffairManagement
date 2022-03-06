package edu.hfnu.service;

import java.sql.SQLException;

import edu.hfnu.DBUtilsDao.MinisterDao;
import edu.hfnu.DBUtilsDao.ProprieterDao;
import edu.hfnu.DBUtilsDao.TeacherDao;
import edu.hfnu.model.Minister;
import edu.hfnu.model.Proprieter;
import edu.hfnu.model.Teacher;

public class LoginService {
	MinisterDao mdao = new MinisterDao();
	TeacherDao tdao = new TeacherDao();
	ProprieterDao pdao = new ProprieterDao();
	
	/**
	 * 验证用户输入的用户名是否存在，返回true就是存在该用户，否则不存在
	 * @param name
	 * @param type
	 * @return
	 * @throws SQLException
	 */
	public boolean isExistUser(String name,String type) throws SQLException {
		if(type.equals("tuanwei")) {
			//团委老师，调用团委老师的dao层方法
			Teacher teacher = tdao.findTeacherByName(name);
			if(teacher!=null) {
				return true;
			}else {
				return false;
			}

			
		}else if(type.equals("shelian")) {
			//社联部长,调用社联部长的dao层方法
			Minister minister = mdao.findMinisterByName(name);
			if(minister!=null) {
				return true;
			}else {
				return false;
			}
		}else {
			//不是团委也不是部长，那就是社长
			Proprieter pro = pdao.findProprieterByName(name);
			if(pro!=null) {
				return true;
			}else {
				return false;
			}
		}
	}
	
	/**
	 * 通过用户名和密码及类型检查是否有该用户
	 * @param name
	 * @param password
	 * @param type
	 * @return
	 * @throws SQLException
	 */
	
	public boolean validateByNameAndPwd(String name,String password,String type) throws SQLException {
		if(type.equals("tuanwei")&&tdao.findTeacherByNameAndPwd(name, password)!=null) {
			return true;//团委老师用户校验成功
		}else if(type.equals("shelian")&&mdao.findMinisterByNameAndPwd(name, password)!=null) {
			return true;//社联部长用户校验成功
		}else if(type.equals("shezhang")&&pdao.findProprieterByNameAndPwd(name, password)!=null){
			return true;//社团负责人用户校验成功
		}else {
			return false;//以上都校验失败，则返回false
		}
	}
	
	/**
	 * 通过团委老师用户名密码返回团委老师对象
	 * @param name
	 * @param password
	 * @return
	 * @throws SQLException
	 */
	public Teacher findTeacherByNameAndPwd(String name,String password) throws SQLException {
		return tdao.findTeacherByNameAndPwd(name, password);
	}
	
	/**
	 * 只通过团委老师用户名返回团委老师对象
	 * @param name
	 * @return
	 * @throws SQLException
	 */
	public Teacher findTeacherByName(String name) throws SQLException {
		return tdao.findTeacherByName(name);
	}
	
	/**
	 * 通过用户名密码返回部门负责人对象
	 * @param name
	 * @param password
	 * @return
	 * @throws SQLException
	 */
	public Minister findMinisterByNameAndPwd(String name,String password) throws SQLException {
		return mdao.findMinisterByNameAndPwd(name, password);
	}
	
	/**
	 * 只通过用户名返回部门负责人对象
	 * @param name
	 * @return
	 * @throws SQLException
	 */
	public Minister findMinisterByName(String name) throws SQLException {
		return mdao.findMinisterByName(name);
	}
	
	/**
	 * 通过用户名密码返回社团负责人对象
	 * @param name
	 * @param password
	 * @return
	 * @throws SQLException
	 */
	public Proprieter findProprieterByNameAndPwd(String name,String password) throws SQLException {
		return pdao.findProprieterByNameAndPwd(name, password);
	}
	
	/**
	 * 只通过用户名返回社团负责人对象
	 * @param name
	 * @return
	 * @throws SQLException
	 */
	public Proprieter findProprieterByName(String name) throws SQLException {
		return pdao.findProprieterByName(name);
	}
	
	/**
	 * 校验团委老师旧密码
	 * @param name
	 * @param oldpass
	 * @return
	 * @throws SQLException
	 */
	public boolean validateOldPasswordForTeacher(String name,String oldpass) throws SQLException {
		
		Teacher t = tdao.findTeacherByName(name);
		
		if(t==null) {//修复单选框选错类型修改密码导致的空指针异常BUG
			return false;
		}
		String currentPass = t.getPassword();
		if(oldpass.equals(currentPass)) {
			return true;	//输入的旧密码与当前密码一致，返回真
		}else {
			return false;
		}
	}
	
	/**
	 * 修改团委老师密码
	 * @param name
	 * @param password
	 * @return
	 * @throws SQLException
	 */
	public boolean updatePasswordForTeacher(String name, String password) throws SQLException {
		return tdao.updatePassword(name, password);
	}
	
	/**
	 * 校验社联部门负责人旧密码
	 * @param name
	 * @param oldpass
	 * @return
	 * @throws SQLException
	 */
	public boolean validateOldPasswordForMinister(String name,String oldpass) throws SQLException {
		Minister m = mdao.findMinisterByName(name);
		if(m==null) {//修复单选框选错类型修改密码导致的空指针异常BUG
			return false;
		}
		String currentPass = m.getPassword();
		if(oldpass.equals(currentPass)) {
			return true;	//输入的旧密码与当前密码一致，返回真
		}else {
			return false;
		}
	}
	
	/**
	 * 修改社联负责人密码
	 * @param name
	 * @param password
	 * @return
	 * @throws SQLException
	 */
	public boolean updatePasswordForMinister(String name, String password) throws SQLException {
		return mdao.updatePassword(name, password);
	}
	
	/**
	 * 校验社团负责人旧密码
	 * @param name
	 * @param oldpass
	 * @return
	 * @throws SQLException
	 */
	public boolean validateOldPasswordForProprieter(String name,String oldpass) throws SQLException {
		Proprieter p = pdao.findProprieterByName(name);
		if(p==null) {//修复单选框选错类型修改密码导致的空指针异常BUG
			return false;
		}
		String currentPass = p.getPassword();
		if(oldpass.equals(currentPass)) {
			return true;	//输入的旧密码与当前密码一致，返回真
		}else {
			return false;
		}
	}
	
	public boolean updatePasswordForProprieter(String name, String password) throws SQLException {
		return pdao.updatePassword(name, password);
	}
}
