package com.spring.paging.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.spring.paging.domain.BoardVO;
import com.spring.paging.domain.Criteria;

public interface BoardService {
	
	public void write(BoardVO boardVO) throws Exception;
	
	public BoardVO read(int bno) throws Exception;
	
	public void update(BoardVO boardVO) throws Exception;
	
	public void delete(int bno) throws Exception;
	
	public List<BoardVO> listAll() throws Exception;
	
	public List<BoardVO> listPage(Criteria cri) throws Exception;
	
	public int listCount() throws Exception;
}
