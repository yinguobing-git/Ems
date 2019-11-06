package service.impl;

import java.sql.Connection;
import java.sql.SQLException;

import dao.ManagerDao;
import dao.impl.ManagerDaoImpl;
import entity.Manager;
import service.ManagerService;
import util.JdbcUtil;

public class ManagerServiceImpl implements ManagerService {

	@Override
	public void regist(Manager m) {//注册管理员
		Connection conn=null;
		try{
			conn=JdbcUtil.getConnection();
			conn.setAutoCommit(false);
			ManagerDao md =new ManagerDaoImpl();
			md.insertOneManager(m);
			conn.commit();
		}catch(Exception e){
			try {
				if(conn!=null){
					conn.rollback();
				}
			} catch (SQLException e1) {
				throw new RuntimeException(e1.getMessage());
			}
		}finally{
			JdbcUtil.close(null, conn);
		}
	}

	@Override
	public Manager login(String username) {//管理员登录
		Connection conn=null;
		Manager m=null;
		try{
			conn=JdbcUtil.getConnection();
			conn.setAutoCommit(false);
			ManagerDao md =new ManagerDaoImpl();
			m= md.selectOneManager(username);
			conn.commit();
			return m;
		}catch(Exception e){
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			throw new RuntimeException(e.getMessage());
		}finally{
			JdbcUtil.close(null,null, conn);
		}
	}

}
