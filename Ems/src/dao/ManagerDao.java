package dao;

import entity.Manager;

public interface ManagerDao {
	public void insertOneManager(Manager m);
	public Manager selectOneManager(String username);
}
