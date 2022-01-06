package com.cg.slms.dao;

import com.cg.slms.domain.Client;
import org.mybatis.spring.SqlSessionTemplate;

import java.util.ArrayList;
import java.util.List;

//实现类
public class ClientDao implements IClientDao {
    private SqlSessionTemplate sqlSession;

    public List<Client> findClient(Client client) {
        List<Client> clients = new ArrayList<Client>();
        clients = sqlSession.selectList("findClient", client);
        return clients;
    }

    public SqlSessionTemplate getSqlSession() {
        return sqlSession;
    }

    public void setSqlSession(SqlSessionTemplate sqlSession) {
        this.sqlSession = sqlSession;
    }

    public boolean addClient(Client client) {
        int ret = sqlSession.insert("addClient", client);
        if (ret > 0) {
            return true;
        } else {
            return false;
        }
    }

    public Client findClientById(String id) {
        Client client = sqlSession.selectOne("findClientById", id);
        return client;
    }

    public boolean updateClient(Client client) {
        int ret = sqlSession.update("updateClient", client);
        if (ret > 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean deleteClientById(String id) {
        int ret = sqlSession.delete("deleteClientById", id);
        if (ret > 0) {
            return true;
        } else {
            return false;
        }
    }


}
