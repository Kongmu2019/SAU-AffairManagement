package edu.hfnu.DBUtilsDao;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import edu.hfnu.model.AwardNameTable;
import edu.hfnu.utils.C3p0Utils;

public class AwardNameDao {
	//获取C3P0数据源
	DataSource ds = C3p0Utils.getDataSource();
	
	/**
	 * 新增一名获奖人员记录
	 * @param obj
	 * @return
	 * @throws SQLException
	 */
	public boolean insert(AwardNameTable obj) throws SQLException {
		//1.创建QueryRunner对象
		QueryRunner runner = new QueryRunner(ds);
		//2.sql语句
		String sql = "insert into awardname(clubname,activityname,prizewinner,prize) values(?,?,?,?);";
		//3.调用 QueryRunner对象的update()方法，其返回的row是发生改变的数据行数
		int row = runner.update(sql,obj.getClubname(),obj.getActivityname(),obj.getPrizewinner(),obj.getPrize());
		if(row>0) {
			//改变的行数不为0，插入成功
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * 根据获奖人姓名删除对应的获奖记录
	 * @param prizewinner
	 * @return
	 * @throws SQLException
	 */
	public boolean delete(String prizewinner) throws SQLException {
		//1.创建QueryRunner对象
		QueryRunner runner = new QueryRunner(ds);
		//2.sql语句
		String sql = "delete from awardname where name=?;";
		//3.调用 QueryRunner对象的update()方法，其返回的row是发生改变的数据行数
		int row = runner.update(sql,prizewinner);
		if(row>0) {
			//改变的行数不为0，删除成功
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * 查询获奖人员表中的所有数据
	 * @return
	 * @throws SQLException
	 */
	public List<AwardNameTable> findAll() throws SQLException{
		//创建QueryRunner 对象
		QueryRunner runner = new QueryRunner(ds);
		//sql
		String sql = "select * from awardname;";
		//调用query方法
		List<AwardNameTable> list = runner.query(sql,new BeanListHandler<AwardNameTable>(AwardNameTable.class));
		return list;
		
	}
	
	/**
	 * 获取获奖人员名单中的所有数据条数
	 * @return
	 * @throws SQLException
	 */
	public int countAll() throws SQLException {
		//创建QueryRunner 对象
		QueryRunner runner = new QueryRunner(ds);
		//sql
		String sql = "select count(*) from awardname;";
		//调用query方法
		Object number = runner.query(sql, new ScalarHandler<Object>());
		
		return Integer.parseInt(number.toString());
	}
	
	
}
