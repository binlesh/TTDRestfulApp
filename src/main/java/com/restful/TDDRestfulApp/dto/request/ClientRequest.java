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

}
