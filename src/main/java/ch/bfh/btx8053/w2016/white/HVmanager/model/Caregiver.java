package ch.bfh.btx8053.w2016.white.HVmanager.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import ch.bfh.btx8053.w2016.white.HVmanager.interfaces.Connectable;
import ch.bfh.btx8053.w2016.white.HVmanager.util.GenderType;
import ch.bfh.btx8053.w2016.white.HVmanager.util.PersonType;



/**
 * This class creates a person from a person type caregiver
 * @author umern11, nedot1, heldf1, caldf1, nallm1 
 *
 */
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorValue("Caregiver")
public class Caregiver extends Person implements Connectable{
    
	
/*==============================================
 *    Attributes
 *==============================================
 */ 
	
    private String password = null; 
    @OneToOne
    private AddressPrivate privateAddress = null;
    @OneToOne
    private AddressBusiness businessAddress = null;
    @OneToMany(mappedBy="Caregiver")
    private List<Client> myClients = new ArrayList<>();
    private List<Client> substituteClient = new ArrayList<>();
    private ExternalPerson substituteCaregiver = null;
    private boolean substituteState = false;
 
     
/*==============================================
 *    Constructor
 *==============================================
 */ 
    
    /**
     *  for persistence
     */
	public Caregiver() {

	}
    
    /**
     * Creates a new caregiver with 
     * 
     * @param lastname as a string
     * @param firstname as a string
     * @param gendertype as a gendertype
     * @param password as a string
     */
    public Caregiver(String lastname, String firstname, GenderType gendertype, String password) {
        super(lastname, firstname, PersonType.CAREGIVER, gendertype);
        this.password = password;
    }
    
    
/*==============================================
 *    GETTER
 *==============================================
 */
 
    /**
     * 
     * @return the password 
     */
    public String getPassword() {
        return password;
    }
    
    /**
     * 
     * @return the private address
     */
    public AddressPrivate getPrivateAddress(){
    	return privateAddress;
    }
    
    
    /**
     * 
     * @return the business address
     */
    public AddressBusiness getBusinessAddress(){
    	return businessAddress;
    }
    
    /**
     * 
     * @return the array list my clients
     */
    public ArrayList<Client> getMyClients(){
    	return (ArrayList<Client>) myClients;
    }
   
    /**
     * 
     * @return the array list substitute client
     */
    public ArrayList<Client> getSubstituteClients(){
    	return (ArrayList<Client>) substituteClient;
    }
    
    /**
     * 
     * @return the substitute caregiver
     */
    public ExternalPerson getSubstituteCaregiver(){
    	return substituteCaregiver;
    }
    
    /**
     * 
     * @return the substitute state
     */
    public boolean getSubstituteState(){
    	return substituteState;
    }
    
    /**
     * example output:<br><br>
     * PersonType: CAREGIVER<br>
     * PID: 10620<br>
     * Nachname: Lieberherr<br>
     * Vorname: Wilfried<br>
     * Geschlecht: M<br>
     * Titel: null<br>
     * Adminrechte: true<br>
     * Password: myPassword<br>
     * 
     * Anrede: Herr<br>
     * AddressType: PRIVATE<br>
     * Strasse: Pflegeweg 8<br>
     * PLZ: 4422<br>
     * Stadt: Gesundheim<br>
     * Land: CH<br>
     * Postfach: null<br>
     * Phone: null<br>
     * Mobile: null<br>
     * Fax: null<br>
     * Email: null<br>
     * 
     * Anrede: Herr<br>
     * AddressType: BUSINESS<br>
     * Strasse: Pflegestrasse 8b<br>
     * PLZ: 4422<br>
     * Stadt: Gesundheim<br>
     * Land: CH<br>
     * Postfach: null<br>
     * Phone: null<br>
     * Mobile: null<br>
     * Fax: null<br>
     * Email: null<br>
     * Department: WerkstadtKlientenliste: []<br>
     * 
     */
	@Override
	public String toString() {
		return super.toString() + "\nPassword: " + password + "\n" + privateAddress + "\n" + businessAddress
				+ "\nKlientenliste: " + myClients;
	}
    
    
	@Override
	public Connectable getConnectable() {
		return this;
	}
	
    
/*==============================================
 *    SETTER
 *==============================================
 */
 
    /**
     * Sets the password for a caregiver
     * 
     * @param password as a string
     */
    public void setPassword(String password) {
        this.password = password;
    }

    
    /**
     * Sets the private address from a caregiver
     * 
     * @param street as string
     * @param zip as string
     * @param city as string
     */
    public void setPrivateAddress(String street, String zip, String city){
    	this.privateAddress = new AddressPrivate(street, zip, city, this.getGender());
    }
    
    /**
     * Sets the business address from a caregiver
     * 
     * @param street as string
     * @param zip as string
     * @param city as string 
     * @param department as string
     */
    public void setBusinessAddress(String street, String zip, String city, String department){
    	this.businessAddress = new AddressBusiness(street, zip, city, department, this.getGender());
    }
    
    /**
     * Sets a new client 
     * 
     * @param newClient
     */
    public void addNewClient(Client newClient){
    	myClients.add(newClient);
    }
    
    /**
     * Sets a new substitute client
     * 
     * @param newClient
     */
    public void addNewSubstituteClient(Client newClient){
    	substituteClient.add(newClient);
    }
    
    /**
     * Sets a substitute person
     * 
     * @param substitutePerson
     */
    public void defineSubstituteCaregiver(ExternalPerson substitutePerson){
    	substituteCaregiver = substitutePerson;
    }
    
    /**
     * Sets a state for the substitute
     */
    public void changeSubstituteState(){
    	if (substituteState == false){
    		substituteState = true;
    	} else {
    		substituteState = false;
    	}
    }

    
/*==============================================
 *    Generated hashCode() and equals()
 *==============================================
 */	
    
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((businessAddress == null) ? 0 : businessAddress.hashCode());
		result = prime * result + ((myClients == null) ? 0 : myClients.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((privateAddress == null) ? 0 : privateAddress.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Caregiver other = (Caregiver) obj;
		if (businessAddress == null) {
			if (other.businessAddress != null)
				return false;
		} else if (!businessAddress.equals(other.businessAddress))
			return false;
		if (myClients == null) {
			if (other.myClients != null)
				return false;
		} else if (!myClients.equals(other.myClients))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (privateAddress == null) {
			if (other.privateAddress != null)
				return false;
		} else if (!privateAddress.equals(other.privateAddress))
			return false;
		return true;
	}
       
}

