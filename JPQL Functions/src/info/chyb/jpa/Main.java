package info.chyb.jpa;

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
		// Query query = entityManager.createQuery(
		// "select avg(e.salary),min(e.salary),max(e.salary), sum(e.salary),count(e)
		// from Employee e ");
		// Object[] result = (Object[]) query.getSingleResult();
		// System.out.println("�rednia " + result[0]);
		// System.out.println("Najnizsza " + result[1] );
		// System.out.println("Najwy�sza " + result[2]);
		// System.out.println("Suma : " + result[3]);
		// System.out.println("Pracownik�w " + result[4]);

		// FUNKCJE NA STRINGACH
		Query query = entityManager.createQuery(
				"select substring(e.firstName,1,3),trim(e.lastName),lower(e.firstName),upper(e.firstName), length(e.firstName) from Employee e where e.firstName = 'Karol'");
		
		Object[] result = (Object[]) query.getSingleResult();
		System.out.println("Pierwsze trzy litery imienia: " + result[0]);
		System.out.println("Nazwisko: |" + result[1] + "|");
		System.out.println("Imi� ma�ymi literami: " + result[2]);
		System.out.println("Imi� wielkimi literami: " + result[3]);
		System.out.println("D�ugo�� imienia: " + result[4]);
		
		entityManager.close();
		entityManagerFactory.close();

	}

	private static void addEmployees() {
		addEmployee("Karol", "Mateusiak", 2633);
		addEmployee("Marika", "Bednarek", 2345);
		addEmployee("Jan", "Mateusiak", 7346);
		addEmployee("Daria", "Kowalska", 2352);
		addEmployee("Monika", "Uci�ska", 4263);
		addEmployee("Ernest", "Paj�k", 2634);
		addEmployee("Kamil", "St�pie�", 2345);
		addEmployee("Przemek", "Maciejewski", 5433);
		addEmployee("Robert", "Wo�niak", 3324);
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
