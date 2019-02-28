package com.spring.paging.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.paging.domain.BoardVO;
import com.spring.paging.domain.Criteria;
import com.spring.paging.domain.PageMaker;
import com.spring.paging.service.BoardService;

@Controller
public class BoardController {
	
	@Autowired
	BoardService boardService;
	
	@RequestMapping(value = "/board/write", method = RequestMethod.GET)
	public String goWriteForm() throws Exception {
		return "/board/writeForm";
	}
	
	@RequestMapping(value = "/board/write", method = RequestMethod.POST)
	public String write(BoardVO boardVO) throws Exception {
		boardService.write(boardVO);
		
		return "redirect:/board/boardList";
	}
	
	@RequestMapping(value = "/board/boardList", method = RequestMethod.GET)
	public void list(Model model) throws Exception{
		List<BoardVO> list = boardService.listAll();
		
		model.addAttribute("list", list);
	}
	
	@RequestMapping(value = "/board/listPage", method = RequestMethod.GET)
	public void listPage(Criteria cri, Model model) throws Exception {
		List<BoardVO> list = boardService.listPage(cri); // 데이터베이스에서 전체 게시물을 가져온다.
		System.out.println("파라미터로 넘어오는 값 확인" + cri); // jsp페이지에서 page와 perPageNum을 파라미터로 넘기면 cri안에 자동으로 들어오게된다.
		model.addAttribute("list", list);
		cri.setPerPageNum(cri.getPerPageNum());
		PageMaker pageMaker = new PageMaker();
		
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(boardService.listCount()); // 전체 게시물 개수를 가져와서 페이징처리 계산한다.
		
		model.addAttribute("pageMaker", pageMaker);
	}
}
