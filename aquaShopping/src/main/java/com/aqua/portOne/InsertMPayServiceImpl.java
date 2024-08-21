package com.aqua.portOne;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InsertMPayServiceImpl implements InsertMPayService{
	
	@Autowired
	InsertMPayDao dao;
	
	@Override
	public int InsertMPayService(PortOneVO vo) {
		return dao.InsertMPayService(vo);
	}

	@Override
	public List<PortOneVO> selectPay(PortOneVO vo) {
		return dao.selectPay(vo);
	}
}