package ch.bfh.btx8053.w2016.white.HVmanager.model;

/**
 * @author umern11, caldf1
 *
 */
public class AddressBusiness extends Address{
	 
/*==============================================
 *    Attributes
 *==============================================
 */ 
    
	private String title = null;
	private String postofficebox = null;
	private String department = null;
	
   
 
    
/*==============================================
 *    Constructor
 *==============================================
 */   
     
    public AddressBusiness(String street, String zip, String city, String title) {
      super(street, zip, city, AddressType.BUSINESS);
      this.title = title;
	
       
	}
      
        
  
 
    
/*==============================================
 *    GETTER
 *==============================================
 */
    
    public String getTitle(){
    	return title;
    }
    
    @Override
	public String toString() {
		return "\nTitle: " + title + super.toString() + "\nPostfach: " + postofficebox + "\nDepartment: " + department;
	}

/*==============================================
 *    SETTER
 *==============================================
 */ 
    
    public void setTitle(String title){
    	this.title = title;
    }
    
 
    
}
