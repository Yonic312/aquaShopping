package com.aquarium.Controller;

import java.io.File;
import java.io.IOException;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.aqua.product.productService;
import com.aqua.product.productVO;

import jakarta.servlet.http.HttpServletRequest;

@RequestMapping("manager")
@Controller
public class managerController {
	managerController () {
		System.out.println("managerController 생성자");
	}
	
	String path = "";
	
	@PostMapping("/FormOK")
	public String FormOK(Model model, productVO vo, HttpServletRequest  request) 
		     throws Exception, IOException {			

		  path = request.getSession().getServletContext().getRealPath("/product/files/");
		  System.out.println("===> path:" + path);
			
		  Random rnd = new Random();
		  String RName = (rnd.nextInt(999999)+100001)+"";
		  
		    MultipartFile file = vo.getPimg();
		    String fileName = file.getOriginalFilename();
		    File F = new File(path+fileName);
		    if (!file.isEmpty()) {
			    if (F.exists()) {
			     String	Fname = fileName.substring(0, fileName.lastIndexOf("."));
			     String Lname = fileName.substring(fileName.lastIndexOf("."));
			     fileName = Fname + "_" + RName + Lname;
			    }
		    } else {
		    	fileName ="space.png";
		    }
		    vo.setPimgStr(fileName);	    
		    file.transferTo(new File(path+fileName));
		    
			service.insert(vo);
			
		   return "redirect:/manager/List";		
		}		
	
	@Autowired
	productService service;
	
	@PostMapping("update")
	String update (productVO vo) {
		System.out.println("/manager/update");
		service.update(vo);
		return "redirect:/manager/List";
	}
	
	@GetMapping("/List") // 관리자 수정 페이지에 쓸 예정
	void List(Model model, productVO vo) {
		System.out.println("List");
		// 상품등록 상품번호 가져오기
		model.addAttribute("se", service.getSequence());
		
		
		model.addAttribute("li", service.list(vo));
		model.addAttribute("goofyList", service.goofyList(vo));
		model.addAttribute("shrimpList", service.shrimpList(vo));
		model.addAttribute("medakaList", service.medakaList(vo));
		model.addAttribute("turtleList", service.turtleList(vo));
		model.addAttribute("shellfishList", service.shellfishList(vo));
		model.addAttribute("ovoviviparousList", service.ovoviviparousList(vo));
		model.addAttribute("cichlidList", service.cichlidList(vo));
		model.addAttribute("karasinList", service.karasinList(vo));
		model.addAttribute("koiList", service.koiList(vo));
		model.addAttribute("catfishList", service.catfishList(vo));
		model.addAttribute("gouramiList", service.gouramiList(vo));
		model.addAttribute("goldfishList", service.goldfishList(vo));
		model.addAttribute("discusList", service.discusList(vo));
		model.addAttribute("largeList", service.largeList(vo));
		
		// 수초
		model.addAttribute("foreList", service.foreList(vo));
		model.addAttribute("middleList", service.middleList(vo));
		model.addAttribute("survivalList", service.survivalList(vo));
		model.addAttribute("sterileList", service.sterileList(vo));
	}
	
	@GetMapping("/edit") // 수정창
	void edit(Model model, productVO vo) {
		model.addAttribute("eli", service.edit(vo));
		System.out.println("edit");
	}
	
	@PostMapping("/delete") // 수정창
	String delete(Model model, productVO vo) {
		service.delete(vo);
		System.out.println("edit");
		return "redirect:/manager/List";
	}
}
