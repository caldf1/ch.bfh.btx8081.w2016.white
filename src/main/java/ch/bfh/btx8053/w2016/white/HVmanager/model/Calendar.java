package ch.bfh.btx8053.w2016.white.HVmanager.model;
 
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
 
/**
 * This class creates a calendar for a person. It has a list of appointments.
 * @author umern11, caldf1, nallm1
 * 
 */
public class Calendar {
     
/*==============================================
 *    Attributes
 *==============================================
 */   
	
    private List<Appointment> appointmentList = new ArrayList<Appointment>();
    private Person person = null;

    
/*==============================================
 *    Constructor
 *==============================================
 */ 
 
    /**
     *  for persistence
     */
    public Calendar(){
         
    }
     
    /**
     * Creates a new calendar with 
     * 
     * @param person from person
     */
    public Calendar(Person person)
    {
        this.person = person;
    }
     
 
/*==============================================
 *    GETTER
 *==============================================
 */
     
    /**
     * 
     * @return the appointment list
     */
    public ArrayList<Appointment> getAppointments() {
        return (ArrayList<Appointment>) appointmentList;
    }
     
 
    /**
     * 
     * @return the calendar 
     */
    public Calendar getCalendar() {
        return this;
    }
     
     
    /**
     * 
     * @return the person from the calendar
     */
    public Person getPerson(){
        return person;
    }
     
     
    /**
     * example output:<br><br>
     * Kalender von: Kalender Inhaber<br>
     * Appointments: [<br>
     * Termin-ID: 0<br>
     * Termin am: 11.06.2017, 09:30 - 12:30<br>
     * Termin mit: 1. Dem Klienten<br>
     * Kommentar: Gespräch1<br>
     * Caregiver: Demo Pfleger, <br>
     * Termin-ID: 0<br>
     * Termin am: 10.06.2017, 09:30 - 12:30<br>
     * Termin mit: 2. Dem Klienten<br>
     * Kommentar: Gespräch<br>
     * Caregiver: Demo Pfleger,<br>
     * Termin-ID: 0<br>
     * Termin am: 09.06.2017, 09:30 - 12:30<br>
     * Termin mit: 3. Dem Klienten<br>
     * Kommentar: Gespräch<br>
     * Caregiver: Demo Pfleger]<br>
     */
    public String toString() {
        return "\nKalender von: " + person.getLastname() + " " + person.getFirstname() + "\nAppointments: "
                + appointmentList;
    }
     
     
/*==============================================
 *    SETTER
 *==============================================
 */
     
     
    /**
     * add a new appointment to the calendar if not conflicted with others
     * @param newAppointment
     * @return true if appointment has no conflict otherwise false
     */
    public boolean addAppointment(Appointment newAppointment)
    {
        if(checkAvailability(newAppointment)) {
            appointmentList.add(newAppointment);
            return true;
        }
        return false;
    }
     
     
     
//    /**
//    * remove an appointment if its unnecessary
//    *
//    * @param appointment from appointment list
//    */
//    public void removeAppointment(Appointment appointment){
//        this.appointmentList.remove(appointmentList);
//    }
     
     
 
     
/*==============================================
 *    CHECKS
 *==============================================
 */
     
    /**
     * Creates a new appointment after checking its availability
     * 
     * @param newAppointment
     * @return true or false
     */
    private boolean checkAvailability(Appointment newAppointment)
    {
        for (Appointment i: this.appointmentList)
        {
            //Existing times to compare 
            GregorianCalendar oldStartTime = i.getStartTime();
            GregorianCalendar oldEndTime = i.getEndTime();
             
            //new times to compare
            GregorianCalendar newStartTime = newAppointment.getStartTime();
            GregorianCalendar newEndTime = newAppointment.getEndTime();
             
            //Checks if the new Appointment is entirely before or entirely after the old one,
            //if the end-and start-time is the same it's also ok.
            //if not returns false.
            if (!((newStartTime.before(oldStartTime) && 
                    (newEndTime.before(oldStartTime) || newEndTime.equals(oldStartTime)))
                ||((newStartTime.after(oldEndTime) || newStartTime.equals(oldEndTime))
                    && (newEndTime.after(oldEndTime))))
                    )  
            {
                return false;
            }   
        }       
        return true;
    }

/*==============================================
 *    Generated hashCode() and equals()
 *==============================================
 */	
    
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((appointmentList == null) ? 0 : appointmentList.hashCode());
		result = prime * result + ((person == null) ? 0 : person.hashCode());
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
		Calendar other = (Calendar) obj;
		if (appointmentList == null) {
			if (other.appointmentList != null)
				return false;
		} else if (!appointmentList.equals(other.appointmentList))
			return false;
		if (person == null) {
			if (other.person != null)
				return false;
		} else if (!person.equals(other.person))
			return false;
		return true;
	}
    
}
