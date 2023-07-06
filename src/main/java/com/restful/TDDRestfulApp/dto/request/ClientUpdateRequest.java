package com.restful.TDDRestfulApp.dto.request;

import org.springframework.lang.NonNull;

public class ClientUpdateRequest {

    private String firstName;
    private String lastName;
    private String mobileNumber;
    private String physicalAddress;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
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

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public void setPhysicalAddress(String physicalAddress) {
        this.physicalAddress = physicalAddress;
    }
}
