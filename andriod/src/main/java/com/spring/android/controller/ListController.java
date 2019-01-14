package com.spring.android.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.android.model.ListVO;
import com.spring.android.service.ListService;

@Controller
public class ListController {
	
	@Autowired
	ListService listService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String goList(Model model, HttpServletRequest request) {
		
		String category = request.getParameter("category");
		List<ListVO> list = new ArrayList<ListVO>();
		
		if(category == null) {
			list = listService.getMainList();
		} else {
			list = listService.getList(category);
		}
		model.addAttribute("list",list);
		
		return "list";
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	@ResponseBody
	public List<ListVO> btnList(HttpServletRequest request) {
		String category = request.getParameter("category");
		
		List<ListVO> list = listService.getList(category);
		
		return list;
	}
	
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public String goDetail(HttpServletRequest request, Model model) {
		int id = Integer.parseInt(request.getParameter("id"));
		ListVO listVO = listService.getDetail(id);
		model.addAttribute("listVO", listVO);
		
		return "detail";
	}
}
