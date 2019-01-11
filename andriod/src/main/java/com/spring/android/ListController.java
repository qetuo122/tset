package com.spring.android;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.model.ListVO;

@Controller
public class ListController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String goList(Model model) {
		
		
		List<ListVO> list = new ArrayList<ListVO>();
		
		list.add(new ListVO(1,"Aroma.GIF","title1","context1"));
		list.add(new ListVO(2,"ArtNails.GIF","title2","context2"));
		list.add(new ListVO(3,"BeautyCollective.GIF","title3","context3"));
		
		System.out.println(list);
		model.addAttribute("list",list);
		
		return "list";
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	@ResponseBody
	public List<ListVO> btnList(HttpServletRequest request) {
		String str = request.getParameter("str");
		List<ListVO> list = new ArrayList<ListVO>();
		
		if(str.equals("sens")) {
			list.add(new ListVO(1,"Aroma.GIF","title1","context1"));
			list.add(new ListVO(2,"ArtNails.GIF","title2","context2"));
			list.add(new ListVO(3,"BeautyCollective.GIF","title3","context3"));
		} else if (str.equals("graphic")) {
			list.add(new ListVO(1,"Bistro.GIF","title4","context4"));
			list.add(new ListVO(2,"CoffeeaTree.GIF","title5","context5"));
			list.add(new ListVO(3,"Coffees.GIF","title6","context6"));
		} else {
			list.add(new ListVO(1,"CookieRoroce.GIF","title7","context7"));
			list.add(new ListVO(2,"Cow.GIF","title8","context8"));
			list.add(new ListVO(3,"Cube.GIF","title9","context9"));
		}
		
		return list;
	}
	
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public String goDetail(HttpServletRequest request, Model model) {
		int id = Integer.parseInt(request.getParameter("id"));
		String image = request.getParameter("image");
		String title = request.getParameter("title");
		String con = request.getParameter("con");
		
		ListVO listVO = new ListVO(id, image, title, con);
		
		model.addAttribute("listVO", listVO);
		
		return "detail";
	}
}
