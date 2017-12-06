package info.chyb.jpa;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import info.chyb.jpa.domain.Employee;

public class Main {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myDatabase");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		Employee employee = new Employee();
		// employee.setId(1L);
		employee.setFirtsName("Jan");
		employee.setLastName("Nowak");
		employee.setSalary(3333.33);
		employee.setSalary2(new BigDecimal("12345.12323"));

		entityManager.getTransaction().begin();
		entityManager.persist(employee);
		entityManager.getTransaction().commit();

		entityManager.close();
		entityManagerFactory.close();
	}

}
