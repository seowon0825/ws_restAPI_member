package com.example.restapi_member.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.restapi_member.entity.Member;
import com.example.restapi_member.repository.IMemberRepository;


@Service
public class MemberService {
	
	@Autowired
	private IMemberRepository memRepository;
	
	public List<Member> findAllMember(){
		return memRepository.findAll();
	}
	
	public Optional<Member> findByIdMember(Long mno){
		return memRepository.findById(mno);
	}
	
	public Member saveMember(Member member) {
		return memRepository.save(member);
	}
	
	public void deleteMember(Long mno) {
		memRepository.deleteById(mno);
	}
	
	

}
