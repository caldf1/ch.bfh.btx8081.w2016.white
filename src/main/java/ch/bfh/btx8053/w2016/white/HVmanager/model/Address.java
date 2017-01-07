package ch.bfh.btx8053.w2016.white.HVmanager.model;

import javax.persistence.Embeddable;

import ch.bfh.btx8053.w2016.white.HVmanager.util.AddressType;

/**
 * @author umern11, caldf1, nedot1
 *
 */
@Embeddable
public class Address {
	 
/*==============================================
 *    Attributes
 *==============================================
 */ 
    
	private AddressType addressType = null;
	private String street = null;
    private String zip = null;
    private String city = null;
    private String country = "CH";
    private String postofficebox = null;
    
    private String phonenumber = null;
    private String mobilenumber = null;
    private String faxnumber = null;
    private String email = null;
    
    // private Date creationDate = null;
    // private Date gueltigAb = null;
    // private Date gueltigBis = null;
    
   

    
    
/*==============================================
 *    Constructor
 *==============================================
 */   
     
    public Address(String street, String zip, String city, AddressType addressType) {
      
        this.street = street;
        this.zip = zip;
        this.city = city;
        this.addressType = addressType;
              
    }
 
    
/*==============================================
 *    GETTER
 *==============================================
 */
    
    public AddressType getAddressType(){
    	return addressType;
    }
    
    public String getStreet() {
        return street;
    }
 
    
    public String getZip() {
        return zip;
    }
     
 
    public String getCity() {
        return city;
    }
    
    public String getCountry(){
    	return country;
    }
 
    public String getPostOfficeBox(){
    	return postofficebox;
    }
    
    public String getPhonenumber(){
    	return phonenumber;
    }
    
    public String getMobilenumber(){
    	return mobilenumber;
    }
    
    public String getFaxnumber(){
    	return faxnumber;
    }
   
    public String getEmail(){
    	return email;
    }
    
 
	@Override
	public String toString() {
		return "\nAddressType: " + addressType + "\nStrasse: " + street + "\nPLZ: " + zip + "\nStadt: " + city + "\nLand: " + country + "\nPostfach: " + postofficebox + "\nPhone: " + phonenumber + "\nMobile: " + mobilenumber + "\nFax: " + faxnumber + "\nEmail: " + email;
	}
	
	public String getAddress(){
		return street + ", " + zip + " " + city;
	}
	
	

/*==============================================
 *    SETTER
 *==============================================
 */ 
        
    public void setStreet(String street) {
        this.street = street;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }
    
    public void setCity(String city) {
        this.city = city;
    }
    
   public void setCountry(String country){
	   this.country = country;
   }
    
   public void setPostOfficeBox(String postofficebox){
	   this.postofficebox = postofficebox;
   }
   
   public void setPhonenumber(String phonenumber){
   	this.phonenumber = phonenumber;
   }

   public void setMobilenumber(String mobilenumber){
   	this.mobilenumber = mobilenumber;
   }
   
   public void setFaxnumber(String faxnumber){
   	this.faxnumber = faxnumber;
   }
   
   public void setEmail(String email){
   	this.email = email;
   }
   
    public void setAddress(String street, String zip, String city){
    	this.street = street;
    	this.zip = zip;
    	this.city = city;
    }
    
}
