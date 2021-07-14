package service;

import java.util.Map;

import models.User;

public interface UserService {
	// fetch a particular user
	User getUser(String id);
	// fetch all users
	Map<Integer, User> getAll();
	// fetch all users for a given role
	Map<Integer, User> getAll(String role);
	// login for the customer portal
	User customerLogin(String id, String password); 
	// login for the employee portal (should work for both employees and managers)
	User employeeLogin(String id, String password); 
	// create a new user (should work for all roles)
	void createUser(String id, String role, String name, String password);
	// delete a user from the database
	void deleteUser(String id);
}
