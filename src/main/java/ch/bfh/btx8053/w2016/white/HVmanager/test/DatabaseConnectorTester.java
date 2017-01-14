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
		

		
		Client c1 = new Client();
		Client c2 = new Client();
		Client c3 = new Client();
		
		c1.setLastname("Neuenschwander");
		c1.setFirstname("Anna");
		c1.setBirthdate("12.12.1070");
		c1.setGenderType(GenderType.FEMALE);
		
		c2.setLastname("Bircher");
		c2.setFirstname("Hans");
		c2.setBirthdate("03.03.1930");
		c2.setGenderType(GenderType.MALE);
		
		c3.setLastname("Mürner");
		c3.setFirstname("Frida");
		c3.setGenderType(GenderType.UNKOWN);
		
		c1.setFirstname("Margrit");
		c3.setGenderType(GenderType.FEMALE);
		
		DatabaseConnector dbc = new DatabaseConnector();
		
		dbc.insertClient(c1);
		dbc.insertClient(c2);
		dbc.insertClient(c3);
		
		dbc.updateClient(c1);
		dbc.showClientList();
		//dbc.deleteClient(c2);
		//dbc.showClientList();

	}

}
