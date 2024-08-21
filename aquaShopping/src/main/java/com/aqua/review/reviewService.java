package com.aqua.review;

import java.util.List;

public interface reviewService {
	void insert(reviewVO vo);
	void delete(reviewVO vo);
	List<reviewVO> list (reviewVO vo);
	int cntList(reviewVO vo);
}
