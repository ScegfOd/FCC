package service;

import java.util.Map;

import dao.UserDao;
import dao.UserDaoImpl;
import models.User;

public class UserServiceImpl implements UserService{
	
	private UserDao userDao;
	
	public UserServiceImpl() {
		this.userDao = new UserDaoImpl();
	}

	// fetch a particular user
	public User getUser(String id) {
		return this.userDao.getUser(id);
	}
	
	// fetch all users
	public Map<Integer, User> getAll(){
		return this.userDao.getAll();
	}
	
	// fetch all users for a given role
	public Map<Integer, User> getAll(String role){
		return this.userDao.getAll(role);
	}
	
	// login for the customer portal
	public User customerLogin(String id, String password) {
		return this.userDao.customerLogin(id, password);
	}
	
	// login for the employee portal (should work for both employees and managers)
	public User employeeLogin(String id, String password) {
		return this.userDao.employeeLogin(id, password);
	}
	
	// create a new user (should work for all roles)
	public void createUser(String id, String role, String name, String password) {
		this.userDao.createUser(new User(id, role, name, password));
	}
	
	// delete a user from the database
	public void deleteUser(String id) {
		this.userDao.deleteUser(id);
	}
}
