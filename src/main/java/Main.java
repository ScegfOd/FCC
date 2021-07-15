import java.math.BigDecimal;
import java.sql.Timestamp;

import models.Order;
import models.User;
import service.OrderService;
import service.OrderServiceImpl;
import service.UserService;
import service.UserServiceImpl;

public class Main {
	public static void main(String[] args) {

//		UserService uservice = new UserServiceImpl();
//		
//		System.out.println(uservice.getUser("admin22"));
//		System.out.println(uservice.getAll());
//		System.out.println(uservice.getAll("employee"));
//		
//		uservice.createUser("test", "test", "test", "test");
//		System.out.println(uservice.getUser("test"));
//		uservice.deleteUser("test");
//		System.out.println(uservice.getAll());
//		
//		System.out.println(uservice.customerLogin("jcombs@gmail.com", "password"));
//		System.out.println(uservice.employeeLogin("admin22", "password1"));
//		System.out.println(uservice.employeeLogin("empl13", "password1"));
		
		OrderService oservice = new OrderServiceImpl();
//		System.out.println(oservice.getOne(1));
//		System.out.println(oservice.getAll());
//		System.out.println(oservice.getAll("guest"));
//		System.out.println(oservice.getPending());
//		System.out.println(oservice.getPending("guest"));
//		System.out.println(oservice.getCompleted());
//		System.out.println(oservice.getCompleted("zford84@gmail.com"));

//		System.out.println(oservice.cancelOrder(23, "admin22", "canceled by customer"));
//		System.out.println(oservice.setOrderStatus(23, "admin22", "completed"));
//		System.out.println(oservice.updateOrder(23, "guest", "pending", "stuff", new BigDecimal(9.99), new Timestamp(System.currentTimeMillis()), null, null, null));
//		System.out.println(oservice.deleteOrder(22));
//		Integer newId = oservice.createOrder("guest", "test", new BigDecimal(9.99), new Timestamp(System.currentTimeMillis()));
//		System.out.println(newId);
//		System.out.println(oservice.getAll("guest"));
		System.out.println(oservice.getStats());
	}
}
