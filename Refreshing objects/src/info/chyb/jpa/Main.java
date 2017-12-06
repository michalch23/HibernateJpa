package info.chyb.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import info.chyb.jpa.domain.Employee;

public class Main {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myDatabase");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		Employee employee = new Employee();
		employee.setFirstName("Jan");
		employee.setLastName("Chyb");
		employee.setSalary(2000.0);

		entityManager.getTransaction().begin();
		entityManager.persist(employee);
		entityManager.getTransaction().commit();

		System.out.println(employee.getFirstName());
		System.out.println(employee.getLastName());
		System.out.println(employee.getSalary());
		//System.out.println(employee.getTax());
		
		entityManager.refresh(employee);
		System.out.println(employee.getFirstName());
		System.out.println(employee.getLastName());
		System.out.println(employee.getSalary());
	//	System.out.println(employee.getTax());
		
		
		
		entityManager.close();
		entityManagerFactory.close();
	}

}
