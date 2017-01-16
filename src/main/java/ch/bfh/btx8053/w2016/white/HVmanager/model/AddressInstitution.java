package ch.bfh.btx8053.w2016.white.HVmanager.model;

import javax.persistence.Embeddable;

import ch.bfh.btx8053.w2016.white.HVmanager.util.AddressType;

/**
 * 
 * 
 * @author umern11, nedot1, heldf1, caldf1
 *
 */
@Embeddable
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
     * @param street
     * @param zip
     * @param city
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
     * @return
     */
    public String getDepartment(){
    	return department;
    }
    
    /**
     * 
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
     * @param department
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
