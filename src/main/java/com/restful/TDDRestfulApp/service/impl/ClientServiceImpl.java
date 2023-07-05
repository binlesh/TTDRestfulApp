package com.restful.TDDRestfulApp.service.impl;

import com.restful.TDDRestfulApp.dto.request.ClientRequest;
import com.restful.TDDRestfulApp.dto.response.ClientResponse;
import com.restful.TDDRestfulApp.repository.ClientRepository;
import com.restful.TDDRestfulApp.service.ClientService;
import com.restful.TDDRestfulApp.utils.AppUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.net.http.HttpResponse;

@Service
@Slf4j
public class ClientServiceImpl implements ClientService {

    private final ClientRepository repository;

    public ClientServiceImpl(ClientRepository repository) {
        this.repository = repository;
    }


    @Override
    public ResponseEntity<ClientResponse> processAddClientRequest(ClientRequest request) {

       // log.info("processing -> client creation request");
        boolean isValidID = AppUtils.validSouthAfricanIDNumber(request.getIdNumber());

       // var valuation = isValidID? "valid" : "invalid";

        //log.info(valuation);

        if(!isValidID){


        }

        ClientResponse response = new ClientResponse(200,"Client added successfully");


        return (ResponseEntity<ClientResponse>) ResponseEntity.badRequest();
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
