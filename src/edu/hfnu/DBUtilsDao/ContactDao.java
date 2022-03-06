package edu.hfnu.DBUtilsDao;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import edu.hfnu.model.Contact1Table;
import edu.hfnu.model.Contact2Table;
import edu.hfnu.utils.C3p0Utils;

public class ContactDao {
	//获取c3p0连接池数据源
	DataSource ds = C3p0Utils.getDataSource();
	
	/**
	 * 查询所有的社联通讯记录
	 * @return
	 * @throws SQLException
	 */
	public List<Contact1Table> findAllContact1() throws SQLException {
		//创建QueryRunner 对象
		QueryRunner runner = new QueryRunner(ds);
		//sql语句
		String sql = "select * from contact1;";
		//调用runner方法
		List<Contact1Table> list = runner.query(sql, new BeanListHandler<Contact1Table>(Contact1Table.class));
		return list;
	}
	
	/**
	 * 得到社联通讯录所有记录数目
	 * @return
	 * @throws SQLException
	 */
	public int countAllContact1() throws SQLException {
		//创建QueryRunner 对象
		QueryRunner runner = new QueryRunner(ds);
		//sql
		String sql = "select count(*) from contact1;";
		//调用query方法
		Object number = runner.query(sql, new ScalarHandler<Object>());
		
		return Integer.parseInt(number.toString());
	}
	
	/**
	 * 查询所有的社团通讯记录
	 * @return
	 * @throws SQLException
	 */
	public List<Contact2Table> findAllContact2() throws SQLException {
		//创建QueryRunner 对象
		QueryRunner runner = new QueryRunner(ds);
		//sql语句
		String sql = "select * from contact2;";
		//调用runner方法
		List<Contact2Table> list = runner.query(sql, new BeanListHandler<Contact2Table>(Contact2Table.class));
		return list;
	}
	
	/**
	 * 得到社团通讯录所有记录数目
	 * @return
	 * @throws SQLException
	 */
	public int countAllContact2() throws SQLException {
		//创建QueryRunner 对象
		QueryRunner runner = new QueryRunner(ds);
		//sql
		String sql = "select count(*) from contact2;";
		//调用query方法
		Object number = runner.query(sql, new ScalarHandler<Object>());
		
		return Integer.parseInt(number.toString());
	}
	
	/**
	 * 新增一位联系人到社团通讯录
	 * @param obj
	 * @return
	 * @throws SQLException
	 */
	public boolean insertContact2(Contact2Table obj) throws SQLException {
		//创建QueryRunner 对象
		QueryRunner runner = new QueryRunner(ds);
		//sql语句
		String sql = "insert into contact2(clubname,proprieter,sex,grade,address,mobilephone) values(?,?,?,?,?,?);";
		//调用runner.update(),row为执行该方法所改变的行数
		int row = runner.update(sql,obj.getClubname(),obj.getProprieter(),obj.getSex(),obj.getGrade(),obj.getAddress(),obj.getMobilephone());
		if(row>0) {
			//插入成功
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * 新增一位联系人到社联通讯录
	 * @param obj
	 * @return
	 * @throws SQLException
	 */
	public boolean insertContact1(Contact1Table obj) throws SQLException {
		//创建QueryRunner 对象
		QueryRunner runner = new QueryRunner(ds);
		//sql语句
		String sql = "insert into contact1(dept,minister,sex,grade,address,mobilephone) values(?,?,?,?,?,?);";
		//调用runner.update(),row为执行该方法所改变的行数
		int row = runner.update(sql,obj.getDept(),obj.getMinister(),obj.getSex(),obj.getGrade(),obj.getAddress(),obj.getMobilephone());
		if(row>0) {
			//插入成功
			return true;
		}else {
			return false;
		}
	}
	
	
}
