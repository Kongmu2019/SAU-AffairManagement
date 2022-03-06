package edu.hfnu.DBUtilsDao;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import edu.hfnu.model.Proprieter;
import edu.hfnu.utils.C3p0Utils;

public class ProprieterDao {
			//获取c3p0连接池数据源
			DataSource ds = C3p0Utils.getDataSource();
			
			/**
			 * 查询所有社团负责人，返回保存所有社团负责人对象的List集合
			 * @return
			 * @throws SQLException
			 */
			public List<Proprieter> findAllProprieters() throws SQLException {
				//创建QueryRunner 对象
				QueryRunner runner = new QueryRunner(ds);
				//sql语句
				String sql = "select * from proprieters;";
				//调用runner方法
				List<Proprieter> list = runner.query(sql, new BeanListHandler<Proprieter>(Proprieter.class));
				return list;
			}
			
			/**
			 * 获取社团负责人表中所有记录条数
			 * @return
			 * @throws SQLException
			 */
			public int countAll() throws SQLException {
				//创建QueryRunner对象
				QueryRunner runner = new QueryRunner(ds);
				//sql
				String sql = "select count(*) from proprieters;";
				//调用runner方法
				Object number = runner.query(sql, new ScalarHandler<Object>());
				
				return Integer.parseInt(number.toString());
			}
			
			/**
			 * 通过社团负责人姓名查询Proprieter对象
			 * @throws SQLException 
			 */
			
			public Proprieter findProprieterByName(String name) throws SQLException {
				//1.创建QueryRunner对象
				QueryRunner runner = new QueryRunner(ds);
				//2.sql语句
				String sql = "select * from proprieters where name=?;";
				//3.调用runner.query()方法
				Proprieter proprieter = runner.query(sql, new BeanHandler<Proprieter>(Proprieter.class),name);
				
				return proprieter;
			}
			
			/**
			 * 通过社团负责人姓名查询Proprieter对象
			 * @throws SQLException 
			 */
			
			public Proprieter findProprieterByNameAndPwd(String name,String password) throws SQLException {
				//1.创建QueryRunner对象
				QueryRunner runner = new QueryRunner(ds);
				//2.sql语句
				String sql = "select * from proprieters where name=? and password=?;";
				//3.调用runner.query()方法
				Proprieter proprieter = runner.query(sql, new BeanHandler<Proprieter>(Proprieter.class),name,password);
				
				return proprieter;
			}
			

			/**
			 * 增加社团负责人用户
			 * @param user
			 * @return
			 * @throws SQLException
			 */
			
			public boolean insertProprieter(Proprieter user) throws SQLException {
				//创建QueryRunner 对象
				QueryRunner runner = new QueryRunner(ds);
				//sql语句
				String sql = "insert into proprieters(name,password,club) values(?,?,?);";
				//调用runner.update(),row为执行该方法所改变的行数
				int row = runner.update(sql,new Object[] {user.getName(),user.getPassword(),user.getClub()});
				if(row>0) {
					//插入成功
					return true;
				}else {
					return false;
				}
			}
			
			
			
			/**
			 * 根据name修改社团负责人密码
			 * @param uname
			 * @param password
			 * @throws SQLException
			 */
			public boolean updatePassword(String uname, String password) throws SQLException {
				//创建QueryRunner 对象
				QueryRunner runner = new QueryRunner(ds);
				String sql = "update proprieters set password=? where name=?;";
				
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
			 * 删除社长用户
			 * @param uname
			 * @return
			 * @throws SQLException
			 */
			public boolean deleteProprieter(String uname) throws SQLException {
				//创建QueryRunner 对象
				QueryRunner runner = new QueryRunner(ds);
				//sql语句
				String sql = "delete from proprieters where name=?;";
				//调用runner.update(),row为执行该方法所改变的行数
				int row = runner.update(sql,uname);
				if(row>0) {
					//插入成功
					return true;
				}else {
					return false;
				}
			}
			
}
