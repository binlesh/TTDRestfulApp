package com.restful.TDDRestfulApp.repository.impl;

import com.restful.TDDRestfulApp.dto.request.ClientSearchRequest;
import com.restful.TDDRestfulApp.model.Client;
import com.restful.TDDRestfulApp.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClientRepositoryImpl implements ClientRepository {

    private List<Client> clients = new ArrayList<>();

    public boolean createClient(Client client){
        return  clients.add(client);
    }

    public List<Client> listClient(){
        return clients;
    }

    @Override
    public List<Client> getMatchingClients(ClientSearchRequest searchRequest) {
        return clients.stream()
                .filter(client -> ( searchRequest.getFirstName().equalsIgnoreCase(client.getFirstName())))
                .filter(client -> ( searchRequest.getLastName().equalsIgnoreCase(client.getLastName())))
                .filter(client -> ( searchRequest.getIdNumber().equals(client.getIdNumber())))
                .filter(client -> ( searchRequest.getMobileNumber().equals(client.getMobileNumber())))
                .toList();
    }

    @Override
    public boolean deleteClient(Client client) {
        return false;
    }

    public boolean deleteClient(String idNumber){
        return clients.remove(getClientByIDNumber(idNumber));
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

    @Override
    public Optional<Client> getClientByIDNumber(String idNumber) {
        return clients.stream()
                .filter(client -> client.getIdNumber().equals(idNumber))
                .findFirst();
    }
}
