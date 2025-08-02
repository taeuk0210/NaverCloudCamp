package com.myedu.myapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myedu.myapp.dao.IMemberRepository;
import com.myedu.myapp.model.MemberVO;

@Service
public class MemberService implements IMemberService {
    
	@Autowired
	IMemberRepository memberRepository;
	
	@Override
	public int deleteMember(String id) {
		return memberRepository.deleteMember(getMember(id));
	}
	
	@Override
	public String getName(String id) {
		return getMember(id).getName();
	}
	
	@Override
	public String getPw(String id) {
		return getMember(id).getPw();
	}
	
	@Override
	public int insertMember(MemberVO member) {
		return memberRepository.insertMember(member);
	}
	
	@Override
	public int updateMember(MemberVO member) {
		return memberRepository.updateMember(member);
	}
	
	@Override
	public int confirmId(String id) {
		return memberRepository.confirmId(id);
	}

	@Override
	public int userCheck(String id, String pw) {
		return memberRepository.userCheck(id, pw);
	}

	@Override
	public String searchID(String name, String phoneNum) {
		return memberRepository.searchID(name, phoneNum);
	}

	@Override
	public String searchPW(String id, String name, String phoneNum) {
		return memberRepository.searchPW(id, name, phoneNum);
	}

	@Override
	public MemberVO getMember(String id) {
		return memberRepository.getMember(id);
	}
	

    
    
    
}
