package com.restful.TDDRestfulApp.repository;

import com.restful.TDDRestfulApp.model.Client;

import java.util.List;

public class ClientRepository {

    private List<Client> clients;


    public boolean addClient(Client client){
        return  clients.add(client);
    }

    public List<Client> listClient(){
        return clients;
    }

    public boolean deleteClient(Client client){
        return clients.remove(client);
    }
}
