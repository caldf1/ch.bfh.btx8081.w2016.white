package ch.bfh.btx8053.w2016.white.HVmanager.persistence;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
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
		EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
						
	}
	
	public void insertCaregiver(Caregiver caregiver){
		EntityManager em = factory.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		em.persist(caregiver);
		em.getTransaction().commit();
		em.close();
	}
	
	public void updateCaregiver(Caregiver caregiver){
		EntityManager em = factory.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		em.merge(caregiver);
		em.getTransaction().commit();
		em.close();
	}
	
	public void deleteCaregiver(Caregiver caregiver){
		EntityTransaction transaction = em.getTransaction();
		em.remove(caregiver);
		em.getTransaction().commit();
		em.close();
	}
	
	public void insertClient(Client client){
		EntityManager em = factory.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		em.persist(client);
		em.getTransaction().commit();
		em.close();
	}
	
	public void updateClient(Client client){
		EntityManager em = factory.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		em.merge(client);
		em.getTransaction().commit();
		em.close();
	}
	
	public void deleteClient(Client client){
		EntityTransaction transaction = em.getTransaction();
		em.remove(client);
		em.getTransaction().commit();
		em.close();
	}
	
	public void insertExternalPerson(ExternalPerson externalPerson){
		EntityManager em = factory.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		em.persist(externalPerson);
		em.getTransaction().commit();
		em.close();
	}
	
	public void updateExternalPerson(ExternalPerson externalPerson){
		EntityManager em = factory.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		em.merge(externalPerson);
		em.getTransaction().commit();
		em.close();
	}
	
	public void deleteExternalPerson(ExternalPerson externalPerson){
		EntityTransaction transaction = em.getTransaction();
		em.remove(externalPerson);
		em.getTransaction().commit();
		em.close();
	}
	
	public void insertInstitution(Institution institution){
		EntityManager em = factory.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		em.persist(institution);
		em.getTransaction().commit();
		em.close();
	}
	
	public void updateInstitution(Institution institution){
		EntityManager em = factory.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		em.merge(institution);
		em.getTransaction().commit();
		em.close();
	}
	
	public void deleteInstitution(Institution institution){
		EntityTransaction transaction = em.getTransaction();
		em.remove(institution);
		em.getTransaction().commit();
		em.close();
	}
}
