package edu.hfnu.DBUtilsDao;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import edu.hfnu.model.PlanCheckTable;
import edu.hfnu.utils.C3p0Utils;

public class PlanCheckDao {
	//获取C3P0数据源
	DataSource ds = C3p0Utils.getDataSource();
		
		/**
		 * 新增一条工作计划申请记录
		 * @param obj
		 * @return
		 * @throws SQLException
		 */
		public boolean insert(PlanCheckTable obj) throws SQLException {
			//1.创建QueryRunner对象
			QueryRunner runner = new QueryRunner(ds);
			//2.sql语句
			String sql = "insert into plancheck(plantime,plancontent,proposer,status,reason) values(?,?,?,?,?);";
			//3.调用 QueryRunner对象的update()方法，其返回的row是发生改变的数据行数
			int row = runner.update(sql,obj.getPlantime(),obj.getPlancontent(),obj.getProposer(),obj.getStatus(),obj.getReason());
			if(row>0) {
				//改变的行数不为0，插入成功
				return true;
			}else {
				return false;
			}
		}
		
		/**
		 * 根据申请工作计划记录的id来删除一条记录
		 * @param prizewinner
		 * @return
		 * @throws SQLException
		 */
		public boolean delete(int id) throws SQLException {
			//1.创建QueryRunner对象
			QueryRunner runner = new QueryRunner(ds);
			//2.sql语句
			String sql = "delete from plancheck where id=?;";
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
		public List<PlanCheckTable> findAllForTeacher(String status) throws SQLException{
			//创建QueryRunner 对象
			QueryRunner runner = new QueryRunner(ds);
			//sql
			String sql = "select * from plancheck where status=?;";
			//调用query方法
			List<PlanCheckTable> list = runner.query(sql,new BeanListHandler<PlanCheckTable>(PlanCheckTable.class),status);
			return list;
			
		}
		
		
		
		/**
		 * 根据一个审核状态获取表中的所有数据条数
		 * @return
		 * @throws SQLException
		 */
		public int countAll(String status) throws SQLException {
			//创建QueryRunner 对象
			QueryRunner runner = new QueryRunner(ds);
			//sql
			String sql = "select count(*) from plancheck where status=?;";
			//调用query方法
			Object number = runner.query(sql, new ScalarHandler<Object>(),status);
			
			return Integer.parseInt(number.toString());
		}
		
		

		/**
		 * 返回表中所有数据
		 * @param status
		 * @return
		 * @throws SQLException
		 */
		public List<PlanCheckTable> findAll() throws SQLException{
			//创建QueryRunner 对象
			QueryRunner runner = new QueryRunner(ds);
			//sql
			String sql = "select * from plancheck;";
			//调用query方法
			List<PlanCheckTable> list = runner.query(sql,new BeanListHandler<PlanCheckTable>(PlanCheckTable.class));
			return list;
			
		}
		
		
		
		/**
		 *返回所有数据条数
		 * @return
		 * @throws SQLException
		 */
		public int countAll() throws SQLException {
			//创建QueryRunner 对象
			QueryRunner runner = new QueryRunner(ds);
			//sql
			String sql = "select count(*) from plancheck;";
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
			String sql = "update plancheck set status=? where id=?;";
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
			String sql = "update plancheck set reason=? where id=?;";
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
			String sql = "update plancheck set reason='未填写'  where id=?;";
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
