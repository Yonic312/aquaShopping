package com.aqua.order;

import java.util.List;

public interface OrderService {
	void orderInsert (OrderVO vo);
	List<OrderVO> orderSelect(OrderVO vo);
}
