package DAO;

import java.sql.SQLException;
import java.util.Collection;

import Tables.Order;
import Tables.User;

public interface UserDAO {

	public void addUser(User user) throws SQLException;

	public Order getUserById(Integer user_id) throws SQLException;

	public Collection<User> getAllUser() throws SQLException;

	public void deleteUser(User user) throws SQLException;

	public Collection<Order> getOrderByUser(User user) throws SQLException;

}
