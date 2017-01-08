package ch.bfh.btx8053.w2016.white.HVmanager.test;

import ch.bfh.btx8053.w2016.white.HVmanager.model.Person;
import ch.bfh.btx8053.w2016.white.HVmanager.util.GenderType;
import ch.bfh.btx8053.w2016.white.HVmanager.util.PersonType;
import ch.bfh.btx8053.w2016.white.HVmanager.persistence.DatabaseConnector;

/**
 * 
 * 
 * @author nedot1, caldf1
 *
 */
public class DatabaseConnectorTester{

	public static void main(String[] args) {
		
		DatabaseConnector dbc = new DatabaseConnector();
		
		Person p1 = new Person("Neuenschwander", "Manuela", PersonType.CLIENT, GenderType.FEMALE);
		Person p2 = new Person("Bucherer", "Emanuel", PersonType.EXTERNAL, GenderType.MALE);
		Person p3 = new Person("Pfahl", "Stefanie", PersonType.CLIENT, GenderType.OTHER);
		
		System.out.println(p1.getLastname());
		
		p1.setFirstname("Margrit");
		
		//dbc.update(p1);
		//dbc.deletePerson(p2);

	}

}
