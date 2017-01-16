package ch.bfh.btx8053.w2016.white.HVmanager.model;

import java.util.ArrayList;

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
@DiscriminatorValue("Client")
public class Client extends Person implements Connectable {
    
	
	/*==============================================
	 *    Attributes
	 *==============================================
	 */ 
	
    private String birthdate = null;
    private ArrayList<Connectable> clientNetwork = new ArrayList<>();
    @Embedded
    private AddressPrivate privateAddress = null;
    private ArrayList<Case> caseList = new ArrayList<>();
   

     
    /*==============================================
     *    Constructor
     *==============================================
     */  
    
    /**
     * 
     */
	public Client() {

	}
    
    /**
     * 
     * @param lastname
     * @param firstname
     * @param gendertype
     * @param birthdate
     */
    public Client(String lastname, String firstname, GenderType gendertype, String birthdate) {
        super(lastname, firstname, PersonType.CLIENT, gendertype);
        this.birthdate = birthdate; 
    }
    
   
 
    /*==============================================
     *    GETTER
     *==============================================
     */
    
    /**
     * 
     * @return
     */
    public String getBirthdate() {
        return birthdate;
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
    public ArrayList<Connectable> getClientNetwork(){
    	return clientNetwork;
    }

    /**
     * 
     * @return
     */
    public ArrayList<Case> getCases(){
    	return caseList;
    }
    
    
	/**
	 * 
	 */
	public String toString() {
		return super.toString() + "\nGeburtsdatum: " + birthdate + "\n" + privateAddress + "\nClient-Netzwerk: \n"
				+ clientNetwork.toString() + "\nFälle: " + caseList;
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
     * @param birthdate
     */
    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }
 
    /**
     * 
     * @param connectable
     */
    public void addToNetwork(Connectable connectable){
    	clientNetwork.add(connectable);
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
     * @param newCase
     */
    public void addCaseToList(Case newCase){
    	caseList.add(newCase);
    }
 
	
}
