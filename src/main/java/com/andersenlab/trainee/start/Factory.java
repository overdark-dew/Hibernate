package com.andersenlab.trainee.start;

import com.andersenlab.trainee.dao.OrderDAO;
import com.andersenlab.trainee.dao.OrderDAOimpl;
import com.andersenlab.trainee.dao.UserDAO;
import com.andersenlab.trainee.dao.UserDAOimpl;

public class Factory {

	private static OrderDAO orderDAO = null;
	private static UserDAO userDAO = null;
	private static Factory instance = null;

	public static synchronized Factory getInstance() {
		if (instance == null) {
			instance = new Factory();
		}
		return instance;
	}

	public OrderDAO getOrderDAO() {
		if (orderDAO == null) {
			orderDAO = new OrderDAOimpl();
		}
		return orderDAO;
	}


	public UserDAO getUserDAO() {
		if (userDAO == null) {
			userDAO = new UserDAOimpl();
		}
		return userDAO;

	}
}
