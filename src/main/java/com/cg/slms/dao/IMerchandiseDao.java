package com.cg.slms.dao;

import com.cg.slms.domain.Merchandise;
import org.mybatis.spring.SqlSessionTemplate;

import java.util.ArrayList;
import java.util.List;

public interface IMerchandiseDao {
    List<Merchandise> findMerchandise(Merchandise merchandise);
    boolean addMerchandise(Merchandise merchandise);
    Merchandise findMerchandiseById(String id);
    boolean updateMerchandise(Merchandise merchandise);
    boolean deleteMerchandiseById(String id);
}



