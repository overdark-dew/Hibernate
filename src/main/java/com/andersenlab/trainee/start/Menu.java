package com.andersenlab.trainee.start;

import java.sql.SQLException;
import java.util.Collection;
import java.util.Iterator;
import java.util.Scanner;

import com.andersenlab.trainee.tables.Order;
import com.andersenlab.trainee.tables.User;

public class Menu {

	static int scan = 0;
	// static String strscan;

	public static void run() throws SQLException {

		for (;;) {

			System.out.println("\n1 - Вывести всех клиентов" + "     2 - Вывести все заказы \n"
					+ "3 - Найти клиента по ID" + "       4 - Найти заказ но ID \n" + "5 - Добавить нового клиента"
					+ "   6 - Добавить новый заказ \n" + "7 - Выполненные заказы        "
							+ "8 - Показать все заказы пользователя\n" + "0 - Выход");

			@SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);

			System.out.print("Ваш выбор: ");
			if (sc.hasNextInt()) {
				scan = sc.nextInt();

			} else {
				System.out.println("Вы ввели не целое число");
			}

			if (scan == 0) {
				break;
			}

			switch (scan) {

			case 1: {

				Collection<User> users = Factory.getInstance().getUserDAO().getAllUser();

				Iterator<User> iterator = users.iterator();
				System.out.println("========Все пользователи=========");
				while (iterator.hasNext()) {
					User user = (User) iterator.next();
					System.out.println("Пользователь: " + user.getName() + "  ID: " + user.getId());

				}
				break;
			}

			case 2: {

				Collection<Order> Orders = Factory.getInstance().getOrderDAO().getAllOrders();

				Iterator<Order> iterator1 = Orders.iterator();
				System.out.println("========Все заказы=========");
				while (iterator1.hasNext()) {
					Order order = (Order) iterator1.next();
					System.out.println("Заказ №: " + order.getId() + " Статус: " + order.getStatus());

				}
				break;
			}

			case 3: {
				System.out.print("Введите номер клиента: ");
				if (sc.hasNextInt()) {

					scan = sc.nextInt();

					User user = Factory.getInstance().getUserDAO().getUserById(scan);
					System.out.println("========Клиент № " + scan + "=========");
					System.out.println("Клиент ID: " + user.getId() + " Пользователь: " + user.getName());
				}
				break;
			}

			case 4: {

				System.out.print("Введите номер заказа: ");
				if (sc.hasNextInt()) {

					scan = sc.nextInt();

					Order order = Factory.getInstance().getOrderDAO().getOrderById(scan);
					System.out.println("========Заказ № " + scan + "=========");
					System.out.println("Заказ №: " + order.getId() + " Статус: " + order.getStatus());
				}
				break;
			}

			case 5: {

				@SuppressWarnings("resource")
				Scanner in = new Scanner(System.in);

				System.out.print("Введите имя пользователя: ");
				if (in.hasNextLine()) {

					String strscan = in.nextLine();

					User newuser = new User();
					newuser.setName(strscan);

					Factory.getInstance().getUserDAO().addUser(newuser);
				}
				break;
			}

			
			case 6: {

				@SuppressWarnings("resource")
				Scanner in = new Scanner(System.in);

				System.out.print("Введите ID пользователя: ");
				if (in.hasNextInt()) {

					int intscan = in.nextInt();

					Order neworder = new Order();
					neworder.setUser_id(intscan);
					neworder.setStatus(0);
					
					Factory.getInstance().getOrderDAO().addOrder(neworder);

				}

				break;
			}
			
			// Не работает!!!
			case 7: {

				Collection<Order> Orders = Factory.getInstance().getOrderDAO().getOrderByStatus();

				Iterator<Order> iterator7 = Orders.iterator();
				System.out.println("========Выполненные заказы=========");
				while (iterator7.hasNext()) {
					Order order = (Order) iterator7.next();
					System.out.println("Заказ №: " + order.getId() + " Статус: " + order.getStatus());

				}
				break;

			}

			case 8: {

				System.out.print("Введите номер клиента: ");
				if (sc.hasNextInt()) {

					scan = sc.nextInt();}
				
				Collection<Order> Orders = Factory.getInstance().getOrderDAO().getOrderByUser(scan);

				Iterator<Order> iterator1 = Orders.iterator();
				System.out.println("========Все заказы=========");
				while (iterator1.hasNext()) {
					Order order = (Order) iterator1.next();
					System.out.println("Заказ №: " + order.getId() + " Статус: " + order.getStatus());

				}
				break;
			}

			case 9: {

				break;
			}

			case 10: {

				break;
			}

			default:
				System.out.println("Вы ввели не верное число");

			}

		}
	}

}
