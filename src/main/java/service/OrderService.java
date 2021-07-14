package service;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Map;

import models.Order;

public interface OrderService {
	// fetch a particular order
	Order getOne(int id);
	// fetch all orders
	Map<Integer, Order> getAll();
	// fetch all orders for a given customer
	Map<Integer, Order> getAll(String customerId);
	// fetch all pending orders
	Map<Integer, Order> getPending();
	// fetch all pending orders for a particular customer
	Map<Integer, Order> getPending(String customerId);
	// fetch all completed orders
	Map<Integer, Order> getCompleted();
	// fetch all completed orders for a particular customer
	Map<Integer, Order> getCompleted(Integer customerId);
	// create a new order
	void createOrer(String customerId, String items, BigDecimal total, Timestamp timePlaced);
	// update an existing order
	void updateOrder(int id, String customerId, String status, String items, BigDecimal total, Timestamp timePlaced, Timestamp timeCompleted, String employeeId, String notes);
	// change the status of an order
	void setOrderStatus(int id, String employeeId, String status);
	// cancel an order
	void cancelOrder(int id, String notes);
	// delete an order from the database
	void deleteOrer(int id);
}
