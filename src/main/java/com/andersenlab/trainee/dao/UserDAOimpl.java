package com.andersenlab.trainee.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.swing.JOptionPane;

import org.hibernate.Session;

import com.andersenlab.trainee.tables.Order;
import com.andersenlab.trainee.tables.User;
import com.andersenlab.trainee.util.HibernateUtil;

public class UserDAOimpl implements UserDAO {

	public void addUser(User user) throws SQLException {

		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.save(user);
			session.getTransaction().commit();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка при вставке", JOptionPane.OK_OPTION);
		} finally {
			if (session != null && session.isOpen()) {

				session.close();
			}
		}

	}

	public User getUserById(Integer user_id) throws SQLException {
		// TODO Auto-generated method stub
		Session session = null;
		User user = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			user = (User) session.get(User.class, user_id);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка 'findById'", JOptionPane.OK_OPTION);
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return user;
	}

	@SuppressWarnings("unchecked")
	public Collection<User> getAllUser() throws SQLException {
		Session session = null;
		List<User> users = new ArrayList<User>();
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			users = session.createCriteria(User.class).list();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка 'getAll'", JOptionPane.OK_OPTION);
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return users;
	}

	public void deleteUser(User user) throws SQLException {
		// TODO Auto-generated method stub

	}

	public Collection<Order> getOrderByUser(User user) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
