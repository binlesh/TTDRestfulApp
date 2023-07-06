package com.restful.TDDRestfulApp.repository;

import com.restful.TDDRestfulApp.dto.request.ClientSearchRequest;
import com.restful.TDDRestfulApp.model.Client;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ClientRepository {
    boolean createClient(Client client);
    List<Client> listClient();

    List<Client> getMatchingClients(ClientSearchRequest searchRequest);
     boolean deleteClient(Client client);
     boolean isIdNumberExist(String idNumber);
     boolean isMobileNumberExist(String mobileNumber);

    Optional<Client> getClientByIDNumber(String idNumber);

}
