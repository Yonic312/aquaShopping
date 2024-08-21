package com.aquarium.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aqua.login.LoginService;
import com.aqua.login.LoginVO;

import jakarta.servlet.http.HttpSession;

@RequestMapping("/login")
@Controller
public class LoginController {
	
	@Autowired
	LoginService service;
	
	public LoginController(){
		System.out.println("LoginController 생성자");
	}
	
	@GetMapping("/loginForm")
	void loginForm( Model model) {		
		System.out.println("===> loginForm 확인");			
	}
	
	@PostMapping("/loginFormOK")
	String loginFormOK( Model model, LoginVO vo) {		
		System.out.println("===> loginFormOK 확인"+ vo);
		LoginVO m = service.getUser(vo);
		System.out.println("m : " + service.getUser(vo));
		if (m != null) {
			if (m.getPassword().equals(vo.getPassword())) {
				System.out.println("로그인 성공!!");
				return "redirect:/login/success";
			}else {
				System.out.println("로그인 실패!!");
				return "redirect:/login/failure";
			}
		}else{
			System.out.println("로그인 실패!!");
			return "redirect:/login/failure";
		}
	}
	
	@GetMapping("/success")
	String success( Model model, HttpSession session) {		
		System.out.println("===> success 확인");
		session.setAttribute("session", "session");
		return "/login/success";	
	}
	
	@GetMapping("/failure")
	String failure( Model model) {		
		System.out.println("===> failure 확인");
		return "/login/failure";	
	}
	
	@GetMapping("/accessDenied")
	String accessDenied( Model model) {		
		System.out.println("===> accessDenied 확인");
		return "/login/accessDenied";	
	}
	
	@GetMapping("/logOut")
	String logOut( Model model, HttpSession session) {		
		System.out.println("===> logOut 확인");
		session.invalidate();
		return "redirect:/index";	
	}
	
	@GetMapping("/update") // 유저 정보 수정
	String update( Model model, LoginVO vo) {		
		System.out.println("===> update 확인");
		service.update(vo);
		return "redirect:/index";	
	}
	
	@GetMapping("/insert") // 회원가입
	String insert( Model model, LoginVO vo) {		
		System.out.println("===> insert 확인");
		service.insertUser(vo);
		System.out.println("회원가입 성공!");
		return "redirect:/login/loginForm";
	}
}
