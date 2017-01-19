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
 * DatabaseConnector connects to the database <br>
 * and provides CRUD operations (create, read, update, delete).
 * 
 * @author nedot1
 */

public class DatabaseConnector {
	
/*==============================================
 *    Attributes
 *==============================================
 */	
	
	private static final String PERSISTENCE_UNIT_NAME = "HVManager";
	EntityManager em = null;
	EntityManagerFactory factory = null;
	EntityTransaction transaction = null;
	
/*==============================================
 *    Constructor
 *==============================================
 */ 	
	
	/**
	 * Creates a DatabaseConnection
	 */
	
	public DatabaseConnector() {
	 factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
	}

/*==============================================
 *    CRUD operations for Caregiver
 *==============================================
 */	
	
	/**
	 * insert a caregiver in the database
	 * 
	 * @param caregiver as entity instance
	 */
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
	
	/**
	 * update a caregiver in the database
	 * 
	 * @param caregiver as entity instance
	 */
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
	
	/**
	 * search a caregiver in the database
	 * 
	 * @param personId as int
	 * 
	 * @return caregiver as entity instance
	 */
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
	
	/**
	 * delete a Caregiver in the database
	 * 
	 * @param caregiver as entity instance
	 */
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
	
/*==============================================
 *    CRUD operations for Client
 *==============================================
 */	
	
	/**
	 * insert a client in the database
	 * 
	 * @param client as entity instance
	 */
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
	
	/**
	 * get a list of all clients
	 * 
	 * @return clients as list<Client>
	 */
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
	
	/**
	 * search a client in the database
	 * 
	 * @param personId as int
	 * 
	 * @return client as entity instance
	 */
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
	
	/**
	 * update a client in the database
	 * 
	 * @param client as entity instance
	 */
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
	
	/**
	 * delete a client in the database
	 * 
	 * @param client as entity instance
	 */
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

	
/*==============================================
 *    CRUD operations for ExternalPerson
 *==============================================
 */		
	
	/**
	 * insert a external person in the database
	 * 
	 * @param externalPerson as entity instance
	 */
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
	
	/**
	 * search a external person in the database
	 * 
	 * @param personId as int
	 * 
	 * @return externalPerson as entity instance
	 */
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
	
	/**
	 * update a external person in the database
	 * 
	 * @param externalPerson as entity instance
	 */
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
	
	/**
	 * delete a external person in the database
	 * 
	 * @param externalPerson as entity instance
	 */
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
	
/*==============================================
 *    CRUD operations for Institution
 *==============================================
 */	
	
	/**
	 * insert a institution in the database
	 * 
	 * @param institution as entity instance
	 */
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
	
	/**
	 * search a institution in the database
	 * 
	 * @param institutionId as int
	 * 
	 * @return institution as entity instance
	 */
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
	
	/**
	 * update a institution in the database
	 * 
	 * @param institution as entity instance
	 */
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
	
	/**
	 * delete a institution in the database
	 * 
	 * @param institution as entity instance
	 */
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
	
/*==============================================
 *    CRUD operations for Activity Recording
 *==============================================
 */	
	
	/**
	 * insert a activity recording in the database
	 * 
	 * @param actrec as entity instance
	 */
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
	
	/**
	 * search a activity recording in the database
	 * 
	 * @param actRecDbId as int
	 * 
	 * @return activityRecording as entity instance
	 */
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
	
	/**
	 * update a activity recording in the database
	 * 
	 * @param actrec as entity instance
	 */
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
	
	/**
	 * delete a activity recording in the database
	 * 
	 * @param actrec as entity instance
	 */
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

