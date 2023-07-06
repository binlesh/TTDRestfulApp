package com.restful.TDDRestfulApp.dto.response;

import com.restful.TDDRestfulApp.dto.ClientDTO;

import java.util.List;

public class AllClientResponse extends ClientResponse{

    private List<ClientDTO> clientList;
    public AllClientResponse(int resultCode, String message) {
        super(resultCode, message);
    }

    public List<ClientDTO> getClientList() {
        return clientList;
    }

    public void setClientList(List<ClientDTO> clientList) {
        this.clientList = clientList;
    }
}
