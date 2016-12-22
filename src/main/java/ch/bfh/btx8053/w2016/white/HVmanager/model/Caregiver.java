package ch.bfh.btx8053.w2016.white.HVmanager.model;

/**
 * @author umern11
 *
 */

//test
//test 2

public class Caregiver extends Person {
    
    private String password; 
     
    public Caregiver(String lastname, String firstname, String password) {
        super(lastname, firstname, PersonType.ADMIN);
        this.password = password;
    }
 
    public String getPassword() {
        return password;
    }
 
    public void setPassword(String password) {
        this.password = password;
    }
     
}

