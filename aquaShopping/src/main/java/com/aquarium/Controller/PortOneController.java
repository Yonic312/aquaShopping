package com.aquarium.Controller;

import java.security.Principal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aqua.order.OrderService;
import com.aqua.order.OrderVO;
import com.aqua.portOne.InsertMPayService;
import com.aqua.portOne.PortOneVO;
import com.aqua.product.productService;
import com.aqua.product.productVO;
import com.aqua.security.SecurityUser;

@RequestMapping("/PortOneT")
@Controller
public class PortOneController {
	PortOneController(){
		System.out.println("PortOneController 생성자");
	}
	
	@Autowired
	InsertMPayService service;
	
	@Autowired
	productService service2;
	
	@Autowired
	OrderService service3;
	
	@ResponseBody
	@PostMapping("/insertMPay")
	String productForm(@RequestBody PortOneVO vo, Model model, Principal principal) {
		String username = principal.getName();
		vo.setUsername(username);
	
        LocalDateTime currentTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        String formattedDateTime = currentTime.format(formatter);
        String orderNum = "order" + formattedDateTime;
        vo.setOid(orderNum);
		
		String OK="";
		int k = service.InsertMPayService(vo);
		System.out.println("k : " + k);
		
		if(k == 1) {
			OK = "/PortOneT/result";
		} else {
			OK = "/PortOneT/fail";
		}
		productVO pvo = new productVO();
		pvo.setUsername(principal.getName());
		List<productVO> pli = service2.cartList(pvo);
		
		for(productVO v : pli) {
			// order 리스트에 추가
			OrderVO vo3 = new OrderVO();
			vo3.setOid(orderNum);
			vo3.setPid(v.getPid());
			vo3.setPimg(v.getPimgStr());
			vo3.setPname(v.getPname());
			vo3.setPprice(v.getPprice());
			vo3.setUsername(v.getUsername());
			vo3.setAmount(v.getAmount());
			System.out.println("vo3 : "+vo3);
			service3.orderInsert(vo3);
		}
		
		// cart 리스트 삭제
		productVO vo2 = new productVO();
		service2.cartDelete(vo2);
		return OK ; // ajax res 자리로 값이 들어간다		
	}
	
	@GetMapping("/result")
	public String result( Model model, PortOneVO vo, Principal principal) {
		vo.setUsername(principal.getName());
		model.addAttribute("result", service.selectPay(vo));
		return "PortOneT/result.html" ;		
	}	
	
	
	@GetMapping("/fail")
	public String fail( Model model) {		
		System.out.println("===> fail 확인");
		model.addAttribute("result", "fail");
		return "PortOneT/fail.html" ;		
	}
	
	@GetMapping("/detail")
	public String detail( Model model, PortOneVO vo, Principal principal) {
		vo.setUsername(principal.getName());
		OrderVO ovo = new OrderVO();
		ovo.setOid(vo.getOid());
		model.addAttribute("result", service3.orderSelect(ovo));
		return "PortOneT/detail" ;		
	}	
		
}
