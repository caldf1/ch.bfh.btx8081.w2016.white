package ch.bfh.btx8053.w2016.white.HVmanager.model;

import javax.persistence.Embeddable;

import ch.bfh.btx8053.w2016.white.HVmanager.util.AddressType;


/**
 * @author umern11, nedot1, heldf1, caldf1
 *
 */
@Embeddable
public class AddressPrivate extends Address{
      
/*==============================================
 *    Attributes
 *==============================================
 */
     
	private String salutation = null; // for "Anrede" like Mr, Ms   
     
   
/*==============================================
 *    Constructor
 *==============================================
 */  
	
	/**
	 * for persistence
	 */
	public AddressPrivate(){
		
	}
    
	/**
	 * 
	 * @param street
	 * @param zip
	 * @param city
	 * @param gender
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
     
    /**
     * 
     * @return
     */
	public String getSalutation(){
        return salutation;
    }
    
	/**
	 * 
	 */
    @Override
    public String toString() {
        return "\nAnrede: " + salutation + super.toString();
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

/*==============================================
 *    Generated hashCode() and equals()
 *==============================================
 */	    
    
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
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
		AddressPrivate other = (AddressPrivate) obj;
		if (salutation == null) {
			if (other.salutation != null)
				return false;
		} else if (!salutation.equals(other.salutation))
			return false;
		return true;
	}
    
}
