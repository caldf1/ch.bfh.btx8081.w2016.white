package ch.bfh.btx8053.w2016.white.HVmanager.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import ch.bfh.btx8053.w2016.white.HVmanager.interfaces.Connectable;
import ch.bfh.btx8053.w2016.white.HVmanager.util.InstitutionType;


/**
 * @author nallm1, umern11, caldf1, nedot1
 *
 */
@Entity
public class Institution implements Connectable {

	/*==============================================
	 *    Attributes
	 *==============================================
	 */ 
	
	private static long id = 1;
	
	@Id
	private String institutionId = null;
	private String institutionName = null;
	private InstitutionType institutionType = null;
	private AddressInstitution institutionAddress = null;
	
	
	
	
	/*==============================================
	 *    Constructor
	 *==============================================
	 */   
	
	public Institution(String institutionName, String institutionType) {
		setInstituteId();
		this.institutionName = institutionName;
		
		if (institutionType.equals("hospital")){
		this.institutionType = InstitutionType.HOSPITAL;
		} else if(institutionType.equals("insurance")){
			this.institutionType = InstitutionType.INSURANCE;
		} else if (institutionType.equals("social insurance")){
			this.institutionType = InstitutionType.SOCIAL_INSURANCE;
		} else {
			this.institutionType = null;
		}
		
	}

	
	/*==============================================
	 *    GETTER
	 *==============================================
	 */
	
	public String getInstitutionName() { 
		return institutionName;	
	}
	
	
	public InstitutionType getInstitutionType() {
		return institutionType;
	}
	
	public String getInstitutionId(){
		return institutionId;
	}
	
	public AddressInstitution getInstitutionAddress(){
		return institutionAddress;
	}
	
	public String toString(){
		return "\nInstituts-ID: " + institutionId + "\nInstituts-Typ: " + institutionType + "\nFirmenname: " + institutionName + "\n" + institutionAddress;
	}
	
	/*==============================================
	 *    SETTER
	 *==============================================
	 */
	
	private void setInstituteId() {
		this.instituteId = "I"+id;
		id++;
	}


	public void setInstitutionName(String institutionName) {
		this.institutionName = institutionName;
	}

	public void setInstitutionAddress(String street, String zip, String city, String department){
    	this.institutionAddress = new AddressInstitution(street, zip, city, department); 
    }

	public void setInstitutionType(InstitutionType institutionType){
		this.institutionType = institutionType;
	}
	
	@Override
	public Connectable getConnectable() {
		return this;
	}


	


	
	
	
	
}
