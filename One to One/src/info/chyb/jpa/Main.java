package info.chyb.jpa;

import info.chyb.jpa.domain.Address;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import info.chyb.jpa.domain.Address;
import info.chyb.jpa.domain.Employee;

public class Main {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myDatabase");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		Employee employee = new Employee();
		Address address = new Address();
		
		employee.setFirstName("Jan");
		employee.setLastName("Nowak");
		employee.setSalary(111.2);
		employee.setAddress(address);
		address.setLocality("Warszawa");
		address.setZipCode("11-333");
		address.setStreet("Koszykowa");
		address.setStreetNumber(33);

		entityManager.getTransaction().begin();
		entityManager.persist(employee);
		entityManager.persist(address);
		entityManager.getTransaction().commit();

		entityManager.close();
		entityManagerFactory.close();
	}

}
