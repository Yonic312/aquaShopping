package com.aqua.review;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface reviewDao {
	void insert(reviewVO vo);
	void delete(reviewVO vo);
	List<reviewVO> list (reviewVO vo);
	int cntList(reviewVO vo);
	
}
