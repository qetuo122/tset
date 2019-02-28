package com.spring.paging.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.spring.paging.domain.BoardVO;
import com.spring.paging.domain.Criteria;

@Repository
public class BoardDAOImpl implements BoardDAO {

	@Autowired
	private SqlSession sql;
	
	private static String namespace = "com.spring.paging.boardMapper.boardMapper";
	
	@Override
	public void write(BoardVO boardVO) throws Exception {
		sql.insert(namespace + ".write", boardVO);
	}

	@Override
	public BoardVO read(int bno) throws Exception {
		return sql.selectOne(namespace + ".read", bno);
	}

	@Override
	public void update(BoardVO boardVO) throws Exception {
		sql.update(namespace + ".update", boardVO);
	}

	@Override
	public void delete(int bno) throws Exception {
		sql.delete(namespace + ".delete", bno);
		
	}
	@Override
	public List<BoardVO> listAll() throws Exception {
		return sql.selectList(namespace + ".listAll");
	}

	@Override
	public List<BoardVO> listPage(Criteria cri) throws Exception {
		return sql.selectList(namespace + ".listPage", cri);
		
	}

	@Override
	public int listCount() throws Exception {
		return sql.selectOne(namespace + ".listCount");
	}
	
	

	
}
