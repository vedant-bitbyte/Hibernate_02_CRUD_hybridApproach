package com.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.entity.Employee;

public class Launch {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("config");
		EntityManager em = emf.createEntityManager();
		
		insert(em);
		read(em);
		update(em);
		delete(em);
		
	}

	private static void delete(EntityManager em) {
		
		Employee employee = em.find(Employee.class, 12);
		
		if (employee != null) {
			EntityTransaction transaction = em.getTransaction();
			transaction.begin();
			
			em.remove(employee); // remove the employee
			transaction.commit();
			
			System.out.println("Employee deleted...");
			
		} else {
			System.out.println("Employee id not found...");
		}
		
	}

	private static void update(EntityManager em) {
		
		Employee employee = em.find(Employee.class, 12);
		
		if (employee != null) {
			EntityTransaction transaction = em.getTransaction();
			transaction.begin();
			
			employee.setEsalary(5000);
			
			em.merge(employee); // Here we set the salary of this obj to 5000, and then merge the changes of the obj to table
			transaction.commit();
			
			System.out.println(employee);
			System.out.println("Data changed...");
			
		} else {
			System.out.println("Employee id not found...");
		}
		
	}

	private static void read(EntityManager em) {
		
		Employee employee = em.find(Employee.class, 12);
		
		if (employee != null) {
			System.out.println("Read: " + employee);
			
		} else {
			System.out.println("Data not found...");
			
		}
		
	}

	private static void insert(EntityManager em) {
		// Unlike JDBC that auto commits whenever a query is run, in Hibernate, we need to always begin a transaction and commit it
		// to make changes reflected in the DB
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		
		Employee employee = new Employee(12, "ABCDEF", "gsfkshdfkah", 3000);
		em.persist(employee);
		
		transaction.commit();
		System.out.println("Data Inserted...");
	}

}
