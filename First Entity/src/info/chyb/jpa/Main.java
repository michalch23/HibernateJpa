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
		//employee.setId(1L);
		employee.setFirtsName("Jan");
		employee.setLastName("Nowak");
		employee.setSalary(3333.33);
		
		Employee employee2 = new Employee();
		//employee.setId(1L);
		employee2.setFirtsName("Robert");
		employee2.setLastName("Bednarek");
		employee2.setSalary(4444.44);
		
		entityManager.getTransaction().begin();
		entityManager.persist(employee);
		entityManager.persist(employee2);//wstawienie do bazy
		entityManager.getTransaction().commit();
		
		entityManager.close();
		entityManagerFactory.close();
	}

}
