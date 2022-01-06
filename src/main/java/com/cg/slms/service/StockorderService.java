package com.cg.slms.service;

import com.cg.slms.dao.IStockorderDao;
import com.cg.slms.dao.IStockorderDao;
import com.cg.slms.domain.Stockorder;
import com.cg.slms.domain.Stockorder;

import java.util.List;

//创建实现类并加入findStockorder实现方法
public class StockorderService implements IStockorderService {

    IStockorderDao stockorderDao;

    public IStockorderDao getStockorderDao() {
        return stockorderDao;
    }
    public void setStockorderDao(IStockorderDao stockorderDao) {
        this.stockorderDao = stockorderDao;
    }
    public List<Stockorder> findStockorder(Stockorder stockorder) {
        return stockorderDao.findStockorder(stockorder);
    }

    public boolean addStockorder(Stockorder stockorder) {
        return stockorderDao.addStockorder(stockorder);
    }

    public Stockorder findStockorderById(String id) {
        return stockorderDao.findStockorderById(id);
    }

    public boolean updateStockorder(Stockorder stockorder) {
        return stockorderDao.updateStockorder(stockorder);
    }

    public boolean deleteStockorderById(String id) {
        return stockorderDao.deleteStockorderById(id);
    }

}
