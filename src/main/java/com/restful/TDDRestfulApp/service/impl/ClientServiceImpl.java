package com.restful.TDDRestfulApp.service.impl;

import com.restful.TDDRestfulApp.dto.request.ClientRequest;
import com.restful.TDDRestfulApp.dto.response.ClientResponse;
import com.restful.TDDRestfulApp.repository.ClientRepository;
import com.restful.TDDRestfulApp.service.ClientService;

public class ClientServiceImpl implements ClientService {

    private final ClientRepository repository;

    public ClientServiceImpl(ClientRepository repository) {
        this.repository = repository;
    }


    @Override
    public ClientResponse processAddClientRequest(ClientRequest request) {


        return null;
    }

    @Override
    public ClientResponse processUpdateClientRequest() {
        return null;
    }

    @Override
    public ClientResponse processSearchClientRequest() {
        return null;
    }

    @Override
    public ClientResponse processDeleteClientRequest() {
        return null;
    }
}
