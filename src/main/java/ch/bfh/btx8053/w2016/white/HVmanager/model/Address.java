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
     *  for persistence
     */
	public Address() {
		super();
	}
    
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

	
/*==============================================
 *    Generated hashCode() and equals()
 *==============================================
 */	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((addressType == null) ? 0 : addressType.hashCode());
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((faxnumber == null) ? 0 : faxnumber.hashCode());
		result = prime * result + ((mobilenumber == null) ? 0 : mobilenumber.hashCode());
		result = prime * result + ((phonenumber == null) ? 0 : phonenumber.hashCode());
		result = prime * result + ((postofficebox == null) ? 0 : postofficebox.hashCode());
		result = prime * result + ((street == null) ? 0 : street.hashCode());
		result = prime * result + ((zip == null) ? 0 : zip.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Address other = (Address) obj;
		if (addressType != other.addressType)
			return false;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (faxnumber == null) {
			if (other.faxnumber != null)
				return false;
		} else if (!faxnumber.equals(other.faxnumber))
			return false;
		if (mobilenumber == null) {
			if (other.mobilenumber != null)
				return false;
		} else if (!mobilenumber.equals(other.mobilenumber))
			return false;
		if (phonenumber == null) {
			if (other.phonenumber != null)
				return false;
		} else if (!phonenumber.equals(other.phonenumber))
			return false;
		if (postofficebox == null) {
			if (other.postofficebox != null)
				return false;
		} else if (!postofficebox.equals(other.postofficebox))
			return false;
		if (street == null) {
			if (other.street != null)
				return false;
		} else if (!street.equals(other.street))
			return false;
		if (zip == null) {
			if (other.zip != null)
				return false;
		} else if (!zip.equals(other.zip))
			return false;
		return true;
	}
	

}
