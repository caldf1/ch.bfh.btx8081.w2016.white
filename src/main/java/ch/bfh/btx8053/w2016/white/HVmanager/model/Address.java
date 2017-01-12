package ch.bfh.btx8053.w2016.white.HVmanager.model;

import javax.persistence.Embeddable;

import ch.bfh.btx8053.w2016.white.HVmanager.util.AddressType;

/**
 * 
 * 
 * @author umern11, nedot1, heldf1, caldf1
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
    

    
    /**
     *  
     * @param street
     * @param zip
     * @param city
     * @param addressType
     */
    public Address(String street, String zip, String city, AddressType addressType) {
      
        this.street = street;
        this.zip = zip;
        this.city = city;
        this.addressType = addressType;
              
    }
 
    public Address() {
		super();
	}



/*==============================================
 *    GETTER
 *==============================================
 */
    
    /**
     * 
     * @return 
     */
    public AddressType getAddressType(){
    	return addressType;
    }
    
    
    /**
     * 
     * @return 
     */
    public String getStreet() {
        return street;
    }
 
    
    /**
     * 
     * @return
     */
    public String getZip() {
        return zip;
    }
     
    /**
     * 
     * @return
     */
    public String getCity() {
        return city;
    }
    
    /**
     * 
     * @return
     */
    public String getCountry(){
    	return country;
    }
 
    /**
     * 
     * @return
     */
    public String getPostOfficeBox(){
    	return postofficebox;
    }
    
    /**
     * 
     * @return
     */
    public String getPhonenumber(){
    	return phonenumber;
    }
    
    /**
     * 
     * @return
     */
    public String getMobilenumber(){
    	return mobilenumber;
    }
    
    /**
     * 
     * @return
     */
    public String getFaxnumber(){
    	return faxnumber;
    }
   
    /**
     * 
     * @return
     */
    public String getEmail(){
    	return email;
    }
    
 
	@Override
	public String toString() {
		return "\nAddressType: " + addressType + "\nStrasse: " + street + "\nPLZ: " + zip + "\nStadt: " + city + "\nLand: " + country + "\nPostfach: " + postofficebox + "\nPhone: " + phonenumber + "\nMobile: " + mobilenumber + "\nFax: " + faxnumber + "\nEmail: " + email;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getAddress(){
		return street + ", " + zip + " " + city;
	}
	
	

/*==============================================
 *    SETTER
 *==============================================
 */ 
    
	/**
	 * 
	 * @param street
	 */
    public void setStreet(String street) {
        this.street = street;
    }

    
    /**
     * 
     * @param zip
     */
    public void setZip(String zip) {
        this.zip = zip;
    }
    
    
    /**
     * 
     * @param city
     */
    public void setCity(String city) {
        this.city = city;
    }
    
    
    /**
     * 
     * @param country
     */
	public void setCountry(String country) {
		this.country = country;
	}

	
	/**
	 * 
	 * @param postofficebox
	 */
	public void setPostOfficeBox(String postofficebox) {
		this.postofficebox = postofficebox;
	}

	
	/**
	 * 
	 * @param phonenumber
	 */
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	
	/**
	 * 
	 * @param mobilenumber
	 */
	public void setMobilenumber(String mobilenumber) {
		this.mobilenumber = mobilenumber;
	}

	
	/**
	 * 
	 * @param faxnumber
	 */
	public void setFaxnumber(String faxnumber) {
		this.faxnumber = faxnumber;
	}

	/**
	 * 
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	
	/**
	 * 
	 * @param street
	 * @param zip
	 * @param city
	 */
	public void setAddress(String street, String zip, String city) {
		this.street = street;
		this.zip = zip;
		this.city = city;
	}

}
