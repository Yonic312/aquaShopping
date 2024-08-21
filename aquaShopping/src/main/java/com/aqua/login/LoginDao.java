package com.aqua.login;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LoginDao {
	LoginVO getUser(LoginVO vo);
	void update(LoginVO vo);
	void insertUser(LoginVO vo);
	void deleteMember(LoginVO vo);
}
