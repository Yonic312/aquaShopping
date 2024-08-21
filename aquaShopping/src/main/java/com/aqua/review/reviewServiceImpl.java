package com.aqua.review;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class reviewServiceImpl implements reviewService {
	reviewServiceImpl(){
		System.out.println("productServiceImpl 생성자");
	}
	
	@Autowired
	reviewDao dao;

	@Override
	public void insert(reviewVO vo) {
		dao.insert(vo);
		
	}

	@Override
	public List<reviewVO> list(reviewVO vo) {
		return dao.list(vo);
	}

	@Override
	public int cntList(reviewVO vo) {
		return dao.cntList(vo);
	}

	@Override
	public void delete(reviewVO vo) {
		dao.delete(vo);
		
	}

}
