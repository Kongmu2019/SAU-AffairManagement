package edu.hfnu.service;

import java.sql.SQLException;
import java.util.List;

import edu.hfnu.DBUtilsDao.ClubEvaluateDao;
import edu.hfnu.model.ClubEvaluateTable;

public class ClubEvaluateService {
	ClubEvaluateDao dao = new ClubEvaluateDao();
	
	/**
	 * 获取社团年审表中的所有数据
	 * @return
	 * @throws SQLException
	 */
	public List<ClubEvaluateTable> findAll() throws SQLException{
		return dao.findAll();
	}
	
	/**
	 * 返回社团年审表中的数据总数
	 * @throws SQLException 
	 */
	
	public int countAll() throws SQLException {
		return dao.countAll();
	}
	
	/**
	 * 在社团年审表中添加一条数据的方法
	 * @param c
	 * @return
	 * @throws SQLException
	 */
	public boolean addOne(ClubEvaluateTable c) throws SQLException {
		return dao.insert(c);
	}
}
