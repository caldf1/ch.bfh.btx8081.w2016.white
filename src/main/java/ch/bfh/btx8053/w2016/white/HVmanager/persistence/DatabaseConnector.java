package ch.bfh.btx8053.w2016.white.HVmanager.persistence;



import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import ch.bfh.btx8053.w2016.white.HVmanager.model.ActivityRecording;
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
	EntityManager em = null;
	EntityManagerFactory factory = null;
	EntityTransaction transaction = null;
	
	public DatabaseConnector() {
	 factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	}
	
	public void insertCaregiver(Caregiver caregiver){
		em = factory.createEntityManager();
		transaction = em.getTransaction();
		transaction.begin();
		try {
			em.persist(caregiver);
			em.flush();
			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Error on insert caregiver: " + e.getMessage());
		}
		finally {
			em.close();
		}
	}
	
	public void updateCaregiver(Caregiver caregiver){
		em = factory.createEntityManager();
		transaction = em.getTransaction();
		transaction.begin();
		try {
			em.merge(caregiver);
			em.flush();
			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Error on update caregiver: " + e.getMessage());
		}
		finally {
			em.close();
		}
	}
	public Caregiver searchCaregiver(int personId) {
		em = factory.createEntityManager();
		try {
			transaction = em.getTransaction();
			transaction.begin();
		return em.find(Caregiver.class, personId);
		} catch (Exception e){
			System.out.println("Error on search caregiver: " + e.getMessage());
			return null;
		}
		finally {
			em.close();
		}
	}
	
	public void deleteCaregiver(Caregiver caregiver){
		em = factory.createEntityManager();
		transaction = em.getTransaction();
		transaction.begin();
		try {
			em.remove(caregiver);
			em.flush();
			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Error on delete caregiver: " + e.getMessage());
		}
		finally {
			em.close();
		}
	}
	
	public void insertClient(Client client){
		em = factory.createEntityManager();
		transaction = em.getTransaction();
		transaction.begin();
		try {
			em.persist(client);
			em.flush();
			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Error on insert client: " + e.getMessage());
		}
		finally {
			em.close();
		}
	}
	
	public List<Client> showClientList() {
		em = factory.createEntityManager();
		transaction = em.getTransaction();
		transaction.begin();
		try {
			Query q = em.createQuery("select c from Client c");
			@SuppressWarnings("unchecked")
			List<Client> clients = q.getResultList();
			return clients;
		} catch (Exception e){
			System.out.println("Error on show client list: " + e.getMessage());
			return null;
		}
		finally {
			em.close();
		}
	}
	
	public Client searchClient(int personId) {
		em = factory.createEntityManager();
		try {
			transaction = em.getTransaction();
			transaction.begin();
		return em.find(Client.class, personId);
		} catch (Exception e){
			System.out.println("Error on search client: " + e.getMessage());
			return null;
		}
		finally {
			em.close();
		}
	}
	
	public void updateClient(Client client){
		em = factory.createEntityManager();
		transaction = em.getTransaction();
		transaction.begin();
		try {
			em.merge(client);
			em.flush();
			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Error on update client: " + e.getMessage());
		}
		finally {
			em.close();
		}
	}
	
	public void deleteClient(Client client){
		em = factory.createEntityManager();
		transaction = em.getTransaction();
		transaction.begin();
		try {
			em.merge(client);
			em.remove(client);
			em.flush();
			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Error on delete client: " + e.getMessage());
		}
		finally {
			em.close();
		}
	}
	
	public void insertExternalPerson(ExternalPerson externalPerson){
		em = factory.createEntityManager();
		transaction = em.getTransaction();
		transaction.begin();
		try {
			em.persist(externalPerson);
			em.flush();
			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Error on insert external person: " + e.getMessage());
		}
		finally{
		em.close();
		}
	}

	public ExternalPerson searchExternalPerson(int personId) {
		em = factory.createEntityManager();
		try {
			transaction = em.getTransaction();
			transaction.begin();
		return em.find(ExternalPerson.class, personId);
		} catch (Exception e){
			System.out.println("Error on search external person: " + e.getMessage());
			return null;
		}
		finally {
			em.close();
		}
	}
	
	public void updateExternalPerson(ExternalPerson externalPerson){
		em = factory.createEntityManager();
		transaction = em.getTransaction();
		transaction.begin();
		try {
			em.merge(externalPerson);
			em.flush();
			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Error on update external person: " + e.getMessage());
		} finally {
			em.close();
		}
	}
	
	public void deleteExternalPerson(ExternalPerson externalPerson){
		em = factory.createEntityManager();
		transaction = em.getTransaction();
		transaction.begin();
		try {
			em.remove(externalPerson);
			em.flush();
			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Error on delete external person: " + e.getMessage());
		} finally {
			em.close();
		}
	}
	
	public void insertInstitution(Institution institution){
		em = factory.createEntityManager();
		transaction = em.getTransaction();
		transaction.begin();
		try {
			em.persist(institution);
			em.flush();
			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Error on insert institution: " + e.getMessage());
		} finally {
		em.close();
		}
		
	}
	
	public Institution searchInstitution(int institutionId) {
		em = factory.createEntityManager();
		try {
			transaction = em.getTransaction();
			transaction.begin();
		return em.find(Institution.class, institutionId);
		} catch (Exception e){
			System.out.println("Error on search external person: " + e.getMessage());
			return null;
		}
		finally {
			em.close();
		}
	}
	
	public void updateInstitution(Institution institution){
		em = factory.createEntityManager();
		transaction = em.getTransaction();
		transaction.begin();
		try {
			em.merge(institution);
			em.flush();
			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Error on update institution: " + e.getMessage());
		} finally {
			em.close();
		}
	}
	
	public void deleteInstitution(Institution institution){
		em = factory.createEntityManager();
		transaction = em.getTransaction();
		transaction.begin();
		try {
			em.remove(institution);
			em.flush();
			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Error on delete institution: " + e.getMessage());
		} finally {
			em.close();
		}
	}
	
	public void insertActRec(ActivityRecording actrec){
		em = factory.createEntityManager();
		transaction = em.getTransaction();
		transaction.begin();
		try {
			em.persist(actrec);
			em.flush();
			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Error on inserting activity recording: " + e.getMessage());
		} finally {
			em.close();
		}
	}
	
	public ActivityRecording searchActivityRecording(int actRecDbId) {
		em = factory.createEntityManager();
		try {
			transaction = em.getTransaction();
			transaction.begin();
		return em.find(ActivityRecording.class, actRecDbId);
		} catch (Exception e){
			System.out.println("Error on search activity recording: " + e.getMessage());
			return null;
		}
		finally {
			em.close();
		}
	}
	
	public void updateActivityRecording(ActivityRecording actrec){
		em = factory.createEntityManager();
		transaction = em.getTransaction();
		transaction.begin();
		try {
			em.merge(actrec);
			em.flush();
			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Error on update activity recording: " + e.getMessage());
		} finally {
			em.close();
		}
	}
	
	public void deleteActivityRecording(ActivityRecording actrec){
		em = factory.createEntityManager();
		transaction = em.getTransaction();
		transaction.begin();
		try {
			em.remove(actrec);
			em.flush();
			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Error on delete activity recording: " + e.getMessage());
		} finally {
			em.close();
		}
	}	
}

