/**  
* <p>Title: BaseDao.java</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) 2019</p>  
* <p>Company: </p>  
* @author wxy  
* @date 2019��7��29��  
* @version 1.0  
*/
package com.rfid.dao;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.dao.config.IResultSetHandler;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import com.util.PropertiesUtils;

/**
 * <p>
 * Title: BaseDao
 * </p>
 * <p>
 * Description:
 * </p>
 * 
 * @author wangxuanye
 * @date 2019��7��29��
 */
public class BaseDao {

	private static BaseDao instance = null;
	// ���� ���ݿ�����
	private static String driverClass;
	// ���� ���ݿ������
	private static String url;
	// ���� ���ݿ��û�
	private static String user;
	// ���� ���ݿ��û�������
	private static String password;
	// ���� ���ݿ��
	protected static String table;

	protected static String datatable;

	static {

		// getClassLoader()��ȡ�ø�Class�������װ����
		// getResourceAsStream(��db.properties��) ������������ķ���������Դ���������ֽ�������
//            InputStream in = BaseDao.class.getClassLoader().getResourceAsStream("db.properties");
		// ʵ����Properties����Ŀ����Ϊ�˴���props
		PropertiesUtils props = new PropertiesUtils(
				System.getProperty("user.dir").replace("\\", "/") + "/db.properties");
		// ��props�����п��Խ��м��������б�Properties�����
//            props.load(in);//Ҳ����˵: ͨ��props������м�������������in��
		/*
		 * ͨ��getProperty������ָ���ļ��ڴ������б�����������
		 */
		// Ҳ����˵: ͨ��props������л�ȡ��db.properties���е�ָ���ļ�-driverClass����ָ����
		driverClass = (String) props.getProperty("jdbc.driverClass");
		// Ҳ����˵: ͨ��props������л�ȡ��db.properties���е�ָ���ļ�-url����ָ����
		url = (String) props.getProperty("jdbc.url");
		// Ҳ����˵: ͨ��props������л�ȡ��db.properties���е�ָ���ļ�-user����ָ����
		user = (String) props.getProperty("jdbc.user");
		// Ҳ����˵: ͨ��props������л�ȡ��db.properties���е�ָ���ļ�-password����ָ����
		password = (String) props.getProperty("jdbc.password");
		// �Ѿ���ȡ�������ļ��е����Լ�ֵ�ԣ����ֽ������������ͷŹر�
		table = (String) props.getProperty("jdbc.table");

		datatable = (String) props.getProperty("jdbc.Datatable");

		try {
			Class.forName(driverClass);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

//	���ڻ�ȡ��ǰ���Ψһʵ��
	public static BaseDao getInstance() {
		if (instance == null) {
//			�ӳټ�����Ҫ���ǲ������⣬���Ը���ǰ�����
			synchronized (BaseDao.class) {
				if (instance == null) {
					instance = new BaseDao();
				}
			}
		}

		return instance;
	}

	public Connection getConnection() {
		Connection con = null;
		try {
			con = (Connection) DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}

	public void closeAll(Connection con, Statement stmt, ResultSet rs) {
		if (null != rs) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (null != stmt) {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (null != con) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * ��ɾ�Ĳ���
	 * 
	 * @param sql    �����SQL���
	 * @param params �ɱ����
	 * @return �������
	 */
	public int ExecuteNonQuery(String sql, Object... params) {
		int count = 0;
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = this.getConnection();
			pstmt = (PreparedStatement) con.prepareStatement(sql);
			if (null != params) {
				for (int i = 0; i < params.length; i++) {
					pstmt.setObject(i + 1, params[i]);
				}
			}
			count = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			this.closeAll(con, pstmt, null);
		}
		return count;
	}

	/**
	 * ��ѯ����
	 * 
	 * @param sql     SQL���
	 * @param handler �жϲ�ѯһ�����Ƕ��
	 * @param params  �ɱ����
	 * @param         <T> ���������ʵ����
	 * @return ����IResultSetHandler�ӿ��еķ���
	 */
	public <T> T executeQuery(String sql, IResultSetHandler<T> handler, Object... params) {
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		try {
			// ��ȡ���ݿ����Ӷ���
			conn = this.getConnection();
			// ��ȡԤ����������
			psmt = (PreparedStatement) conn.prepareStatement(sql);
			// ��Ԥ������丳ֵ
			for (int i = 0; i < params.length; i++) {
				psmt.setObject(i + 1, params[i]);
			}
			// ִ��SQL����ȡ�����
			rs = psmt.executeQuery();
			// ��������
			return handler.handle(rs);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// �ر����ݿ�����
			this.closeAll(conn, psmt, rs);
		}
		return null;
	}

	public static boolean createDatabase(String database) {
		BaseDao bd = getInstance();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;// ���ݿ�����
		try {
			conn = bd.getConnection();
			stmt = (Statement) conn.createStatement();
			String sql = "SELECT COUNT(*) FROM information_schema.schemata WHERE schema_name=\"" + database + "\"";
			System.out.println(sql);
			rs = stmt.executeQuery(sql);
			if (rs.next()) {
				if (rs.getInt(1) == 0) {
					String createdatabase = "create database " + database
							+ " character set utf8 collate utf8_general_ci";
					System.out.println(createdatabase);
					stmt.executeUpdate(createdatabase);
				}
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			bd.closeAll(conn, stmt, rs);
		}
		return false;
	}

}
