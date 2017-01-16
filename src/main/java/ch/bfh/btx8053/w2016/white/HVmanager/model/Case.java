package ch.bfh.btx8053.w2016.white.HVmanager.model;
 
import java.util.ArrayList;
 
/**
 *
 * @author: umern1, caldf1
 */
public class Case {
 
	
/*==============================================
 *    Attributes
 *==============================================
 */
     
     
    private int caseID = 0; // immutable
    private int cargiverID = 0; 
    private String startDate = null;
    private String endDate = null;
    private Boolean state = false;
     
    private ArrayList<Diagnose> diagnoseList = new ArrayList<>();
    private ArrayList<Bill> billList = new ArrayList<>();
    private ArrayList<MedDoc> medDocs = new ArrayList<>();
    private ArrayList<ActivityRecording> activityRecords = new ArrayList<>();
 
         
 
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
     * 
     * @param startDate
     * @param mainDiagnose
     * @param cargiverID
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
     * @return
     */
    public int getCaseID() {
        return caseID;
    }
 
     
    /**
     * 
     * @return
     */
    public ArrayList<Diagnose> getDiagnoseList() {
        return diagnoseList;
    }
 
     
    /**
     * 
     * @return
     */
    public String getMainDiagnose() {
        return diagnoseList.get(0).getDiagnose();
    }
     
     
    /**
     * 
     * @return
     */
    public String getStartDate() {
        return startDate;
    }
 
     
    /**
     * 
     * @return
     */
    public String getEndDate() {
        return endDate;
    }
 
 
    /**
     * 
     * @return
     */
    public int getCargiverID() {
        return cargiverID;
    }   
     
    /**
     * 
     * @return
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
     * @return
     */
    public ArrayList<Bill> getBills(){
        return billList;
    }
 
    /**
     * 
     * @return
     */
    public ArrayList<MedDoc> getMedDocs(){
        return medDocs;
    }
     
    /**
     * 
     * @return
     */
    public ArrayList<ActivityRecording> getActivityRecords(){
        return activityRecords;
    }
     
     
    /**
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
     * 
     * @param diagnose
     */
    public void addDiagnose(String diagnose){
        diagnoseList.add(new Diagnose(diagnose));
    }
 
     
    /**
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
     * 
     * @param startDate
     */
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }
 
     
    /**
     * 
     * @param endDate
     */
    public void setEndDate(String endDate) {
        this.endDate = endDate;
        this.state = true;
    }
 
 
    /**
     * 
     * @param caregiverID
     */
    public void setCargiverID(int caregiverID) {
        this.cargiverID = caregiverID;
    }
     
     
    /**
     * 
     * @param newBill
     */
    public void addBillToList(Bill newBill){
        billList.add(newBill);
    }
     
     
    /**
     * 
     * @param newMedDoc
     */
    public void addMedDocToList(MedDoc newMedDoc){
        medDocs.add(newMedDoc);
    }
     
     /**
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
     * @return
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
