package ch.bfh.btx8053.w2016.white.HVmanager.model;

import java.util.ArrayList;

/**
 * @author umern11, caldf1
 *
 */
public class Client extends Person {
    
	
	/*==============================================
	 *    Attributes
	 *==============================================
	 */ 
	
    private String birthdate = null;
    private ArrayList<Object> clientNetwork = new ArrayList<>();
    private AddressPrivate privateAddress = null;
    //private Address2Business businessAddress = null;
   

     
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
    
//    public Address2Business getBusinessAddress(){
//    	return businessAddress;
//    }
    
    /*==============================================
     *    SETTER
     *==============================================
     */
    
    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }
 
    public void addPersonToNetwork(Person person){
    	clientNetwork.add(person);
    }
    
    public void addInstituteToNetwork(Institution institution){
    	clientNetwork.add(institution);
    }
    
    public void setPrivateAddress(String street, String zip, String city){
    	this.privateAddress = new AddressPrivate(street, zip, city, this.getGender());
    }
    
//    public void setBusinessAddress(String street, String zip, String city, String anrede){
//    	this.businessAddress = new Address2Business(street, zip, city, anrede);
//    }
	 
 
}
