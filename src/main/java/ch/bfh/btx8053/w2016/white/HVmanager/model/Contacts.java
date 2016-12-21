package ch.bfh.btx8053.w2016.white.HVmanager.model;

/**
 * @author umern11
 *
 */
public class Contacts {
    private int clientId;
    private int relationId;
    private String relationType;
 
    public Contacts(int clientId, int relationId, String relationType) {
        this.clientId = clientId;
        this.relationId = relationId;
        this.relationType = relationType;
    }
     
}
 