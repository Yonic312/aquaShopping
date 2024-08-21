package com.aqua.order;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderDao {
	void orderInsert (OrderVO vo);
	List<OrderVO> orderSelect(OrderVO vo);
}
