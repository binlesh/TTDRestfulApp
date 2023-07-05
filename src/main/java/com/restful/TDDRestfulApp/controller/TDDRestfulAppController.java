package com.restful.TDDRestfulApp.controller;


import com.restful.TDDRestfulApp.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
@RequestMapping("api/v1/customers")
public class TDDRestfulAppController {

    private final ClientService clientService;

    @Autowired
    public TDDRestfulAppController(ClientService clientService) {
        this.clientService = clientService;
    }


    @PostMapping("/")
    public void createClient(){
        System.out.println("client creation");


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
