package service.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import service.EmsService;
import util.JdbcUtil;
import dao.EmsDao;
import dao.impl.EmsDaoImpl;
import entity.Ems;

public class EmsServiceImpl implements EmsService {
	 
	@Override
	public void regist(Ems e) {//添加一个联系人
		EmsDao ed =new EmsDaoImpl();
		Connection conn =null;
		try{
			conn=JdbcUtil.getConnection();
			conn.setAutoCommit(false);
			Ems ems=ed.selectByName(e.getName());
			if(ems!=null)throw new RuntimeException("对不起，名字为"+e.getName()+"的联系人已经存在，不能出现重名的联系人");
			ed.insert(e);
			conn.commit();
		}catch(Exception ee){
			if(conn!=null){
				try{
					conn.rollback();
				}catch(Exception e1) {
				
				}
				throw new RuntimeException(ee.getMessage());
			}	
		}finally{
			JdbcUtil.close(null, conn);
		}
	}

	@Override
	public void remove(int id) {//删除一个联系人
		EmsDao ed =new EmsDaoImpl();
		Connection conn =null;
		try{
			conn=JdbcUtil.getConnection();
			conn.setAutoCommit(false);
			ed.delete(id);
			conn.commit();
		}catch(Exception ee){
			try {
				if(conn!=null){
					conn.rollback();
				}
			} catch (SQLException e1) {
				
			}
			throw new RuntimeException(ee.getMessage());
		}finally{
			JdbcUtil.close(null, conn);
		}
	}

	@Override
	public void update(Ems e) {//修改一个联系人
		EmsDao ed =new EmsDaoImpl();
		Connection conn =null;
		try{
			conn=JdbcUtil.getConnection();
			conn.setAutoCommit(false);
			Ems ems=ed.selectById(e.getId());
			Ems ems1=ed.selectByName(e.getName());
			if(ems1!=null && !ems.getName().equals(e.getName()) )throw new RuntimeException("对不起，名字为"+e.getName()+"的联系人已经存在，不能修改成两个重名的联系人");
			ed.update(e);
			conn.commit();
		}catch(Exception ee){
			try {
				if(conn!=null){
					conn.rollback();
				}
			} catch (SQLException e1) {
				
			}
			throw new RuntimeException(ee.getMessage());
		}finally{
			JdbcUtil.close(null, conn);
		}
	}

	@Override
	public Ems queryById(int id) {//查询一个联系人
		EmsDao ed =new EmsDaoImpl();
		Connection conn =null;
		Ems e=null;
		try{
			conn=JdbcUtil.getConnection();
			conn.setAutoCommit(false);
			e = ed.selectById(id);
			if(e==null)throw new RuntimeException("id为"+id+"的联系人不存在");
			conn.commit();
			return e;
		}catch(Exception ee){
			if(conn!=null)try{conn.rollback();}catch(Exception e1){}
			throw new RuntimeException(ee.getMessage());
		}finally{
			JdbcUtil.close(null, null, conn);
		}
	}

	@Override
	public List<Ems> queryAll() {//查询所有联系人
		EmsDao ed =new EmsDaoImpl();
		Connection conn =null;
		List<Ems>list=new ArrayList<Ems>();
		try{
			conn=JdbcUtil.getConnection();
			conn.setAutoCommit(false);
			list=ed.selectAll();
			conn.commit();
			return list;
		}catch(Exception ee){
			if(conn!=null)try{conn.rollback();}catch(Exception e1){}
			throw new RuntimeException(ee.getMessage());
		}finally{
			JdbcUtil.close(null, null, conn);
		}
	}
}
