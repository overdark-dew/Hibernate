package Start;

import DAO.OrderDAO;
import DAO.OrderDAOimpl;
import DAO.UserDAO;
import DAO.UserDAOimpl;

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
