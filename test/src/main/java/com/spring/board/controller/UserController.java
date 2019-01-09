package com.spring.board.controller;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.board.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String login(HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();
		boolean loginChk = false;
		
		if(cookies != null) {
			for(int i = 0; i < cookies.length; i++) {
				System.out.println(cookies[i].getName());
				if(cookies[i].getName().equals("remember_id")) {
					loginChk = true;
				} else {
					loginChk = false;
				}
			}
		} else {
			loginChk = false;
		}
		
		if(loginChk) {
			return "redirect:/board/list";
		} else {
			return "home";
		}
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	@ResponseBody
	public String loginOk(HttpServletRequest request, HttpSession session, HttpServletResponse response) {
		String user_id = request.getParameter("user_id");
		String remember_id = request.getParameter("remember_id");
		
		return userService.getPw(user_id,remember_id, session, response);
		
	}
}
