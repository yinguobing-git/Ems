package util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

public class JdbcUtil {
	
	private static Properties  map = new Properties();
	
	static{
		InputStream is = null;
		try {
			// 读取配置文件内容，获取四个值
			is = JdbcUtil.class.getResourceAsStream("/conf/jdbc.properties");
			map.load(is);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(is!=null) try{ is.close(); }catch(Exception ee){}
		}
	}
	
	private static final ThreadLocal<Connection> tol = new ThreadLocal<Connection>();
	
	public static Connection getConnection() throws Exception{
		Connection conn = tol.get();
		if(conn==null){
		   Class.forName( map.getProperty("driver"));
		   conn = DriverManager.getConnection(map.getProperty("url"),map.getProperty("username"),map.getProperty("password"));
	       tol.set(conn);
		}
		return conn;
	
	}
	
	public static void close(ResultSet rs , PreparedStatement pstm , Connection conn){
		if( rs!=null) try{ rs.close(); }catch(Exception e){}
		if( pstm!=null) try{ pstm.close(); }catch(Exception e){}
		if( conn!=null) try{ conn.close();  tol.remove(); }catch(Exception e){}
	}

	public static void close(PreparedStatement pstm , Connection conn){
		if( pstm!=null) try{ pstm.close(); }catch(Exception e){}
		if( conn!=null) try{ conn.close();  tol.remove(); }catch(Exception e){}
	}
	
}


