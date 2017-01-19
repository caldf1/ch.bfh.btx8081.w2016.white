package ch.bfh.btx8053.w2016.white.HVmanager.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import ch.bfh.btx8053.w2016.white.HVmanager.util.AddressType;

/**This class extends from class address<br>
 * This class is for external person<br>
 * @author umern11, nedot1, heldf1, caldf1
 *
 */
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorValue("AddressBusiness")
public class AddressBusiness extends Address{
	 
/*==============================================
 *    Attributes
 *==============================================
 */ 
    
	private String salutation = null; // for "Anrede" like Mr, Ms
	private String department = null;
	
   
/*==============================================
 *    Constructor
 *==============================================
 */   
	
	/**
	 *  for persistence
	 */
    public AddressBusiness(){
    	super();
    	
    }
	
    /**
     *  
     * @param street from external person
     * @param zip from external person
     * @param city from external person
     * @param department from external person
     * @param gender from external person
     */
    public AddressBusiness(String street, String zip, String city, String department, String gender) {
        super(street, zip, city, AddressType.BUSINESS);
        this.department = department;
        
        if (gender.equals("M")) {
            this.salutation = "Herr";
        } else if (gender.equals("W")) {
            this.salutation = "Frau";
        } else {
            this.salutation = "";
        }
    }    


    
/*==============================================
 *    GETTER
 *==============================================
 */
    
    /**
     * 
     * @return the salutation
     */
    public String getSalutation(){
    	return salutation;
    }
    
    /**
     * 
     * @return the department
     */
    public String getDepartment(){
    	return department;
    }
    
    /**
     * example output:<br><br>
     * Anrede: Herr<br>
     * AddressType: BUSINESS<br>
     * Strasse: Businessweg 5<br>
     * PLZ: 6035<br>
     * Stadt: Leistungsstadt<br>
     * Land: CH<br>
     * Postfach: null<br>
     * Phone: null<br>
     * Mobile: null<br>
     * Fax: null<br>
     * Email: null<br>
     * Department: Teppichetage<br>
     */
    
    @Override
	public String toString() {
    	return "\nAnrede: " + salutation + super.toString()  + "\nDepartment: " + department;
	}

/*==============================================
 *    SETTER
 *==============================================
 */ 
    
    /**
     * 
     * @param salutation as a string
     */
    public void setSalutation(String salutation){
        this.salutation = salutation;
    }
    
    /**
     * 
     * @param department as a string
     */
    public void setDepartment(String department){
    	this.department = department;
    }

    
/*==============================================
 *    Generated hashCode() and equals()
 *==============================================
 */	
    
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((department == null) ? 0 : department.hashCode());
		result = prime * result + ((salutation == null) ? 0 : salutation.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		AddressBusiness other = (AddressBusiness) obj;
		if (department == null) {
			if (other.department != null)
				return false;
		} else if (!department.equals(other.department))
			return false;
		if (salutation == null) {
			if (other.salutation != null)
				return false;
		} else if (!salutation.equals(other.salutation))
			return false;
		return true;
	} 
    
}
