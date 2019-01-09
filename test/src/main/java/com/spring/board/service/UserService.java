package com.spring.board.service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.board.dao.UserDaoInterface;

@Service
public class UserService {

	@Autowired
	private SqlSessionTemplate sqlSession;
	private UserDaoInterface userDao;
	
	public String getPw(String user_id, String remember_id, HttpSession session, HttpServletResponse response) {
		userDao = sqlSession.getMapper(UserDaoInterface.class);
		
		session.setAttribute("userSession", user_id);
		
		Cookie cookie = new Cookie("remember_id", user_id);
		if(remember_id.equals("true")) {
			response.addCookie(cookie);
		} else {
			cookie.setMaxAge(0);
			response.addCookie(cookie);
		}
		return userDao.getPWI(user_id);
	}

}
