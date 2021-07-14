import java.math.BigDecimal;
import java.sql.Timestamp;

import models.Order;
import models.User;
import service.UserService;
import service.UserServiceImpl;

public class Main {
	public static void main(String[] args) {

		UserService uservice = new UserServiceImpl();
		
		System.out.println(uservice.getUser("admin22"));
		System.out.println(uservice.getAll());
		System.out.println(uservice.getAll("employee"));
		
		uservice.createUser("test", "test", "test", "test");
		System.out.println(uservice.getUser("test"));
		uservice.deleteUser("test");
		System.out.println(uservice.getAll());
		
		System.out.println(uservice.customerLogin("jcombs@gmail.com", "password"));
		System.out.println(uservice.employeeLogin("admin22", "password1"));
		System.out.println(uservice.employeeLogin("empl13", "password1"));
	}
}
