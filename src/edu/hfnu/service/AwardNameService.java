package edu.hfnu.service;

import java.sql.SQLException;
import java.util.List;

import edu.hfnu.DBUtilsDao.AwardNameDao;
import edu.hfnu.model.AwardNameTable;

public class AwardNameService {
	AwardNameDao dao = new AwardNameDao();
	
	/**
	 * 增加一条获奖人员记录，从社长获取
	 * @param obj
	 * @return
	 * @throws SQLException
	 */
	public boolean addOne(AwardNameTable obj) throws SQLException {
		return dao.insert(obj);
	}
	
	/**
	 * 根据获奖人姓名删除一条记录，从组织部获取
	 * @param prizewinner
	 * @return
	 * @throws SQLException
	 */
	public boolean deleteOne(String prizewinner) throws SQLException {
		return dao.delete(prizewinner);
	}
	
	/**
	 * 获取获奖人员表中所有数据
	 * @return
	 * @throws SQLException
	 */
	public List<AwardNameTable> findAll() throws SQLException{
		return dao.findAll();
	}
	
	/**
	 * 获取所有数据条数
	 * @return
	 * @throws SQLException
	 */
	public int countAll() throws SQLException {
		return dao.countAll();
	}
}
