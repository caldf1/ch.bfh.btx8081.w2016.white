package ch.bfh.btx8053.w2016.white.HVmanager.test;

import ch.bfh.btx8053.w2016.white.HVmanager.model.ActivityRecording;
import ch.bfh.btx8053.w2016.white.HVmanager.model.Caregiver;
import ch.bfh.btx8053.w2016.white.HVmanager.model.Client;
import ch.bfh.btx8053.w2016.white.HVmanager.model.ExternalPerson;
import ch.bfh.btx8053.w2016.white.HVmanager.model.Institution;
import ch.bfh.btx8053.w2016.white.HVmanager.util.ExternalPersonType;
import ch.bfh.btx8053.w2016.white.HVmanager.util.GenderType;
import ch.bfh.btx8053.w2016.white.HVmanager.util.InstitutionType;
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
		
		ActivityRecording ar1 = new ActivityRecording();
		ar1.setDate("15.10.2016");
		ar1.setDescription("Medikament abgeben");
		ar1.setQuantity("20 Minuten");
		
		dbc.insertActRec(ar1);

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
		
		Caregiver cg = new Caregiver();
		cg.setLastname("Piller");
		cg.setFirstname("Peter");
		cg.setGenderType(GenderType.MALE);
		cg.setBusinessAddress("Holzweg 3", "3000", "Bern", "Suchtprävention");
		
		ExternalPerson ep1 = new ExternalPerson();
		ExternalPerson ep2 = new ExternalPerson();
		ep1.setLastname("Krüger");
		ep1.setFirstname("Hans");
		ep1.setGenderType(GenderType.MALE);
		ep1.setBusinessAddress("Flussweg 2", "3000", "Bern", "Innere Medizin");
		ep1.setExternalPersonType(ExternalPersonType.DOCTOR);
		ep2.setLastname("Brava");
		ep2.setFirstname("Carla");
		ep2.setBusinessAddress("Riedweg 33", "3322", "Schönbühl-Urtenen", "");
		ep2.setGenderType(GenderType.FEMALE);
		ep2.setExternalPersonType(ExternalPersonType.FAMILY);
		ep2.setDescription("Ehefrau");
		
		Institution inst1 = new Institution();
		inst1.setInstitutionName("Klinik Höheweg");
		inst1.setInstitutionAddress("Höheweg 1", "2501", "Biel", "Innere Medizin");
		inst1.setInstitutionType(InstitutionType.HOSPITAL);
		
	
		dbc.insertClient(c1);
		dbc.insertClient(c2);
		dbc.insertClient(c3);
		dbc.insertCaregiver(cg);
		dbc.insertExternalPerson(ep1);
		dbc.insertExternalPerson(ep2);
		dbc.insertInstitution(inst1);
		
		dbc.updateClient(c1);
		dbc.showClientList();
		dbc.deleteClient(c2);
		dbc.showClientList();

	}

}
