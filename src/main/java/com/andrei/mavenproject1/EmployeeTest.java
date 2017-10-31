/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andrei.mavenproject1;


import com.andrei.entities.Category;
import com.andrei.entities.Employee;
import com.andrei.entities.Scheduledoutgoingmessage;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.hibernate.Query;
import org.hibernate.Session;

public class EmployeeTest {

    private static EntityManager em;

    public static void main(String[] args) {

       /*EntityManagerFactory emf = Persistence.createEntityManagerFactory("EmployeeService");
        em = emf.createEntityManager();
        createEmployee(5, "Saint", "Peter", "Engineering");
        createEmployee(6, "Jack", " Dorsey", "Imaginea");
        createEmployee(7, "Sam", "Fox", "Imaginea");
        emf.close();*/
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("uuService");
        em = emf.createEntityManager();
        createOutgoingMessage();
        emf.close();
       
        //getAllCategories();

    }

    private static void createEmployee(int id, String firstName, String lastName, String dept) {
        em.getTransaction().begin();
        Employee emp = new Employee(id, firstName, lastName, dept);
        em.persist(emp);
        em.getTransaction().commit();
    }
    
    
    private static void createOutgoingMessage() {
        em.getTransaction().begin();
        Scheduledoutgoingmessage som =   new Scheduledoutgoingmessage( new Date(), (short)1, 1) ;     
        som.setOriginalmessage("original message");
        em.persist(som);
    
        em.getTransaction().commit();
    }
    
      
    static void getAllCategories(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query q = session.createQuery("From Category ");
        List<Category> resultList = q.list();
        System.out.println("num of categories:" + resultList.size());
        for (Category next : resultList) {
            System.out.println("next category: " + next);
        }
        
        session.getTransaction().commit();
        session.close();
        
    }
}
