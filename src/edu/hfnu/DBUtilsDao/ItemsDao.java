package edu.hfnu.DBUtilsDao;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import edu.hfnu.model.ItemsTable;
import edu.hfnu.utils.C3p0Utils;

public class ItemsDao {
	//获取C3P0数据源
	DataSource ds = C3p0Utils.getDataSource();
	
	/**
	 * 新增物资
	 * @param obj
	 * @return
	 * @throws SQLException
	 */
	public boolean insert(ItemsTable obj) throws SQLException {
		//1.创建QueryRunner对象
		QueryRunner runner = new QueryRunner(ds);
		//2.sql语句
		String sql = "insert into items(itemid,itemname,inventory) values(?,?,?);";
		//3.调用 QueryRunner对象的update()方法，其返回的row是发生改变的数据行数
		int row = runner.update(sql,obj.getItemid(),obj.getItemname(),obj.getInventory());
		if(row>0) {
			//改变的行数不为0，插入成功
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * 修改物资库存数目
	 * @param inventory
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public boolean updateInventory(int inventory,String itemid) throws SQLException {
		//1.创建QueryRunner对象
		QueryRunner runner = new QueryRunner(ds);
		//2.sql语句
		String sql = "update items set inventory=? where itemid=?";
		//3.调用 QueryRunner对象的update()方法，其返回的row是发生改变的数据行数
		int row = runner.update(sql,inventory,itemid);
		if(row>0) {
			//改变的行数不为0，插入成功
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * 根据物资编号删除对应的物资记录
	 * @param prizewinner
	 * @return
	 * @throws SQLException
	 */
	public boolean delete(String itemid) throws SQLException {
		//1.创建QueryRunner对象
		QueryRunner runner = new QueryRunner(ds);
		//2.sql语句
		String sql = "delete from items where itemid=?;";
		//3.调用 QueryRunner对象的update()方法，其返回的row是发生改变的数据行数
		int row = runner.update(sql,itemid);
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
	public List<ItemsTable> findAll() throws SQLException{
		//创建QueryRunner 对象
		QueryRunner runner = new QueryRunner(ds);
		//sql
		String sql = "select * from items;";
		//调用query方法
		List<ItemsTable> list = runner.query(sql,new BeanListHandler<ItemsTable>(ItemsTable.class));
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
		String sql = "select count(*) from items;";
		//调用query方法
		Object number = runner.query(sql, new ScalarHandler<Object>());
		
		return Integer.parseInt(number.toString());
	}
	
	
}
