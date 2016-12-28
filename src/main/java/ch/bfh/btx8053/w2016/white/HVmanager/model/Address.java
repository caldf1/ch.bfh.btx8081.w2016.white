package ch.bfh.btx8053.w2016.white.HVmanager.model;

/**
 * @author umern11, caldf1
 *
 */
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
    
    public String getStreet() {
        return street;
    }
 
    
    public String getPLZ() {
        return zip;
    }
     
 
    public String getCity() {
        return city;
    }
 
    public String getPostOfficeBox(){
    	return postofficebox;
    }
    
    public AddressType getAddressType(){
    	return addressType;
    }
   
 
	@Override
	public String toString() {
		return "Address: " + street + ", " + zip + " " + city + ", " + country + "/nPhone: " + phonenumber + "/nMobile: " + mobilenumber + "/nFax: " + faxnumber + "/nEmail: " + email;
	}
	
	

/*==============================================
 *    SETTER
 *==============================================
 */ 
    
    public void addPhonenumber(String phonenumber){
    	this.phonenumber = phonenumber;
    }

    public void addMobilenumber(String mobilenumber){
    	this.mobilenumber = mobilenumber;
    }
    
    public void addFaxnumber(String faxnumber){
    	this.faxnumber = faxnumber;
    }
    
    public void addEmail(String email){
    	this.email = email;
    }
    
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
    
   public void setPostfach(String postofficebox){
	   this.postofficebox = postofficebox;
   }
   
   
    public void setAddress(String street, String zip, String city){
    	this.street = street;
    	this.zip = zip;
    	this.city = city;
    }
    
}
