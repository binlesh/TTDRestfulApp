package com.restful.TDDRestfulApp.service.impl;

import com.restful.TDDRestfulApp.dto.ClientDTO;
import com.restful.TDDRestfulApp.dto.request.ClientRequest;
import com.restful.TDDRestfulApp.dto.request.ClientSearchRequest;
import com.restful.TDDRestfulApp.dto.request.ClientUpdateRequest;
import com.restful.TDDRestfulApp.dto.response.AllClientResponse;
import com.restful.TDDRestfulApp.dto.response.ClientResponse;
import com.restful.TDDRestfulApp.mapper.ClientToDTOMapper;
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
import java.util.Optional;


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

        if (AppUtils.validSouthAfricanIDNumber(idNumber)) {
            return ResponseEntity.badRequest().body(new ClientResponse(HttpStatus.BAD_REQUEST.value(), "Invalid South African ID number"));
        }

        if (clientRepository.isIdNumberExist(idNumber)) {
            return ResponseEntity.badRequest()
                    .body(
                            new ClientResponse(409, "ID Number already exists"));
        }

        if (clientRepository.isMobileNumberExist(mobileNumber)) {
            return ResponseEntity.badRequest()
                    .body(
                            new ClientResponse(409, "Mobile Number already exist"));
        }

        clientRepository.createClient(new Client(
                clientRequest.getFirstName(),
                clientRequest.getLastName(),
                clientRequest.getMobileNumber(),
                clientRequest.getIdNumber(),
                clientRequest.getPhysicalAddress()
        ));

        ClientResponse response =
                new ClientResponse(200, "Client added successfully");
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<ClientResponse> listAllClients() {
        List<ClientDTO> clientDTOS = ClientToDTOMapper
                .mapClientModelToDTOs(clientRepository.listClient());

        if (clientDTOS.isEmpty()) {
            return ResponseEntity.badRequest().body(
                    new ClientResponse(HttpStatus.NO_CONTENT.value(),
                            "There are no clients to display")
            );
        }

        ClientResponse response =
                new AllClientResponse(HttpStatus.OK.value(),
                        "Retrieved all Clients successfully",
                        clientDTOS);

        return ResponseEntity.ok(response);
    }


    @Override
    public ResponseEntity<ClientResponse> processUpdateClientRequest(
            String idNumber,
            ClientUpdateRequest clientUpdateRequest) {

        System.out.println("updating the client with ID Number: "+ idNumber);


        return null;
    }

    @Override
    public ResponseEntity<ClientResponse> processSearchClientRequest(ClientSearchRequest searchRequest) {
        System.out.println("processing client search request");


        return null;
    }

    @Override
    public ResponseEntity<ClientResponse> processDeleteClientRequest(String idNumber) {
        Optional<Client> optionalClient = clientRepository.getClientByIDNumber(idNumber);

        if (!optionalClient.isPresent()) {
            ClientResponse response = new ClientResponse(
                    HttpStatus.NOT_FOUND.value(),
                    "Client not found. Deletion not performed");
            return ResponseEntity.ok(response);

        }
        var isClientDeleted = clientRepository.deleteClient(optionalClient.get());

        if (isClientDeleted) {
            ClientResponse response = new ClientResponse(
                    HttpStatus.NOT_FOUND.value(),
                    "Client has with ID: " + idNumber + " deleted successfully");
            return ResponseEntity.ok(response);

        }else{

            ClientResponse response = new ClientResponse(
                    HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    "Unknown error while deleting the client");
            return ResponseEntity.ok(response);
        }
    }
}
