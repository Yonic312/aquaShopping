package com.aqua.product;

import java.util.List;

public interface productService {
void insert(productVO vo);
	
	List<productVO> nlist(productVO vo);
	List<productVO> list(productVO vo);
	
	// 수생동물 목록
	List<productVO> goofyList(productVO vo);
	List<productVO> shrimpList(productVO vo);
	List<productVO> medakaList(productVO vo);
	List<productVO> turtleList(productVO vo);
	List<productVO> shellfishList(productVO vo);
	List<productVO> ovoviviparousList(productVO vo);
	List<productVO> cichlidList(productVO vo);
	List<productVO> karasinList(productVO vo);
	List<productVO> koiList(productVO vo);
	List<productVO> catfishList(productVO vo);
	List<productVO> gouramiList(productVO vo);
	List<productVO> goldfishList(productVO vo);
	List<productVO> discusList(productVO vo);
	List<productVO> largeList(productVO vo);
	
	//수생식물 목록
	List<productVO> wpList(productVO vo); // 전체 (index 하단)
	List<productVO> foreList(productVO vo); // 전경수초
	List<productVO> middleList(productVO vo); // 중경/후경 수초
	List<productVO> survivalList(productVO vo); // 활착/구근/부상
	List<productVO> sterileList(productVO vo); // 무균배양수초

	// 검색 목록
	List<productVO> searchList(productVO vo); // index 검색창
	
	// Cart
	void cartInsert(productVO vo);
	void cartDelete(productVO vo);
	void cartDeleteOne(productVO vo);
	void cartUpdate(productVO vo);
	List<productVO> cartList(productVO vo);
	int countCart(productVO vo);
	
	int getSequence();
	
	// Product
	void update (productVO vo);
	void delete (productVO vo);
	productVO edit(productVO vo);
}
