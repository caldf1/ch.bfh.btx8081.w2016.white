package ch.bfh.btx8053.w2016.white.HVmanager.model;
 
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
 
/**
 * This class creates a new a case for a client
 * @author: umern1, caldf1, nedot1, nallm1
 */

@Entity
public class Case {
 
	
/*==============================================
 *    Attributes
 *==============================================
 */
     
    @Id
    @GeneratedValue
    private int caseID = 0; // immutable
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="CaregiverID")
    private int cargiverID = 0; 
    private String startDate = null;
    private String endDate = null;
    private Boolean state = false;
     
    private List<Diagnose> diagnoseList = new ArrayList<>();
    @OneToOne
    private List<Bill> billList = new ArrayList<>();
    @OneToMany(mappedBy="Case")
    private List<MedDoc> medDocs = new ArrayList<>();
    @OneToMany(mappedBy="Case")
    private List<ActivityRecording> activityRecords = new ArrayList<>();
 
         
 
/*==============================================
 *    Constructor
 *==============================================
 */
 
    /**
     *  for persistence
     */
    public Case(){
         
    }
 
     
    /**
     * Creates a new case with
     * 
     * @param startDate as a string
     * @param mainDiagnose as a string
     * @param cargiverID as an int
     */
    public Case(String startDate, String mainDiagnose, int cargiverID) {
     
        this.startDate = startDate; 
        this.cargiverID = cargiverID;
         
        diagnoseList.add(new Diagnose(mainDiagnose));
    }
     
 
 
/*==============================================
 *    GETTER
 *==============================================
 */
 
 
    /**
     * 
     * @return the case ID
     */
    public int getCaseID() {
        return caseID;
    }
 
     
    /**
     * 
     * @return the diagnose list
     */
    public ArrayList<Diagnose> getDiagnoseList() {
        return (ArrayList<Diagnose>) diagnoseList;
    }
 
     
    /**
     * 
     * @return the main diagnose from diagnose list
     */
    public String getMainDiagnose() {
        return diagnoseList.get(0).getDiagnose();
    }
     
     
    /**
     * 
     * @return the start date
     */
    public String getStartDate() {
        return startDate;
    }
 
     
    /**
     * 
     * @return the end date
     */
    public String getEndDate() {
        return endDate;
    }
 
 
    /**
     * 
     * @return the caregiver ID
     */
    public int getCargiverID() {
        return cargiverID;
    }   
     
    /**
     * 
     * @return state
     */
	public String getState(){
		
		if (state == false){
			return "offen";
		} else {
			return "geschlossen";
		}
	}
 
    /**
     * 
     * @return the bill list 
     */
    public ArrayList<Bill> getBills(){
        return (ArrayList<Bill>) billList;
    }
 
    /**
     * 
     * @return the medical documents
     */
    public ArrayList<MedDoc> getMedDocs(){
        return (ArrayList<MedDoc>) medDocs;
    }
     
    /**
     * 
     * @return the acitivity records
     */
    public ArrayList<ActivityRecording> getActivityRecords(){
        return (ArrayList<ActivityRecording>) activityRecords;
    }
     
     
    /**
     * 
     * example output:<br><br>
     * Case:<br> 
     * Fallnummer: 0<br>
     * CaregiverID: 99<br>
     * Status: offen<br>
     * Eröffnungsdatum: 11.01.2017<br>
     * Fall geschlossen am: null<br>
     * Diagnosen: [<br>
     * Diagnose: Burnout,<br>
     * Diagnose: Fruscht,<br> 
     * Diagnose: Rutsch mer de Buggel ab!,<br> 
     * Diagnose: Aschiss]<br>
     * Rechnungen: [<br>
     * Rechnung:<br>
     * Rechnungsdatum: null<br>
     * Rechnungsnummer: 0<br>
     * Fallnummer: 0<br>
     * Rechnungssteller: 0<br>
     * Bemerkung: null<br>
     * Leistungen: []<br>
     * Rechnungstotal: 0.0]<br>
     * Medizinische Dokumente: [<br>
     * ID Medizinisches Dokument: 0<br>
     * Erfassungsdatum: null<br>
     * Letzte Änderung: null<br>
     * Dateiname: null<br>
     * Speicherort: null]<br>
     * Aktivitäten: [<br>
     * ActivityRecording:<br> 
     * Datum: null<br>
     * Beschreibung: null<br>
     * Quantität: null]<br>
     * 
     */
    @Override
    public String toString() {
        return "\nCase: \nFallnummer: " + caseID + "\nCaregiverID: " + cargiverID + "\nStatus: "+ getState() + "\nEröffnungsdatum: " + startDate
                + "\nFall geschlossen am: " + endDate + "\nDiagnosen: " + diagnoseList + "\nRechnungen: " + billList
                + "\nMedizinische Dokumente: " + medDocs + "\nAktivitäten: " + activityRecords;
    }
 
 
 
