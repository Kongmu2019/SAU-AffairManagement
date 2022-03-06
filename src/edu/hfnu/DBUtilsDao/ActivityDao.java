package edu.hfnu.DBUtilsDao;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import edu.hfnu.model.ActivityTable;
import edu.hfnu.model.AwardNameTable;
import edu.hfnu.utils.C3p0Utils;

public class ActivityDao {
	//获取C3P0数据源
	DataSource ds = C3p0Utils.getDataSource();
	
	/**
	 * 新增一条活动申请记录
	 * @param obj
	 * @return
	 * @throws SQLException
	 */
	public boolean insert(ActivityTable obj) throws SQLException {
		//1.创建QueryRunner对象
		QueryRunner runner = new QueryRunner(ds);
		//2.sql语句
		String sql = "insert into activity(clubname,name,activitytime,site,scope,proprieter,status,reason) values(?,?,?,?,?,?,?,?);";
		//3.调用 QueryRunner对象的update()方法，其返回的row是发生改变的数据行数
		int row = runner.update(sql,obj.getClubname(),obj.getName(),obj.getActivitytime(),obj.getSite(),obj.getScope(),obj.getProprieter(),obj.getStatus(),obj.getReason());
		if(row>0) {
			//改变的行数不为0，插入成功
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * 根据活动名称删除对应的申请活动记录
	 * @param prizewinner
	 * @return
	 * @throws SQLException
	 */
	public boolean delete(String name) throws SQLException {
		//1.创建QueryRunner对象
		QueryRunner runner = new QueryRunner(ds);
		//2.sql语句
		String sql = "delete from activity where name=?;";
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
	 * 根据审核状态查询表中的所有数据
	 * @return
	 * @throws SQLException
	 */
	public List<ActivityTable> findAll(String status) throws SQLException{
		//创建QueryRunner 对象
		QueryRunner runner = new QueryRunner(ds);
		//sql
		String sql = "select * from activity where status=?;";
		//调用query方法
		List<ActivityTable> list = runner.query(sql,new BeanListHandler<ActivityTable>(ActivityTable.class),status);
		return list;
		
	}
	
	/**
	 * 根据审核状态获取表中的所有数据条数
	 * @return
	 * @throws SQLException
	 */
	public int countAll(String status) throws SQLException {
		//创建QueryRunner 对象
		QueryRunner runner = new QueryRunner(ds);
		//sql
		String sql = "select count(*) from activity where status=?;";
		//调用query方法
		Object number = runner.query(sql, new ScalarHandler<Object>(),status);
		
		return Integer.parseInt(number.toString());
	}
	
	/**
	 * 查询表中的所有数据
	 * @return
	 * @throws SQLException
	 */
	public List<ActivityTable> findAll() throws SQLException{
		//创建QueryRunner 对象
		QueryRunner runner = new QueryRunner(ds);
		//sql
		String sql = "select * from activity;";
		//调用query方法
		List<ActivityTable> list = runner.query(sql,new BeanListHandler<ActivityTable>(ActivityTable.class));
		return list;
		
	}
	
	/**
	 * 获取表中的所有数据条数
	 * @return
	 * @throws SQLException
	 */
	public int countAll() throws SQLException {
		//创建QueryRunner 对象
		QueryRunner runner = new QueryRunner(ds);
		//sql
		String sql = "select count(*) from activity;";
		//调用query方法
		Object number = runner.query(sql, new ScalarHandler<Object>());
		
		return Integer.parseInt(number.toString());
	}
	
	/**
	 * 根据申请活动的活动名称修改审核状态
	 * @param id
	 * @param status
	 * @return
	 * @throws SQLException
	 */
	public boolean updateStatus(String name,String status) throws SQLException {
		//1.创建QueryRunner对象
		QueryRunner runner = new QueryRunner(ds);
		//2.sql
		String sql = "update activity set status=? where name=?;";
		//3.调用 QueryRunner对象的update()方法，其返回的row是发生改变的数据行数
		int row = runner.update(sql,status,name);
		if(row>0) {
			//改变的行数不为0，修改成功
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * 修改审核记录中否决原因的方法
	 * @param id
	 * @param reason
	 * @return
	 * @throws SQLException
	 */
	public boolean updateReason(int id,String reason) throws SQLException {
		//1.创建QueryRunner对象
		QueryRunner runner = new QueryRunner(ds);
		//2.sql
		String sql = "update activity set reason=? where id=?;";
		//3.调用 QueryRunner对象的update()方法，其返回的row是发生改变的数据行数
		int row = runner.update(sql,reason,id);
		if(row>0) {
			//改变的行数不为0，修改成功
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * 将否决原因恢复成未填写状态
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public boolean removeReason(int id) throws SQLException {
		//1.创建QueryRunner对象
		QueryRunner runner = new QueryRunner(ds);
		//2.sql
		String sql = "update activity set reason='未填写'  where id=?;";
		//3.调用 QueryRunner对象的update()方法，其返回的row是发生改变的数据行数
		int row = runner.update(sql,id);
		if(row>0) {
			//改变的行数不为0，修改成功
			return true;
		}else {
			return false;
		}
	}
	
	
}
