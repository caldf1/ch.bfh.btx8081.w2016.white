package ch.bfh.btx8053.w2016.white.HVmanager.model;
 
import java.util.GregorianCalendar;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
 
 
/**
 * 
 * This class record appointments from caregiver with clients
 * @author umern11, caldf1, nedot1, nallm1
 * 
 */
@Entity
public class Appointment {
     
/*==============================================
 *    Attributes
 *==============================================
 */
    @Id
    @GeneratedValue
    private int appointmentDbID = 0; // for database
    private GregorianCalendar startTime = null;
    private GregorianCalendar endTime = null;
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="ClientID")
    private Client client = null;
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="CaregiverID")
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
     * Creates a new appointment with
     * 
     * @param startTime from Gregorian Calender
     * @param endTime from Gregorian Calender
     * @param client form persontype client
     * @param caregiver from personetype caregiver
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
     * @return the appointment ID
     */
    public int getAppointmentDbID(){
        return appointmentDbID;
    }
     
     
    /**
     * 
     * @return the start time
     */
    public GregorianCalendar getStartTime() {
        return startTime;
    }
     
    /**
     * 
     * @return the end time
     */
    public GregorianCalendar getEndTime() {
        return endTime;
    }
     
    /**
     * 
     * @return the client name
     */
    public Client getClient() {
        return client;
    }
     
    /**
     * 
     * @return the caregiver name
     */
    public Caregiver getCaregiver() {
        return caregiver;
    }
     
     
    /**
     * 
     * @return the appointments comments
     */
    public String getComment() {
        return comment;
    }
     
     /**
      *
      * example output:<br><br>
      * Termin-ID: 0<br>
      * Termin am: 11.06.2017, 09:30 - 12:30<br>
      * Termin mit: Dem Klienten<br>
      * Kommentar: Gespräch<br>
      * Caregiver: Demo Pfleger<br>
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
 
        return "\nTermin-ID: " + appointmentDbID + aString + "\nTermin mit: " + client.getLastname() + " "
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
     * Sets the start time from a appointment
     * 
     * @param startTime from the Gregorian Calendar
     */
    public void setStartTime(GregorianCalendar startTime) {
        this.startTime = startTime;
    }
     
    /**
     * Sets the end time from a appointment
     * 
     * @param endTime from the Gregorian Calendar
     */
    public void setEndTime(GregorianCalendar endTime) {
        this.endTime = endTime;
    }
     
     
    /**
     * Sets the client for a appointment
     * 
     * @param client from persontype client
     */
    public void changeClient(Client client) {
        this.client = client;
    }
     
    /**
     * Sets the caregiver for a appointment
     * 
     * @param caregiver from persontype caregiver
     */
    public void changeCaregiver(Caregiver caregiver) {
        this.caregiver = caregiver;
    }
 
     
    /**
     * Sets the comment for a appointment
     * 
     * @param comment as a string
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
		result = prime * result + appointmentDbID;
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
		if (appointmentDbID != other.appointmentDbID)
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
