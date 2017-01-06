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
     
    private String title = null;
     
    
  
     
/*==============================================
 *    Constructor
 *==============================================
 */  
      
    public AddressPrivate(String street, String zip, String city, GenderType gender) {
      super(street, zip, city, AddressType.PRIVATE);
         
        if (gender.equals(GenderType.MALE)) {
            this.title = "Herr";
        } else if (gender.equals(GenderType.FEMALE)) {
            this.title = "Frau";
        } else {
            this.title = "";
        }
        
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
        return "\nTitle: " + title + super.toString();
    }
 
/*==============================================
 *    SETTER
 *==============================================
 */
     
    public void setTitle(String anrede){
        this.title = title;
    }
     
  
     
}
