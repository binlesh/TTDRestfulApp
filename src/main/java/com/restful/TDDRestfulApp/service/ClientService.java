package com.restful.TDDRestfulApp.service;

import com.restful.TDDRestfulApp.dto.request.ClientRequest;
import com.restful.TDDRestfulApp.dto.request.ClientSearchRequest;
import com.restful.TDDRestfulApp.dto.request.ClientUpdateRequest;
import com.restful.TDDRestfulApp.dto.response.ClientResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface ClientService {

    ResponseEntity<ClientResponse> processCreateClientRequest(ClientRequest request);

    ResponseEntity<ClientResponse> listAllClients();

    ResponseEntity<ClientResponse>processUpdateClientRequest(
            String idNumber,
            ClientUpdateRequest clientUpdateRequest);

    ResponseEntity<ClientResponse> processSearchClientRequest(ClientSearchRequest searchRequest);

    ResponseEntity<ClientResponse> processDeleteClientRequest(String idNumber);



}
