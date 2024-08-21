package com.aqua.order;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	OrderDao dao;

	public void orderInsert(OrderVO vo) {
		dao.orderInsert(vo);
	}

	@Override
	public List<OrderVO> orderSelect(OrderVO vo) {
		return dao.orderSelect(vo);
	}
}
