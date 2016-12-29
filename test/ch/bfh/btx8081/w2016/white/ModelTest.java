package ch.bfh.btx8081.w2016.white;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

import ch.bfh.btx8053.w2016.white.HVmanager.model.Address;
import ch.bfh.btx8053.w2016.white.HVmanager.model.Caregiver;
import ch.bfh.btx8053.w2016.white.HVmanager.model.Client;
import ch.bfh.btx8053.w2016.white.HVmanager.model.Institution;
import ch.bfh.btx8053.w2016.white.HVmanager.util.AddressType;
import ch.bfh.btx8053.w2016.white.HVmanager.util.PersonType;

/**
 * Tests for every class in the package "model".
 * 
 * @author caldf1
 *
 */
public class ModelTest {

	@Ignore
	public void activityRecordingTest(){
		// not implemented
	}
	
	@Test
	public void addressTest(){
		Address address1 = new Address("Geschäftsweg 2b", "1234", "Workcity", AddressType.BUSINESS);
		Address address2 = new Address("Privatweg 1a", "4321", "Lachen", AddressType.PRIVATE);
		Address address3 = new Address("Institutsweg 33","1234", "Workcity", AddressType.INSTITUTION);
		
		address3.setStreet("Andere Strasse 9");
		address3.setZip("5464");
		address3.setCity("Andere Stadt");
		assertEquals("Andere Strasse 9", address3.getStreet());
		assertEquals("5464", address3.getZip());
		assertEquals("Andere Stadt", address3.getCity());
		
		address1.setPhonenumber("044 432 11 11");
		address1.setMobilenumber("078 987 65 43");
		address1.setFaxnumber("044 432 11 12");
		address1.setEmail("test@bfh.ch");
		address1.setPostOfficeBox("Postfach 10");
		address1.setCountry("NORWAY");
		
		address3.setAddress("Neuer Weg 2", "7353", "Neue Stadt");
		assertEquals("Neuer Weg 2, 7353 Neue Stadt", address3.getAddress());
		
		System.out.println(address1.toString());
		System.out.println(address2.toString());
		System.out.println(address3.toString());
		
		assertEquals(AddressType.INSTITUTION, address3.getAddressType());
		assertEquals(AddressType.PRIVATE, address2.getAddressType());
		assertEquals(AddressType.BUSINESS, address1.getAddressType());
		assertEquals("Geschäftsweg 2b", address1.getStreet());
		assertEquals("1234", address1.getZip());
		assertEquals("Workcity", address1.getCity());
		assertEquals("NORWAY", address1.getCountry());
		assertEquals("Postfach 10", address1.getPostOfficeBox());
		assertEquals("044 432 11 11", address1.getPhonenumber());
		assertEquals("078 987 65 43", address1.getMobilenumber());
		assertEquals("044 432 11 12", address1.getFaxnumber());
		assertEquals("test@bfh.ch", address1.getEmail());
					
	}
	
	@Test
	public void addressBusinessTest() {
		Caregiver caregiver = new Caregiver("Lieberherr", "Wilfried", "myPassword");
		caregiver.setBusinessAddress("Pflegestrasse 6", "2502", "Biel/Bienne", "Herr");
		assertEquals("Pflegestrasse 6", caregiver.getBusinessAddress().getStreet());
		assertEquals("2502", caregiver.getBusinessAddress().getZip());
		assertEquals("Biel/Bienne", caregiver.getBusinessAddress().getCity());
		assertEquals(AddressType.BUSINESS, caregiver.getBusinessAddress().getAddressType());
		
	}
	
	@Test
	public void addressInstitutionTest(){
		
	}
	
	@Test
	public void addressPrivateTest() {
		
		Client client = new Client("Brönnimann", "Elisabeth", "03.05.1937");
		client.setPrivateAddress("Höheweg 80", "2502", "Biel/Bienne");
		assertEquals("Höheweg 80", client.getPrivateAddress().getStreet());
		assertEquals("2502", client.getPrivateAddress().getZip());
		assertEquals("Biel/Bienne", client.getPrivateAddress().getCity());
		assertEquals(AddressType.PRIVATE, client.getPrivateAddress().getAddressType());
		
		
	}
	
	
	@Ignore
	public void appointmentTest(){
		// not implemented
	}
	
	@Ignore
	public void billTest(){
		// not implemented
	}
	
	@Ignore
	public void calendarTest(){
		// not implemented
	}
	
	@Test
	public void caregiverTest() {
		Caregiver caregiver = new Caregiver("Lieberherr", "Wilfried", "myPassword");
		assertEquals("Lieberherr", caregiver.getLastname());
		assertEquals("Wilfried", caregiver.getFirstname());
		assertEquals("myPassword", caregiver.getPassword());
	}
	
	
	@Test
	public void caseTest(){
		// not implemented
	}
	
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
	public void externalPersonTest(){
		
	}
	
	@Test
	public void institutionTest(){
		
	}
	
	
	@Ignore
	public void medDocTest(){
		// not implemented
	}
	
	
	@Test
	public void networkTest() {
		Client client = new Client("Brönnimann", "Elisabeth", "03.05.1937");
		Caregiver caregiver = new Caregiver("Lieberherr", "Wilfried", "myPassword");
		Institution institution = new Institution("Spitalzentrum Biel", "hospital");
		client.addToNetwork(institution);
		client.addToNetwork(caregiver);
		System.out.println(client.getClientNetwork());
		
		
	}
	
	@Test
	public void personTest(){
		
	}
	
	@Ignore
	public void statisticsTest(){
		// not implemented
	}
	

}
