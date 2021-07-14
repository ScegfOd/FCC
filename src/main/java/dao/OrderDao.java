package dao;

import java.util.Map;

import models.Order;

public interface OrderDao {
	Map<Integer, Order> getAll();
	Map<Integer, Order> getAll(Integer customerId);
	Order getOne(Integer id);
	Map<Integer, Order> getPending();
	Map<Integer, Order> getPending(String customerId);
	Map<Integer, Order> getCompleted();
	Map<Integer, Order> getCompleted(Integer customerId);
	void createOrer(Order order);
	void updateOrder(Integer id, Order newOrder);
	void deleteOrer(Integer id);
}