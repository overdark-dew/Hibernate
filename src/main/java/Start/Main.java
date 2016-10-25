package Start;

import java.sql.SQLException;
import java.util.Collection;
import java.util.Iterator;
import util.HibernateUtil;
//import java.util.Scanner;


import Tables.User;

@SuppressWarnings("unused")
public class Main {

	public static void main(String[] args) throws SQLException, NullPointerException {

		Collection<User> users = Factory.getInstance().getUserDAO().getAllUser();
		System.out.println(users);
//		Iterator iterator = users.iterator();
//		System.out.println("========Все пользователи=========");
//		while (iterator.hasNext()) {
//			User user = (User) iterator.next();
//			System.out.println("Пользователь : " + user.getName() + "  ID : " + user.getUser_id());
//			
//
//		}
	}
	
}
