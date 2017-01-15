package ch.bfh.btx8053.w2016.white.HVmanager.model;
 
 
/**
 * 
 * @author: umern11, caldf1
 */
public class ActivityRecording {
     
     
    /*==============================================
     *    Attributes
     *==============================================
     */
     
     
    private String date = null;
    private String description = null;
    private String quantity = null;
    
 
     
    /*==============================================
     *    Constructor
     *==============================================
     */
     
    /**
     * 
     */
    public ActivityRecording(){
         
    }
     
    /**
     * 
     * @param date
     * @param description
     * @param quantity
     */
    public ActivityRecording (String date, String description, String quantity) {
         
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
    
     
}
