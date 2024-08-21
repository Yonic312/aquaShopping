package com.aqua.product;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class productVO {
	private String pid;
	private String pname;
	private int pprice;
	private String pkind;
	private String pdesc;
	private String pimgStr;
	private MultipartFile pimg;
	private String today;
	private int cnt;
	
	private int countRecord; // 레코드 수 

	private String cid;
	private int amount;
	
	private String username;
	private String arrange; // 정렬
	
	private String keyword; // 검색어
	
	private int cntReview;
	
	
}
