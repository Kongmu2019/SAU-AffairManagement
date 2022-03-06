package edu.hfnu.DBUtilsDao;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import edu.hfnu.model.ClubEvaluateTable;
import edu.hfnu.utils.C3p0Utils;

public class ClubEvaluateDao {
	//获取c3p0连接池数据源
	DataSource ds = C3p0Utils.getDataSource();
	
	/**
	 * 查询年审表中的所有数据
	 * @return
	 * @throws SQLException
	 */
	public List<ClubEvaluateTable> findAll() throws SQLException{
		//创建QueryRunner 对象
		QueryRunner runner = new QueryRunner(ds);
		//sql
		String sql = "select * from clubevaluate;";
		//调用query方法
		List<ClubEvaluateTable> list = runner.query(sql,new BeanListHandler<ClubEvaluateTable>(ClubEvaluateTable.class));
		return list;
		
	}
	
	/**
	 * 获取社团年审表中的所有数据条数
	 * @return
	 * @throws SQLException
	 */
	public int countAll() throws SQLException {
		//创建QueryRunner 对象
		QueryRunner runner = new QueryRunner(ds);
		//sql
		String sql = "select count(*) from clubevaluate;";
		//调用query方法
		Object obj = runner.query(sql, new ScalarHandler<Object>());
		
		return Integer.parseInt(obj.toString());
	}
	
	/**
	 * 传入一个对象来实现插入操作
	 * @param c
	 * @return
	 * @throws SQLException
	 */
	public boolean insert(ClubEvaluateTable c) throws SQLException {
		//创建QueryRunner 对象
		QueryRunner runner = new QueryRunner(ds);
		//sql语句
		String sql = "insert into clubevaluate(clubname,zhiliang,yingxiang,manyi,hudong,total) values(?,?,?,?,?,?);";
		//调用runner.update(),row为执行该方法所改变的行数
		int row = runner.update(sql,new Object[] {c.getClubname(),c.getZhiliang(),c.getYingxiang(),c.getManyi(),c.getHudong(),c.getTotal()});
		if(row>0) {
			//插入成功
			return true;
		}else {
			return false;
		}
	}
}
