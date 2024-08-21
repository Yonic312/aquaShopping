package com.aqua.portOne;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface InsertMPayDao {
	int InsertMPayService(PortOneVO vo);
	List<PortOneVO> selectPay(PortOneVO vo);
}
