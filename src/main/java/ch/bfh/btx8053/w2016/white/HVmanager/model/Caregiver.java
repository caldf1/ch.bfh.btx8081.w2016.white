package ch.bfh.btx8053.w2016.white.HVmanager.model;

import interfaces.Connectable;

/**
 * @author umern11, caldf1
 *
 */
public class Caregiver extends Person implements Connectable{
    
	/*==============================================
	 *    Attributes
	 *==============================================
	 */ 
	
    private String password = null; 
    //private String title = null;
    private AddressPrivate privateAddress = null;
    private AddressBusiness businessAddress = null;
 
     
    /*==============================================
     *    Constructor
     *==============================================
     */ 
    
    public Caregiver(String lastname, String firstname, String password) {
        super(lastname, firstname, PersonType.CAREGIVER);
        this.password = password;
    }
    
    /*==============================================
     *    GETTER
     *==============================================
     */
 
    public String getPassword() {
        return password;
    }
    
    public AddressPrivate getPrivateAddress(){
    	return privateAddress;
    }
    
    public AddressBusiness getBusinessAddress(){
    	return businessAddress;
    }
   
    
    /*==============================================
     *    SETTER
     *==============================================
     */
 
    public void setPassword(String password) {
        this.password = password;
    }

    public void setPrivateAddress(String street, String zip, String city){
    	this.privateAddress = new AddressPrivate(street, zip, city, this.getGender());
    }
    
    public void setBusinessAddress(String street, String zip, String city, String anrede){
    	this.businessAddress = new AddressBusiness(street, zip, city, anrede);
    }

	@Override
	public Connectable getConnectable() {
		return this;
	}
    


    
}

