package com.cg.slms.dao;

import java.util.ArrayList;
import java.util.List;

import com.cg.slms.domain.Stockin;
import org.mybatis.spring.SqlSessionTemplate;


public class StockinDao implements IStockinDao{
	private SqlSessionTemplate sqlSession;
	
	public SqlSessionTemplate getSqlSession() {
		return sqlSession;
	}

	public void setSqlSession(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}

	public List<Stockin> findStockin(Stockin stockin){
		List<Stockin> stockins=new ArrayList<Stockin>();
		stockins=sqlSession.selectList("findStockin", stockin);
		return stockins;
	}

	public boolean addStockin(Stockin stockin) {
		int ret = sqlSession.insert("addStockin", stockin);
		if (ret > 0) {
			return true;
		} else {
			return false;
		}
	}



	public Stockin findStockinById(String id) {
		Stockin stockin = sqlSession.selectOne("findStockinById", id);
		return stockin;
	}

	public boolean updateStockin(Stockin stockin) {
		int ret = sqlSession.update("updateStockin", stockin);
		if (ret > 0) {
			return true;
		} else {
			return false;
		}
	}

	public boolean deleteStockinById(String id) {
		int ret = sqlSession.delete("deleteStockinById", id);
		if (ret > 0) {
			return true;
		} else {
			return false;
		}
	}


}
