package com.aquarium.Controller;

import java.io.File;
import java.io.IOException;
import java.security.Principal;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.aqua.product.productService;
import com.aqua.product.productVO;
import com.aqua.review.reviewService;
import com.aqua.review.reviewVO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@RequestMapping("/aquarium")
@Controller
public class ProductController {
	ProductController () {
		System.out.println("ProductController 생성자");
	}
	
	@Autowired
	productService service;
	
	@Autowired
	reviewService rservice;
	
	@GetMapping("/order")
	void order(Model model, productVO vo, reviewVO rvo) {
		System.out.println("/aquarium/order");
		model.addAttribute("eli", service.edit(vo));
		model.addAttribute("rli", rservice.list(rvo));
		model.addAttribute("cntRli", rservice.cntList(rvo));	
	}
	
	/*
	 * if(request.getParameter("pid")!=null) { vo.setPid(rvo.getPid()); }
	 */
	
	@GetMapping("/productList")
	void goofyList(Model model, productVO vo, HttpServletRequest request) {
		System.out.println(request.getParameter("List"));
		if (request.getParameter("List").equals("goofyList")) {
			System.out.println("goofyList : " + request.getParameter("arrange"));
			vo.setArrange(request.getParameter("arrange"));
			System.out.println(vo.getArrange()==null);
			
			model.addAttribute("type","goofyList");
			
			model.addAttribute("title" , "구피 종류");
			model.addAttribute("productList", service.goofyList(vo));
			model.addAttribute("count",service.goofyList(vo).size());
			
		} else if(request.getParameter("List").equals("shrimpList")) {
			System.out.println("shrimpList");
			model.addAttribute("title" , "CRS/새우 종류");
			model.addAttribute("type","shrimpList");
			model.addAttribute("productList", service.shrimpList(vo));
			model.addAttribute("count",service.shrimpList(vo).size());
			
		} else if(request.getParameter("List").equals("medakaList")) {
			System.out.println("medakaList");
			model.addAttribute("title" , "메다카 종류");
			model.addAttribute("type","medakaList");
			model.addAttribute("productList", service.medakaList(vo));
			model.addAttribute("count",service.medakaList(vo).size());
			
		} else if(request.getParameter("List").equals("turtleList")) {
			System.out.println("turtleList");
			model.addAttribute("title" , "거북이 종류");
			model.addAttribute("type","turtleList");
			model.addAttribute("productList", service.turtleList(vo));
			model.addAttribute("count",service.turtleList(vo).size());			
			
		} else if(request.getParameter("List").equals("shellfishList")) {
			System.out.println("shellfishList");
			model.addAttribute("title" , "갑각/패각류 종류");
			model.addAttribute("type","shellfishList");
			model.addAttribute("productList", service.shellfishList(vo));
			model.addAttribute("count",service.shellfishList(vo).size());
			
		} else if(request.getParameter("List").equals("ovoviviparousList")) {
			System.out.println("ovoviviparousList");
			model.addAttribute("title" , "난생/난태생송사리 종류");
			model.addAttribute("type","ovoviviparousList");
			model.addAttribute("productList", service.ovoviviparousList(vo));
			model.addAttribute("count",service.ovoviviparousList(vo).size());
			
		} else if(request.getParameter("List").equals("cichlidList")) {
			System.out.println("cichlidList");
			model.addAttribute("title" , "시클리드 종류");
			model.addAttribute("type","cichlidList");
			model.addAttribute("productList", service.cichlidList(vo));
			model.addAttribute("count",service.cichlidList(vo).size());
			
		} else if(request.getParameter("List").equals("karasinList")) {
			System.out.println("karasinList");
			model.addAttribute("title" , "카라신/레인보우 종류");
			model.addAttribute("type","karasinList");
			model.addAttribute("productList", service.karasinList(vo));
			model.addAttribute("count",service.karasinList(vo).size());
			
		} else if(request.getParameter("List").equals("koiList")) {
			System.out.println("koiList");
			model.addAttribute("title" , "잉어과 종류");
			model.addAttribute("type","koiList");
			model.addAttribute("productList", service.koiList(vo));
			model.addAttribute("count",service.koiList(vo).size());
			
		} else if(request.getParameter("List").equals("catfishList")) {
			System.out.println("catfishList");
			model.addAttribute("title" , "메기과 종류");
			model.addAttribute("type","catfishList");
			model.addAttribute("productList", service.catfishList(vo));
			model.addAttribute("count",service.catfishList(vo).size());
			
		} else if(request.getParameter("List").equals("gouramiList")) {
			System.out.println("gouramiList");
			model.addAttribute("title" , "베타/구라미");
			model.addAttribute("type","gouramiList");
			model.addAttribute("productList", service.gouramiList(vo));
			model.addAttribute("count",service.gouramiList(vo).size());
			
		} else if(request.getParameter("List").equals("goldfishList")) {
			System.out.println("goldfishList");
			model.addAttribute("title" , "금붕어/비단잉어");
			model.addAttribute("type","goldfishList");
			model.addAttribute("productList", service.goldfishList(vo));
			model.addAttribute("count",service.goldfishList(vo).size());
			
		} else if(request.getParameter("List").equals("discusList")) {
			System.out.println("discusList");
			model.addAttribute("title" , "디스커스/엔젤");
			model.addAttribute("type","discusList");
			model.addAttribute("productList", service.discusList(vo));
			model.addAttribute("count",service.discusList(vo).size());
			
		} else if(request.getParameter("List").equals("largeList")) {
			System.out.println("largeList");
			model.addAttribute("title" , "대형어/기수");
			model.addAttribute("type","largeList");
			model.addAttribute("productList", service.largeList(vo));
			model.addAttribute("count",service.largeList(vo).size());
			
		// 수초
		} else if(request.getParameter("List").equals("foreList")) {
			System.out.println("foreList");
			model.addAttribute("title" , "전경수초");
			model.addAttribute("type","foreList");
			model.addAttribute("productList", service.foreList(vo));
			model.addAttribute("count",service.foreList(vo).size());
			
		} else if(request.getParameter("List").equals("middleList")) {
			System.out.println("middleList");
			model.addAttribute("title" , "중경/후경 수초");
			model.addAttribute("type","middleList");
			model.addAttribute("productList", service.middleList(vo));
			model.addAttribute("count",service.middleList(vo).size());
			
		} else if(request.getParameter("List").equals("survivalList")) {
			System.out.println("survivalList");
			model.addAttribute("title" , "활착/구근/부상");
			model.addAttribute("type","survivalList");
			model.addAttribute("productList", service.survivalList(vo));
			model.addAttribute("count",service.survivalList(vo).size());
			
		} else if(request.getParameter("List").equals("sterileList")) {
			System.out.println("sterileList");
			model.addAttribute("title" , "무균배양수초");
			model.addAttribute("type","sterileList");
			model.addAttribute("productList", service.sterileList(vo));
			model.addAttribute("count",service.sterileList(vo).size());
			
		}
	}
		
