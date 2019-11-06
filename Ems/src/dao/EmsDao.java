package dao;

import java.util.List;

import entity.Ems;

public interface EmsDao {
	public void insert(Ems e);//添加
	public void delete(int id);//删除
	public void update(Ems e);//修改
	public Ems selectById(int id);//根据id查询
	public List<Ems> selectAll();//查所有
	public Ems selectByName(String name);//根据名字查询
}
