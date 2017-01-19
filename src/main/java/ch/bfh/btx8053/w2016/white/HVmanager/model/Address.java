package ch.bfh.btx8053.w2016.white.HVmanager.model;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import ch.bfh.btx8053.w2016.white.HVmanager.util.AddressType;

/**
 * 
 * This class create a address with contact information<br>
 * @author umern11, nedot1, heldf1, caldf1
 *
 */
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="AddressType", discriminatorType=DiscriminatorType.STRING)
public class Address {
	 
/*==============================================
 *    Attributes
 *==============================================
 */ 
    
	@Id
	@GeneratedValue
	private int addressId = 0; // for database
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
     * short version<br>  
     * @param street from person or external person
     * @param zip from person or external person
     * @param city from person or external person
     * @param addressType from business, institution, private
     */
    public Address(String street, String zip, String city, AddressType addressType) {
      
        this.street = street;
        this.zip = zip;
        this.city = city;
        this.addressType = addressType;              
    }
    
    
    /**
     * long version<br> 
     * @param street from person or external person
     * @param zip from person or external person
     * @param city from person or external person
     * @param addressType from business, institution, private
     * @param postofficebox from person or external person
     * @param phonenumber from person or external person
     * @param mobilenumber from person or external person
     * @param faxnumber from person or external person
     * @param email from person or external person
     */
    public Address(String street, String zip, String city, AddressType addressType, String postofficebox, String phonenumber, String mobilenumber, String faxnumber, String email) {
        
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
     * @return the address ID
     */
    public int getAddressId(){
    	return addressId;
    }
    
    /**
     * 
     * @return the address type
     */
    public AddressType getAddressType(){
    	return addressType;
    }
    
    
    /**
     * 
     * @return the street
     */
    public String getStreet() {
        return street;
    }
 
    
    /**
     * 
     * @return the zip
     */
    public String getZip() {
        return zip;
    }
     
    /**
     * 
     * @return the city
     */
    public String getCity() {
        return city;
    }
    
    /**
     * 
     * @return the country
     */
    public String getCountry(){
    	return country;
    }
 
    /**
     * 
     * @return the post office box
     */
    public String getPostOfficeBox(){
    	return postofficebox;
    }
    
    /**
     * 
     * @return the phonenumber
     */
    public String getPhonenumber(){
    	return phonenumber;
    }
    
    /**
     * 
     * @return the mobilenumber
     */
    public String getMobilenumber(){
    	return mobilenumber;
    }
    
    /**
     * 
     * @return the faxnumber
     */
    public String getFaxnumber(){
    	return faxnumber;
    }
   
    /**
     * 
     * @return the email
     */
    public String getEmail(){
    	return email;
    }
    
    
    /**
     * example output:<br><br>
     * AddressType: BUSINESS<br>
     * Strasse: Geschäftsweg 2b<br>
     * PLZ: 1234<br>
     * Stadt: Workcity<br>
     * Land: NORWAY<br>
     * Postfach: Postfach 10<br>
     * Phone: 044 432 11 11<br>
     * Mobile: 078 987 65 43<br>
     * Fax: 044 432 11 12<br>
     * Email: test@bfh.ch<br>
     */


      
	@Override
	public String toString() {
		return "\nAddressType: " + addressType + "\nStrasse: " + street + "\nPLZ: " + zip + "\nStadt: " + city + "\nLand: " + country + "\nPostfach: " + postofficebox + "\nPhone: " + phonenumber + "\nMobile: " + mobilenumber + "\nFax: " + faxnumber + "\nEmail: " + email;
	}
	
	/**
	 * 
	 * @return the address
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
	 * @param street as a string
	 */
    public void setStreet(String street) {
        this.street = street;
    }

    
    /**
     * 
     * @param zip as a string
     */
    public void setZip(String zip) {
        this.zip = zip;
    }
    
    
    /**
     * 
     * @param city as a string
     */
    public void setCity(String city) {
        this.city = city;
    }
    
    
    /**
     * 
     * @param country as a string
     */
	public void setCountry(String country) {
		this.country = country;
	}

	
	/**
	 * 
	 * @param postofficebox as a string
	 */
	public void setPostOfficeBox(String postofficebox) {
		this.postofficebox = postofficebox;
	}

	
	/**
	 * 
	 * @param phonenumber as a string
	 */
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	
	/**
	 * 
	 * @param mobilenumber as a string
	 */
	public void setMobilenumber(String mobilenumber) {
		this.mobilenumber = mobilenumber;
	}

	
	/**
	 * 
	 * @param faxnumber as a string
	 */
	public void setFaxnumber(String faxnumber) {
		this.faxnumber = faxnumber;
	}

	/**
	 * 
	 * @param email as a string
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	
	/**
	 * 
	 * @param street as a string
	 * @param zip as a string
	 * @param city as a string
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
		result = prime * result + addressId;
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
		if (addressId != other.addressId)
			return false;
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
