package com.cg.slms.service;

import com.cg.slms.dao.IClientDao;
import com.cg.slms.domain.Client;


import java.util.List;

public interface IClientService {
    List<Client> findClient(Client Client);
    boolean addClient(Client Client);
    Client findClientById(String id);
    boolean updateClient(Client Client);
    boolean deleteClientById(String id);

//    List<Client> findClient(Client client);
}


