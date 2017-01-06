package ch.bfh.btx8053.w2016.white.HVmanager.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import ch.bfh.btx8053.w2016.white.HVmanager.util.ExternalPersonType;
import ch.bfh.btx8053.w2016.white.HVmanager.util.PersonType;

/**
 * @author nallm1, umern11, caldf1, nedot1
 *
 */
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorValue("ExternalPerson")
public class ExternalPerson extends Person {

	/*
	 * ============================================== 
	 * Attributes
	 * ==============================================
	 */

	private ExternalPersonType externalPersonType = null;
	private String description = null;
	private AddressPrivate privateAddress = null;
    private AddressBusiness businessAddress = null;
	

	/*
	 * ============================================== 
	 * Constructor
	 * ==============================================
	 */

	public ExternalPerson(String lastname, String firstname, ExternalPersonType externalPersonType) {

		super(lastname, firstname, PersonType.EXTERNAL);

		this.externalPersonType = externalPersonType;
	}

	/*
	 * ============================================== 
	 * GETTER
	 * ==============================================
	 */

	public ExternalPersonType getExternalPersonType() {
		return externalPersonType;
	}

	public String getDescription() {
		return description;
	}

	public AddressPrivate getPrivateAddress() {
		return privateAddress;
	}

	public AddressBusiness getBusinessAddress() {
		return businessAddress;
	}   

	/*
	 * ============================================== 
	 * SETTER
	 * ==============================================
	 */

	public void setExternalPersonType(ExternalPersonType externalPersonType) {
		this.externalPersonType = externalPersonType;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setPrivateAddress(String street, String zip, String city) {
		this.privateAddress = new AddressPrivate(street, zip, city, this.getGender());
	}

	public void setBusinessAddress(String street, String zip, String city, String anrede) {
		this.businessAddress = new AddressBusiness(street, zip, city, anrede);
	}

}
