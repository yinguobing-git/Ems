package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import util.JdbcUtil;
import dao.ManagerDao;
import entity.Manager;

public class ManagerDaoImpl implements ManagerDao {

	@Override
	public void insertOneManager(Manager m) {
		Connection conn =null;
		PreparedStatement pstm =null;
		try{
			conn=JdbcUtil.getConnection();
			String sql="insert into manager values(manager_id.nextval,?,?,?,?)";
			pstm=conn.prepareStatement(sql);
			pstm.setString(1, m.getName());
			pstm.setString(2, m.getUsername());
			pstm.setString(3, m.getPassword());
			pstm.setString(4, m.getSex());
			pstm.executeUpdate();
		}catch(Exception e){
			throw new RuntimeException(e.getMessage());
		}finally{
			JdbcUtil.close(pstm, null);
		}
	}

	@Override
	public Manager selectOneManager(String username) {
		Connection conn =null;
		PreparedStatement pstm =null;
		ResultSet rs =null;
		Manager m=null;
		try{
			conn=JdbcUtil.getConnection();
			String sql="select * from manager where username=?";
			pstm=conn.prepareStatement(sql);
			pstm.setString(1, username);
			rs=pstm.executeQuery();
			if(rs.next()){
				m=new Manager();
				m.setId(rs.getInt(1));
				m.setName(rs.getString(2));
				m.setUsername(rs.getString(3));
				m.setPassword(rs.getString(4));
				m.setSex(rs.getString(5));
			}return m;
		}catch(Exception e){
			throw new RuntimeException(e.getMessage());
		}finally{
			JdbcUtil.close(rs,pstm, null);
		}
	}

}
