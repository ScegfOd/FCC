import java.math.BigDecimal;
import java.sql.Timestamp;

import models.Order;
import models.User;

public class Main {
	public static void main(String[] args) {
		// set up some dummy users
		User newCustomer = new User("customer@email.com", "customer", "New Customer", "password");
		User newEmployee = new User("EMP-001", "employee", "New Employee", "password");
		
		// this is the constructor we would use when a new order is created
		Order newOrder = new Order(newCustomer.getId(), "Chicken", new BigDecimal(9.51), new Timestamp(System.currentTimeMillis()));
		
		// this is the constructor we would use when retrieving an order from the database
		Order pastOrder = new Order(1, "customer id", "complete", "more chicken", new BigDecimal(9.99), new Timestamp(System.currentTimeMillis()), 
									new Timestamp(System.currentTimeMillis()), "employee id");
		
		
		System.out.println(newCustomer);
		System.out.println(newEmployee);
		System.out.println(newOrder);
		System.out.println(pastOrder);
	}
}
