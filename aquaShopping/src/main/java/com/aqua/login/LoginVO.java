package com.aqua.login;

import java.util.Date;

import lombok.Data;

@Data
public class LoginVO {
	private String pid;
	private String username;
	private String password;
	private String role;
	private String name;
	private String pimg;
	private String today;
	private String email;
	private String phonenumber;
	
	private String address1;
	private String address2;
	private String address3;
	private String refundAccount; // 환불계좌
	private String birthday;
	
}
