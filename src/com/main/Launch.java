package com.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.entity.Employee;

public class Launch {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("config");
		EntityManager em = emf.createEntityManager();
		
		insert(em);
//		read(em);
//		update(em);
//		delete(em);
		
		em.close();
		emf.close();
		
	}

	private static void delete(EntityManager em) {
		
		
		
	}

	private static void update(EntityManager em) {
		
		
		
	}

	private static void read(EntityManager em) {
		
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		
		
		
		transaction.commit();
		
	}

	private static void insert(EntityManager em) {
		// Unlike JDBC that auto commits whenever a query is run, in Hibernate, we need to always begin a transaction and commit it
		// to make changes reflected in the DB
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		
		String sql = "insert into xemployee(id, name, address, salary) values (?,?,?,?);";
		
		// loop to represent a bulk insertion
		for (int i = 0; i < 10; i++) {
			
			// Here, we used the native sql which means we write the sql query with reference to the actual DB parameters,
			// like here we used the xemployee table with its actual parameters in the table
			Query nativeQuery = em.createNativeQuery(sql);
			
			nativeQuery.setParameter(1, 1234+i);
			nativeQuery.setParameter(2, "xyzzz");
			nativeQuery.setParameter(3, "afsgdfgdg");
			nativeQuery.setParameter(4, 1000*i);
			
			nativeQuery.executeUpdate();
			
		}
		
		transaction.commit();
		System.out.println("Bulk Data Inserted...");
	}

}
