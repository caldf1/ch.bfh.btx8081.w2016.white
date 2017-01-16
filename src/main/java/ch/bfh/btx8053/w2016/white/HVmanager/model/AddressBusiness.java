package ch.bfh.btx8053.w2016.white.HVmanager.model;

import javax.persistence.Embeddable;

import ch.bfh.btx8053.w2016.white.HVmanager.util.AddressType;

/**
 * @author umern11, nedot1, heldf1, caldf1
 *
 */
@Embeddable
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
     * @param street
     * @param zip
     * @param city
     * @param department
     * @param gender
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
     * @return
     */
    public String getSalutation(){
    	return salutation;
    }
    
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
    	return "\nAnrede: " + salutation + super.toString()  + "\nDepartment: " + department;
	}

/*==============================================
 *    SETTER
 *==============================================
 */ 
    
    /**
     * 
     * @param salutation
     */
    public void setSalutation(String salutation){
        this.salutation = salutation;
    }
    
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
