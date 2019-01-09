package com.spring.board.dao;

import java.util.List;

import com.spring.board.model.BoardVO;

public interface UserDaoInterface {

	String getPWI(String user_id);

	List<BoardVO> getBoardList();

	int writeBoardI(BoardVO boardVo);

	BoardVO getBoardViewI(int board_id);

	int changePwI(String password, int board_id);

	String getPwI(int board_id);

	int changeCntI(int board_id, int view_cnt);

}
