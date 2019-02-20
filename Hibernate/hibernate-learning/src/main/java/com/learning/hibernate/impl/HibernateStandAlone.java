package com.learning.hibernate.impl;
import java.util.List;

import org.hibernate.Session;

import com.learning.hibernate.model.Address;
import com.learning.hibernate.model.Student;
import com.learning.hibernate.utility.HibernateUtil;
 
public class HibernateStandAlone {
     
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
 
        Student student = new Student("Sam","Whatever","Maths");
        Address address = new Address("10 Fake street","NYC","USA");
         
         
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
 
        session.persist(student);
         
      //  address.setId(student.getId());
        student.setAddress(address);
        session.save(student);
         
        List<Student> students = (List<Student>)session.createQuery("from Student ").list();
        for(Student s: students){
            System.out.println("Details : "+s);
        }
         
        session.getTransaction().commit();
        session.close();  
    }
 
}