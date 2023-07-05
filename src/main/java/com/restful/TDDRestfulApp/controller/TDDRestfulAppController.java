package com.restful.TDDRestfulApp.controller;


import com.restful.TDDRestfulApp.dto.request.ClientRequest;
import com.restful.TDDRestfulApp.dto.response.ClientResponse;
import com.restful.TDDRestfulApp.service.ClientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@Validated
@Slf4j
@RequestMapping("api/v1/customers")
public class TDDRestfulAppController {

    private final ClientService clientService;

    @Autowired
    public TDDRestfulAppController(ClientService clientService) {
        this.clientService = clientService;
    }


    @PostMapping(value="/", consumes = APPLICATION_JSON_VALUE, produces =APPLICATION_JSON_VALUE)
    public ResponseEntity<ClientResponse> createClient(@Validated @RequestBody ClientRequest clientRequest){
        log.info("start - Client creation request");

        return  ResponseEntity.ok(clientService.processAddClientRequest(clientRequest));
    }
    @RequestMapping("/")
    public void listClients(){


    }

    @RequestMapping("/{id}")
    public void getClient(){


    }


    @DeleteMapping
    public void deleteClient(){


    }

    @RequestMapping("/search")
    public void searchClient(){



    }
}
