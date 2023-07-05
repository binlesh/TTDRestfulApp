package com.restful.TDDRestfulApp.dto.response;

public class ClientResponse {

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
