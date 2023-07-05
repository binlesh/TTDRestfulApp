package com.restful.TDDRestfulApp.service;

import com.restful.TDDRestfulApp.dto.request.ClientRequest;
import com.restful.TDDRestfulApp.dto.response.ClientResponse;
import org.springframework.stereotype.Service;

@Service
public interface ClientService {

    ClientResponse processAddClientRequest(ClientRequest request);

    ClientResponse processUpdateClientRequest();

    ClientResponse processSearchClientRequest();

    ClientResponse processDeleteClientRequest();



}
