package ch.bfh.btx8053.w2016.white.HVmanager.model;
 
import java.util.GregorianCalendar;
 
 
/**
 * @author umern11, caldf1
 * @version 1.0
 */
public class Appointment {
     
/*==============================================
 *    Attributes
 *==============================================
 */
      
    private int appointmentID = 0;
    private GregorianCalendar startTime = null;
    private GregorianCalendar endTime = null;
    private Client client = null;
    private Caregiver caregiver = null;
    private String comment = null;
     
  
/*==============================================
 *    Constructor
 *==============================================
 */
     
     
    /**
     *  for persistence
     */
    public Appointment(){
         
    }
     
     
    /**
     * 
     * @param startTime
     * @param endTime
     * @param location
     * @param client
     */
    public Appointment(GregorianCalendar startTime, GregorianCalendar endTime, Client client, Caregiver caregiver){ 
        this.startTime = startTime;
        this.endTime = endTime;
        this.client = client;
        this.caregiver = caregiver;
    }
     
/*==============================================
 *    GETTER
 *==============================================
 */
     
    /**
     * 
     * @return
     */
    public int getAppointmentID(){
        return appointmentID;
    }
     
     
    /**
     * 
     * @return
     */
    public GregorianCalendar getStartTime() {
        return startTime;
    }
     
    /**
     * 
     * @return
     */
    public GregorianCalendar getEndTime() {
        return endTime;
    }
     
    /**
     * 
     * @return
     */
    public Client getClient() {
        return client;
    }
     
    public Caregiver getCaregiver() {
        return caregiver;
    }
     
     
    /**
     * 
     * @return
     */
    public String getComment() {
        return comment;
    }
     
     /**
      *
      * @return the string representation with format:
      *
      * Termin-ID: 
      * Termin am: 11.06.2017, 09:30 - 12:30
      * Termin mit: Dem Klienten
      * Kommentar: Gespräch
      * 
      */
    @Override
    public String toString() {
        String aString = "\nTermin am: ";
 
        if (!(startTime == null)) {
            aString = aString + ""
                    + getNumberRepresentation(String.valueOf(startTime.get(GregorianCalendar.DAY_OF_MONTH))) + "."
                    + getNumberRepresentation(String.valueOf(startTime.get(GregorianCalendar.MONTH + 1))) + "."
                    + String.valueOf(startTime.get(GregorianCalendar.YEAR)) + ", "
                    + getNumberRepresentation(String.valueOf(startTime.get(GregorianCalendar.HOUR_OF_DAY))) + ":"
                    + getNumberRepresentation(String.valueOf(startTime.get(GregorianCalendar.MINUTE)));
        }
 
        if (!(endTime == null)) {
            aString = aString + " - "
                    + getNumberRepresentation(String.valueOf(endTime.get(GregorianCalendar.HOUR_OF_DAY))) + ":"
                    + getNumberRepresentation(String.valueOf(endTime.get(GregorianCalendar.MINUTE)));
        }
 
        return "\nTermin-ID: " + appointmentID + aString + "\nTermin mit: " + client.getLastname() + " "
                + client.getFirstname() + "\nKommentar: " + comment + "\nCaregiver: " + caregiver.getLastname() + " "
                + caregiver.getFirstname();
    }
     
     
    /*
     *  helper Class for toString()
     */
    private String getNumberRepresentation(String min) {
        String rep = "";
        if(min.length() == 1) {
            rep = "0" + min;
        }
        else {
            rep = "" + min;
        }
        return rep;
    }
     
     
/*==============================================
 *    SETTER
 *==============================================
 */
 
    /**
     * 
     * @param startTime
     */
    public void setStartTime(GregorianCalendar startTime) {
        this.startTime = startTime;
    }
     
    /**
     * 
     * @param endTime
     */
    public void setEndTime(GregorianCalendar endTime) {
        this.endTime = endTime;
    }
     
     
    /**
     * 
     * @param client
     */
    public void changeClient(Client client) {
        this.client = client;
    }
     
    /**
     * 
     * @param caregiver
     */
    public void changeCaregiver(Caregiver caregiver) {
        this.caregiver = caregiver;
    }
 
     
    /**
     * 
     * @param comment
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

/*==============================================
 *    Generated hashCode() and equals()
 *==============================================
 */	
    
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + appointmentID;
		result = prime * result + ((caregiver == null) ? 0 : caregiver.hashCode());
		result = prime * result + ((client == null) ? 0 : client.hashCode());
		result = prime * result + ((comment == null) ? 0 : comment.hashCode());
		result = prime * result + ((endTime == null) ? 0 : endTime.hashCode());
		result = prime * result + ((startTime == null) ? 0 : startTime.hashCode());
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
		Appointment other = (Appointment) obj;
		if (appointmentID != other.appointmentID)
			return false;
		if (caregiver == null) {
			if (other.caregiver != null)
				return false;
		} else if (!caregiver.equals(other.caregiver))
			return false;
		if (client == null) {
			if (other.client != null)
				return false;
		} else if (!client.equals(other.client))
			return false;
		if (comment == null) {
			if (other.comment != null)
				return false;
		} else if (!comment.equals(other.comment))
			return false;
		if (endTime == null) {
			if (other.endTime != null)
				return false;
		} else if (!endTime.equals(other.endTime))
			return false;
		if (startTime == null) {
			if (other.startTime != null)
				return false;
		} else if (!startTime.equals(other.startTime))
			return false;
		return true;
	}
    
}
