package com.cg.slms.service;

import com.cg.slms.dao.IMerchandiseDao;
import com.cg.slms.domain.Merchandise;

import java.util.List;

//创建实现类并加入findMerchandise实现方法
public class MerchandiseService implements IMerchandiseService {

    private IMerchandiseDao merchandiseDao;

    public List<Merchandise> findMerchandise(Merchandise merchandise) {
        return merchandiseDao.findMerchandise(merchandise);
    }

    public IMerchandiseDao getMerchandiseDao() {
        return merchandiseDao;
    }

    public void setMerchandiseDao(IMerchandiseDao merchandiseDao) {
        this.merchandiseDao = merchandiseDao;
    }

    public boolean addMerchandise(Merchandise merchandise) {
        return merchandiseDao.addMerchandise(merchandise);
    }

    public Merchandise findMerchandiseById(String id) {
        return merchandiseDao.findMerchandiseById(id);
    }

    public boolean updateMerchandise(Merchandise merchandise) {
        return merchandiseDao.updateMerchandise(merchandise);
    }

    public boolean deleteMerchandiseById(String id) {
        return merchandiseDao.deleteMerchandiseById(id);
    }

}
