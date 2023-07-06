package com.restful.TDDRestfulApp.service.impl;

import com.restful.TDDRestfulApp.dto.ClientDTO;
import com.restful.TDDRestfulApp.dto.request.ClientRequest;
import com.restful.TDDRestfulApp.dto.response.AllClientResponse;
import com.restful.TDDRestfulApp.dto.response.ClientResponse;
import com.restful.TDDRestfulApp.model.Client;
import com.restful.TDDRestfulApp.repository.ClientRepository;
import com.restful.TDDRestfulApp.service.ClientService;
import com.restful.TDDRestfulApp.utils.AppUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@Slf4j
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }


    @Override
    public ResponseEntity<ClientResponse> processCreateClientRequest(ClientRequest clientRequest) {

        var idNumber = clientRequest.getIdNumber();
        var mobileNumber = clientRequest.getMobileNumber();

        if(AppUtils.validSouthAfricanIDNumber(idNumber)){
            return ResponseEntity.badRequest().body(new ClientResponse(HttpStatus.BAD_REQUEST.value(), "Invalid South African ID number"));
        }

        if (clientRepository.isIdNumberExist(idNumber)) {
            return ResponseEntity.badRequest()
                    .body(
                            new ClientResponse(409,"ID Number already exists"));
        }

        if (clientRepository.isMobileNumberExist(mobileNumber)) {
            return ResponseEntity.badRequest()
                    .body(
                            new ClientResponse(409, "Mobile Number already exist"));
        }


        ClientResponse response = new ClientResponse(200,"Client added successfully");


        return (ResponseEntity<ClientResponse>) ResponseEntity.badRequest();
    }

    @Override
    public ResponseEntity<ClientResponse> listAllClients() {
        List<Client> clientList = clientRepository.listClient();

        if(clientList.isEmpty()){
            return (ResponseEntity<ClientResponse>)ResponseEntity.noContent();
        }

        ClientResponse response =
                new AllClientResponse(HttpStatus.OK.value(),
                        "Retrieved all Clients successfully",
                        new ArrayList<ClientDTO>());

        return ResponseEntity.ok(response);
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
