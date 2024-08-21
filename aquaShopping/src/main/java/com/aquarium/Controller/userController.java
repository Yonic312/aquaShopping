package com.aquarium.Controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.*;
import org.springframework.security.core.context.*;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aqua.login.LoginService;
import com.aqua.login.LoginVO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RequestMapping("/user")
@Controller
public class userController {
	userController(){
		System.out.println("userController 생성자");
	}
	
	@Autowired
	LoginService service;
	
	@GetMapping("/edit")
	String edit( Model model, Principal principal, LoginVO vo) {
		String username = principal.getName();
		model.addAttribute("username", username);
		vo.setUsername(username);
		model.addAttribute("uli", service.getUser(vo));
		return "/aquarium/userEdit";		
	}
	
	@GetMapping("/delete")
	String delete( Model model, Principal principal, LoginVO vo, HttpServletRequest request, HttpServletResponse response) {		
		System.out.println("===> delete 확인");
		vo.setUsername(principal.getName());
		service.deleteMember(vo);
		
		 // 로그아웃 처리
	    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    System.out.println("auth : " + auth);
	    if (auth != null) {
	        new SecurityContextLogoutHandler().logout(request, response, auth);
	    }
		return "redirect:/index";		
	}
	
	@GetMapping("/update")
	String update( Model model, Principal principal, LoginVO vo) {		
		System.out.println("===> update 확인");
		String username = principal.getName();
		model.addAttribute("username", username);
		
		vo.setUsername(username);
		
		System.out.println("update vo : " + vo);
		service.update(vo);
		return "redirect:/user/edit";		
	}
}
