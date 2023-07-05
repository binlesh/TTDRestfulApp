package com.restful.TDDRestfulApp.dto.request;

import org.springframework.lang.NonNull;

public class ClientRequest {

    @NonNull
    private String firstName;
    @NonNull
    private String lastName;
    private String mobileNumber;
    @NonNull
    private String idNumber;
    private String physicalAddress;

    @NonNull
    public String getFirstName() {
        return firstName;
    }

    @NonNull
    public String getLastName() {
        return lastName;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    @NonNull
    public String getIdNumber() {
        return idNumber;
    }

    public String getPhysicalAddress() {
        return physicalAddress;
    }

    public void setFirstName(@NonNull String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(@NonNull String lastName) {
        this.lastName = lastName;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public void setIdNumber(@NonNull String idNumber) {
        this.idNumber = idNumber;
    }

    public void setPhysicalAddress(String physicalAddress) {
        this.physicalAddress = physicalAddress;
    }
}
