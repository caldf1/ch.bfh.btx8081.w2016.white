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
     *  for persistence
     */
    public Network(){
    	
    }
    
    
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
     *  helper Class for the Constructor
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

	
/*==============================================
 *    Generated hashCode() and equals()
 *==============================================
 */	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((contactPerson == null) ? 0 : contactPerson.hashCode());
		result = prime * result + ((doctor == null) ? 0 : doctor.hashCode());
		result = prime * result + ((ergotherapeuth == null) ? 0 : ergotherapeuth.hashCode());
		result = prime * result + ((family == null) ? 0 : family.hashCode());
		result = prime * result + ((healthVisitor == null) ? 0 : healthVisitor.hashCode());
		result = prime * result + ((hospital == null) ? 0 : hospital.hashCode());
		result = prime * result + ((insurance == null) ? 0 : insurance.hashCode());
		result = prime * result + ((kesb == null) ? 0 : kesb.hashCode());
		result = prime * result + ((nurse == null) ? 0 : nurse.hashCode());
		result = prime * result + ((other == null) ? 0 : other.hashCode());
		result = prime * result + ((physio == null) ? 0 : physio.hashCode());
		result = prime * result + ((relative == null) ? 0 : relative.hashCode());
		result = prime * result + ((socialInsurance == null) ? 0 : socialInsurance.hashCode());
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
		Network other = (Network) obj;
		if (contactPerson == null) {
			if (other.contactPerson != null)
				return false;
		} else if (!contactPerson.equals(other.contactPerson))
			return false;
		if (doctor == null) {
			if (other.doctor != null)
				return false;
		} else if (!doctor.equals(other.doctor))
			return false;
		if (ergotherapeuth == null) {
			if (other.ergotherapeuth != null)
				return false;
		} else if (!ergotherapeuth.equals(other.ergotherapeuth))
			return false;
		if (family == null) {
			if (other.family != null)
				return false;
		} else if (!family.equals(other.family))
			return false;
		if (healthVisitor == null) {
			if (other.healthVisitor != null)
				return false;
		} else if (!healthVisitor.equals(other.healthVisitor))
			return false;
		if (hospital == null) {
			if (other.hospital != null)
				return false;
		} else if (!hospital.equals(other.hospital))
			return false;
		if (insurance == null) {
			if (other.insurance != null)
				return false;
		} else if (!insurance.equals(other.insurance))
			return false;
		if (kesb == null) {
			if (other.kesb != null)
				return false;
		} else if (!kesb.equals(other.kesb))
			return false;
		if (nurse == null) {
			if (other.nurse != null)
				return false;
		} else if (!nurse.equals(other.nurse))
			return false;
		if (this.other == null) {
			if (other.other != null)
				return false;
		} else if (!this.other.equals(other.other))
			return false;
		if (physio == null) {
			if (other.physio != null)
				return false;
		} else if (!physio.equals(other.physio))
			return false;
		if (relative == null) {
			if (other.relative != null)
				return false;
		} else if (!relative.equals(other.relative))
			return false;
		if (socialInsurance == null) {
			if (other.socialInsurance != null)
				return false;
		} else if (!socialInsurance.equals(other.socialInsurance))
			return false;
		return true;
	}
   	
}
    
 