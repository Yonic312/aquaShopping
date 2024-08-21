package com.aqua.portOne;

import java.util.List;

public interface InsertMPayService {
	int InsertMPayService(PortOneVO vo);
	List<PortOneVO> selectPay(PortOneVO vo);
}
