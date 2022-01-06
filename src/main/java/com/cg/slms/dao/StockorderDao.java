package com.cg.slms.dao;

import com.cg.slms.domain.Stockorder;
import org.mybatis.spring.SqlSessionTemplate;

import java.util.ArrayList;
import java.util.List;

public class StockorderDao implements IStockorderDao {
    private SqlSessionTemplate sqlSession;

    public SqlSessionTemplate getSqlSession() {
        return sqlSession;
    }

    public void setSqlSession(SqlSessionTemplate sqlSession) {
        this.sqlSession = sqlSession;
    }

    public List<Stockorder> findStockorder(Stockorder stockorder){
        List<Stockorder> stockorders=new ArrayList<Stockorder>();
        stockorders=sqlSession.selectList("findStockorder", stockorder);
        return stockorders;
    }

    public boolean addStockorder(Stockorder stockorder) {
        int ret = sqlSession.insert("addStockorder", stockorder);
        if (ret > 0) {
            return true;
        } else {
            return false;
        }
    }



    public Stockorder findStockorderById(String id) {
        Stockorder stockorder = sqlSession.selectOne("findStockorderById", id);
        return stockorder;
    }

    public boolean updateStockorder(Stockorder stockorder) {
        int ret = sqlSession.update("updateStockorder", stockorder);
        if (ret > 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean deleteStockorderById(String id) {
        int ret = sqlSession.delete("deleteStockorderById", id);
        if (ret > 0) {
            return true;
        } else {
            return false;
        }
    }



}
