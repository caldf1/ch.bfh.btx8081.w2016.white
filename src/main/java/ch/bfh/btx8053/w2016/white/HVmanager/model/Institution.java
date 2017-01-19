package ch.bfh.btx8053.w2016.white.HVmanager.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import ch.bfh.btx8053.w2016.white.HVmanager.interfaces.Connectable;
import ch.bfh.btx8053.w2016.white.HVmanager.util.InstitutionType;


/**
 * This class create a institution with an id, a name, an institution-type and can have an institution-address.
 * @author nallm1, umern11, nedot1, heldf1, caldf1
 *   
 */
@Entity
public class Institution implements Connectable {

	
/*==============================================
 *    Attributes
 *==============================================
 */ 
	
	// private static long id = 1;
	
	@Id
	@GeneratedValue
	private int institutionId = 0;
	private String institutionName = null;
	private InstitutionType institutionType = null;
	@OneToOne
	private AddressInstitution institutionAddress = null;
	
	
	
	
/*==============================================
 *    Constructor
 *==============================================
 */ 
	
	/**
	 *  for persistence
	 */
	public Institution(){
		
	}
	
	
	/**
	 * 
	 * Checks and sets institutiontypes
	 * 
	 * @param institutionName as a String
	 * @param institutionType as a instutionType
	 */
	public Institution(String institutionName, String institutionType) {
		// setInstituteId();
		this.institutionName = institutionName;
		
		if (institutionType.equals("hospital")){
		this.institutionType = InstitutionType.HOSPITAL;
		} else if(institutionType.equals("insurance")){
			this.institutionType = InstitutionType.INSURANCE;
		} else if (institutionType.equals("social insurance")){
			this.institutionType = InstitutionType.SOCIAL_INSURANCE;
		} else if (institutionType.equals("kesb")){
			this.institutionType = InstitutionType.KESB;
		}else {
			this.institutionType = null;
		}		
	}
	
	
/*==============================================
 *    GETTER
 *==============================================
 */
	
	/**
	 * 
	 * Gets the institution Name
	 * 
	 * @return institutionName as a String
	 */
	public String getInstitutionName() { 
		return institutionName;	
	}
	
	/**
	 * 
	 * Gets the Institution Type
	 * 
	 * @return Institution Type as institutionType
	 */
	public InstitutionType getInstitutionType() {
		return institutionType;
	}
	
	/**
	 * 
	 * Gets the Institution Id
	 * 
	 * @return institution as a int
	 */
	public int getInstitutionId(){
		return institutionId;
	}
	
	/**
	 * Gets the Institution Address
	 * 
	 * @return institutionAdress as AdressInstitution 
	 */
	public AddressInstitution getInstitutionAddress(){
		return institutionAddress;
	}
	
	
	/**
	 * Gets a String of all Institution Elements
	 * 
	 * @param institutionId as int
	 * @param institutionType as a InstitutionType
	 * @param institutionName as a String
	 * @param institutionAddress as a AddressInstitution
	 * 
	 */
	@Override
	public String toString(){
		return "\nInstituts-ID: " + institutionId + "\nInstituts-Typ: " + institutionType + "\nFirmenname: " + institutionName + "\n" + institutionAddress;
	}
	
	

	@Override
	public Connectable getConnectable() {
		return this;
	}
	
/*==============================================
 *    SETTER
 *==============================================
 */
	
	/*
	 * first institutionId will be "I1"
	 */
//	private void setInstituteId() {
//		this.institutionId = "I"+id;
//		id++;
//	}

	
	/**
	 * 
	 * Sets the InstitutionName 
	 * 
	 * @param institutionName as a String
	 */
	public void setInstitutionName(String institutionName) {
		this.institutionName = institutionName;
	}

	/**
	 * Sets Institution Address as AddressInstitution
	 * 
	 * @param street as a String
	 * @param zip as a String
	 * @param city as String
	 * @param department as a String
	 */
	public void setInstitutionAddress(String street, String zip, String city, String department){
    	this.institutionAddress = new AddressInstitution(street, zip, city, department); 
    }

	/**
	 * 
	 * Sets the Istitution type
	 *  
	 * @param institutionType as a institutionType
	 */
	public void setInstitutionType(InstitutionType institutionType){
		this.institutionType = institutionType;
	}

	
/*==============================================
 *    Generated hashCode() and equals()
 *==============================================
 */	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((institutionAddress == null) ? 0 : institutionAddress.hashCode());
		result = prime * result + institutionId;
		result = prime * result + ((institutionName == null) ? 0 : institutionName.hashCode());
		result = prime * result + ((institutionType == null) ? 0 : institutionType.hashCode());
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
		Institution other = (Institution) obj;
		if (institutionAddress == null) {
			if (other.institutionAddress != null)
				return false;
		} else if (!institutionAddress.equals(other.institutionAddress))
			return false;
		if (institutionId != other.institutionId)
			return false;
		if (institutionName == null) {
			if (other.institutionName != null)
				return false;
		} else if (!institutionName.equals(other.institutionName))
			return false;
		if (institutionType != other.institutionType)
			return false;
		return true;
	}
	
}
