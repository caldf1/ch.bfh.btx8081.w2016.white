package ch.bfh.btx8053.w2016.white.HVmanager.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 
 * @author: umern11, caldf1, nedot1
 */
@Entity
public class ActivityRecording {
     
     
/*==============================================
 *    Attributes
 *==============================================
 */
     
    @Id
    @GeneratedValue
    private int actRecDbId = 0; //for database
	private String date = null;
    private String description = null;
    private String quantity = null;
    
 
     
/*==============================================
 *    Constructor
 *==============================================
 */
     
    /**
     *  for persistence
     */
    public ActivityRecording(){
         
    }
     
    /**
     * 
     * @param actRecDbId
     * @param date
     * @param description
     * @param quantity
     */
    public ActivityRecording (int actRecDbId, String date, String description, String quantity) {
         
        this.actRecDbId = actRecDbId;
        this.date = date;
        this.description = description;
        this.quantity = quantity;
               
    }
 
 
     
/*==============================================
 *    GETTER
 *==============================================
 */
   
    /**
     * 
     * @return
     */
    public int getactRecDbId() {
        return actRecDbId;
    }
    
    /**
     * 
     * @return
     */
    public String getDate() {
        return date;
    }
 
 
    /**
     * 
     * @return
     */
    public String getDescription() {
        return description;
    }
 
 
 
    /**
     * 
     * @return
     */
    public String getQuantity() {
        return quantity;
    }
 
 
    /**
     * 
     */
    @Override
    public String toString(){
        return "\nActivityRecording: \nDatum: " + date + "\nBeschreibung: " + description + "\nQuantität: " + quantity;
    }
 
 
/*==============================================
 *    SETTER
 *==============================================
 */

    /**
     * 
     * @param date
     */
    public void setDate(String date) {
        this.date = date;
    }
 
 
    /**
     * 
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }
 
 
 
    /**
     * 
     * @param quantity
     */
    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    
    /*==============================================
     *    Generated hashCode() and equals()
     *==============================================
     */	
    
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + actRecDbId;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((quantity == null) ? 0 : quantity.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ActivityRecording other = (ActivityRecording) obj;
		if (actRecDbId != other.actRecDbId)
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (quantity == null) {
			if (other.quantity != null)
				return false;
		} else if (!quantity.equals(other.quantity))
			return false;
		return true;
	}
   
}
