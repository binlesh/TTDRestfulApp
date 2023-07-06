package com.restful.TDDRestfulApp.controller;


import com.restful.TDDRestfulApp.dto.request.ClientRequest;
import com.restful.TDDRestfulApp.dto.request.ClientSearchRequest;
import com.restful.TDDRestfulApp.dto.request.ClientUpdateRequest;
import com.restful.TDDRestfulApp.dto.response.ClientResponse;
import com.restful.TDDRestfulApp.service.ClientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@Validated
@Slf4j
@RequestMapping("api/v1/clients")
public class TDDRestfulAppController {

    private final ClientService clientService;

    @Autowired
    public TDDRestfulAppController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping(value="/",
            consumes = APPLICATION_JSON_VALUE,
            produces =APPLICATION_JSON_VALUE)
    public ResponseEntity<ClientResponse> createClient(@Validated @RequestBody ClientRequest clientRequest){
        try {
             return clientService.processCreateClientRequest(clientRequest);
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ClientResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), "An error occurred." +
                            " Please contact the Administrator"));
        }
    }
    @PutMapping(value="/{idNumber}",
            consumes = APPLICATION_JSON_VALUE,
            produces =APPLICATION_JSON_VALUE)
    public ResponseEntity<ClientResponse> updateClient(
            @PathVariable("idNumber") String idNumber,
            @RequestBody ClientUpdateRequest clientUpdateRequest){

       return clientService.processUpdateClientRequest(idNumber, clientUpdateRequest);

    }
    @RequestMapping("/")
    public ResponseEntity<ClientResponse> listClients(){
        return clientService.listAllClients();
    }

    @DeleteMapping(value = "/{idNumber}")
    public ResponseEntity<ClientResponse> deleteClient(@PathVariable("idNumber") String idNumber){
        return clientService.processDeleteClientRequest(idNumber);
    }

    @GetMapping(value="/search",
            consumes = APPLICATION_JSON_VALUE,
            produces =APPLICATION_JSON_VALUE )
    public ResponseEntity<ClientResponse>  searchClient(@RequestBody ClientSearchRequest searchRequest){
        return clientService.processSearchClientRequest(searchRequest);
    }
}
