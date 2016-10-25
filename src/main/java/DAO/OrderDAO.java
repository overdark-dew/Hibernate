package DAO;

import Tables.User;
import Tables.Order;

import java.util.Collection;
import java.sql.SQLException;

public interface OrderDAO {

	public void addOrder(Order order) throws SQLException;

	public void updateOrder(Integer order_id, Order order) throws SQLException;

	public Order getOrderById(Integer order_id) throws SQLException;

	public Collection<Order> getOrderByStatus(Order order) throws SQLException;

	public Collection<Order> getAllOrders() throws SQLException;

	public void deleteOrder(Order order) throws SQLException;

	public Collection<Order> getOrderByUser(User user) throws SQLException;
}
