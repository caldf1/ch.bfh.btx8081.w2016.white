package ch.bfh.btx8081.w2016.white;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

import ch.bfh.btx8053.w2016.white.HVmanager.model.AddressType;
import ch.bfh.btx8053.w2016.white.HVmanager.model.Caregiver;
import ch.bfh.btx8053.w2016.white.HVmanager.model.Client;
import ch.bfh.btx8053.w2016.white.HVmanager.model.Institution;
import ch.bfh.btx8053.w2016.white.HVmanager.model.PersonType;

/**
 * 
 * @author caldf1
 *
 */
public class ModelTest {

	
	@Test
	public void clientTest() {
		
		Client client = new Client("Brönnimann", "Elisabeth", "03.05.1937");
		assertEquals("Brönnimann", client.getLastname());
		assertEquals("Elisabeth", client.getFirstname());
		assertEquals("03.05.1937", client.getBirthdate());
		assertEquals(PersonType.CLIENT, client.getPersonType());
		assertEquals(false, client.getAdminRights());
	}
	
	
	@Test
	public void privateAddressTest() {
		
		Client client = new Client("Brönnimann", "Elisabeth", "03.05.1937");
		client.setPrivateAddress("Höheweg 80", "2502", "Biel/Bienne");
		assertEquals("Höheweg 80", client.getPrivateAddress().getStreet());
		assertEquals("2502", client.getPrivateAddress().getPLZ());
		assertEquals("Biel/Bienne", client.getPrivateAddress().getCity());
		assertEquals(AddressType.PRIVATE, client.getPrivateAddress().getAddressType());
		
		
	}
	
	@Test
	public void caregiverTest() {
		Caregiver caregiver = new Caregiver("Lieberherr", "Wilfried", "myPassword");
		assertEquals("Lieberherr", caregiver.getLastname());
		assertEquals("Wilfried", caregiver.getFirstname());
		assertEquals("myPassword", caregiver.getPassword());
	}
	
	
	@Test
	public void businessAddressTest() {
		Caregiver caregiver = new Caregiver("Lieberherr", "Wilfried", "myPassword");
		caregiver.setBusinessAddress("Pflegestrasse 6", "2502", "Biel/Bienne", "Herr");
		assertEquals("Pflegestrasse 6", caregiver.getBusinessAddress().getStreet());
		assertEquals("2502", caregiver.getBusinessAddress().getPLZ());
		assertEquals("Biel/Bienne", caregiver.getBusinessAddress().getCity());
		assertEquals(AddressType.BUSINESS, caregiver.getBusinessAddress().getAddressType());
		
	}
	
	
	
	@Test
	public void externalTest() {
		
	}
	
	@Test
	public void externalAddressTest() {
		
	}
	
	
	
	@Test
	public void NetworkTest() {
		Client client = new Client("Brönnimann", "Elisabeth", "03.05.1937");
		Caregiver caregiver = new Caregiver("Lieberherr", "Wilfried", "myPassword");
		Institution institution = new Institution("Spitalzentrum Biel", "hospital");
		client.addToNetwork(institution);
		client.addToNetwork(caregiver);
		System.out.println(client.getClientNetwork());
		
		
	}
	
	

}
