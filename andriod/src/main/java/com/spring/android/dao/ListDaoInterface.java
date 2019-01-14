package com.spring.android.dao;

import java.util.List;

import com.spring.android.model.ListVO;

public interface ListDaoInterface {

	List<ListVO> getMainListI();

	List<ListVO> getListI(String category);

	ListVO getDetailI(int id);

}
