package ch.bfh.btx8053.w2016.white.HVmanager.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Embedded;
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
    @Embedded
    private AddressPrivate privateAddress = null;
    @Embedded
    private AddressBusiness businessAddress = null;
 
     
    /*==============================================
     *    Constructor
     *==============================================
     */ 
    
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
     */
    @Override
    public String toString(){
    	return super.toString() + "\nPassword: " + password + "\n" + privateAddress  + "\n" + businessAddress;
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
 
    
}

