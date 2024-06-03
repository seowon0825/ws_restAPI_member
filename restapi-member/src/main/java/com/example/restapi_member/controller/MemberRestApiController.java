package com.example.restapi_member.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.restapi_member.entity.Member;
import com.example.restapi_member.service.MemberService;

@RestController
@RequestMapping("/api/members")
public class MemberRestApiController {
	
	@Autowired
	private MemberService memService;
	
	@PostMapping
	public String registMember(Member member) {
		memService.saveMember(member);
		return "index";
	}
	
	@GetMapping
	public List<Member> memberList() {
		return memService.findAllMember();
	}
	
	@GetMapping("/{mno}")
	public Member memDetail(@PathVariable("mno") Long mno) {
		Optional<Member> member = memService.findByIdMember(mno);
		System.out.println("member : " + member);
		System.out.println("mno" + mno);
		if(member.isPresent()) {
			System.out.println("memberget = " +member.get());
			Member member2 = new Member();
			member2.setUsername(member.get().getUsername());
			member2.setAddr(member.get().getAddr());
			member2.setEmail(member.get().getEmail());
			member2.setMno(member.get().getMno());
			member2.setPassword(member.get().getPassword());
			member2.setName(member.get().getName());
			System.out.println("member2 : "+member2);
			return member2;
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Member not found");
		}
	}
	
	
	
	
	
	
	
	
	
	
}