/* ============================================== 
 * SETTER
 * ==============================================
 */
 
 
    /**
     * Sets a new diagnose to the diagnose list
     * 
     * @param diagnose as a string
     */
    public void addDiagnose(String diagnose){
        diagnoseList.add(new Diagnose(diagnose));
    }
 
     
    /**
     * Remove a diagnose from diagnose list if its already available
     * 
     * @param diagnose
     */
    public void removeDiagnose(String diagnose) {
         
        for (Diagnose i : this.diagnoseList){
            if (i.getDiagnose().equals(diagnose)){
                this.diagnoseList.remove(i);
            }
        }       
    }
     
     
    /**
     * Sets a new main diagnose
     * 
     * @param newMainDiagnose
     */
    public void setMainDiagnose(String newMainDiagnose){
         
        Diagnose mainDiagnose = new Diagnose(newMainDiagnose);
         
        for (Diagnose i : this.diagnoseList){
            if (i.getDiagnose().equals(mainDiagnose)){
                this.diagnoseList.remove(i);
            }
        }
         
        diagnoseList.add(0, mainDiagnose);          
    }
 
     
    /**
     * Sets a start date
     * 
     * @param startDate
     */
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }
 
     
    /**
     * Sets a end date
     * 
     * @param endDate
     */
    public void setEndDate(String endDate) {
        this.endDate = endDate;
        this.state = true;
    }
 
 
    /**
     * Sets a cargiver ID
     * 
     * @param caregiverID
     */
    public void setCargiverID(int caregiverID) {
        this.cargiverID = caregiverID;
    }
     
     
    /**
     * Sets a new bill
     * 
     * @param newBill
     */
    public void addBillToList(Bill newBill){
        billList.add(newBill);
    }
     
     
    /**
     * Sets a new medical document
     * 
     * @param newMedDoc
     */
    public void addMedDocToList(MedDoc newMedDoc){
        medDocs.add(newMedDoc);
    }
     
     /**
      * sets a new activity to the activity records
      * 
      * @param newActivity
      */
    public void addActivityRecordsToList(ActivityRecording newActivity){
        activityRecords.add(newActivity);
    }

    
/*==============================================
 *    Generated hashCode() and equals()
 *==============================================
 */	
    
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((activityRecords == null) ? 0 : activityRecords.hashCode());
		result = prime * result + ((billList == null) ? 0 : billList.hashCode());
		result = prime * result + cargiverID;
		result = prime * result + caseID;
		result = prime * result + ((diagnoseList == null) ? 0 : diagnoseList.hashCode());
		result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
		result = prime * result + ((medDocs == null) ? 0 : medDocs.hashCode());
		result = prime * result + ((startDate == null) ? 0 : startDate.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
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
		Case other = (Case) obj;
		if (activityRecords == null) {
			if (other.activityRecords != null)
				return false;
		} else if (!activityRecords.equals(other.activityRecords))
			return false;
		if (billList == null) {
			if (other.billList != null)
				return false;
		} else if (!billList.equals(other.billList))
			return false;
		if (cargiverID != other.cargiverID)
			return false;
		if (caseID != other.caseID)
			return false;
		if (diagnoseList == null) {
			if (other.diagnoseList != null)
				return false;
		} else if (!diagnoseList.equals(other.diagnoseList))
			return false;
		if (endDate == null) {
			if (other.endDate != null)
				return false;
		} else if (!endDate.equals(other.endDate))
			return false;
		if (medDocs == null) {
			if (other.medDocs != null)
				return false;
		} else if (!medDocs.equals(other.medDocs))
			return false;
		if (startDate == null) {
			if (other.startDate != null)
				return false;
		} else if (!startDate.equals(other.startDate))
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		return true;
	}
 
}
 
/*==================================================================================================
 *    Inner Class
 *==================================================================================================
 */	
 
/**
 * Innere Klasse um Diagnosen zu erstellen
 * 
 * @author caldf1
 *
 */
class Diagnose {
 
    /*==============================================
     *    Attributes Inner Class
     *==============================================
     */
     
    String diagnose = null;
     
    /*==============================================
     *    Constructor Inner Class
     *==============================================
     */
     
    /**
     *  for persistence
     */
    Diagnose(){
    	
    }
    
    /**
     * 
     * @param diagnose
     */
    Diagnose(String diagnose){
        this.diagnose = diagnose;
    }
     
     
    /*==============================================
     *    Getter Inner Class
     *==============================================
     */
     
    /**
     * 
     * @return diagnose
     */
    String getDiagnose(){
        return diagnose;
    }
    
   
    @Override
    public String toString(){
    	return "\nDiagnose: " + diagnose;
    }
    
// /*==============================================
//  *    Setter Inner Class
//  *==============================================
//  */ 
// void setDiagnose(String diagnose){
//     this.diagnose = diagnose;
// }
    
/*==================================================
 *    Generated hashCode() and equals() Inner Class
 *==================================================
 */	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((diagnose == null) ? 0 : diagnose.hashCode());
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
		Diagnose other = (Diagnose) obj;
		if (diagnose == null) {
			if (other.diagnose != null)
				return false;
		} else if (!diagnose.equals(other.diagnose))
			return false;
		return true;
	}
        
     
}
