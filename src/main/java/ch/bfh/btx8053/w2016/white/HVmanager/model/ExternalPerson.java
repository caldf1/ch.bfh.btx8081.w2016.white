package ch.bfh.btx8053.w2016.white.HVmanager.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Embedded;
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

	/*
	 * ============================================== 
	 * Attributes
	 * ==============================================
	 */

	private ExternalPersonType externalPersonType = null;
	private String description = null;
	@Embedded
	private AddressPrivate privateAddress = null;
	@Embedded
    private AddressBusiness businessAddress = null;
	

	/*
	 * ============================================== 
	 * Constructor
	 * ==============================================
	 */

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
    
    public ExternalPerson(){
    	
    }

	/*
	 * ============================================== 
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
	
	/*
	 * ============================================== 
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

}
