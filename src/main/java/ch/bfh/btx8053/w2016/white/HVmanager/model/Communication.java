package ch.bfh.btx8053.w2016.white.HVmanager.model;
 
/**
 * @author umern11
 *
 */
public class Communication {
 
    private int personId;
    private int externalInstitutionId;
    private String value;
    private CommunicationType communicationType;
     
    public Communication(int Id, String value, CommunicationType communicationType, String type) {
        if (type.equals("p")){
            this.personId = Id;
        }
        else {
            this.externalInstitutionId = Id;
        }
        this.value = value;
        this.communicationType = communicationType;
    }
 
 
    public String getValue() {
        return value;
    }
 
    public void setValue(String value) {
        this.value = value;
    }
 
    public CommunicationType getCommunicationType() {
        return communicationType;
    }
 
    public void setCommunicationType(CommunicationType communicationType) {
        this.communicationType = communicationType;
    }
     
}
 