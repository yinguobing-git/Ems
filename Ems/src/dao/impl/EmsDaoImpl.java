package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.management.RuntimeErrorException;

import util.JdbcUtil;
import dao.EmsDao;
import entity.Ems;

public class EmsDaoImpl implements EmsDao {

	@Override
	public void insert(Ems e) {//添加联系人
		Connection conn=null;
		PreparedStatement pstm =null;
		Ems ems=null;
		try{
			conn=JdbcUtil.getConnection();
			String sql="insert into ems values(ems_id.nextval,?,?,?,?,?)";
			pstm=conn.prepareStatement(sql);
			pstm.setString(1, e.getName());
			pstm.setDouble(2, e.getSalary());
			pstm.setInt(3, e.getAge());
			pstm.setString(4, e.getSex());
			java.sql.Date date=new java.sql.Date(e.getBirthday().getTime());
			pstm.setDate(5, date);
			pstm.executeUpdate();
			
		}catch(Exception e1){
			e1.printStackTrace();
			throw new RuntimeException(e1.getMessage());
		}finally{
			JdbcUtil.close(pstm, null);
		}
	}

	@Override
	public void delete(int id) {//删除联系人
		Connection conn=null;
		PreparedStatement pstm =null;
		Ems ems=null;
		try{
			conn=JdbcUtil.getConnection();
			String sql="delete from ems where id = ?";
			pstm=conn.prepareStatement(sql);
			pstm.setInt(1, id);
			pstm.executeUpdate();
		}catch(Exception e1){
			throw new RuntimeException(e1.getMessage());
		}finally{
			JdbcUtil.close(pstm, null);
		}
	}

	@Override
	
	public void update(Ems e) {//修改联系人
		Connection conn=null;
		PreparedStatement pstm =null;
		Ems ems=null;
		try{
			conn=JdbcUtil.getConnection();
			String sql="update ems set name=?, salary=?, age=?, sex=?, birthday=? where id=?";
			pstm=conn.prepareStatement(sql);
			pstm.setString(1, e.getName());
			pstm.setDouble(2, e.getSalary());
			pstm.setInt(3, e.getAge());
			pstm.setString(4, e.getSex());
			pstm.setDate(5, new java.sql.Date(e.getBirthday().getTime()));
			pstm.setInt(6, e.getId());
			pstm.executeUpdate();
		}catch(Exception e1){
			throw new RuntimeException(e1.getMessage());
		}finally{
			JdbcUtil.close(pstm, null);
		}
	}

	@Override
	public Ems selectById(int id) {//根据id查询联系人
		Connection conn=null;
		PreparedStatement pstm =null;
		ResultSet rs =null; 
		Ems e=null;
		try{
			conn=JdbcUtil.getConnection();
			String sql="select * from ems where id=?";
			pstm=conn.prepareStatement(sql);
			pstm.setInt(1, id);
			rs = pstm.executeQuery();
			if(rs.next()){
				e=new Ems();
				e.setId(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setSalary(rs.getDouble(3));
				e.setAge(rs.getInt(4));
				e.setSex(rs.getString(5));
				e.setBirthday(rs.getDate(6));
			}
			return e;
		}catch(Exception e1){
			throw new RuntimeException(e1.getMessage());
		}finally{
			JdbcUtil.close(rs, pstm, null);
		}
	}

	@Override
	public List<Ems> selectAll() {//查询所有联系人
		Connection conn=null;
		PreparedStatement pstm =null;
		ResultSet rs =null; 
		List<Ems>list=new ArrayList<Ems>();
		try{
			conn=JdbcUtil.getConnection();
			String sql="select * from ems";
			pstm=conn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while(rs.next()){
				Ems e=new Ems();
				e.setId(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setSalary(rs.getDouble(3));
				e.setAge(rs.getInt(4));
				e.setSex(rs.getString(5));
				e.setBirthday(rs.getDate(6));
				list.add(e);
			}
			return list;
		}catch(Exception e1){
			throw new RuntimeException(e1.getMessage());
		}finally{
			JdbcUtil.close(rs, pstm, null);
		}
	}

	@Override
	public Ems selectByName(String name) {//按名字查询
		Connection conn=null;
		PreparedStatement pstm =null;
		ResultSet rs =null; 
		Ems e=null;
		try{
			conn=JdbcUtil.getConnection();
			String sql="select * from ems where name=?";
			pstm=conn.prepareStatement(sql);
			pstm.setString(1, name);
			rs = pstm.executeQuery();
			if(rs.next()){
				e=new Ems();
				e.setId(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setSalary(rs.getDouble(3));
				e.setAge(rs.getInt(4));
				e.setSex(rs.getString(5));
				e.setBirthday(rs.getDate(6));
			}
			return e;
		}catch(Exception e1){
			throw new RuntimeException(e1.getMessage());
		}finally{
			JdbcUtil.close(rs, pstm, null);
		}
	}
}
