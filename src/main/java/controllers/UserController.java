package controllers;

import io.javalin.http.Context;
import models.User;
import service.UserService;
import service.UserServiceImpl;

public class UserController {
	
	static UserService userService = new UserServiceImpl();
	
	// fetch a particular user
	public static void getUser(Context context) {
		String id = context.pathParam("id");
		User result = userService.getUser(id);
		
		if(result == null) {
			context.result("No user exists with that ID");
		} else {
			context.json(result);
		}
		
	}

	// fetch all users
	public static void getAll(Context context) {
		context.json(userService.getAll());
	}
	
	// fetch all users for a particular role
	public static void getAllByRole(Context context) {
		String role = context.pathParam("role");
		context.json(userService.getAll(role));
	}
	
	// login for the customer portal
	public static void customerLogin(Context context) {
		String id = context.formParam("id");
		String password = context.formParam("password");
		
		User result = userService.customerLogin(id, password);
		
		if(result == null) {
			// return an error message
			context.result("Invalid credentials");
		} else {
			// set the session variables for current user and user role
			context.sessionAttribute("currentUser", result.getId());
			context.sessionAttribute("userRole", result.getRole());
			
			// print it in the console to verify
			System.out.println(context.sessionAttributeMap());
			
			// return the user information
			context.json(result);
		}
	}
	
	// login for the employee portal
	public static void employeeLogin(Context context) {
		String id = context.formParam("id");
		String password = context.formParam("password");
		
		User result = userService.employeeLogin(id, password);
		
		if(result == null) {
			// return an error message
			context.result("Invalid credentials");
		} else {
			// set the session variables for current user and user role
			context.sessionAttribute("currentUser", result.getId());
			context.sessionAttribute("userRole", result.getRole());
			
			// print it in the console to verify
			System.out.println(context.sessionAttributeMap());
			
			// return the user information
			context.json(result);
		}
	}
	
	// logout (should work for customers and employees)
	public static void logout(Context context) {
		// reset the session variables to null
		context.sessionAttribute("currentUser", null);
		context.sessionAttribute("userRole", null);
		
		// print it in the console to verify
		System.out.println(context.sessionAttributeMap());
		
		// return a message 
		context.result("Logged out successfully");
	}
	
	// create a new user
	public static void createUser(Context context) {
		User user = context.bodyAsClass(User.class);
		String result = userService.createUser(user);
		context.result(result);
	}
	
	
	// delete a user from the database
	public static void deleteUser(Context context) {
		String id = context.pathParam("id");
		String result = userService.deleteUser(id);
		context.result(result);
	}
}
