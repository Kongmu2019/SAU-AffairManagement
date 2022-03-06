package edu.hfnu.utils;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3p0Utils {
	private static DataSource ds;
	static {
		//初始化数据源,采用c3p0-config.xml文件中的saumaster配置方法
		ds = new ComboPooledDataSource("saumaster");
	}
	
	//静态方法getDataSource() 用于返回数据源对象ds
	public static DataSource getDataSource() {
		return ds;
	}
	
	//提供连接对象
	public static Connection getConnection() throws SQLException {
		return ds.getConnection();
	}
}
