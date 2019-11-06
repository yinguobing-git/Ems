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
	public void regist(Ems e) {//���һ����ϵ��
		EmsDao ed =new EmsDaoImpl();
		Connection conn =null;
		try{
			conn=JdbcUtil.getConnection();
			conn.setAutoCommit(false);
			Ems ems=ed.selectByName(e.getName());
			if(ems!=null)throw new RuntimeException("�Բ�������Ϊ"+e.getName()+"����ϵ���Ѿ����ڣ����ܳ�����������ϵ��");
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
	public void remove(int id) {//ɾ��һ����ϵ��
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
	public void update(Ems e) {//�޸�һ����ϵ��
		EmsDao ed =new EmsDaoImpl();
		Connection conn =null;
		try{
			conn=JdbcUtil.getConnection();
			conn.setAutoCommit(false);
			Ems ems=ed.selectById(e.getId());
			Ems ems1=ed.selectByName(e.getName());
			if(ems1!=null && !ems.getName().equals(e.getName()) )throw new RuntimeException("�Բ�������Ϊ"+e.getName()+"����ϵ���Ѿ����ڣ������޸ĳ�������������ϵ��");
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
	public Ems queryById(int id) {//��ѯһ����ϵ��
		EmsDao ed =new EmsDaoImpl();
		Connection conn =null;
		Ems e=null;
		try{
			conn=JdbcUtil.getConnection();
			conn.setAutoCommit(false);
			e = ed.selectById(id);
			if(e==null)throw new RuntimeException("idΪ"+id+"����ϵ�˲�����");
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
	public List<Ems> queryAll() {//��ѯ������ϵ��
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
