package ch.bfh.btx8053.w2016.white.HVmanager.model;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import ch.bfh.btx8053.w2016.white.HVmanager.util.GenderType;
import ch.bfh.btx8053.w2016.white.HVmanager.util.PersonType;

/**
 * Person with <br>
 * ID, lastname, firstname, <br>
 * persontype can be CAREGIVER or CLIENT or EXTERNAL, adminrights<br>
 * private Address, business Address, institution Address
 * 
 * 
 * @author nallm1, umern11, caldf1, nedot1
 *
 */
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="PersonType", discriminatorType=DiscriminatorType.STRING)
public class Person {
	
		
/*==============================================
 *    Attributes
 *==============================================
 */ 
	private static long id = 10000;

	@Id
	private String personId = null;
	private String lastname = null; 
	private String firstname = null;
	private GenderType genderType = GenderType.UNKOWN;
	private String title = null;

	private PersonType personType = null;
	private boolean adminRights = false;
	
	

/*==============================================
 *    Constructor
 *==============================================
 */   
	public Person(String lastname, String firstname, PersonType personType, GenderType genderType) {
		
		this.lastname = lastname; 
		this.firstname = firstname;
		
		setPersonId();
		
		switch (personType) {
		case CAREGIVER:
			this.personType = PersonType.CAREGIVER;
			break;
		case CLIENT:
			this.personType = PersonType.CLIENT;
			break;
		case EXTERNAL:
			this.personType = PersonType.EXTERNAL;
			break;
		}
		
		
		if (this.personType == PersonType.CAREGIVER) {
			setAdminRights();
		}
		
		switch (genderType) {
		case MALE:
			this.genderType = GenderType.MALE;
			break;
		case FEMALE:
			this.genderType = GenderType.FEMALE;
			break;
		case OTHER:
			this.genderType = GenderType.OTHER;
			break;
		case UNKOWN:
			this.genderType = GenderType.UNKOWN;
			break;
		}
		
	}
	


/*==============================================
 *    GETTER
 *==============================================
 */
	public String getPersonId() {
		return personId;
	}

	public String getLastname() {
		return lastname;
	}



	public String getFirstname() {
		return firstname;
	}

	public String getGender(){ 
		
		if (genderType.equals(GenderType.FEMALE)){
			return "W"; // "weiblich"
		} else if (genderType.equals(GenderType.MALE)) {
			return "M"; // "männlich"
		} else if (genderType.equals(GenderType.OTHER)){
			return "Other Gender"; 
		} else {
			return "unbekannt"; // Geschlecht nicht erfasst
		}
	}
	
	public String getTitle(){
		return title;
	}
	
	public PersonType getPersonType() {
		return personType;
	}
	
	
	public boolean getAdminRights() {
		return adminRights;
	}
	
	public String toString(){
		return "\nPersonType: " + personType + "\nPID: " + personId + "\nNachname: " + lastname + "\nVorname: " + firstname + "\nGeschlecht: " + this.getGender() + "\nTitel: " + title + "\nAdminrechte: " + adminRights ;
	}
	
/*==============================================
 *    SETTER
 *==============================================
 */
	
	private void setPersonId() {
		this.personId = "P"+id;
		id ++; // TODO geändert!
	}
	
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	public void setGenderType(GenderType genderType){ 
		this.genderType = genderType;
	}

	public void setTitle(String title){
		this.title = title;
	}
	
	private void setAdminRights() {
		this.adminRights = true;
	}
	
}