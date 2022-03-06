package edu.hfnu.DBUtilsDao;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import edu.hfnu.model.Teacher;
import edu.hfnu.utils.C3p0Utils;

public class TeacherDao {
	    //获取c3p0连接池数据源
		DataSource ds = C3p0Utils.getDataSource();
		
		//查询所有团委老师，返回保存所有团委老师对象的List集合
		public List<Teacher> findAllTeachers() throws SQLException {
			//创建QueryRunner 对象
			QueryRunner runner = new QueryRunner(ds);
			//sql语句
			String sql = "select * from teachers;";
			//调用runner方法
			List<Teacher> list = runner.query(sql, new BeanListHandler<Teacher>(Teacher.class));
			return list;
		}
		
		/**
		 * 获取团委老师表中的所有用户条数
		 * @return
		 * @throws SQLException
		 */
		public int countAll() throws SQLException {
			//创建QueryRunner对象
			QueryRunner runner = new QueryRunner(ds);
			//sql
			String sql = "select count(*) from teachers;";
			//调用runner方法
			Object number = runner.query(sql, new ScalarHandler<Object>());
			
			return Integer.parseInt(number.toString());
		}
		
		/**
		 * 通过团委老师姓名查询Teacher对象
		 * @throws SQLException 
		 */
		
		public Teacher findTeacherByName(String name) throws SQLException {
			//1.创建QueryRunner对象
			QueryRunner runner = new QueryRunner(ds);
			//2.sql语句
			String sql = "select * from teachers where name=?;";
			//3.调用runner.query()方法
			Teacher teacher = runner.query(sql, new BeanHandler<Teacher>(Teacher.class),name);
			
			return teacher;
		}
		
		/**
		 * 通过团委老师姓名和密码查询Teacher对象
		 * @throws SQLException 
		 */
		
		public Teacher findTeacherByNameAndPwd(String name,String password) throws SQLException {
			//1.创建QueryRunner对象
			QueryRunner runner = new QueryRunner(ds);
			//2.sql语句
			String sql = "select * from teachers where name=? and password=?;";
			//3.调用runner.query()方法
			Teacher teacher = runner.query(sql, new BeanHandler<Teacher>(Teacher.class),name,password);
			
			return teacher;
		}
		
		
		/**
		 * 增加团委老师用户
		 * @param user
		 * @return
		 * @throws SQLException
		 */
		
		public boolean insertTeacher(Teacher user) throws SQLException {
			//创建QueryRunner 对象
			QueryRunner runner = new QueryRunner(ds);
			//sql语句
			String sql = "insert into teachers(name,password) values(?,?);";
			//调用runner.update(),row为执行该方法所改变的行数
			int row = runner.update(sql,new Object[] {user.getName(),user.getPassword()});
			if(row>0) {
				//插入成功
				return true;
			}else {
				return false;
			}
		}
		
		
		
		/**
		 * 根据name修改团委老师密码
		 * @param uname
		 * @param password
		 * @throws SQLException
		 */
		public boolean updatePassword(String uname, String password) throws SQLException {
			//创建QueryRunner 对象
			QueryRunner runner = new QueryRunner(ds);
			String sql = "update teachers set password=? where name=?;";
			
			//调用runner.update(),row为执行该方法所改变的行数
			int row = runner.update(sql, password, uname);
			if(row>0) {
				//修改成功
				return true;
			}else {
				return false;
			}
		}
		
		
		
		/**
		 * 删除团委老师用户
		 * @param uname
		 * @return
		 * @throws SQLException
		 */
		public boolean deleteTeacher(String uname) throws SQLException {
			//创建QueryRunner 对象
			QueryRunner runner = new QueryRunner(ds);
			//sql语句
			String sql = "delete from teachers where name=?;";
			//调用runner.update(),row为执行该方法所改变的行数
			int row = runner.update(sql,uname);
			if(row>0) {
				//插入成功
				return true;
			}else {
				return false;
			}
		}
		
		
		
}
