package ch.bfh.btx8053.w2016.white.HVmanager.model;

/**
 * @author umern11, caldf1
 *
 */
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
     *  
     * @param street
     * @param zip
     * @param city
     */
    public AddressInstitution(String street, String zip, String city) {
      super(street, zip, city, AddressType.INSTITUTION);	
       
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
    
 
    
}
