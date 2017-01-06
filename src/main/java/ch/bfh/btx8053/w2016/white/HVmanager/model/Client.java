package ch.bfh.btx8053.w2016.white.HVmanager.model;

import java.util.ArrayList;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import ch.bfh.btx8053.w2016.white.HVmanager.interfaces.Connectable;
import ch.bfh.btx8053.w2016.white.HVmanager.util.PersonType;


/**
 * @author umern11, caldf1, nedot1
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
    private AddressPrivate privateAddress = null;
 
   

     
    /*==============================================
     *    Constructor
     *==============================================
     */  
    
    public Client(String lastname, String firstname, String birthdate) {
        super(lastname, firstname, PersonType.CLIENT);
        this.birthdate = birthdate; 
    }
 
    /*==============================================
     *    GETTER
     *==============================================
     */
    
    public String getBirthdate() {
        return birthdate;
    }
 
    public AddressPrivate getPrivateAddress(){
    	return privateAddress;
    }
    
    public ArrayList<Connectable> getClientNetwork(){
    	return clientNetwork;
    }

    
    /*==============================================
     *    SETTER
     *==============================================
     */
    
    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }
 
    public void addToNetwork(Connectable connectable){
    	clientNetwork.add(connectable);
    }
    
//    public void addInstituteToNetwork(Institution institution){
//    	clientNetwork.add(institution);
//    }
    
    public void setPrivateAddress(String street, String zip, String city){
    	this.privateAddress = new AddressPrivate(street, zip, city, this.getGender());
    }

	@Override
	public Connectable getConnectable() {
		return this;
	}


    

	 
 
}
