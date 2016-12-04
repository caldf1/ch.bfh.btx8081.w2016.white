package applicationLogic;

/**
 * Client = Patients
 *
 * @author group white
 *
 */
public class Client {

	// Client-ID-Generator as a static-variable
	private static int idForClient = 1;
	
	//Instanzvaribalen (Attribute)
	private int clientID = 0;
	private String lastname = null;
	private String fristname = null;
	private String birthdate = null;
	private char gender = null;
	
	/* Adresse
	 * Telefonnummer
	 * Mobilenummer
	 * gender
	 * ...
	 * 
	 */
	
	//Constructor
	public void Client(String lastname, String firstname, String birthdate){
		this.clientID = idForClient;
		idForClient++;
		this.lastname = lastname;
		this.fristname = firstname;		
		
	}
	
	
	// Methoden: getter und setter
	
}
