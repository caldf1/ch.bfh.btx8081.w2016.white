package ch.bfh.btx8053.w2016.white.HVmanager.model;

/**
 * @author umern11
 *
 */

//test

public class Address {
	 
    private String street;
    private int zip;
    private String city;
    private AddressType addressType;
    private int personId;
    private int externalInstitutionId;
     
    public Address(int Id, String street, int zip, String city, AddressType addressType, String type) {
        if (type.equals("p")){
            this.personId = Id;
        }
        else {
            this.externalInstitutionId = Id;
        }
        this.street = street;
        this.zip = zip;
        this.city = city;
        this.addressType = addressType;
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
 
    public AddressType getAdressType() {
        return addressType;
    }
 
    public void setAddressType(AddressType addressType) {
        this.addressType = addressType;
    }
     
     
}
