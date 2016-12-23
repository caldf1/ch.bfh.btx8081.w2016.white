package ch.bfh.btx8053.w2016.white.HVmanager.persistence;
//
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.EntityTransaction;
//import javax.persistence.Persistence;
//
//import ch.bfh.btx8053.w2016.white.HVmanager.model.Person;
//import ch.bfh.btx8053.w2016.white.HVmanager.model.PersonType;
//
///**
// * 
// * @author nedot1
// *
// */
//
public class DatabaseConnector {
//	
//	private static final String PERSISTENCE_UNIT_NAME = "HVManager";
//	EntityManager em;
//	EntityManagerFactory factory;
//	EntityTransaction transaction;
//	
//	public DatabaseConnector() {
//		EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
//						
//	}
//	
//	public void insertPerson(Person person){
//		EntityManager em = factory.createEntityManager();
//		EntityTransaction transaction = em.getTransaction();
//		transaction.begin();
//		em.persist(person);
//		em.getTransaction().commit();
//		em.close();
//	}
//	
//	public void update(Person person){
//		EntityManager em = factory.createEntityManager();
//		EntityTransaction transaction = em.getTransaction();
//		transaction.begin();
//		em.merge(person);
//		em.getTransaction().commit();
//		em.close();
//	}
//	
//	public void deletePerson(Person person){
//		EntityTransaction transaction = em.getTransaction();
//		em.remove(person);
//		em.getTransaction().commit();
//		em.close();
//	}
}
