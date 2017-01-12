package ch.bfh.btx8053.w2016.white.HVmanager.test;

import ch.bfh.btx8053.w2016.white.HVmanager.model.Client;
import ch.bfh.btx8053.w2016.white.HVmanager.util.GenderType;
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
		
		Client c1 = new Client("Neuenschwander", "Manuela", GenderType.FEMALE, "12.12.1970");
		Client c2 = new Client("Bucherer", "Emanuel", GenderType.MALE, "30.03.1966");
		Client c3 = new Client("Pfahl", "Stefanie", GenderType.OTHER, "10.05.1954");
		
		System.out.println(c1.getLastname());
		
		c1.setFirstname("Margrit");
		c3.setGenderType(GenderType.FEMALE);
		
		dbc.updateClient(c1);
		dbc.deleteClient(c2);
		dbc.showClientList();

	}

}
