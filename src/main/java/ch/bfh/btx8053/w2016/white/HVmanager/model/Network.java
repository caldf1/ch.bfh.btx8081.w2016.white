package ch.bfh.btx8053.w2016.white.HVmanager.model;

import java.util.ArrayList;
import java.util.List;

import ch.bfh.btx8053.w2016.white.HVmanager.interfaces.Connectable;
import ch.bfh.btx8053.w2016.white.HVmanager.util.ExternalPersonType;
import ch.bfh.btx8053.w2016.white.HVmanager.util.InstitutionType;

/**
 * Verarbeitet die Netzwerk-Liste des Klienten und gibt die nicht leeren Listen zusammengefasst zurueck
 * 
 * @author umern11, caldf1
 *
 */
public class Network {

	/*==============================================
	 *    Attributes
	 *==============================================
	 */ 
    
	private ArrayList<Connectable> hospital = new ArrayList<>();
	private ArrayList<Connectable> insurance = new ArrayList<>();
	private ArrayList<Connectable> socialInsurance = new ArrayList<>();
	private ArrayList<Connectable> kesb = new ArrayList<>();
	
    private ArrayList<Connectable> doctor = new ArrayList<>();
    private ArrayList<Connectable> nurse = new ArrayList<>();
    private ArrayList<Connectable> healthVisitor = new ArrayList<>();
    private ArrayList<Connectable> physio = new ArrayList<>();
    private ArrayList<Connectable> ergotherapeuth = new ArrayList<>();
    private ArrayList<Connectable> other = new ArrayList<>();
    private ArrayList<Connectable> contactPerson = new ArrayList<>();
    private ArrayList<Connectable> family = new ArrayList<>();
    private ArrayList<Connectable> relative = new ArrayList<>();
	
    
    /*==============================================
     *    Constructor
     *==============================================
     */  
    
    /**
     * Fuellt die einzelnen Listen ab und gibt die nicht leeren Liste als ArrayList zurueck.
     * 
     * @param clientNetworkList
     */
    public Network(ArrayList<Connectable> clientNetworkList){
    	
    	createNetwork(clientNetworkList);
    	getNetwork();
  	
    }
    
    
    /*==============================================
     *    GETTER
     *==============================================
     */
   
    
    /*
     * fuegt die einzelnen nicht leeren Liste in eine Liste ein
     * 
     * @return eine Liste mit ArrayList<Connectable>
     */
    @SuppressWarnings("rawtypes")
	private ArrayList<List> getNetwork(){
    	
    	ArrayList<List> networkLists = new ArrayList<>(); 
    	
    	if (hospital.size() >= 1) {
    		networkLists.add(hospital);	
    	}
    	
    	if (insurance.size() >= 1) {
    		networkLists.add(insurance);	
    	}
    	
    	if (socialInsurance.size() >= 1) {
    		networkLists.add(socialInsurance);	
    	}
    	
    	if (kesb.size() >= 1) {
    		networkLists.add(kesb);	
    	}
    	
    	if (doctor.size() >= 1) {
    		networkLists.add(doctor);	
    	}
    	
    	if (nurse.size() >= 1) {
    		networkLists.add(nurse);	
    	}
    	
    	if (healthVisitor.size() >= 1) {
    		networkLists.add(healthVisitor);	
    	}
    	
    	if (physio.size() >= 1) {
    		networkLists.add(physio);	
    	}
    	
    	if (ergotherapeuth.size() >= 1) {
    		networkLists.add(ergotherapeuth);	
    	}
    	
    	if (other.size() >= 1) {
    		networkLists.add(other);	
    	}
    	
    	if (contactPerson.size() >= 1) {
    		networkLists.add(contactPerson);	
    	}
    	
    	if (family.size() >= 1) {
    		networkLists.add(family);	
    	}
    	
    	if (relative.size() >= 1) {
    		networkLists.add(relative);	
    	}
    	   	
    	return networkLists; 
    
    }
    
    
    /*==============================================
     *    SETTER
     *==============================================
     */ 
    
    /*
     * 
     */
	private void createNetwork(ArrayList<Connectable> clientNetworkList) {

		for (Connectable i : clientNetworkList) {

			// verteilt die ExternalPersonen in die einzelnen Listen entsprechend dem ExternalPersonType
			if (i instanceof ExternalPerson) {
				if (((ExternalPerson) i).getExternalPersonType().equals(ExternalPersonType.CONTACT_PERSON)) {
					this.contactPerson.add(i);
				}
				if (((ExternalPerson) i).getExternalPersonType().equals(ExternalPersonType.DOCTOR)) {
					this.doctor.add(i);
				}
				if (((ExternalPerson) i).getExternalPersonType().equals(ExternalPersonType.ERGOTHERAPEUTH)) {
					this.ergotherapeuth.add(i);
				}
				if (((ExternalPerson) i).getExternalPersonType().equals(ExternalPersonType.FAMILY)) {
					this.family.add(i);
				}
				if (((ExternalPerson) i).getExternalPersonType().equals(ExternalPersonType.HEALTH_VISITOR)) {
					this.healthVisitor.add(i);
				}
				if (((ExternalPerson) i).getExternalPersonType().equals(ExternalPersonType.NURSE)) {
					this.nurse.add(i);
				}
				if (((ExternalPerson) i).getExternalPersonType().equals(ExternalPersonType.OTHER)) {
					this.other.add(i);
				}
				if (((ExternalPerson) i).getExternalPersonType().equals(ExternalPersonType.PHYSIO)) {
					this.physio.add(i);
				}
				if (((ExternalPerson) i).getExternalPersonType().equals(ExternalPersonType.RELATIVE)) {
					this.relative.add(i);
				}	
			}  
			
			// verteilt die Institutionen in die einzelnen Listen entsprechend dem InstitutionType
			if (i instanceof Institution) {
				if (((Institution) i).getInstitutionType().equals(InstitutionType.HOSPITAL)){
    				hospital.add(i);
    			}
				
				if (((Institution) i).getInstitutionType().equals(InstitutionType.INSURANCE)){
    				insurance.add(i);
    			}
				
				if (((Institution) i).getInstitutionType().equals(InstitutionType.KESB)){
    				kesb.add(i);
    			}
				
				if (((Institution) i).getInstitutionType().equals(InstitutionType.SOCIAL_INSURANCE)){
    				socialInsurance.add(i);
    			}				
			}
		}		
	}
	    	
    	
}
    
 