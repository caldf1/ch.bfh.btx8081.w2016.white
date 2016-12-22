package ch.bfh.btx8053.w2016.white.HVmanager.model;

/**
 * @author nallm1
 *
 */
public class Person {
	
	//Instanzvariablen (Attribute)
	private int personId;
	private String lastname; 
	private String firstname;
	private boolean admin;
	private boolean client;
	private boolean extern;

	
	
	//Constructor
	public Person (String lastname, String firstname, PersonType personType) {
		this.lastname = lastname; 
		this.firstname = firstname;
		this.personId = 1;
		switch (personType) {
		case ADMIN: this.admin = true;
		break;
		case CLIENT: this.client = true;
		break;
		case EXTERN: this.extern = true;
		break;
		}
	}

	//getter
	public String getLastname() {
		return lastname;
	}


	public void setLastname(String lastname) {
		this.lastname = lastname;
	}


	public String getFirstname() {
		return firstname;
	}


	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	public PersonType getPersonType() {
		if (this.admin) {
			return PersonType.ADMIN;
		}
		else if (this.client) {
			return PersonType.CLIENT;
		}
		else {
			return PersonType.EXTERN;
		}
	}
	
	
	public int getPersonId() {
		return personId;
	}

	public void setPersonId(int personId) {
		this.personId = personId;
	}

	public void addAdress (String street, int zip, String city, AdressType adressType) {
		Adress adress = new Adress(personId, street, zip, city, adressType, "p");
	}

	public void addCommunication (String value, CommunicationType communicationType) {
		Communication communication = new Communication(this.personId, value, communicationType, "p");
	}
	
}