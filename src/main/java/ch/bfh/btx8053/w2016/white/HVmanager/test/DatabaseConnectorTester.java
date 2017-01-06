package ch.bfh.btx8053.w2016.white.HVmanager.test;

import ch.bfh.btx8053.w2016.white.HVmanager.model.Person;
import ch.bfh.btx8053.w2016.white.HVmanager.util.PersonType;
import ch.bfh.btx8053.w2016.white.HVmanager.persistence.DatabaseConnector;

public class DatabaseConnectorTester{

	public static void main(String[] args) {
		
		DatabaseConnector dbc = new DatabaseConnector();
		
		Person p1 = new Person("Neuenschwander", "Manuela", PersonType.CLIENT);
		Person p2 = new Person("Bucherer", "Emanuel", PersonType.EXTERNAL);
		Person p3 = new Person("Pfahl", "Stefanie", PersonType.CLIENT);
		
		System.out.println(p1.getLastname());
		
		p1.setFirstname("Margrit");
		
		//dbc.update(p1);
		//dbc.deletePerson(p2);

	}

}
