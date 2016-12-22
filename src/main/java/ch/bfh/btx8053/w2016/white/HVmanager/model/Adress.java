package ch.bfh.btx8053.w2016.white.HVmanager.model;

/**
 * @author umern11
 *
 */

//Test

public class Adress {
	 
    private String street;
    private int zip;
    private String city;
    private AdressType adressType;
    private int personId;
    private int externalInstitutionId;
     
    public Adress(int Id, String street, int zip, String city, AdressType adressType, String type) {
        if (type.equals("p")){
            this.personId = Id;
        }
        else {
            this.externalInstitutionId = Id;
        }
        this.street = street;
        this.zip = zip;
        this.city = city;
        this.adressType = adressType;
    }
 
    public String getStreet() {
        return street;
    }
 
    public void setStreet(String street) {
        this.street = street;
    }
 
    public int getZip() {
        return zip;
    }
 
    public void setZip(int zip) {
        this.zip = zip;
    }
 
    public String getCity() {
        return city;
    }
 
    public void setCity(String city) {
        this.city = city;
    }
 
    public AdressType getAdressType() {
        return adressType;
    }
 
    public void setAdressType(AdressType adressType) {
        this.adressType = adressType;
    }
     
     
}
