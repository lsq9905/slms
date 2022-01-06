package com.cg.slms.service;
import com.cg.slms.dao.IStockorderDao;
import com.cg.slms.domain.Stockorder;

import java.util.List;

public interface IStockorderService {
    List<Stockorder> findStockorder(Stockorder stockorder);
    boolean addStockorder(Stockorder stockorder);
    Stockorder findStockorderById(String id);
    boolean updateStockorder(Stockorder stockorder);
    boolean deleteStockorderById(String id);
}
