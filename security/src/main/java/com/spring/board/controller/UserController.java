package com.spring.board.controller;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
	
	/*@Autowired
	private UserService userService;*/
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String login(HttpServletRequest request, Authentication auth) {
		HttpSession session = request.getSession();
		System.out.println("컨트롤러에서 auth확인 : " + auth); // 로그인에 성공하면 auth에 로그인데이터가 저장됨
		//System.out.println(http);
		boolean loginChk = false;
		System.out.println("컨트롤러에서 세션 확인 : " + session.getAttribute("remember_id"));
		
		if(session.getAttribute("remember_id") == null) {
			loginChk = false;
		} else {
			loginChk = true;
		}
		/*Cookie[] cookies = request.getCookies(); // 저장된 쿠키를 가져옴
		System.out.println(cookies);
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
		}*/
		
		if(loginChk) {
			return "redirect:/board/list";
		} else {
			return "home";
		}
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public void login() {
		System.out.println("로그인확인");
	}
	
	/*@RequestMapping(value = "/", method = RequestMethod.POST)
	@ResponseBody
	public String loginOk(HttpServletRequest request, HttpSession session, HttpServletResponse response) {
		String user_id = request.getParameter("user_id");
		String remember_id = request.getParameter("remember_id");
		
		System.out.println(user_id);
		return userService.getPw(user_id,remember_id, session, response);
		
	}*/
	
	// 접근권한이 없을때 실행되는 컨트롤러
	@RequestMapping(value = "accessDenied")
	public ModelAndView accessDeniedPage() throws Exception{
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("msg","접근권한이 없습니다.");
		modelAndView.setViewName("accessDenied"); // /accessDenied페이지로 이동
		return modelAndView;
	}
}
