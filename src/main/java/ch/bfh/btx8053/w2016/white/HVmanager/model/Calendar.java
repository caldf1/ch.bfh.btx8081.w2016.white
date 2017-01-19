package ch.bfh.btx8053.w2016.white.HVmanager.model;
 
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
 
/**
 * This Class create a Calendar for a Person. It has a list of appointments.
 * @author umern11, caldf1
 * @version 1.0
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
     * 
     * @param person
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
     * @return
     */
    public ArrayList<Appointment> getAppointments() {
        return (ArrayList<Appointment>) appointmentList;
    }
     
 
    /**
     * 
     * @return
     */
    public Calendar getCalendar() {
        return this;
    }
     
     
    /**
     * 
     * @return
     */
    public Person getPerson(){
        return person;
    }
     
     
    /**
     * 
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
     
     
     
    /**
     * 
     * @param appointment
     */
    public void removeAppointment(Appointment appointment){
        this.appointmentList.remove(appointmentList);
    }
     
     
 
     
/*==============================================
 *    CHECKS
 *==============================================
 */
     
    /**
     * 
     * @param newAppointment
     * @return
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
