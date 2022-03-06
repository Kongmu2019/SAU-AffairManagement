package edu.hfnu.DBUtilsDao;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import edu.hfnu.model.ActivityroomTable;
import edu.hfnu.utils.C3p0Utils;

public class ActivityroomDao {
	//获取C3P0数据源
	DataSource ds = C3p0Utils.getDataSource();
	
	/**
	 * 新增一条活动室申请记录
	 * @param obj
	 * @return
	 * @throws SQLException
	 */
	public boolean insert(ActivityroomTable obj) throws SQLException {
		//1.创建QueryRunner对象
		QueryRunner runner = new QueryRunner(ds);
		//2.sql语句
		String sql = "insert into activityroom(clubname,timeblock,purpose,proprieter,status,reason) values(?,?,?,?,?,?);";
		//3.调用 QueryRunner对象的update()方法，其返回的row是发生改变的数据行数
		int row = runner.update(sql,obj.getClubname(),obj.getTimeblock(),obj.getPurpose(),obj.getProprieter(),obj.getStatus(),obj.getReason());
		if(row>0) {
			//改变的行数不为0，插入成功
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * 根据社团名称删除对应的申请活动室记录
	 * @param prizewinner
	 * @return
	 * @throws SQLException
	 */
	public boolean delete(String clubname) throws SQLException {
		//1.创建QueryRunner对象
		QueryRunner runner = new QueryRunner(ds);
		//2.sql语句
		String sql = "delete from activityroom where clubname=?;";
		//3.调用 QueryRunner对象的update()方法，其返回的row是发生改变的数据行数
		int row = runner.update(sql,clubname);
		if(row>0) {
			//改变的行数不为0，删除成功
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * 查询表中的所有数据
	 * @return
	 * @throws SQLException
	 */
	public List<ActivityroomTable> findAll() throws SQLException{
		//创建QueryRunner 对象
		QueryRunner runner = new QueryRunner(ds);
		//sql
		String sql = "select * from activityroom;";
		//调用query方法
		List<ActivityroomTable> list = runner.query(sql,new BeanListHandler<ActivityroomTable>(ActivityroomTable.class));
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
		String sql = "select count(*) from activityroom;";
		//调用query方法
		Object number = runner.query(sql, new ScalarHandler<Object>());
		
		return Integer.parseInt(number.toString());
	}
	
	/**
	 * 根据审核状态查询表中的所有数据
	 * @return
	 * @throws SQLException
	 */
	public List<ActivityroomTable> findAll(String status) throws SQLException{
		//创建QueryRunner 对象
		QueryRunner runner = new QueryRunner(ds);
		//sql
		String sql = "select * from activityroom where status=?;";
		//调用query方法
		List<ActivityroomTable> list = runner.query(sql,new BeanListHandler<ActivityroomTable>(ActivityroomTable.class),status);
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
		String sql = "select count(*) from activityroom where status=?;";
		//调用query方法
		Object number = runner.query(sql, new ScalarHandler<Object>(),status);
		
		return Integer.parseInt(number.toString());
	}
	
	/**
	 * 根据申请活动室的社团名称修改审核状态
	 * @param id
	 * @param status
	 * @return
	 * @throws SQLException
	 */
	public boolean updateStatus(String clubname,String status) throws SQLException {
		//1.创建QueryRunner对象
		QueryRunner runner = new QueryRunner(ds);
		//2.sql
		String sql = "update activityroom set status=? where clubname=?;";
		//3.调用 QueryRunner对象的update()方法，其返回的row是发生改变的数据行数
		int row = runner.update(sql,status,clubname);
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
		String sql = "update activityroom set reason=? where id=?;";
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
		String sql = "update activityroom set reason='未填写'  where id=?;";
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
