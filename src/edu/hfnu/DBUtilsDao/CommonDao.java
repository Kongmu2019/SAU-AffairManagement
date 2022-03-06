package edu.hfnu.DBUtilsDao;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;

import edu.hfnu.utils.C3p0Utils;

public class CommonDao {
	//获取c3p0连接池数据源
	private static DataSource ds = C3p0Utils.getDataSource();
	
	/**
	 * 这个方法出现了BUG，原因是传入的tablename经过runner.update()方法处理后，
	 * 会在表名上加上'  '，SQL语法报错，故不采用
	 * @param id
	 * @param tablename
	 * @return
	 * @throws SQLException

	
	//根据给定的id删除给定表格的数据
	public static boolean delTable(int id,String tablename) throws SQLException{
		//1.创建QueryRunner对象
		QueryRunner runner = new QueryRunner(ds);
		//2.sql语句
		String sql = "delete from ? where id=?;";
		//3.调用 QueryRunner对象的update()方法，其返回的row是发生改变的数据行数
		int row = runner.update(sql,tablename,id);
		if(row>0) {
			//改变的行数不为0，删除成功
			return true;
		}else {
			return false;
		}
	}
	
	*/
	
	public static boolean delAwardname(int id) throws SQLException {
		//1.创建QueryRunner对象
		QueryRunner runner = new QueryRunner(ds);
		//2.sql语句
		String sql = "delete from awardname where id=?;";
		//3.调用 QueryRunner对象的update()方法，其返回的row是发生改变的数据行数
		int row = runner.update(sql,id);
		if(row>0) {
			//改变的行数不为0，删除成功
			return true;
		}else {
			return false;
		}
	}
	
	public static boolean delNewclub(int id) throws SQLException {
		//1.创建QueryRunner对象
		QueryRunner runner = new QueryRunner(ds);
		//2.sql语句
		String sql = "delete from newclub where id=?;";
		//3.调用 QueryRunner对象的update()方法，其返回的row是发生改变的数据行数
		int row = runner.update(sql,id);
		if(row>0) {
			//改变的行数不为0，删除成功
			return true;
		}else {
			return false;
		}
	}
	
	
	public static boolean delActivity(int id) throws SQLException {
		//1.创建QueryRunner对象
		QueryRunner runner = new QueryRunner(ds);
		//2.sql语句
		String sql = "delete from activity where id=?;";
		//3.调用 QueryRunner对象的update()方法，其返回的row是发生改变的数据行数
		int row = runner.update(sql,id);
		if(row>0) {
			//改变的行数不为0，删除成功
			return true;
		}else {
			return false;
		}
	}
	
	
	
	
	public static boolean delActivityroom(int id) throws SQLException {
		//1.创建QueryRunner对象
		QueryRunner runner = new QueryRunner(ds);
		//2.sql语句
		String sql = "delete from activityroom where id=?;";
		//3.调用 QueryRunner对象的update()方法，其返回的row是发生改变的数据行数
		int row = runner.update(sql,id);
		if(row>0) {
			//改变的行数不为0，删除成功
			return true;
		}else {
			return false;
		}
	}
	
	
	public static boolean delHonorcheck(int id) throws SQLException {
		//1.创建QueryRunner对象
		QueryRunner runner = new QueryRunner(ds);
		//2.sql语句
		String sql = "delete from honorcheck where id=?;";
		//3.调用 QueryRunner对象的update()方法，其返回的row是发生改变的数据行数
		int row = runner.update(sql,id);
		if(row>0) {
			//改变的行数不为0，删除成功
			return true;
		}else {
			return false;
		}
	}
	
	public static boolean delClubevaluate(int id) throws SQLException {
		//1.创建QueryRunner对象
		QueryRunner runner = new QueryRunner(ds);
		//2.sql语句
		String sql = "delete from clubevaluate where id=?;";
		//3.调用 QueryRunner对象的update()方法，其返回的row是发生改变的数据行数
		int row = runner.update(sql,id);
		if(row>0) {
			//改变的行数不为0，删除成功
			return true;
		}else {
			return false;
		}
	}
	
