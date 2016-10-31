package test.hibernate.hibernate_first;

import java.sql.SQLException;

import org.hibernate.Session;

//import com.andersenlab.trainee.dao.UserDAO;
import com.andersenlab.trainee.dao.UserDAOimpl;
import com.andersenlab.trainee.tables.User;
import com.andersenlab.trainee.util.HibernateUtil; 
 
public class HibernateTest { 
 
   
	public static void main(String[] args)  { 
        
    	//UserDAOimpl userDAOimpl = new UserDAOimpl();
    	
    	Session session = HibernateUtil.getSessionFactory().openSession(); 
        session.beginTransaction(); 
 
        UserDAOimpl userDAO = new UserDAOimpl();
        User us = new User(); 
        us.setName("Ибрагим");
        us.setId(20);
     
       
		try {
			userDAO.addUser(us);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 
        
    } 
} 
