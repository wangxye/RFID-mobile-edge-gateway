/**  
* <p>Title: BaseDao.java</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) 2019</p>  
* <p>Company: </p>  
* @author wxy  
* @date 2019年7月29日  
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
 * @date 2019年7月29日
 */
public class BaseDao {

	private static BaseDao instance = null;
	// 定义 数据库驱动
	private static String driverClass;
	// 定义 数据库的连接
	private static String url;
	// 定义 数据库用户
	private static String user;
	// 定义 数据库用户的密码
	private static String password;
	// 定义 数据库表
	protected static String table;

	protected static String datatable;

	static {

		// getClassLoader()是取得该Class对象的类装载器
		// getResourceAsStream(“db.properties”) 调用类加载器的方法加载资源，返回是字节输入流
//            InputStream in = BaseDao.class.getClassLoader().getResourceAsStream("db.properties");
		// 实例化Properties对象，目的是为了创建props
		PropertiesUtils props = new PropertiesUtils(
				System.getProperty("user.dir").replace("\\", "/") + "/db.properties");
		// 在props对象中可以进行加载属性列表到Properties类对象
//            props.load(in);//也就是说: 通过props对象进行加载输入流对象（in）
		/*
		 * 通过getProperty方法用指定的键在此属性列表中搜索属性
		 */
		// 也就是说: 通过props对象进行获取【db.properties】中的指定的键-driverClass（被指定）
		driverClass = (String) props.getProperty("jdbc.driverClass");
		// 也就是说: 通过props对象进行获取【db.properties】中的指定的键-url（被指定）
		url = (String) props.getProperty("jdbc.url");
		// 也就是说: 通过props对象进行获取【db.properties】中的指定的键-user（被指定）
		user = (String) props.getProperty("jdbc.user");
		// 也就是说: 通过props对象进行获取【db.properties】中的指定的键-password（被指定）
		password = (String) props.getProperty("jdbc.password");
		// 已经获取过配置文件中的属性键值对，将字节输入流进行释放关闭
		table = (String) props.getProperty("jdbc.table");

		datatable = (String) props.getProperty("jdbc.Datatable");

		try {
			Class.forName(driverClass);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

//	用于获取当前类的唯一实例
	public static BaseDao getInstance() {
		if (instance == null) {
//			延迟加载需要考虑并发问题，所以给当前类加锁
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
	 * 增删改操作
	 * 
	 * @param sql    传入的SQL语句
	 * @param params 可变参数
	 * @return 操作结果
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
	 * 查询操作
	 * 
	 * @param sql     SQL语句
	 * @param handler 判断查询一个还是多个
	 * @param params  可变参数
	 * @param         <T> 具体操作的实体类
	 * @return 返回IResultSetHandler接口中的泛型
	 */
	public <T> T executeQuery(String sql, IResultSetHandler<T> handler, Object... params) {
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		try {
			// 获取数据库连接对象
			conn = this.getConnection();
			// 获取预编译语句对象
			psmt = (PreparedStatement) conn.prepareStatement(sql);
			// 给预编译语句赋值
			for (int i = 0; i < params.length; i++) {
				psmt.setObject(i + 1, params[i]);
			}
			// 执行SQL语句获取结果集
			rs = psmt.executeQuery();
			// 处理结果集
			return handler.handle(rs);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 关闭数据库连接
			this.closeAll(conn, psmt, rs);
		}
		return null;
	}

	public static boolean createDatabase(String database) {
		BaseDao bd = getInstance();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;// 数据库结果集
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
