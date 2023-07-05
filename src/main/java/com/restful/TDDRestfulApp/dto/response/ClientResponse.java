package com.restful.TDDRestfulApp.dto.response;

import lombok.Builder;

@Builder
public class ClientResponse {

    public ClientResponse(int resultCode, String message) {
        this.resultCode = resultCode;
        this.message = message;
    }

    private int resultCode;
    private String message;

    public int getResultCode() {
        return resultCode;
    }

    public String getMessage() {
        return message;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
