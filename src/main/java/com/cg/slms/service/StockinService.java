package com.cg.slms.service;

import java.util.List;

import com.cg.slms.dao.IStockinDao;
import com.cg.slms.dao.StockinDao;
import com.cg.slms.domain.Employee;
import com.cg.slms.domain.Stockin;

public class StockinService implements IStockinService {
	IStockinDao stockinDao;
	
	public IStockinDao getStockinDao() {
		return stockinDao;
	}
	public void setStockinDao(IStockinDao stockinDao) {
		this.stockinDao = stockinDao;
	}
	public List<Stockin> findStockin(Stockin stockin) {
		return stockinDao.findStockin(stockin);
	}

	public boolean addStockin(Stockin stockin) {
		return stockinDao.addStockin(stockin);
	}

	public Stockin findStockinById(String id) {
		return stockinDao.findStockinById(id);
	}

	public boolean updateStockin(Stockin stockin) {
		return stockinDao.updateStockin(stockin);
	}

	public boolean deleteStockinById(String id) {
		return stockinDao.deleteStockinById(id);
	}
}
