package ch.bfh.btx8053.w2016.white.HVmanager.model;

/**
 * @author nallm1
 *
 */
public class ExternalInstitution {

	private String name;
	private ExternalInstitutionType externalInstitutionType;
	private int institutionId;
	
	
	public ExternalInstitution(String name, ExternalInstitutionType externalInstitutionType) {
		this.name = name;
		this.externalInstitutionType = externalInstitutionType;
		this.institutionId = 1;
	}

	public void addAdress (String street, int zip, String city, AdressType adressType) {
		Adress adress = new Adress(this.institutionId, street, zip, city, adressType, "e");
	}

	public void addCommunication (String value, CommunicationType communicationType) {
		Communication communication = new Communication(this.institutionId, value, communicationType, "e");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ExternalInstitutionType getExternalInstitutionType() {
		return externalInstitutionType;
	}

	public void ExternalInstitutionType(ExternalInstitutionType externalInstitutionType) {
		this.externalInstitutionType = externalInstitutionType;
	}

	public int getInstitutionId() {
		return institutionId;
	}

	public void setInstitutionId(int institutionId) {
		this.institutionId = institutionId;
	}
	
	
	
}
