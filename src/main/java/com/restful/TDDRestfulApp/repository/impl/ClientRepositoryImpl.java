package com.restful.TDDRestfulApp.repository.impl;

import com.restful.TDDRestfulApp.model.Client;
import com.restful.TDDRestfulApp.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClientRepositoryImpl implements ClientRepository {

    private List<Client> clients = new ArrayList<>();

    public boolean createClient(Client client){
        return  clients.add(client);
    }

    public List<Client> listClient(){
        return clients;
    }

    public boolean deleteClient(Client client){
        return clients.remove(client);
    }

    public boolean isIdNumberExist(String idNumber) {
        var idNumberFound = clients
                .stream()
                .filter(
                        client -> idNumber.equals(client.getIdNumber())
                )
                .count();

        return idNumberFound>1;
    }
    public boolean isMobileNumberExist(String mobileNumber) {
        var mobileNumberFound = clients
                .stream()
                .filter(
                        client -> mobileNumber.equals(client.getIdNumber())
                )
                .count();

        return mobileNumberFound>1;
    }
}
