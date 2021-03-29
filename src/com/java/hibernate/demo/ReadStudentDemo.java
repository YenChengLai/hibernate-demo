package com.java.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.java.hibernate.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {
			// create a student object
			Student demoStudent = new Student("Clark", "Kent", "superMan@gmail.com");

			// start a transaction
			session.beginTransaction();

			// save the student object
			session.save(demoStudent);

			// commit transaction
			session.getTransaction().commit();

			// find out the student's id as query's primary key
			int pk = demoStudent.getId();

			// get a new session to start transaction (even query is a transaction in
			// hibernate)
			session = factory.getCurrentSession();
			session.beginTransaction();

			// retrieve student data based on the pk
			Student student = session.get(Student.class, pk);
			System.out.println(student);
			
			// commit transaction
			session.getTransaction().commit();

		} finally {
			factory.close();
		}
	}

}
