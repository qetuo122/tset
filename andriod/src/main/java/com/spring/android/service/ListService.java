package com.spring.android.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.android.dao.ListDaoInterface;
import com.spring.android.model.ListVO;

@Service
public class ListService {

	@Autowired
	private SqlSessionTemplate sqlSession;
	private ListDaoInterface listDao;
	
	public List<ListVO>getMainList() {
		listDao = sqlSession.getMapper(ListDaoInterface.class);
		return listDao.getMainListI();
	}

	public List<ListVO> getList(String category) {
		listDao = sqlSession.getMapper(ListDaoInterface.class);
		return listDao.getListI(category);
	}

	public ListVO getDetail(int id) {
		listDao = sqlSession.getMapper(ListDaoInterface.class);
		return listDao.getDetailI(id);
	}
}
