package com.restful.TDDRestfulApp.repository;

import com.restful.TDDRestfulApp.model.Client;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
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
