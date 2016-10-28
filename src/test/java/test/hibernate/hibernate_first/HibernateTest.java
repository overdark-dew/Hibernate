package test.hibernate.hibernate_first;

import util.HibernateUtil;
import org.hibernate.Session;
import Tables.User; 
 
public class HibernateTest { 
 
    public static void main(String[] args) { 
        Session session = HibernateUtil.getSessionFactory().openSession(); 
        session.beginTransaction(); 
 
        
        User us = new User(); 
        us.setName("Ибрагим"); 
        
 
        session.save(us); 
 
        session.getTransaction().commit(); 
        HibernateUtil.shutdown(); 
    } 
} 
