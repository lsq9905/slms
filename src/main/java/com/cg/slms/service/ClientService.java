package com.cg.slms.service;

import com.cg.slms.dao.IClientDao;
import com.cg.slms.domain.Client;

import java.util.List;

public class ClientService implements IClientService {

    private IClientDao clientDao;

    public IClientDao getClientDao() {
        return clientDao;
    }

    public void setClientDao(IClientDao ClientDao) {
        this.clientDao = ClientDao;
    }

    public boolean addClient(Client Client) {
        return clientDao.addClient(Client);
    }

    public Client findClientById(String id) {
        return clientDao.findClientById(id);
    }

    public boolean updateClient(Client Client) {
        return clientDao.updateClient(Client);
    }

    public boolean deleteClientById(String id) {
        return clientDao.deleteClientById(id);
    }

    public List<Client> findClient(Client client) {
        return clientDao.findClient(client);
    }

}
