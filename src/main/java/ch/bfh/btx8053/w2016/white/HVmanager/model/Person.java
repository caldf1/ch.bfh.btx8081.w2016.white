package ch.bfh.btx8053.w2016.white.HVmanager.model;

import ch.bfh.btx8053.w2016.white.HVmanager.util.GenderType;
import ch.bfh.btx8053.w2016.white.HVmanager.util.PersonType;

/**
 * Person with <br>
 * ID, lastname, firstname, <br>
 * persontype can be CAREGIVER or CLIENT or EXTERNAL, adminrights<br>
 * private Address, business Address, institution Address
 * 
 * 
 * @author nallm1, umern11, caldf1
 *
 */
public class Person {
	
		
/*==============================================
 *    Attributes
 *==============================================
 */ 
	private static long id = 10000;

	private String personId = null;
	private String lastname = null; 
	private String firstname = null;
	private GenderType gender = GenderType.UNKOWN;

	private PersonType personType = null;
	private boolean adminRights = false;
	
	

/*==============================================
 *    Constructor
 *==============================================
 */   
	public Person(String lastname, String firstname, PersonType personType) {
		
		this.lastname = lastname; 
		this.firstname = firstname;
		
		setPersonId();
		
		switch (personType) {
		case CAREGIVER: this.personType = PersonType.CAREGIVER;
		break;
		case CLIENT: this.personType = PersonType.CLIENT;
		break;
		case EXTERNAL: this.personType = PersonType.EXTERNAL;
		break;
		}
		
		
		if (this.personType == PersonType.CAREGIVER) {
			setAdminRights();
		}
		
	}
	


/*==============================================
 *    GETTER
 *==============================================
 */
	
	public String getLastname() {
		return lastname;
	}



	public String getFirstname() {
		return firstname;
	}

	
	public PersonType getPersonType() {
		return personType;
	}
	
	
	public String getPersonId() {
		return personId;
	}

	public boolean getAdminRights() {
		return adminRights;
	}

	public GenderType getGender(){
		return gender;
	}
	
/*==============================================
 *    SETTER
 *==============================================
 */
	
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	private void setPersonId() {
		this.personId = "P"+id;
		id = id++;
	}
	
	private void setAdminRights() {
		adminRights = true;
	}

	public void setGender(GenderType gender){
		this.gender = gender;
	}
	
	
}