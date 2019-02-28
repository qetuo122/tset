package com.spring.paging.persistence;

import java.util.List;

import com.spring.paging.domain.BoardVO;
import com.spring.paging.domain.Criteria;

public interface BoardDAO {
	
	public void write(BoardVO boardVO) throws Exception; // 작성
	
	public BoardVO read(int bno) throws Exception; // 조회
	
	public void update(BoardVO boardVO) throws Exception; // 수정
	
	public void delete(int bno) throws Exception; // 삭제
	
	public List<BoardVO> listAll() throws Exception; // 리스트 불러오기
	
	public List<BoardVO> listPage(Criteria cri) throws Exception; // 페이징처리 된 리스트 불러오기
	
	public int listCount() throws Exception; // 게시물 총 개수

}
