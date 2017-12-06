package info.chyb.jpa;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import info.chyb.jpa.domain.Employee;

public class Main {
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;

	public static void main(String[] args) {
		entityManagerFactory = Persistence.createEntityManagerFactory("myDatabase");
		entityManager = entityManagerFactory.createEntityManager();

		addEmployees();
		// pobieranie jednej osoby
		// TypedQuery<Employee> query = entityManager.createQuery("select e from
		// Employee e where e.salary > :minSalary",
		// Employee.class);
		// query.setParameter("minSalary", 5000.0);
		// for (Employee employee : query.getResultList()) {
		//
		// System.out.println(employee.getFirstName());
		// System.out.println(employee.getLastName());
		// System.out.println(employee.getSalary());
		// System.out.println();
		//
		// }

		TypedQuery<Employee> query = entityManager
				.createQuery("select e from Employee e where e.salary > ?1 and e.salary <?2", Employee.class);

		query.setParameter(1, 2000.0);
		query.setParameter(2, 3000.0);
		for (Employee employee : query.getResultList()) {

			System.out.println(employee.getFirstName());
			System.out.println(employee.getLastName());
			System.out.println(employee.getSalary());
			System.out.println();

		}
		
		
		entityManager.close();
		entityManagerFactory.close();

	}

	private static void addEmployees() {
		addEmployee("Karol", "Mateusiak", 2633);
		addEmployee("Marika", "Bednarek", 2345);
		addEmployee("Jan", "Mateusiak", 7346);
		addEmployee("Daria", "Kowalska", 2352);
		addEmployee("Monika", "Uciñska", 4263);
		addEmployee("Ernest", "Paj¹k", 2634);
		addEmployee("Kamil", "Stêpieñ", 2345);
		addEmployee("Przemek", "Maciejewski", 5433);
		addEmployee("Robert", "WoŸniak", 3324);
		addEmployee("Agnieszka", "Nowak", 2000);
		addEmployee("Angelika", "Bednarska", 1000);
	}

	private static void addEmployee(String firstName, String lastName, double salary) {
		Employee employee = new Employee();
		employee.setFirstName(firstName);
		employee.setLastName(lastName);
		employee.setSalary(salary);

		entityManager.getTransaction().begin();
		entityManager.persist(employee);
		entityManager.getTransaction().commit();
	}
}
