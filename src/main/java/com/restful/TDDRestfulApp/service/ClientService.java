package com.restful.TDDRestfulApp.service;

import com.restful.TDDRestfulApp.dto.request.ClientRequest;
import com.restful.TDDRestfulApp.dto.response.ClientResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface ClientService {

    ResponseEntity<ClientResponse> processAddClientRequest(ClientRequest request);

    ClientResponse processUpdateClientRequest();

    ClientResponse processSearchClientRequest();

    ClientResponse processDeleteClientRequest();



}
