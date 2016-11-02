package com.andersenlab.trainee.dao;

import java.util.Collection;

import com.andersenlab.trainee.tables.Order;
//import com.andersenlab.trainee.tables.User;

import java.sql.SQLException;

public interface OrderDAO {

	public void addOrder(Order order) throws SQLException;

	public void updateOrder(Integer order_id, Order order) throws SQLException;

	public Order getOrderById(Integer order_id) throws SQLException;

	public Collection<Order> getOrderByStatus() throws SQLException;

	public Collection<Order> getAllOrders() throws SQLException;

	public void deleteOrder(Order order) throws SQLException;

	public Collection<Order> getOrderByUser(Integer user_id) throws SQLException;
}
