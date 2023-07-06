package com.restful.TDDRestfulApp.repository;

import com.restful.TDDRestfulApp.model.Client;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ClientRepository {
    public boolean createClient(Client client);
    public List<Client> listClient();
    public boolean deleteClient(Client client);
    public boolean isIdNumberExist(String idNumber);
    public boolean isMobileNumberExist(String mobileNumber);

}
