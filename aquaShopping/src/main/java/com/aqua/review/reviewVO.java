package com.aqua.review;

import lombok.Data;

@Data
public class reviewVO {
	private String rid; // pk : 물건별로 정리
	private String rname; // 작성자
	private String contents; // 내용
	private String nowdate; // 시간
	private String star; // 별점
	private String pid; // uk
}
