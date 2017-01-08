package ch.bfh.btx8081.w2016.white;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

import ch.bfh.btx8053.w2016.white.HVmanager.model.Address;
import ch.bfh.btx8053.w2016.white.HVmanager.model.AddressBusiness;
import ch.bfh.btx8053.w2016.white.HVmanager.model.AddressInstitution;
import ch.bfh.btx8053.w2016.white.HVmanager.model.AddressPrivate;
import ch.bfh.btx8053.w2016.white.HVmanager.model.Caregiver;
import ch.bfh.btx8053.w2016.white.HVmanager.model.Client;
import ch.bfh.btx8053.w2016.white.HVmanager.model.ExternalPerson;
import ch.bfh.btx8053.w2016.white.HVmanager.model.Institution;
import ch.bfh.btx8053.w2016.white.HVmanager.model.Person;
import ch.bfh.btx8053.w2016.white.HVmanager.util.AddressType;
import ch.bfh.btx8053.w2016.white.HVmanager.util.ExternalPersonType;
import ch.bfh.btx8053.w2016.white.HVmanager.util.GenderType;
import ch.bfh.btx8053.w2016.white.HVmanager.util.InstitutionType;
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
		
		System.out.print("\n============ toString() von Address ============");
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
		AddressBusiness businessAddress = new AddressBusiness("Businessweg 5", "6035", "Leistungsstadt", "Teppichetage", "M");
		
		System.out.print("\n============ toString() von AddressBusiness ============");
		System.out.println(businessAddress.toString());
		
		assertEquals("Herr", businessAddress.getSalutation());
		assertEquals("Teppichetage", businessAddress.getDepartment());
		
		businessAddress.setSalutation("Frau");
		businessAddress.setDepartment("Direktion");
		
		assertEquals("Frau", businessAddress.getSalutation());
		assertEquals("Direktion", businessAddress.getDepartment());
	}
	
	@Test
	public void addressInstitutionTest(){
		
		AddressInstitution institutionAddress = new AddressInstitution("Institution-Weg 5", "6035", "Leistungsstadt", "Teppichetage");
		
		System.out.print("\n============ toString() von AddressInstitution ============");
		System.out.println(institutionAddress.toString());
		
		institutionAddress.setDepartment("Direktion");
		
		assertEquals("Direktion", institutionAddress.getDepartment());
						
	}
	
	@Test
	public void addressPrivateTest() {
		
		AddressPrivate privateAddress1 = new AddressPrivate("Privatweg 5", "1000", "Kreativcity", "W");
		AddressPrivate privateAddress2 = new AddressPrivate("Privatweg 5", "1000", "Kreativcity", "Other Gender");
		
		System.out.print("\n============ toString() von AddressPrivate ============");
		System.out.println(privateAddress1.toString());
		
		assertEquals("Frau", privateAddress1.getSalutation());
		assertEquals("", privateAddress2.getSalutation());

		privateAddress1.setSalutation("Herr");
		
		assertEquals("Herr", privateAddress1.getSalutation());
		
		
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
		
		Caregiver caregiver = new Caregiver("Lieberherr", "Wilfried", GenderType.MALE, "myPassword");
		caregiver.setPrivateAddress("Pflegeweg 8", "4422", "Gesundheim");
		caregiver.setBusinessAddress("Pflegestrasse 8b", "4422", "Gesundheim", "Werkstadt");
		
		System.out.print("\n============ toString() von Caregiver ============");
		System.out.println(caregiver.toString());
		
		assertEquals("myPassword", caregiver.getPassword());
		System.out.println("\n\nCaregiver Private Address: " + caregiver.getPrivateAddress());
		System.out.println("\nCaregiver Business Address: " + caregiver.getBusinessAddress());
		
		caregiver.setPassword("changedPassword");
		assertEquals("changedPassword", caregiver.getPassword());
		
	}
	
	
	@Test
	public void caseTest(){
		// not implemented
	}
	
	@Test
	public void clientTest() {
		
		Client client = new Client("Brönnimann", "Elisabeth", GenderType.FEMALE,"03.05.1937");
		client.setPrivateAddress("Kreuzweg 11", "2502", "Biel/Bienne");	
		
		Caregiver caregiver = new Caregiver("Lieberherr", "Wilfried", GenderType.MALE, "myPassword");
		ExternalPerson externalPerson = new ExternalPerson("Iseli", "Elvira", GenderType.FEMALE, ExternalPersonType.FAMILY);
		Institution institution = new Institution("Klinik Höhenweg","hospital");
		client.addToNetwork(caregiver);
		client.addToNetwork(externalPerson);
		client.addToNetwork(institution);
		
		System.out.print("\n============ toString() von Client ============");
		System.out.println(client.toString());
		
		assertEquals(3, client.getClientNetwork().size());
		assertEquals("03.05.1937", client.getBirthdate());
		
		client.setBirthdate("05.03.1973");
		assertEquals("05.03.1973", client.getBirthdate());
		
	}
	
	
	@Test
	public void externalPersonTest(){
		
		ExternalPerson externalPerson = new ExternalPerson("Iseli", "Elvira", GenderType.FEMALE, ExternalPersonType.FAMILY);
		externalPerson.setDescription("Sorgt für gute Stimmung!");
		externalPerson.setPrivateAddress("Happystreet 3", "8853", "Lachen");
		externalPerson.setBusinessAddress("Humorstrasse", "8853", "Lachen", "Unterhaltung");
		
		System.out.print("\n============ toString() von ExternalPerson ============");
		System.out.println(externalPerson.toString());
		
		assertEquals("Sorgt für gute Stimmung!", externalPerson.getDescription());
		assertEquals(ExternalPersonType.FAMILY, externalPerson.getExternalPersonType());
		
	}
	
	@Test
	public void institutionTest(){
		
		Institution institution = new Institution("Klinik Höheweg","hospital");
		institution.setInstitutionAddress("Höheweg 80", "2502", "Biel/Bienne", "Annahme");
		
		System.out.print("\n============ toString() von Institution ============");
		System.out.println(institution.toString());
		
		assertEquals("I", institution.getInstitutionId().substring(0, 1));
		assertEquals("Klinik Höheweg", institution.getInstitutionName());
		assertEquals(InstitutionType.HOSPITAL, institution.getInstitutionType());
		
	}
	
	
	@Ignore
	public void medDocTest(){
		// not implemented
	}
	
	
	@Test
	public void networkTest() {
		Client client = new Client("Brönnimann", "Elisabeth", GenderType.FEMALE,"03.05.1937");
		Caregiver caregiver = new Caregiver("Lieberherr", "Wilfried",GenderType.MALE, "myPassword");
		Institution institution = new Institution("Spitalzentrum Biel", "hospital");
		client.addToNetwork(institution);
		client.addToNetwork(caregiver);
		System.out.println(client.getClientNetwork());
		
		
	}
	
	@Test
	public void personTest(){
		
		Person person1 = new Person("Lieberherr", "Alfons", PersonType.CAREGIVER, GenderType.MALE);
		person1.setTitle("Prof. Dr.");
		assertEquals("M", person1.getGender());
		assertEquals("Prof. Dr.", person1.getTitle());
		
		Person person2 = new Person("Iseli", "Elvira", PersonType.EXTERNAL, GenderType.OTHER);
		assertEquals("Other Gender", person2.getGender());
		
		Person person3 = new Person("Brönnimann", "Elisabeth", PersonType.CLIENT, GenderType.UNKOWN);
		assertEquals("unbekannt", person3.getGender());
		
		person3.setGenderType(GenderType.FEMALE);
		assertEquals("W", person3.getGender());
		
		System.out.print("\n============ toString() von Person ============");
		System.out.println(person1.toString());
		System.out.println(person2.toString());
		System.out.println(person3.toString());
		
		assertEquals(true, person1.getAdminRights());
		assertEquals(false, person2.getAdminRights());
		assertEquals(false, person3.getAdminRights());
		
		assertEquals("P100", person1.getPersonId().substring(0, 4));
		assertEquals("Iseli", person2.getLastname());
		assertEquals("Elvira", person2.getFirstname());
		
		assertEquals(PersonType.CAREGIVER, person1.getPersonType());
		assertEquals(PersonType.EXTERNAL, person2.getPersonType());
		assertEquals(PersonType.CLIENT, person3.getPersonType());
		
	}
	
	@Ignore
	public void statisticsTest(){
		// not implemented
	}
	

}
