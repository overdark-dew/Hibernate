package com.andersenlab.trainee.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.swing.JOptionPane;

import org.hibernate.Query;
import org.hibernate.Session;

import com.andersenlab.trainee.tables.Order;
//import com.andersenlab.trainee.tables.User;
import com.andersenlab.trainee.util.HibernateUtil;

public class OrderDAOimpl implements OrderDAO {

	public void addOrder(Order order) throws SQLException {
		// TODO Auto-generated method stub
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.save(order);
			session.getTransaction().commit();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка при вставке", JOptionPane.OK_OPTION);
		} finally {
			if (session != null && session.isOpen()) {

				session.close();
			}
		}

	}

	public void updateOrder(Integer order_id, Order order) throws SQLException {
		// TODO Auto-generated method stub

	}

	public Order getOrderById(Integer order_id) throws SQLException {
		// TODO Auto-generated method stub
		Session session = null;
		Order order = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			order = (Order) session.get(Order.class, order_id);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка 'findById'", JOptionPane.OK_OPTION);
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return order;

	}

	@SuppressWarnings("unchecked")
	public Collection<Order> getOrderByStatus() throws SQLException {
		// TODO Auto-generated method stub
		Session session = null;
		List<Order> orders = new ArrayList<Order>();
		try {
			session = HibernateUtil.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			Integer status = 1;
			Query query = session.createQuery("from Order where status = 1").setInteger("Status ", status);
			orders = (List<Order>) query.list();
			session.getTransaction().commit();

		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return orders;
	}

	@SuppressWarnings("unchecked")
	public Collection<Order> getAllOrders() throws SQLException {
		// TODO Auto-generated method stub
		Session session = null;
		List<Order> orders = new ArrayList<Order>();
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			orders = session.createCriteria(Order.class).list();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка 'getAll'", JOptionPane.OK_OPTION);
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return orders;

	}

	public void deleteOrder(Order order) throws SQLException {
		// TODO Auto-generated method stub
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.delete(order);
			session.getTransaction().commit();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка при удалении", JOptionPane.OK_OPTION);
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}

	}

	@SuppressWarnings("unchecked")
	public Collection<Order> getOrderByUser(Integer user_id) throws SQLException {
		Session session = null;
		List<Order> orders = new ArrayList<Order>();
		try {
			session = HibernateUtil.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			//Integer user_id = id;
			Query query = session.createQuery("from order where user_id = :user_id").setLong("user_id", user_id);
			orders = (List<Order>) query.list();
			session.getTransaction().commit();

		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return orders;

	}

}
