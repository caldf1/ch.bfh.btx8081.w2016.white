package ch.bfh.btx8053.w2016.white.HVmanager.model;

import java.util.Date;

/**
 * @author umern11
 *
 */
public class Client extends Person {
     
    private Date birthdate; 
     
    public Client(String lastname, String firstname, Date birthdate) {
        super(lastname, firstname, PersonType.CLIENT);
        this.birthdate = birthdate;
    }
 
    public Date getBirthdate() {
        return birthdate;
    }
 
    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }
 
    public void addRelation (int relationId, String relationType) {
        Contacts contact = new Contacts(super.getPersonId(), relationId, relationType);
    }
 
     
 
}
