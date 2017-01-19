package ch.bfh.btx8053.w2016.white.HVmanager.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import ch.bfh.btx8053.w2016.white.HVmanager.interfaces.Connectable;
import ch.bfh.btx8053.w2016.white.HVmanager.util.GenderType;
import ch.bfh.btx8053.w2016.white.HVmanager.util.PersonType;



/**
 * 
 * This class creates a person from a person type client
 * @author umern11, nedot1, heldf1, caldf1, nallm1
 *
 */
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorValue("Client")
public class Client extends Person implements Connectable {
    
	
	/*==============================================
	 *    Attributes
	 *==============================================
	 */ 
	
    private String birthdate = null;
    private List<Connectable> clientNetwork = new ArrayList<>();
    @OneToOne
    private AddressPrivate privateAddress = null;
    @OneToMany(mappedBy="Client")
    private List<Case> caseList = new ArrayList<>();
   

     
    /*==============================================
     *    Constructor
     *==============================================
     */  
    
    /**
     *  for persistence
     */
	public Client() {

	}
    
    /**
     * Creates a new client with
     *  
     * @param lastname as a string
     * @param firstname as a string
     * @param gendertype as a gendertype
     * @param birthdate as a string
     */
    public Client(String lastname, String firstname, GenderType gendertype, String birthdate) {
        super(lastname, firstname, PersonType.CLIENT, gendertype);
        this.birthdate = birthdate; 
    }
    
    /**
     * Constructor for the view
     * 
     * @param lastname as a string
     * @param firstname as a string
     * @param gendertype as a gendertype
     * @param birthdate as a string
     */
    public Client(String lastname, String firstname, char gender, String birthdate) {
    	super(lastname, firstname, PersonType.CLIENT, gender);

        this.birthdate = birthdate; 
    }

   
 
    /*==============================================
     *    GETTER
     *==============================================
     */
    
    /**
     * 
     * @return the birthdate
     */
    public String getBirthdate() {
        return birthdate;
    }
 
    /**
     * 
     * @return the private address
     */
    public AddressPrivate getPrivateAddress(){
    	return privateAddress;
    }
    
    /**
     * 
     * @return the client network
     */
    public ArrayList<Connectable> getClientNetwork(){
    	return (ArrayList<Connectable>) clientNetwork;
    }

    /**
     * 
     * @return case list
     */
    public ArrayList<Case> getCases(){
    	return (ArrayList<Case>) caseList;
    }
    
    
	/**
	 *  example Output:<br><br>
	 *  PersonType: CLIENT<br>
	 *	PID: 10621<br>
	 *	Nachname: Brönnimann<br>
	 *	Vorname: Elisabeth<br>
	 *	Geschlecht: W<br>
	 *	Titel: null<br>
	 *	Adminrechte: false<br>
	 *	Geburtsdatum: 03.05.1937<br>
	 */
	public String toString() {
		return super.toString() + "\nGeburtsdatum: " + birthdate + "\n" + privateAddress + "\nClient-Netzwerk: \n"
				+ clientNetwork.toString() + "\nFälle: " + caseList;
	}
    

	@Override
	public Connectable getConnectable() {
		return this;
	}

	
    /*==============================================
     *    SETTER
     *==============================================
     */
    
    /**
     * Sets a birthdate
     * 
     * @param birthdate as a string
     */
    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }
 
    /**
     * Sets a new network to client network
     * @param connectable
     */
    public void addToNetwork(Connectable connectable){
    	clientNetwork.add(connectable);
    }
    
    /**
     * Sets a private address
     * 
     * @param street as a string
     * @param zip as a string
     * @param city as a string
     */
    public void setPrivateAddress(String street, String zip, String city){
    	this.privateAddress = new AddressPrivate(street, zip, city, this.getGender());
    }

    /**
     * Sets a new case to the case list
     * @param newCase
     */
    public void addCaseToList(Case newCase){
    	caseList.add(newCase);
    }
 
	
}
