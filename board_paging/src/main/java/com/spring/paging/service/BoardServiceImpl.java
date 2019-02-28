package com.spring.paging.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.paging.domain.BoardVO;
import com.spring.paging.domain.Criteria;
import com.spring.paging.persistence.BoardDAO;

@Repository
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDAO boardDao;
	
	@Override
	public void write(BoardVO boardVO) throws Exception {
		boardDao.write(boardVO);
	}

	@Override
	public BoardVO read(int bno) throws Exception {
		return boardDao.read(bno);
	}

	@Override
	public void update(BoardVO boardVO) throws Exception {
		boardDao.update(boardVO);
	}

	@Override
	public void delete(int bno) throws Exception {
		boardDao.delete(bno);
	}

	@Override
	public List<BoardVO> listAll() throws Exception {
		return boardDao.listAll();
	}

	@Override
	public List<BoardVO> listPage(Criteria cri) throws Exception {
		return boardDao.listPage(cri);
	}

	@Override
	public int listCount() throws Exception {
		return boardDao.listCount();
	}
	

	
}
