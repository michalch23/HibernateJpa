package info.chyb.jpa;


import info.chyb.jpa.domain.Cat;
import info.chyb.jpa.domain.Owner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myDatabase");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		Owner owner = new Owner();
		Cat cat = new Cat();

		owner.setFirstName("Jan");
		owner.setLastName("Nowak");

		cat.setName("Burek");
		owner.setCat(cat);
		

		entityManager.getTransaction().begin();
		entityManager.persist(owner);
		entityManager.persist(cat);
		entityManager.getTransaction().commit();

		entityManager.close();
		entityManagerFactory.close();
	}

}