		@PostMapping("/cartInsert")
		String ProductInsert(Model model, productVO vo, Principal principal) {
			System.out.println("cartInsert vo : " + vo);
			vo.setUsername(principal.getName());
			service.cartInsert(vo);
			return "redirect:/index";
		}
		
		@GetMapping("/cartList")
		void cartList(Model model, productVO vo, Principal principal, HttpSession session) {
			vo.setUsername(principal.getName());
			List<productVO> li = service.cartList(vo);
			if (li.size() > 0) {
				productVO mm = li.get(0);
				model.addAttribute(mm.getCid());
				
				// 장바구니 개수
				if(principal!=null) {
				vo.setUsername(principal.getName());
				session.setAttribute("countCart", service.countCart(vo));
				model.addAttribute("countCart",session.getAttribute("countCart"));
				}
				
			}
			
			// 장바구니 합계
			int sumPay = 0;
			for(productVO VO : service.cartList(vo)){
				 sumPay = sumPay + VO.getPprice() * VO.getAmount();
			}
			model.addAttribute("sumPay", sumPay);
			model.addAttribute("li", service.cartList(vo));
			
		}
		
		@GetMapping("/cartDelete")
		String cartDelete(Model model, productVO vo) {
			System.out.println("cartDelete");
			service.cartDelete(vo);
			return "redirect:/index";
		}
		
		@GetMapping("/cartDelete2")
		String cartDelete2(String[] cid, Model model, productVO vo) {
			System.out.println("cartDelete : " + cid.length);
			for (int i=0; i < cid.length; i++) {
				vo.setCid(cid[i]);
				service.cartDeleteOne(vo);
			}
			
			// service.cartDelete(vo);
			return "redirect:/index";
		}
		
		@GetMapping("/cartDeleteOne")
		String cartDeleteOne(Model model, productVO vo) {
			System.out.println("cartDeleteOne : " + vo);
			service.cartDeleteOne(vo);
			return "redirect:/aquarium/cartList";
		}
		
		@GetMapping("/cartUpdate")
		String cartUpdate(Model model, productVO vo, int[]amount, int[]cid) {
			System.out.println("cartUpdate : " + vo);
			
			
			for(int i=0; i < amount.length; i++) {
				vo.setAmount(amount[i]);
				vo.setCid(Integer.toString(cid[i]));
				System.out.println("amount : " + amount[i]);
				System.out.println("cid : " + Integer.toString(cid[i]));
				service.cartUpdate(vo);
			}
			return "redirect:/aquarium/cartList";
		}
		
		@GetMapping("/search")
		String search(Model model, productVO vo) {
			model.addAttribute("title" , vo.getKeyword());
			model.addAttribute("productList", service.searchList(vo));
			model.addAttribute("count",service.searchList(vo).size());
			return "/aquarium/productListS";
		}
}
