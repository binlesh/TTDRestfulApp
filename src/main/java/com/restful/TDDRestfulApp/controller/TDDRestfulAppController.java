package com.restful.TDDRestfulApp.controller;


import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/customers")
public class TDDRestfulAppController {


    @PostMapping("/")
    public void createClient(){


    }

    @RequestMapping("/")
    public void listClients(){


    }

    @RequestMapping("/{id}")
    public void getClient(){


    }

    @PostMapping("/")
    public void updateClient(){


    }

    @DeleteMapping
    public void deleteClient(){


    }

    @RequestMapping("/search")
    public void searchClient(){



    }
}
