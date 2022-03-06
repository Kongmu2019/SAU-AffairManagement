package edu.hfnu.DBUtilsDao;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import edu.hfnu.model.NewClubTable;
import edu.hfnu.utils.C3p0Utils;

public class NewClubDao {
	//获取C3P0数据源
	DataSource ds = C3p0Utils.getDataSource();
		
		/**
		 * 新增一条社团成立申请记录
		 * @param obj
		 * @return
		 * @throws SQLException
		 */
		public boolean insert(NewClubTable obj) throws SQLException {
			//1.创建QueryRunner对象
			QueryRunner runner = new QueryRunner(ds);
			//2.sql语句
			String sql = "insert into newclub(clubname,proprieter,applytime,status1,status2,reason1,reason2) values(?,?,?,?,?,?,?);";
			//3.调用 QueryRunner对象的update()方法，其返回的row是发生改变的数据行数
			int row = runner.update(sql,obj.getClubname(),obj.getProprieter(),obj.getApplytime(),obj.getStatus1(),obj.getStatus2(),obj.getReason1(),obj.getReason2());
			if(row>0) {
				//改变的行数不为0，插入成功
				return true;
			}else {
				return false;
			}
		}
		
		/**
		 * 根据申请成立社团记录的社团名称来删除一条记录
		 * @param prizewinner
		 * @return
		 * @throws SQLException
		 */
		public boolean delete(String clubname) throws SQLException {
			//1.创建QueryRunner对象
			QueryRunner runner = new QueryRunner(ds);
			//2.sql语句
			String sql = "delete from newclub where clubname=?;";
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
		 * 根据组织部审核状态取出对应用户应该审核的数据
		 * @param status1
		 * @return
		 * @throws SQLException
		 */
		public List<NewClubTable> findAllByOne(String status1) throws SQLException{
			//创建QueryRunner 对象
			QueryRunner runner = new QueryRunner(ds);
			//sql
			String sql = "select * from newclub where status1=?;";
			//调用query方法
			List<NewClubTable> list = runner.query(sql,new BeanListHandler<NewClubTable>(NewClubTable.class),status1);
			return list;
			
		}
		
		/**
		 * 根据两个审核状态取出对应用户应该审核的数据
		 * @return
		 * @throws SQLException
		 */
		public List<NewClubTable> findAll(String status1,String status2) throws SQLException{
			//创建QueryRunner 对象
			QueryRunner runner = new QueryRunner(ds);
			//sql
			String sql = "select * from newclub where status1=? and status2=?;";
			//调用query方法
			List<NewClubTable> list = runner.query(sql,new BeanListHandler<NewClubTable>(NewClubTable.class),status1,status2);
			return list;
			
		}
		
		/**
		 *取出所有数据
		 * @return
		 * @throws SQLException
		 */
		public List<NewClubTable> findAll() throws SQLException{
			//创建QueryRunner 对象
			QueryRunner runner = new QueryRunner(ds);
			//sql
			String sql = "select * from newclub;";
			//调用query方法
			List<NewClubTable> list = runner.query(sql,new BeanListHandler<NewClubTable>(NewClubTable.class));
			return list;
			
		}
		
		/**
		 * 根据两个审核状态是或关系取数据,主要用于汇总审核失败的申请记录，即status1=reject or status2=reject
		 */
		public List<NewClubTable> findAllForProprieter(String status1,String status2) throws SQLException{
			//创建QueryRunner 对象
			QueryRunner runner = new QueryRunner(ds);
			//sql
			String sql = "select * from newclub where status1=? or status2=?;";
			//调用query方法
			List<NewClubTable> list = runner.query(sql,new BeanListHandler<NewClubTable>(NewClubTable.class),status1,status2);
			return list;
			
		} 
		
		/**
		 * 根据两个审核状态获取荣誉证书审核表中的所有数据条数
		 * @return
		 * @throws SQLException
		 */
		public int countAll(String status1,String status2) throws SQLException {
			//创建QueryRunner 对象
			QueryRunner runner = new QueryRunner(ds);
			//sql
			String sql = "select count(*) from newclub where status1=? and status2=?;";
			//调用query方法
			Object number = runner.query(sql, new ScalarHandler<Object>(),status1,status2);
			
			return Integer.parseInt(number.toString());
		}
		
		/**
		 * 根据一个审核状态获取荣誉证书审核表中的所有数据条数
		 * @return
		 * @throws SQLException
		 */
		public int countAll(String status1) throws SQLException {
			//创建QueryRunner 对象
			QueryRunner runner = new QueryRunner(ds);
			//sql
			String sql = "select count(*) from newclub where status1=?;";
			//调用query方法
			Object number = runner.query(sql, new ScalarHandler<Object>(),status1);
			
			return Integer.parseInt(number.toString());
		}
		
		/**
		 * 取出所有数据条数
		 * @return
		 * @throws SQLException
		 */
		public int countAll() throws SQLException {
			//创建QueryRunner 对象
			QueryRunner runner = new QueryRunner(ds);
			//sql
			String sql = "select count(*) from newclub;";
			//调用query方法
			Object number = runner.query(sql, new ScalarHandler<Object>());
			
			return Integer.parseInt(number.toString());
		}
		
		/**
		 * 根据对应的社团名称修改组织部审核状态
		 * @param clubname
		 * @param status1
		 * @return
		 * @throws SQLException
		 */
		public boolean updateHonorForMinister(String clubname,String status1) throws SQLException {
			//1.创建QueryRunner对象
			QueryRunner runner = new QueryRunner(ds);
			//2.sql
			String sql = "update newclub set status1=? where clubname=?;";
			//3.调用 QueryRunner对象的update()方法，其返回的row是发生改变的数据行数
			int row = runner.update(sql,status1,clubname);
			if(row>0) {
				//改变的行数不为0，修改成功
				return true;
			}else {
				return false;
			}
		}
		
		/**
		 * 根据对应的社团名称修改团委审核状态
		 * @param clubname
		 * @param status1
		 * @return
		 * @throws SQLException
		 */
		public boolean updateHonorForTeacher(String clubname,String status2) throws SQLException {
			//1.创建QueryRunner对象
			QueryRunner runner = new QueryRunner(ds);
			//2.sql
			String sql = "update newclub set status2=? where clubname=?;";
			//3.调用 QueryRunner对象的update()方法，其返回的row是发生改变的数据行数
			int row = runner.update(sql,status2,clubname);
			if(row>0) {
				//改变的行数不为0，修改成功
				return true;
			}else {
				return false;
			}
		}
		
		/**
		 * 组织部修改审核记录中否决原因的方法
		 * @param id
		 * @param reason1
		 * @return
		 * @throws SQLException
		 */
		public boolean updateReason1(int id,String reason1) throws SQLException {
			//1.创建QueryRunner对象
			QueryRunner runner = new QueryRunner(ds);
			//2.sql
			String sql = "update newclub set reason1=? where id=?;";
			//3.调用 QueryRunner对象的update()方法，其返回的row是发生改变的数据行数
			int row = runner.update(sql,reason1,id);
			if(row>0) {
				//改变的行数不为0，修改成功
				return true;
			}else {
				return false;
			}
		}
		
		/**
		 * 团委修改审核记录中否决原因的方法
		 * @param id
		 * @param reason2
		 * @return
		 * @throws SQLException
		 */
		public boolean updateReason2(int id,String reason2) throws SQLException {
			//1.创建QueryRunner对象
			QueryRunner runner = new QueryRunner(ds);
			//2.sql
			String sql = "update newclub set reason2=? where id=?;";
			//3.调用 QueryRunner对象的update()方法，其返回的row是发生改变的数据行数
			int row = runner.update(sql,reason2,id);
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
			String sql = "update newclub set reason1='未填写'，reason2='未填写'  where id=?;";
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
