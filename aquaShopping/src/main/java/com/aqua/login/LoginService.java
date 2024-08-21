package com.aqua.login;

public interface LoginService {
	LoginVO getUser(LoginVO vo);
	void update(LoginVO vo);
	void insertUser(LoginVO vo);
	void deleteMember(LoginVO vo);
}
