package ch.bfh.btx8053.w2016.white.HVmanager.model;

import javax.persistence.Embeddable;

import ch.bfh.btx8053.w2016.white.HVmanager.util.AddressType;
import ch.bfh.btx8053.w2016.white.HVmanager.util.GenderType;

/**
 * @author umern11, caldf1, nedot1
 *
 */
@Embeddable
public class AddressPrivate extends Address{
      
/*==============================================
 *    Attributes
 *==============================================
 */
     
	private String salutation = null; // for «Anrede» like Mr, Ms   
     
    
  
     
/*==============================================
 *    Constructor
 *==============================================
 */  
      
	public AddressPrivate(String street, String zip, String city, String gender) {
	      super(street, zip, city, AddressType.PRIVATE);
	         
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
     
    public String getSalutation(){
        return salutation;
    }
     
    @Override
    public String toString() {
        return "\nAnrede: " + salutation + super.toString();
    }
 
/*==============================================
 *    SETTER
 *==============================================
 */
     
    public void setSalutation(String salutation){
        this.salutation = salutation;
    }
     
  
     
}
