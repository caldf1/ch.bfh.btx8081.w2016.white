package ch.bfh.btx8081.w2016.white.junit;


import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.Ignore;
import org.junit.Test;

import ch.bfh.btx8053.w2016.white.HVmanager.model.ActivityRecording;
import ch.bfh.btx8053.w2016.white.HVmanager.model.Address;
import ch.bfh.btx8053.w2016.white.HVmanager.model.AddressBusiness;
import ch.bfh.btx8053.w2016.white.HVmanager.model.AddressInstitution;
import ch.bfh.btx8053.w2016.white.HVmanager.model.AddressPrivate;
import ch.bfh.btx8053.w2016.white.HVmanager.model.Appointment;
import ch.bfh.btx8053.w2016.white.HVmanager.model.Bill;
import ch.bfh.btx8053.w2016.white.HVmanager.model.BillPosition;
import ch.bfh.btx8053.w2016.white.HVmanager.model.Calendar;
import ch.bfh.btx8053.w2016.white.HVmanager.model.Caregiver;
import ch.bfh.btx8053.w2016.white.HVmanager.model.Case;
import ch.bfh.btx8053.w2016.white.HVmanager.model.Client;
import ch.bfh.btx8053.w2016.white.HVmanager.model.ExternalPerson;
import ch.bfh.btx8053.w2016.white.HVmanager.model.Institution;
import ch.bfh.btx8053.w2016.white.HVmanager.model.MedDoc;
import ch.bfh.btx8053.w2016.white.HVmanager.model.Network;
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

	@Test
	public void activityRecordingTest(){
		
		ActivityRecording activityRecord = new ActivityRecording("11.01.2017", "Beschreibung", "Anzahl");
		assertEquals("11.01.2017", activityRecord.getDate());
		assertEquals("Beschreibung", activityRecord.getDescription());
		assertEquals("Anzahl", activityRecord.getQuantity());
		
		activityRecord.setDate("21.12.2016");
		activityRecord.setDescription("Treppensteigen");
		activityRecord.setQuantity("3x/Tag");
		assertEquals("21.12.2016", activityRecord.getDate());
		assertEquals("Treppensteigen", activityRecord.getDescription());
		assertEquals("3x/Tag", activityRecord.getQuantity());
		
		System.out.print("\n============ toString() von ActivityRecording ============");
		System.out.println(activityRecord.toString());
						
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
	
	
	@Test
	public void appointmentTest() {

		Client client = new Client("Dem", "Klienten", GenderType.UNKOWN, "");
		Caregiver caregiver = new Caregiver("Demo", "Pfleger", GenderType.UNKOWN, "password");
		GregorianCalendar startTime = new GregorianCalendar(2017, 01, 11, 9, 30);
		GregorianCalendar endTime = new GregorianCalendar(2017, 01, 11, 12, 30);
		
		Client changeClient = new Client("Dem", "Client", GenderType.UNKOWN, "");
		Caregiver changeCaregiver = new Caregiver("Demo", "Give Care", GenderType.UNKOWN, "password");		
		GregorianCalendar newStartTime = new GregorianCalendar(2017, 01, 11, 14, 30);
		GregorianCalendar newEndTime = new GregorianCalendar(2017, 01, 11, 16, 30);

		Appointment appointment = new Appointment(new GregorianCalendar(2017, 01, 11, 9, 30),
				new GregorianCalendar(2017, 01, 11, 12, 30), new Client("Dem", "Klienten", GenderType.UNKOWN, ""),
				new Caregiver("Demo", "Pfleger", GenderType.UNKOWN, "password"));
		appointment.setComment("Gespräch");

		System.out.print("\n============ toString() von Appointment ============");
		System.out.println(appointment.toString());

		assertEquals(caregiver, appointment.getCaregiver());
		assertEquals(client, appointment.getClient());
		assertEquals("Gespräch", appointment.getComment());
		assertEquals(startTime, appointment.getStartTime());
		assertEquals(endTime, appointment.getEndTime());
		
		appointment.changeClient(changeClient);
		appointment.changeCaregiver(changeCaregiver);
		appointment.setStartTime(newStartTime);
		appointment.setEndTime(newEndTime);
		appointment.setComment("Begleitung");
		
		assertEquals(changeClient, appointment.getClient());
		assertEquals(changeCaregiver, appointment.getCaregiver());
		assertEquals("Begleitung", appointment.getComment());
		assertEquals(newStartTime, appointment.getStartTime());
		assertEquals(newEndTime, appointment.getEndTime());
		
	}
	
	@Test
	public void billTest(){ 
		
	Bill bill1 = new Bill("11.01.2017", 100, 12, "Gespräch 05.01.2017");
	BillPosition leistung1 = new BillPosition("Leistung 1", 10.50);
	BillPosition leistung2 = new BillPosition("Leistung 2", 9.50);
	
	assertEquals("11.01.2017", bill1.getBillDate());
	assertEquals(12, bill1.getCaregiverID());
	assertEquals(100, bill1.getCaseID());
	assertEquals("Gespräch 05.01.2017", bill1.getDescription());	
	
	System.out.print("\n============ toString() von Bill ============");
	
		System.out.println("\nTotal1: " + bill1.getBillTotalValue());
		assertEquals("0.0", bill1.getBillTotalValue());
		bill1.addBillPosition(leistung1);
		System.out.println("Total2: " + bill1.getBillTotalValue());
		assertEquals("10.50", bill1.getBillTotalValue());
		bill1.addBillPosition(leistung2);
		System.out.println("Total3: " +bill1.getBillTotalValue());
		assertEquals("20.00", bill1.getBillTotalValue());
	
	System.out.println(bill1.toString());
	
		bill1.removeBillPosition(leistung2);
		System.out.println("Total4: " +bill1.getBillTotalValue());
		assertEquals("10.50", bill1.getBillTotalValue());
	
	bill1.setBillDate("01.11.2016");
	bill1.setCaregiverID(13);
	bill1.setCaseID(99);
	bill1.setDescription("Gespräch 05.10.2016");
	
	assertEquals("01.11.2016", bill1.getBillDate());
	assertEquals(13, bill1.getCaregiverID());
	assertEquals(99, bill1.getCaseID());
	assertEquals("Gespräch 05.10.2016", bill1.getDescription());
	
	}
	
	
	@Test
	public void calendarTest(){
		
		Person person = new Person("Kalender", "Inhaber", PersonType.CAREGIVER, GenderType.OTHER);
		
		Appointment appointment1 = new Appointment(new GregorianCalendar(2017, 01, 11, 9, 30),
				new GregorianCalendar(2017, 01, 11, 12, 30), new Client("1. Dem", "Klienten", GenderType.UNKOWN, ""), new Caregiver("Demo", "Pfleger", GenderType.UNKOWN, "password"));
		appointment1.setComment("Gespräch1");
		
		Appointment appointment2 = new Appointment(new GregorianCalendar(2017, 01, 10, 9, 30),
				new GregorianCalendar(2017, 01, 10, 12, 30), new Client("2. Dem", "Klienten", GenderType.UNKOWN, ""), new Caregiver("Demo", "Pfleger", GenderType.UNKOWN, "password"));
		appointment2.setComment("Gespräch");
		
		Appointment appointment3 = new Appointment(new GregorianCalendar(2017, 01, 9, 9, 30),
				new GregorianCalendar(2017, 01, 9, 12, 30), new Client("3. Dem", "Klienten", GenderType.UNKOWN, ""), new Caregiver("Demo", "Pfleger", GenderType.UNKOWN, "password"));
		appointment3.setComment("Gespräch");
		
		Calendar calendar = new Calendar(person);
		calendar.addAppointment(appointment1);
		calendar.addAppointment(appointment2);
		calendar.addAppointment(appointment3);
		calendar.removeAppointment(appointment3);
		
		System.out.print("\n============ toString() von Calendar ============");
		System.out.println(calendar.toString());
		
		assertEquals(calendar, calendar.getCalendar());
		System.out.println("\ngetAppointments(): \n" + calendar.getAppointments());
		assertEquals(person, calendar.getPerson());

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
		//  TODO
		ArrayList<ActivityRecording> activityList = new ArrayList<>();
		activityList.add(new ActivityRecording());
	
		ArrayList<Bill> billList = new ArrayList<>();
		billList.add(new Bill());
		
		ArrayList<MedDoc> medDocList = new ArrayList<>();
		medDocList.add(new MedDoc());
		
		

		Case medCase = new Case("11.01.2017", "Burnout", 99);
		medCase.addActivityRecordsToList(new ActivityRecording());
		medCase.addBillToList(new Bill());
		medCase.addMedDocToList(new MedDoc());
		
		medCase.addDiagnose("Fruscht");
		medCase.addDiagnose("Rutsch mer de Buggel ab!");
		medCase.addDiagnose("Aschiss");
		//medCase.removeDiagnose("Aschiss");
		
		System.out.print("\n============ toString() von Case ============");
		System.out.println(medCase.toString());
		
		
		assertEquals(activityList, medCase.getActivityRecords());
		assertEquals(billList, medCase.getBills());
		assertEquals(99, medCase.getCargiverID());
		//assertEquals("", medCase.getCaseID());
		//assertEquals("", medCase.getDiagnoseList());
		assertEquals("11.01.2017", medCase.getStartDate());
		assertEquals(null, medCase.getEndDate());
		assertEquals("Burnout", medCase.getMainDiagnose());
		assertEquals(medDocList, medCase.getMedDocs());
		
		medCase.setMainDiagnose("Out of Burn");
		assertEquals("Out of Burn", medCase.getMainDiagnose());
		
		
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
		
		//assertEquals("I", institution.getInstitutionId().substring(0, 1));
		assertEquals("Klinik Höheweg", institution.getInstitutionName());
		assertEquals(InstitutionType.HOSPITAL, institution.getInstitutionType());
		
	}
	
	
	@Test
	public void medDocTest(){
		
		MedDoc doc1 = new MedDoc("Testfile", "\\C:\\Desktop");
		//MedDoc doc2 = new MedDoc(medDocFile); for Sprint 4
		Date creationDate = doc1.getCreationDate(); 
		
		System.out.print("\n============ toString() von MedDoc ============");
		System.out.println(doc1.toString());

		assertEquals("Testfile",doc1.getFilename());
		assertEquals("\\C:\\Desktop",doc1.getStorageLocation());
		
		// Zeitverzögerung einbauen sprint 4
		doc1.setFilename("Testdatei");
		doc1.setStorageLocation("\\C:\\Dokumente");
		assertEquals(creationDate, doc1.getCreationDate());
		assertNotEquals(creationDate, doc1.getDateLastChange());
		
		System.out.print("\nErstellungsdatum: " + doc1.getCreationDate());
		System.out.println("\nÄnderungsdatum: " + doc1.getDateLastChange());
		
		//doc1.open(); for sprint 4
		
	}
	
	
	@Test
	public void networkTest() {
	
		Client client = new Client("Brönnimann", "Elisabeth", GenderType.FEMALE,"03.05.1937");
		
		ExternalPerson person1 = new ExternalPerson("A", "B", GenderType.MALE, ExternalPersonType.DOCTOR);
		ExternalPerson person2 = new ExternalPerson("C", "D", GenderType.MALE, ExternalPersonType.DOCTOR);
		ExternalPerson person3 = new ExternalPerson("E", "F", GenderType.MALE, ExternalPersonType.FAMILY);
		ExternalPerson person4 = new ExternalPerson("G", "H", GenderType.MALE, ExternalPersonType.FAMILY);
		ExternalPerson person5 = new ExternalPerson("I", "J", GenderType.MALE, ExternalPersonType.CONTACT_PERSON);
		
		client.addToNetwork(person1);
		client.addToNetwork(person2);
		client.addToNetwork(person3);
		client.addToNetwork(person4);
		client.addToNetwork(person5);
		
		System.out.print("\n============ Network Lists ============");
		System.out.println(new Network(client.getClientNetwork()).toString());
		
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
		
		//assertEquals("P100", person1.getPersonId().substring(0, 4));
		assertEquals("Iseli", person2.getLastname());
		assertEquals("Elvira", person2.getFirstname());
		
		assertEquals(PersonType.CAREGIVER, person1.getPersonType());
		assertEquals(PersonType.EXTERNAL, person2.getPersonType());
		assertEquals(PersonType.CLIENT, person3.getPersonType());
		
	}
	
	@Ignore
	public void statisticsTest(){
		// not implemented TODO
		// Tests for class Statistic, will be a Task for maybe sprint 10.
	}
	

}
