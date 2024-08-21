package com.aqua.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class productServiceImpl implements productService {
	productServiceImpl(){
		System.out.println("productServiceImpl 생성자");
	}
	
	@Autowired
	productDao dao;

	@Override
	public void insert(productVO vo) {
		dao.insert(vo);
	}

	@Override
	public List<productVO> list(productVO vo) {
		return dao.list(vo);
	}

	@Override
	public int getSequence() {
		return dao.getSequence();
	}

	@Override
	public List<productVO> nlist(productVO vo) {
		return dao.nlist(vo);
	}

	@Override
	public List<productVO> goofyList(productVO vo) {
		return dao.goofyList(vo);
	}

	@Override
	public List<productVO> shrimpList(productVO vo) {
		return dao.shrimpList(vo);
	}

	@Override
	public List<productVO> medakaList(productVO vo) {
		return dao.medakaList(vo);
	}

	@Override
	public List<productVO> turtleList(productVO vo) {
		return dao.turtleList(vo);
	}

	@Override
	public List<productVO> shellfishList(productVO vo) {
		return dao.shellfishList(vo);
	}

	@Override
	public List<productVO> ovoviviparousList(productVO vo) {
		return dao.ovoviviparousList(vo);
	}

	@Override
	public List<productVO> cichlidList(productVO vo) {
		return dao.cichlidList(vo);
	}

	@Override
	public List<productVO> karasinList(productVO vo) {
		return dao.karasinList(vo);
	}

	@Override
	public List<productVO> koiList(productVO vo) {
		return dao.koiList(vo);
	}

	@Override
	public List<productVO> catfishList(productVO vo) {
		return dao.catfishList(vo);
	}

	@Override
	public List<productVO> gouramiList(productVO vo) {
		return dao.gouramiList(vo);
	}

	@Override
	public List<productVO> goldfishList(productVO vo) {
		return dao.goldfishList(vo);
	}

	@Override
	public List<productVO> discusList(productVO vo) {
		return dao.discusList(vo);
	}

	@Override
	public List<productVO> largeList(productVO vo) {
		return dao.largeList(vo);
	}

	@Override
	public productVO edit(productVO vo) {
		return dao.edit(vo);
	}

	@Override
	public void cartInsert(productVO vo) {
		dao.cartInsert(vo);
		
	}

	@Override
	public List<productVO> cartList(productVO vo) {
		return dao.cartList(vo);
	}

	@Override
	public void cartDelete(productVO vo) {
		dao.cartDelete(vo);
	}

	@Override
	public void cartDeleteOne(productVO vo) {
		dao.cartDeleteOne(vo);
		
	}

	@Override
	public void update(productVO vo) {
		dao.update(vo);		
	}

	@Override
	public void delete(productVO vo) {
		dao.delete(vo);
	}

	@Override
	public void cartUpdate(productVO vo) {
		dao.cartUpdate(vo);
	}

	@Override
	public List<productVO> wpList(productVO vo) {
		return dao.wpList(vo);
	}

	@Override
	public List<productVO> foreList(productVO vo) {
		return dao.foreList(vo);
	}

	@Override
	public List<productVO> middleList(productVO vo) {
		return dao.middleList(vo);
	}

	@Override
	public List<productVO> survivalList(productVO vo) {
		return dao.survivalList(vo);
	}

	@Override
	public List<productVO> sterileList(productVO vo) {
		return dao.sterileList(vo);
	}

	@Override
	public int countCart(productVO vo) {
		return dao.countCart(vo);
	}

	@Override
	public List<productVO> searchList(productVO vo) {
		return dao.searchList(vo);
	}
}
