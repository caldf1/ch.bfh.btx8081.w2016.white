package ch.bfh.btx8053.w2016.white.HVmanager.model;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
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
 * @author nallm1, umern11, nedot1, heldf1, caldf1
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
	
	private static int id = 10598;

	@Id
	@GeneratedValue
	private int iddb = 0;
	private int personId = 0;
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
	
	/**
	 *  for persistence
	 */
	public Person(){
		
	}
	
	/**
	 * Creates a new person with
	 * 
	 * @param lastname as a string
	 * @param firstname as a string
	 * @param personType as a personType
	 * @param genderType as a genderType
	 */
	public Person(String lastname, String firstname, PersonType personType, GenderType genderType) {
		
		this.lastname = lastname; 
		this.firstname = firstname;
		
		setPersonId();
		switchPersonType(personType);
		if (this.personType == PersonType.CAREGIVER) {
			setAdminRights();
		}
		
		switchGenderType(genderType);

			
	}
	
	/**
	 * Constructor for the view, creates a perso for the veiw
	 * 
	 * @param lastname as a String
	 * @param firstname as a String
	 * @param personType as a personType
	 * @param gender as a char
	 */
	public Person(String lastname, String firstname, PersonType personType, char gender) {
		
		this.lastname = lastname; 
		this.firstname = firstname;		
		
		setPersonId();
		switchPersonType(personType);
		if (this.personType == PersonType.CAREGIVER) {
			setAdminRights();
		}
		
		//validateGender(gender);
		if (gender == 'W' || gender == 'w' || gender == 'F' || gender == 'f') {
			switchGenderType(GenderType.FEMALE);
		} else if (gender == 'M' || gender == 'm') {
			switchGenderType(GenderType.MALE);
		} else if (gender == 'O' || gender == 'o' || gender == 'A' || gender == 'a' || gender == 'T' || gender == 't') {
			switchGenderType(GenderType.OTHER);
		} else {
			switchGenderType(GenderType.UNKOWN);
		}

	}
	
	
	
	

/*==============================================
 *    GETTER
 *==============================================
 */
	
	/**
	*
	*Gets the personId
	*
	*@return personId as a int
	**/
	
	public int getPersonId() {
		return personId;
	}

	
	/**
	 * 
	 * Gets the Lastname
	 * 
	 * @return lastname as a String
	 */
	public String getLastname() {
		return lastname;
	}


	/**
	 * Gets the firstname
	 * 
	 * @return firstname as a String
	 */
	public String getFirstname() {
		return firstname;
	}

	/**
	 * 
	 * Gets the gender
	 * 
	 * @return gender as a String
	 */
	public String getGender(){ 
		
		if (genderType.equals(GenderType.FEMALE)){
			return "W"; // "weiblich"
		} else if (genderType.equals(GenderType.MALE)) {
			return "M"; // "maennlich"
		} else if (genderType.equals(GenderType.OTHER)){
			return "Other Gender"; 
		} else {
			return "unbekannt"; // Geschlecht nicht erfasst
		}
	}
	
	/**
	 * 
	 * Gets the title
	 * 
	 * @return title as a String
	 */
	public String getTitle(){
		return title;
	}
	
	
	/**
	 * Gets the person type PersonType
	 * 
	 * @return personType as a PersonType
	 */
	public PersonType getPersonType() {
		return personType;
	}
	
	
	/**
	 * 
	 * Gets the admin rights
	 * 
	 * @return adminRights as a boolean
	 */
	public boolean getAdminRights() {
		return adminRights;
	}
	
	
	/**
	 * 
	 * Gets a String of all attributes of person
	 * 
	 * @param PersonType as a personType
	 * @param PID, the personID as a int
	 * @param lastname as a String
	 * @param firstname  as a String
	 * @param Gender as a genderType
	 * @param Titel as a String
	 * @param Admin rights as a boolean
	 * 
	 * @return String
	 * 
	 */
	public String toString(){
		return "\nPersonType: " + personType + "\nPID: " + personId + "\nNachname: " + lastname + "\nVorname: " + firstname + "\nGeschlecht: " + this.getGender() + "\nTitel: " + title + "\nAdminrechte: " + adminRights ;
	}
	
/*==============================================
 *    SETTER
 *==============================================
 */
	
	
	/*
	 * first PersonId will be 10598 
	 */
	private void setPersonId() {
		this.personId = id;
		id++; 
	}
	
	
	/**
	 * Sets the lastname of this person
	 * 
	 * @param lastname as a String
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	
	/**
	 * 
	 * Sets the Firstname of this person
	 * 
	 * @param firstname as a String
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	
	/**
	 * 
	 * Sets the GenderType of this person
	 * 
	 * @param genderType as a genderType
	 */
	public void setGenderType(GenderType genderType){ 
		switchGenderType(genderType);
	}

	
	/**
	 * 
	 *Seths the title of this person 
	 *
	 * @param title as a String
	 */
	public void setTitle(String title){
		this.title = title;
	}
	
	
	/*
	 * Sets adminRights to true for Caregivers
	 */
	private void setAdminRights() {
		this.adminRights = true;
	}

	/**
	 * helper Method for the Constructor
	 * @param personType as personType
	 */
	private void switchPersonType(PersonType personType){
		
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
	}
	
	
	/**
	 * helper Method for the Constructor
	 * @param gendertype
	 */
	private void switchGenderType(GenderType gendertype){
		
		switch (gendertype) {
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
 *    Generated hashCode() and equals()
 *==============================================
 */	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + personId;
		result = prime * result + (adminRights ? 1231 : 1237);
		result = prime * result + ((firstname == null) ? 0 : firstname.hashCode());
		result = prime * result + ((genderType == null) ? 0 : genderType.hashCode());
		result = prime * result + ((lastname == null) ? 0 : lastname.hashCode());
		result = prime * result + ((personType == null) ? 0 : personType.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (personId != other.personId)
			return false;
		if (adminRights != other.adminRights)
			return false;
		if (firstname == null) {
			if (other.firstname != null)
				return false;
		} else if (!firstname.equals(other.firstname))
			return false;
		if (genderType != other.genderType)
			return false;
		if (lastname == null) {
			if (other.lastname != null)
				return false;
		} else if (!lastname.equals(other.lastname))
			return false;
		if (personType != other.personType)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}
	
}