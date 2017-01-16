package ch.bfh.btx8053.w2016.white.HVmanager.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import ch.bfh.btx8053.w2016.white.HVmanager.interfaces.Connectable;
import ch.bfh.btx8053.w2016.white.HVmanager.util.ExternalPersonType;
import ch.bfh.btx8053.w2016.white.HVmanager.util.GenderType;
import ch.bfh.btx8053.w2016.white.HVmanager.util.PersonType;

/**
 * 
 * 
 * @author nallm1, umern11, nedot1, heldf1, caldf1
 *
 */
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorValue("ExternalPerson")
public class ExternalPerson extends Person implements Connectable {

	
/* ============================================== 
 * Attributes
 * ==============================================
 */

	private ExternalPersonType externalPersonType = null;
	private String description = null;
	private AddressPrivate privateAddress = null;
    private AddressBusiness businessAddress = null;
	

/* ============================================== 
 * Constructor
 * ==============================================
 */

	/**
	 *  for persistence
	 */
    public ExternalPerson(){
    	
    }
	
	
    /**
     * 
     * @param lastname
     * @param firstname
     * @param gendertype
     * @param externalPersonType
     */
    public ExternalPerson(String lastname, String firstname, GenderType gendertype, ExternalPersonType externalPersonType) {
		super(lastname, firstname, PersonType.EXTERNAL, gendertype);
		this.externalPersonType = externalPersonType;
	}
    

/* ============================================== 
 * GETTER
 * ==============================================
 */

    /**
     * 
     * @return
     */
	public ExternalPersonType getExternalPersonType() {
		return externalPersonType;
	}

	/**
	 * 
	 * @return
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * 
	 * @return
	 */
	public AddressPrivate getPrivateAddress() {
		return privateAddress;
	}

	/**
	 * 
	 * @return
	 */
	public AddressBusiness getBusinessAddress() {
		return businessAddress;
	}   

	/**
	 * 
	 */
	public String toString(){
		return super.toString() + "\nExternalPersonType: " + externalPersonType + "\nBemerkungen: " + description + "\n" + privateAddress + "\n" + businessAddress;
	}
	
	
	@Override 
	public Connectable getConnectable() {
		return this;
	}
	
/* ============================================== 
 * SETTER
 * ==============================================
 */

	/**
	 * 
	 * @param externalPersonType
	 */
	public void setExternalPersonType(ExternalPersonType externalPersonType) {
		this.externalPersonType = externalPersonType;
	}

	
	/**
	 * 
	 * @param description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * 
	 * @param street
	 * @param zip
	 * @param city
	 */
	public void setPrivateAddress(String street, String zip, String city) {
		this.privateAddress = new AddressPrivate(street, zip, city, this.getGender());
	}

	
	/**
	 * 
	 * @param street
	 * @param zip
	 * @param city
	 * @param department
	 */
	public void setBusinessAddress(String street, String zip, String city, String department) {
		this.businessAddress = new AddressBusiness(street, zip, city, department, this.getGender());
	}

/*==============================================
 *    Generated hashCode() and equals()
 *==============================================
 */	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((businessAddress == null) ? 0 : businessAddress.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((externalPersonType == null) ? 0 : externalPersonType.hashCode());
		result = prime * result + ((privateAddress == null) ? 0 : privateAddress.hashCode());
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
		ExternalPerson other = (ExternalPerson) obj;
		if (businessAddress == null) {
			if (other.businessAddress != null)
				return false;
		} else if (!businessAddress.equals(other.businessAddress))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (externalPersonType != other.externalPersonType)
			return false;
		if (privateAddress == null) {
			if (other.privateAddress != null)
				return false;
		} else if (!privateAddress.equals(other.privateAddress))
			return false;
		return true;
	}

}
