package edu.hfnu.DBUtilsDao;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import edu.hfnu.model.ItemCheckTable;
import edu.hfnu.utils.C3p0Utils;

public class ItemCheckDao {
	//获取C3P0数据源
	DataSource ds = C3p0Utils.getDataSource();
		
		/**
		 * 新增一条采购物资申请记录
		 * @param obj
		 * @return
		 * @throws SQLException
		 */
		public boolean insert(ItemCheckTable obj) throws SQLException {
			//1.创建QueryRunner对象
			QueryRunner runner = new QueryRunner(ds);
			//2.sql语句
			String sql = "insert into itemcheck(datebuy,item,price,numbers,status,reason) values(?,?,?,?,?,?);";
			//3.调用 QueryRunner对象的update()方法，其返回的row是发生改变的数据行数
			int row = runner.update(sql,obj.getDatebuy(),obj.getItem(),obj.getPrice(),obj.getNumbers(),obj.getStatus(),obj.getReason());
			if(row>0) {
				//改变的行数不为0，插入成功
				return true;
			}else {
				return false;
			}
		}
		
		/**
		 * 根据申请采购物资记录的id来删除一条记录
		 * @param prizewinner
		 * @return
		 * @throws SQLException
		 */
		public boolean delete(int id) throws SQLException {
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
		
		/**
		 * 根据团委审核状态取出对应用户应该审核的数据
		 * @param status
		 * @return
		 * @throws SQLException
		 */
		public List<ItemCheckTable> findAllForTeacher(String status) throws SQLException{
			//创建QueryRunner 对象
			QueryRunner runner = new QueryRunner(ds);
			//sql
			String sql = "select * from itemcheck where status=?;";
			//调用query方法
			List<ItemCheckTable> list = runner.query(sql,new BeanListHandler<ItemCheckTable>(ItemCheckTable.class),status);
			return list;
			
		}
		
		
		
		/**
		 * 根据一个审核状态获取物资采购审核表中的所有数据条数
		 * @return
		 * @throws SQLException
		 */
		public int countAll(String status) throws SQLException {
			//创建QueryRunner 对象
			QueryRunner runner = new QueryRunner(ds);
			//sql
			String sql = "select count(*) from itemcheck where status=?;";
			//调用query方法
			Object number = runner.query(sql, new ScalarHandler<Object>(),status);
			
			return Integer.parseInt(number.toString());
		}
		
		/**
		 * 取出所有数据
		 * @param status
		 * @return
		 * @throws SQLException
		 */
		public List<ItemCheckTable> findAll() throws SQLException{
			//创建QueryRunner 对象
			QueryRunner runner = new QueryRunner(ds);
			//sql
			String sql = "select * from itemcheck;";
			//调用query方法
			List<ItemCheckTable> list = runner.query(sql,new BeanListHandler<ItemCheckTable>(ItemCheckTable.class));
			return list;
			
		}
		
		
		
		/**
		 * 获取物资采购审核表中的所有数据条数
		 * @return
		 * @throws SQLException
		 */
		public int countAll() throws SQLException {
			//创建QueryRunner 对象
			QueryRunner runner = new QueryRunner(ds);
			//sql
			String sql = "select count(*) from itemcheck;";
			//调用query方法
			Object number = runner.query(sql, new ScalarHandler<Object>());
			
			return Integer.parseInt(number.toString());
		}
		
		/**
		 * 根据对应的id修改团委审核状态
		 * @param clubname
		 * @param status1
		 * @return
		 * @throws SQLException
		 */
		public boolean updateStatusForTeacher(int id,String status) throws SQLException {
			//1.创建QueryRunner对象
			QueryRunner runner = new QueryRunner(ds);
			//2.sql
			String sql = "update itemcheck set status=? where id=?;";
			//3.调用 QueryRunner对象的update()方法，其返回的row是发生改变的数据行数
			int row = runner.update(sql,status,id);
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
			String sql = "update itemcheck set reason=? where id=?;";
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
			String sql = "update itemcheck set reason='未填写' where id=?;";
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
