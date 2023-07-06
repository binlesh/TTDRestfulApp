package com.restful.TDDRestfulApp.dto;

public class ClientDTO {

    private String firstName;
    private String lastName;
    private String idNumber;
    private String mobileNumber;
    private String physicalAddress;

    public ClientDTO(String firstName, String lastName, String idNumber, String mobileNumber,
                     String physicalAddress) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.idNumber = idNumber;
        this.mobileNumber = mobileNumber;
        this.physicalAddress = physicalAddress;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public String getPhysicalAddress() {
        return physicalAddress;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public void setPhysicalAddress(String physicalAddress) {
        this.physicalAddress = physicalAddress;
    }
}
