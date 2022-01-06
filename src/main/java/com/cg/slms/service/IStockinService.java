package com.cg.slms.service;

import java.util.List;

import com.cg.slms.domain.Employee;
import com.cg.slms.domain.Stockin;

public interface IStockinService {

	List<Stockin> findStockin(Stockin stockin);
	boolean addStockin(Stockin stockin);
	Stockin findStockinById(String id);
	boolean updateStockin(Stockin stockin);
	boolean deleteStockinById(String id);
}
