package com.example.restapi_member.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.restapi_member.entity.Member;

public interface IMemberRepository extends JpaRepository<Member, Long>{

}
