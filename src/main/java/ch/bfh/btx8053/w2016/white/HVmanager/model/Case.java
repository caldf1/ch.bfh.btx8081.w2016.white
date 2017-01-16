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
     * 
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
    public Diagnose getMainDiagnose() {
        return diagnoseList.get(0);
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
        return "\nCase: \nFallnummer: " + caseID + "\nCaregiverID: " + "\nStatus: "+ getState() + cargiverID + "\nEröffnungsdatum: " + startDate
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
     
 
}
 
 
 
/**
 * Innere Klasse um Diagnosen zu erstellen
 * 
 * @author caldf1
 *
 */
class Diagnose {
 
    /*==============================================
     *    Attributes
     *==============================================
     */
     
    String diagnose = null;
     
    /*==============================================
     *    Constructor
     *==============================================
     */
     
    /**
     * 
     * @param diagnose
     */
    Diagnose(String diagnose){
        this.diagnose = diagnose;
    }
     
     
    /*==============================================
     *    Getter
     *==============================================
     */
     
    /**
     * 
     * @return
     */
    String getDiagnose(){
        return diagnose;
    }
     
     
//  /*==============================================
//   *    Setter
//   *==============================================
//   */ 
//  void setDiagnose(String diagnose){
//      this.diagnose = diagnose;
//  }
     
}
