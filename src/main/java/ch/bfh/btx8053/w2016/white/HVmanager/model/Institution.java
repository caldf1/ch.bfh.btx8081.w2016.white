package ch.bfh.btx8053.w2016.white.HVmanager.model;

/**
 * @author nallm1, umern11, caldf1
 *
 */
public class Institution {

	/*==============================================
	 *    Attributes
	 *==============================================
	 */ 
	
	private long id = 1;
	
	private String instituteId = null;
	private String institutionName = null;
	private InstitutionType institutionType = null;
	private AddressInstitution institutionAddress = null;
	
	
	
	
	/*==============================================
	 *    Constructor
	 *==============================================
	 */   
	
	public Institution(String institutionName, InstitutionType institutionType) {
		this.institutionName = institutionName;
		this.institutionType = institutionType;
		setInstituteId();
	}

	
	/*==============================================
	 *    GETTER
	 *==============================================
	 */
	
	public String getName() {
		System.out.println(institutionName);
		return institutionName;	
	}
	
	
	public InstitutionType getInstitutionType() {
		return institutionType;
	}
	
	public String getInstituteId(){
		return instituteId;
	}
	
	public AddressInstitution getInstitutionAddress(){
		return institutionAddress;
	}
	
	
	/*==============================================
	 *    SETTER
	 *==============================================
	 */
	
	private void setInstituteId() {
		this.instituteId = "I"+id;
		id = id++;
	}


	public void setName(String name) {
		this.institutionName = name;
	}

	public void setInstitutionAddress(String street, String zip, String city){
    	this.institutionAddress = new AddressInstitution(street, zip, city);
    }


	
	
	
	
}
