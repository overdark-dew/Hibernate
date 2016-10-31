package com.andersenlab.trainee.dao;

import java.sql.SQLException;
import java.util.Collection;

import com.andersenlab.trainee.tables.Order;
import com.andersenlab.trainee.tables.User;

public interface UserDAO {

	public void addUser(User user) throws SQLException;

	public User getUserById(User user) throws SQLException;

	public Collection<User> getAllUser() throws SQLException;

	public void deleteUser(User user) throws SQLException;

	public Collection<Order> getOrderByUser(User user) throws SQLException;

}
