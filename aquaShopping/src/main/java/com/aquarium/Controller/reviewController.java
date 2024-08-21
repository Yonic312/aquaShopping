package com.aquarium.Controller;

import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aqua.product.productService;
import com.aqua.product.productVO;
import com.aqua.review.reviewService;
import com.aqua.review.reviewVO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.websocket.Session;

@RequestMapping("/review")
@Controller
public class reviewController {
	reviewController(){
		System.out.println("reviewController 생성자");
	}
	
	HttpSession session;
	@Autowired
	reviewService service;
	
	
	@GetMapping("/insert")
	String insert(Model model, reviewVO vo, Principal principal) {
		System.out.println("/insert 매핑");
		vo.setRname(principal.getName());
		service.insert(vo);
		return "redirect:/aquarium/order?pid="+vo.getPid();
	}
	
	@GetMapping("/delete")
	String delete(Model model, reviewVO vo, Principal principal, HttpServletRequest request) {
		System.out.println("/delete 매핑");
		vo.setRid(request.getParameter("rid"));
		vo.setPid(request.getParameter("pid"));
		service.delete(vo);
		return "redirect:/aquarium/order?pid="+vo.getPid();
	}
}
