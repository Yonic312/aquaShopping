package com.aqua.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService{
	
	@Autowired
	LoginDao dao;
	
	@Override
	public LoginVO getUser(LoginVO vo) {
		
		return dao.getUser(vo);
	}

	@Override
	public void update(LoginVO vo) {
		dao.update(vo);
		}

	@Override
	public void insertUser(LoginVO vo) {
		dao.insertUser(vo);
	}

	@Override
	public void deleteMember(LoginVO vo) {
		dao.deleteMember(vo);
	}

}
