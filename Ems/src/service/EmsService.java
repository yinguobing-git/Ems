package service;

import java.util.List;

import entity.Ems;

public interface EmsService {
	public void regist(Ems e);//���
	public void remove(int id);//ɾ��
	public void update(Ems e);//�޸�
	public Ems queryById(int id);//�鵥��
	public List<Ems> queryAll();//������	
}
