package ch.bfh.btx8053.w2016.white.HVmanager.model;

import java.util.ArrayList;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import ch.bfh.btx8053.w2016.white.HVmanager.interfaces.Connectable;
import ch.bfh.btx8053.w2016.white.HVmanager.util.GenderType;
import ch.bfh.btx8053.w2016.white.HVmanager.util.PersonType;



/**
 * 
 * 
 * @author umern11, nedot1, heldf1, caldf1
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
    private AddressPrivate privateAddress = null;
    private AddressBusiness businessAddress = null;
    private ArrayList<Client> myClients = new ArrayList<>();
 
     
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
     * 
     * @param lastname
     * @param firstname
     * @param gendertype
     * @param password
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
     * @return
     */
    public String getPassword() {
        return password;
    }
    
    /**
     * 
     * @return
     */
    public AddressPrivate getPrivateAddress(){
    	return privateAddress;
    }
    
    
    /**
     * 
     * @return
     */
    public AddressBusiness getBusinessAddress(){
    	return businessAddress;
    }
    
    /**
     * 
     * @return
     */
    public ArrayList<Client> getMyClients(){
    	return myClients;
    }
   
    /**
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
     * 
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    
    /**
     * 
     * @param street
     * @param zip
     * @param city
     */
    public void setPrivateAddress(String street, String zip, String city){
    	this.privateAddress = new AddressPrivate(street, zip, city, this.getGender());
    }
    
    /**
     * 
     * @param street
     * @param zip
     * @param city
     * @param department
     */
    public void setBusinessAddress(String street, String zip, String city, String department){
    	this.businessAddress = new AddressBusiness(street, zip, city, department, this.getGender());
    }
    
    /**
     * 
     * @param newClient
     */
    public void addNewClient(Client newClient){
    	myClients.add(newClient);
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

