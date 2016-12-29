package ch.bfh.btx8053.w2016.white.HVmanager.model;

import java.util.ArrayList;

import ch.bfh.btx8053.w2016.white.HVmanager.util.PersonType;
import interfaces.Connectable;

/**
 * @author umern11, caldf1
 *
 */
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
