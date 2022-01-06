package com.cg.slms.dao;

import com.cg.slms.domain.Merchandise;
import org.mybatis.spring.SqlSessionTemplate;

import java.util.ArrayList;
import java.util.List;

public class MerchandiseDao implements IMerchandiseDao {

    public SqlSessionTemplate getSqlSession() {
        return sqlSession;
    }

    public void setSqlSession(SqlSessionTemplate sqlSession) {
        this.sqlSession = sqlSession;
    }

    private SqlSessionTemplate sqlSession;

    public List<Merchandise> findMerchandise(Merchandise merchandise) {
        List<Merchandise> merchandises = new ArrayList<Merchandise>();
        merchandises = sqlSession.selectList("findMerchandise", merchandise);
        return merchandises;
    }

    public boolean addMerchandise(Merchandise merchandise) {
        int ret = sqlSession.insert("addMerchandise", merchandise);
        if (ret > 0) {
            return true;
        } else {
            return false;
        }
    }

    public Merchandise findMerchandiseById(String id) {
        Merchandise merchandise = sqlSession.selectOne("findMerchandiseById", id);
        return merchandise;
    }

    public boolean updateMerchandise(Merchandise merchandise) {
        int ret = sqlSession.update("updateMerchandise", merchandise);
        if (ret > 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean deleteMerchandiseById(String id) {
        int ret = sqlSession.delete("deleteMerchandiseById", id);
        if (ret > 0) {
            return true;
        } else {
            return false;
        }
    }


}
