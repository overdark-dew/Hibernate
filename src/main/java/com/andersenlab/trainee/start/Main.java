package com.andersenlab.trainee.start;

import java.sql.SQLException;
import java.util.Collection;
import java.util.Iterator;
//import util.HibernateUtil;
//import java.util.Scanner;

//import com.andersenlab.trainee.dao.OrderDAOimpl;
import com.andersenlab.trainee.tables.Order;
import com.andersenlab.trainee.tables.User;

public class Main {

	public static void main(String[] args) throws SQLException {

		Collection<User> users = Factory.getInstance().getUserDAO().getAllUser();

		Iterator<User> iterator = users.iterator();
		System.out.println("========Все пользователи=========");
		while (iterator.hasNext()) {
			User user = (User) iterator.next();
			System.out.println("Пользователь: " + user.getName() + "  ID: " + user.getId());

		}

		Collection<Order> Orders = Factory.getInstance().getOrderDAO().getAllOrders();

		Iterator<Order> iterator1 = Orders.iterator();
		System.out.println("========Все заказы=========");
		while (iterator1.hasNext()) {
			Order order = (Order) iterator1.next();
			System.out.println("Заказ №: " + order.getId() + " Статус: " + order.getStatus());

		}
		int n = 2;
		Order ordern = Factory.getInstance().getOrderDAO().getOrderById(n);
		System.out.println("========Все заказ № " + n +"=========");
		System.out.println("Заказ №: " + ordern.getId() + " Статус: " + ordern.getStatus());
//		if (orderDAO == null) {
//			orderDAO = new OrderDAOimpl();
//
//		User us = new User();
//		us.setName("Ибрагим");
//		
//
//		try {
//			UserDAO.addUser(us);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

	}

}
