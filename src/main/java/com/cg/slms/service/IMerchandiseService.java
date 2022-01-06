package com.cg.slms.service;

import com.cg.slms.dao.IMerchandiseDao;
import com.cg.slms.domain.Merchandise;

import java.util.List;

public interface IMerchandiseService {
    List<Merchandise> findMerchandise(Merchandise Merchandise);
    boolean addMerchandise(Merchandise Merchandise);
    Merchandise findMerchandiseById(String id);
    boolean updateMerchandise(Merchandise Merchandise);
    boolean deleteMerchandiseById(String id);
}

