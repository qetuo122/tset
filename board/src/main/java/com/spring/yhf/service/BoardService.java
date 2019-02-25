package com.spring.yhf.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.yhf.dao.BoardDaoInterface;
import com.spring.yhf.model.BoardListVO;
import com.spring.yhf.model.BoardVO;

@Service
public class BoardService {

	@Autowired
	private SqlSessionTemplate sessionTemplate;
	private BoardDaoInterface boardDao;
	
	
	public BoardListVO getList(int line, int pageNumber) {
		
		boardDao = sessionTemplate.getMapper(BoardDaoInterface.class);
		int currentPageNum = pageNumber; // 현재 페이지
		
		int listTotalCount = boardDao.pageCount();
		List<BoardVO> boardList = null;
		int firstRow = 0;
		
		if(listTotalCount > 0) {
			
			firstRow = (pageNumber - 1) * (line * 4); //한줄에 4개씩이므로 보여줄 line*4개씩
			boardList = boardDao.getListI(firstRow, line * 4);
		}
		
		return new BoardListVO(listTotalCount, currentPageNum, boardList, line*4, firstRow);
	}
	
	public BoardVO getDetail(int id) {
		boardDao = sessionTemplate.getMapper(BoardDaoInterface.class);
		return boardDao.getDetailI(id);
	}


}
