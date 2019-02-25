package com.spring.board.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.RequestCache;

import com.spring.board.model.UserDetailsVO;

public class CustomLoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws ServletException, IOException {
		HttpSession session = request.getSession();
		UserDetailsVO userDetailsVO = (UserDetailsVO)authentication.getPrincipal();
		System.out.println("핸들러에서 파라미터 확인 : " + request.getParameter("remember_id"));
		System.out.println("핸들러에서 권한 확인 : " + userDetailsVO);
		
		Cookie cookie = new Cookie("remember_id", userDetailsVO.getUserId());
		cookie.setMaxAge(60*60);
		
		if(request.getParameter("remember_id") != null) {
			System.out.println("로그인 기억하기 실행");
			System.out.println(request.getParameter("remember_id"));
			session.setAttribute("remember_id", userDetailsVO);
			session.setMaxInactiveInterval(60*60*24);
			System.out.println("컨트롤러에서 세션 확인 : " + session.getAttribute("remember_id"));
			
			response.addCookie(cookie);
		} else {
			System.out.println("로그인 기억하기 해제");
			session.removeAttribute("remember_id");;
			
			cookie.setMaxAge(0);
			response.addCookie(cookie);
		}
		response.sendRedirect(request.getContextPath() + "/board/list");
	}
}
