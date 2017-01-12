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

    public AddressBusiness(){
    	super();
    	
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
    
}