	public static boolean delMinisters(int id) throws SQLException {
		//1.创建QueryRunner对象
		QueryRunner runner = new QueryRunner(ds);
		//2.sql语句
		String sql = "delete from ministers where id=?;";
		//3.调用 QueryRunner对象的update()方法，其返回的row是发生改变的数据行数
		int row = runner.update(sql,id);
		if(row>0) {
			//改变的行数不为0，删除成功
			return true;
		}else {
			return false;
		}
	}
	
	public static boolean delProprieters(int id) throws SQLException {
		//1.创建QueryRunner对象
		QueryRunner runner = new QueryRunner(ds);
		//2.sql语句
		String sql = "delete from proprieters where id=?;";
		//3.调用 QueryRunner对象的update()方法，其返回的row是发生改变的数据行数
		int row = runner.update(sql,id);
		if(row>0) {
			//改变的行数不为0，删除成功
			return true;
		}else {
			return false;
		}
	}
	
	public static boolean delTeachers(int id) throws SQLException {
		//1.创建QueryRunner对象
		QueryRunner runner = new QueryRunner(ds);
		//2.sql语句
		String sql = "delete from teachers where id=?;";
		//3.调用 QueryRunner对象的update()方法，其返回的row是发生改变的数据行数
		int row = runner.update(sql,id);
		if(row>0) {
			//改变的行数不为0，删除成功
			return true;
		}else {
			return false;
		}
	}
	
	public static boolean delClubinfo(int id) throws SQLException {
		//1.创建QueryRunner对象
		QueryRunner runner = new QueryRunner(ds);
		//2.sql语句
		String sql = "delete from clubinfo where id=?;";
		//3.调用 QueryRunner对象的update()方法，其返回的row是发生改变的数据行数
		int row = runner.update(sql,id);
		if(row>0) {
			//改变的行数不为0，删除成功
			return true;
		}else {
			return false;
		}
	}
	
	public static boolean delPlancheck(int id) throws SQLException {
		//1.创建QueryRunner对象
		QueryRunner runner = new QueryRunner(ds);
		//2.sql语句
		String sql = "delete from plancheck where id=?;";
		//3.调用 QueryRunner对象的update()方法，其返回的row是发生改变的数据行数
		int row = runner.update(sql,id);
		if(row>0) {
			//改变的行数不为0，删除成功
			return true;
		}else {
			return false;
		}
	}
	
	public static boolean delItemcheck(int id) throws SQLException {
		//1.创建QueryRunner对象
		QueryRunner runner = new QueryRunner(ds);
		//2.sql语句
		String sql = "delete from itemcheck where id=?;";
		//3.调用 QueryRunner对象的update()方法，其返回的row是发生改变的数据行数
		int row = runner.update(sql,id);
		if(row>0) {
			//改变的行数不为0，删除成功
			return true;
		}else {
			return false;
		}
	}
	
	public static boolean delContact1(int id) throws SQLException {
		//1.创建QueryRunner对象
		QueryRunner runner = new QueryRunner(ds);
		//2.sql语句
		String sql = "delete from contact1 where id=?;";
		//3.调用 QueryRunner对象的update()方法，其返回的row是发生改变的数据行数
		int row = runner.update(sql,id);
		if(row>0) {
			//改变的行数不为0，删除成功
			return true;
		}else {
			return false;
		}
	}
	
	public static boolean delContact2(int id) throws SQLException {
		//1.创建QueryRunner对象
		QueryRunner runner = new QueryRunner(ds);
		//2.sql语句
		String sql = "delete from contact2 where id=?;";
		//3.调用 QueryRunner对象的update()方法，其返回的row是发生改变的数据行数
		int row = runner.update(sql,id);
		if(row>0) {
			//改变的行数不为0，删除成功
			return true;
		}else {
			return false;
		}
	}
	
	public static boolean delItems(int id) throws SQLException {
		//1.创建QueryRunner对象
		QueryRunner runner = new QueryRunner(ds);
		//2.sql语句
		String sql = "delete from items where id=?;";
		//3.调用 QueryRunner对象的update()方法，其返回的row是发生改变的数据行数
		int row = runner.update(sql,id);
		if(row>0) {
			//改变的行数不为0，删除成功
			return true;
		}else {
			return false;
		}
	}
}
