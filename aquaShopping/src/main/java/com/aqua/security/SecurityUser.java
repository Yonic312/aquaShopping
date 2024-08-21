package com.aqua.security;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

import com.aqua.login.LoginVO;

public class SecurityUser extends User {

	private static final long serialVersionUID = 1L;

	public SecurityUser(LoginVO vo) {
		super(vo.getUsername(), "{noop}" + vo.getPassword(),
				AuthorityUtils.createAuthorityList(vo.getRole().toString()));
	}
}