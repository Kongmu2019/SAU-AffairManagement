package edu.hfnu.DBUtilsDao;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import edu.hfnu.model.Minister;
import edu.hfnu.utils.C3p0Utils;

public class MinisterDao {
	//获取c3p0连接池数据源
	DataSource ds = C3p0Utils.getDataSource();
	
	
	//查询所有部长，返回保存所有部长对象的List集合
	public List<Minister> findAllMinisters() throws SQLException {
		//创建QueryRunner 对象
		QueryRunner runner = new QueryRunner(ds);
		//sql语句
		String sql = "select * from ministers;";
		//调用runner方法
		List<Minister> list = runner.query(sql, new BeanListHandler<Minister>(Minister.class));
		return list;
	}
	
	/**
	 * 获取社联部长表中的所有记录条数
	 * @return
	 * @throws SQLException
	 */
	public int countAll() throws SQLException {
		//创建QueryRunner对象
		QueryRunner runner = new QueryRunner(ds);
		//sql
		String sql = "select count(*) from ministers;";
		//调用runner方法
		Object number = runner.query(sql, new ScalarHandler<Object>());
		
		return Integer.parseInt(number.toString());
	}
	
	/**
	 * 通过部长姓名查询Minister对象
	 * @throws SQLException 
	 */
	
	public Minister findMinisterByName(String name) throws SQLException {
		//1.创建QueryRunner对象
		QueryRunner runner = new QueryRunner(ds);
		//2.sql语句
		String sql = "select * from ministers where name=?;";
		//3.调用runner.query()方法
		Minister minister = runner.query(sql, new BeanHandler<Minister>(Minister.class),name);
		
		return minister;
	}
	
	/**
	 * 通过部长姓名查询Minister对象
	 * @throws SQLException 
	 */
	
	public Minister findMinisterByNameAndPwd(String name,String password) throws SQLException {
		//1.创建QueryRunner对象
		QueryRunner runner = new QueryRunner(ds);
		//2.sql语句
		String sql = "select * from ministers where name=? and password=?;";
		//3.调用runner.query()方法
		Minister minister = runner.query(sql, new BeanHandler<Minister>(Minister.class),name,password);
		
		return minister;
	}
	

	/**
	 * 增加社联部长用户
	 * @param user
	 * @return
	 * @throws SQLException
	 */
	
	public boolean insertMinister(Minister user) throws SQLException {
		//创建QueryRunner 对象
		QueryRunner runner = new QueryRunner(ds);
		//sql语句
		String sql = "insert into ministers(name,password,dept) values(?,?,?);";
		//调用runner.update(),row为执行该方法所改变的行数
		int row = runner.update(sql,new Object[] {user.getName(),user.getPassword(),user.getDept()});
		if(row>0) {
			//插入成功
			return true;
		}else {
			return false;
		}
	}
	
	
	
	/**
	 * 根据name修改社联部长密码
	 * @param uname
	 * @param password
	 * @throws SQLException
	 */
	public boolean updatePassword(String uname, String password) throws SQLException {
		//创建QueryRunner 对象
		QueryRunner runner = new QueryRunner(ds);
		String sql = "update ministers set password=? where name=?;";
		
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
	 * 删除社联部长用户
	 * @param uname
	 * @return
	 * @throws SQLException
	 */
	public boolean deleteMinister(String uname) throws SQLException {
		//创建QueryRunner 对象
		QueryRunner runner = new QueryRunner(ds);
		//sql语句
		String sql = "delete from ministers where name=?;";
		//调用runner.update(),row为执行该方法所改变的行数
		int row = runner.update(sql,uname);
		if(row>0) {
			//插入成功
			return true;
		}else {
			return false;
		}
	}
	
	public boolean deleteAll() throws SQLException {
		//1.创建QueryRunner 对象
		QueryRunner runner = new QueryRunner(ds);
		//2.sql语句
		String sql = "delete from ministers;";
		//3.调用runner.update(),row为执行该方法所改变的行数
		int row = runner.update(sql);
		if(row>0) {
			//插入成功
			return true;
		}else {
			return false;
		}
}
	
}
