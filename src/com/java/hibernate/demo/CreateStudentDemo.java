package com.java.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.java.hibernate.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {
			// create a student object
			Student demoStudent = new Student("Joe", "Biden", "joeBiden@gmail.com");

			// start a transaction
			session.beginTransaction();

			// save the student object
			session.save(demoStudent);

			// commit transaction
			session.getTransaction().commit();

		} finally {
			factory.close();
		}
	}

}
