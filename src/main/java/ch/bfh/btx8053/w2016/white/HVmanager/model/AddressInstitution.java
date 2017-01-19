package ch.bfh.btx8053.w2016.white.HVmanager.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import ch.bfh.btx8053.w2016.white.HVmanager.util.AddressType;

/**
 * This class extends from class address<br>
 * This class is for institution<br>
 * 
 * @author umern11, nedot1, heldf1, caldf1
 *
 */
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorValue("AddressInstitution")
public class AddressInstitution extends Address{
	 
/*==============================================
 *    Attributes
 *==============================================
 */ 
    
	private String department = null;

    
/*==============================================
 *    Constructor
 *==============================================
 */   
	
	/**
	 *  for persistence
	 */
    public AddressInstitution(){
    	
    }
	
    /**
     *  
     * @param street from institution
     * @param zip from institution
     * @param city from institution
     */
    public AddressInstitution(String street, String zip, String city, String department) {
        super(street, zip, city, AddressType.INSTITUTION);	
        this.department = department; 
         
  	}
      
    
/*==============================================
 *    GETTER
 *==============================================
 */
    
    
    /**
     * 
     * @return the department
     */
    public String getDepartment(){
    	return department;
    }
    
    /**
     * example output:<br><br>
     * Instituts-ID: 0<br>
     * Instituts-Typ: HOSPITAL<br>
     * Firmenname: Klinik Höheweg<br>
     * AddressType: INSTITUTION<br>
     * Strasse: Höheweg 80<br>
     * PLZ: 2502<br>
     * Stadt: Biel/Bienne<br>
     * Land: CH<br>
     * Postfach: null<br>
     * Phone: null<br>
     * Mobile: null<br>
     * Fax: null<br>
     * Email: null<br>
     * Department: Annahme
     */
    @Override
	public String toString() {
		return super.toString() + "\nDepartment: " + department;
	}

    
/*==============================================
 *    SETTER
 *==============================================
 */ 
    
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
		AddressInstitution other = (AddressInstitution) obj;
		if (department == null) {
			if (other.department != null)
				return false;
		} else if (!department.equals(other.department))
			return false;
		return true;
	}
   
}
