package ch.bfh.btx8053.w2016.white.HVmanager.model;

/**
 * @author nallm1
 *
 */
public class ExternalPerson extends Person {
	
	private ExternalPersonType externalPersonType;
	
	public ExternalPerson(String lastname, String firstname, ExternalPersonType externalPersonType) {
		super(lastname, firstname, PersonType.EXTERN);
		this.externalPersonType = externalPersonType;
	}

	public ExternalPersonType getExternalPersonType() {
		return externalPersonType;
	}

	public void setExternalPersonType(ExternalPersonType externalPersonType) {
		this.externalPersonType = externalPersonType;
	}

}
