package com.restful.TDDRestfulApp.mapper;

import com.restful.TDDRestfulApp.dto.ClientDTO;
import com.restful.TDDRestfulApp.model.Client;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ClientToDTOMapper {


    public static List<ClientDTO> mapClientModelToDTOs(List<Client> clientList){

        var clientDTOs = new ArrayList<ClientDTO>();
       clientList.stream().map(

                client -> clientDTOs.add(new ClientDTO(
                        client.getFirstName(),
                        client.getLastName(),
                        client.getIdNumber(),
                        client.getMobileNumber(),
                        client.getPhysicalAddress()
                ))

        ).toList();

        return clientDTOs;
    }
}
