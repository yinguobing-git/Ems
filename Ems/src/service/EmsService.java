package service;

import java.util.List;

import entity.Ems;

public interface EmsService {
	public void regist(Ems e);//添加
	public void remove(int id);//删除
	public void update(Ems e);//修改
	public Ems queryById(int id);//查单个
	public List<Ems> queryAll();//查所有	
}
