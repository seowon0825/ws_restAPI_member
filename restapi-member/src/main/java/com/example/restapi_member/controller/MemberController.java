package com.example.restapi_member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.restapi_member.service.MemberService;

@Controller
@RequestMapping("/members")
public class MemberController {
	
	@Autowired
	private MemberService memService;
	
	@RequestMapping("/index")
	public String root() {
		
		return "index";
	}
	
	@RequestMapping("/regForm")
	public String registForm() {
		
		return "members/registForm";
	}
	
	@GetMapping("/list")
	public String memList(Model model) {
		model.addAttribute("list", memService.findAllMember());
		return "members/list_thymeleaf";
	}
	
	@GetMapping("/list_script")
	public String memListScript() {
		return "members/list_script";
	}
	
	@GetMapping("/modifyForm")
	public String modifyForm(@RequestParam("mno") Long mno, Model model) {
		model.addAttribute("mno", mno);
		System.out.println(mno);
		return "members/modifyForm";
	}
	
	
}
