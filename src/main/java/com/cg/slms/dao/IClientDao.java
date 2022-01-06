package com.cg.slms.dao;

import com.cg.slms.domain.Client;
import org.mybatis.spring.SqlSessionTemplate;

import java.util.ArrayList;
import java.util.List;

public interface IClientDao {
    List<Client> findClient(Client Client);
    boolean addClient(Client Client);
    Client findClientById(String id);
    boolean updateClient(Client Client);
    boolean deleteClientById(String id);
}

