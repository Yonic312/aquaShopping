package com.aquarium.Controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aqua.product.productService;
import com.aqua.product.productVO;

import jakarta.servlet.http.HttpSession;
import jakarta.websocket.Session;

@Controller
public class startController {
	startController(){
		System.out.println("indexController 생성자");
	}
	
	HttpSession session;
	@Autowired
	productService service;
	
	@GetMapping("/index")
	String index1(Model model, productVO vo,Principal principal, HttpSession session) {
		System.out.println("/index 매핑");
		model.addAttribute("nli", service.nlist(vo));
		model.addAttribute("li", service.list(vo));
		model.addAttribute("pli",service.wpList(vo));
		
		// 장바구니 개수
		if(principal!=null) {
		vo.setUsername(principal.getName());
		session.setAttribute("countCart", service.countCart(vo));
		}
		return "index.html";
	}
	
	@PostMapping("/index")
	String index2(Model model, productVO vo) {
		System.out.println("/index 매핑");
		model.addAttribute("nli", service.nlist(vo));
		model.addAttribute("li", service.list(vo));
		return "index.html";
	}
}
