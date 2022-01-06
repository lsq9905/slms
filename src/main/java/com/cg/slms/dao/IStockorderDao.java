package com.cg.slms.dao;

import com.cg.slms.domain.Stockorder;
import com.cg.slms.domain.Stockorder;
import org.mybatis.spring.SqlSessionTemplate;

import java.util.ArrayList;
import java.util.List;

public interface IStockorderDao {

    List<Stockorder> findStockorder(Stockorder stockorder);
    boolean addStockorder(Stockorder stockorder);
    Stockorder findStockorderById(String id);
    boolean updateStockorder(Stockorder stockorder);
    boolean deleteStockorderById(String id);
}

