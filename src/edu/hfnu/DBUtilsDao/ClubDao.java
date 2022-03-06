package edu.hfnu.DBUtilsDao;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import edu.hfnu.model.ClubinfoTable;
import edu.hfnu.utils.C3p0Utils;

public class ClubDao {
	//获取C3P0数据源
	DataSource ds = C3p0Utils.getDataSource();
	
	/**
	 * 创建一个社团
	 * @param name社团名称
	 * @param pname社长姓名
	 * @param credit社团信用评分
	 * @return
	 * @throws SQLException
	 */
	public boolean newClub(String name,String pname,int credit) throws SQLException {
		//1.创建QueryRunner对象
		QueryRunner runner = new QueryRunner(ds);
		//2.sql语句
		String sql = "insert into clubinfo(name,pname,credit) values(?,?,?);";
		//3.调用 QueryRunner对象的update()方法，其返回的row是发生改变的数据行数
		int row = runner.update(sql,name,pname,credit);
		if(row>0) {
			//改变的行数不为0，插入成功
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * 删除一个社团
	 * @param name
	 * @return
	 * @throws SQLException
	 */
	public boolean dropClub(String name) throws SQLException {
		//1.创建QueryRunner对象
		QueryRunner runner = new QueryRunner(ds);
		//2.sql语句
		String sql = "delete from clubinfo where name=?;";
		//3.调用 QueryRunner对象的update()方法，其返回的row是发生改变的数据行数
		int row = runner.update(sql,name);
		if(row>0) {
			//改变的行数不为0，删除成功
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * 修改社团所属社长信息
	 * @param name
	 * @param pname
	 * @return
	 * @throws SQLException
	 */
	public boolean updateProprieter(String name,String pname) throws SQLException {
		//1.创建QueryRunner对象
		QueryRunner runner = new QueryRunner(ds);
		//2.sql
		String sql = "update clubinfo set pname=? where name=?;";
		//3.调用 QueryRunner对象的update()方法，其返回的row是发生改变的数据行数
		int row = runner.update(sql,pname,name);
		if(row>0) {
			//改变的行数不为0，修改成功
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * 修改社团的信誉分
	 * @param name
	 * @param pname
	 * @return
	 * @throws SQLException
	 */
	public boolean updateCredit(String name,int credit) throws SQLException {
		//1.创建QueryRunner对象
		QueryRunner runner = new QueryRunner(ds);
		//2.sql
		String sql = "update clubinfo set credit=? where name=?;";
		//3.调用 QueryRunner对象的update()方法，其返回的row是发生改变的数据行数
		int row = runner.update(sql,credit,name);
		if(row>0) {
			//改变的行数不为0，修改成功
			return true;
		}else {
			return false;
		}
	}
	
	
	//查询所有数据
	public List<ClubinfoTable> findAll() throws SQLException {
		//创建QueryRunner 对象
		QueryRunner runner = new QueryRunner(ds);
		//sql语句
		String sql = "select * from clubinfo;";
		//调用runner方法
		List<ClubinfoTable> list = runner.query(sql, new BeanListHandler<ClubinfoTable>(ClubinfoTable.class));
		return list;
	}
			
	/**
	 * 获取所有数据条数
	 * @return
	 * @throws SQLException
	 */
	public int countAll() throws SQLException {
		//创建QueryRunner对象
		QueryRunner runner = new QueryRunner(ds);
		//sql
		String sql = "select count(*) from clubinfo;";
		//调用runner方法
		Object number = runner.query(sql, new ScalarHandler<Object>());
				
		return Integer.parseInt(number.toString());
	}
}
