package ch.bfh.btx8053.w2016.white.HVmanager.persistence;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import ch.bfh.btx8053.w2016.white.HVmanager.model.Caregiver;
import ch.bfh.btx8053.w2016.white.HVmanager.model.Client;
import ch.bfh.btx8053.w2016.white.HVmanager.model.ExternalPerson;
import ch.bfh.btx8053.w2016.white.HVmanager.model.Institution;


/**
 * 
 * @author nedot1
 *
 */

public class DatabaseConnector {
	
	private static final String PERSISTENCE_UNIT_NAME = "HVManager";
	EntityManager em;
	EntityManagerFactory factory;
	EntityTransaction transaction;
	
	public DatabaseConnector() {
	 factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	}
	
	public void insertCaregiver(Caregiver caregiver){
		em = factory.createEntityManager();
		transaction = em.getTransaction();
		transaction.begin();
		try {
			em.persist(caregiver);
			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Error on insert caregiver: " + e.getMessage());
		}
		em.close();
	}
	
	public void updateCaregiver(Caregiver caregiver){
		em = factory.createEntityManager();
		transaction = em.getTransaction();
		transaction.begin();
		try {
			em.merge(caregiver);
			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Error on update caregiver: " + e.getMessage());
		}
		em.close();
	}
	
	public void deleteCaregiver(Caregiver caregiver){
		em = factory.createEntityManager();
		transaction = em.getTransaction();
		transaction.begin();
		try {
			em.remove(caregiver);
			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Error on delete caregiver: " + e.getMessage());
		}
		em.close();
	}
	
	public void insertClient(Client client){
		em = factory.createEntityManager();
		transaction = em.getTransaction();
		transaction.begin();
		try {
			em.persist(client);
			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Error on insert client: " + e.getMessage());
		}
		em.close();
	}
	
	public void showClientList() {
		em = factory.createEntityManager();
		transaction = em.getTransaction();
		transaction.begin();
		Query q = em.createQuery("select c from Client c");
		List<Client> clients = q.getResultList();
		System.out.println("" + clients.size() + " clienten: ");
		for (Client c : clients)
			System.out.println(c);
		em.close();
	}
	
	public void searchClient() {
		em = factory.createEntityManager();
		transaction = em.getTransaction();
		transaction.begin();
		//Client c = em.find(Client.class, personId); personId als PK nicht möglich?
		em.close();
	}
	
	public void updateClient(Client client){
		em = factory.createEntityManager();
		transaction = em.getTransaction();
		transaction.begin();
		try {
			em.merge(client);
			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Error on update client: " + e.getMessage());
		}
		em.close();
	}
	
	public void deleteClient(Client client){
		em.getEntityManagerFactory().createEntityManager();
		transaction = em.getTransaction();
		transaction.begin();
		try {
			em.remove(client);
			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Error on delete client: " + e.getMessage());
		}
		em.close();
	}
	
	public void insertExternalPerson(ExternalPerson externalPerson){
		em = factory.createEntityManager();
		transaction = em.getTransaction();
		transaction.begin();
		try {
			em.persist(externalPerson);
			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Error on insert external person: " + e.getMessage());
		}
		em.close();
	}
	
	public void updateExternalPerson(ExternalPerson externalPerson){
		em = factory.createEntityManager();
		transaction = em.getTransaction();
		transaction.begin();
		try {
			em.merge(externalPerson);
			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Error on update external person: " + e.getMessage());
		}
		em.close();
	}
	
	public void deleteExternalPerson(ExternalPerson externalPerson){
		em = factory.createEntityManager();
		transaction = em.getTransaction();
		transaction.begin();
		try {
			em.remove(externalPerson);
			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Error on delete external person: " + e.getMessage());
		}
		em.close();
	}
	
	public void insertInstitution(Institution institution){
		em = factory.createEntityManager();
		transaction = em.getTransaction();
		transaction.begin();
		try {
			em.persist(institution);
			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Error on insert institution: " + e.getMessage());
		}
		em.close();
	}
	
	public void updateInstitution(Institution institution){
		em = factory.createEntityManager();
		transaction = em.getTransaction();
		transaction.begin();
		try {
			em.merge(institution);
			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Error on update institution: " + e.getMessage());
		}
		em.close();
	}
	
	public void deleteInstitution(Institution institution){
		em = factory.createEntityManager();
		transaction = em.getTransaction();
		transaction.begin();
		try {
			em.remove(institution);
			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Error on delete institution: " + e.getMessage());
		}
		em.close();
	}
}
