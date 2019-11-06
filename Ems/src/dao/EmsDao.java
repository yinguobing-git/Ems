package dao;

import java.util.List;

import entity.Ems;

public interface EmsDao {
	public void insert(Ems e);//���
	public void delete(int id);//ɾ��
	public void update(Ems e);//�޸�
	public Ems selectById(int id);//����id��ѯ
	public List<Ems> selectAll();//������
	public Ems selectByName(String name);//�������ֲ�ѯ
}
