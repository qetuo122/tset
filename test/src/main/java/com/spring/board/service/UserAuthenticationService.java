package com.spring.board.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.spring.board.dao.UserDaoInterface;
import com.spring.board.model.UserDetailsVO;

@Service
public class UserAuthenticationService implements UserDetailsService {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	private UserDaoInterface userDao;

	public UserAuthenticationService() {
	}
	
	public UserAuthenticationService(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		//Map<String, Object> user = sqlSession.selectOne("selectUser",username);
		
		userDao = sqlSession.getMapper(UserDaoInterface.class);
		Map<String, Object> user = userDao.selectUser(username); // 데이터베이스에서 입력한 유저 아이디를 조건으로 데이터를 맵에 담음
		
		System.out.println(user);
		
		if(user == null) throw new UsernameNotFoundException(username);
		
		List<GrantedAuthority> gas = new ArrayList<GrantedAuthority>();
		gas.add(new SimpleGrantedAuthority(user.get("authority").toString()));
		
		return new UserDetailsVO(user.get("username").toString(), user.get("password").toString(), (boolean)user.get("enabled"), true, true, true, gas, user.get("username").toString());
	}
	
	
}
