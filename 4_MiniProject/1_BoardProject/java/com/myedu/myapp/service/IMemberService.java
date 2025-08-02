package com.myedu.myapp.service;

import com.myedu.myapp.model.MemberVO;

public interface IMemberService {
    
	
	public int deleteMember(String id) ;
	public String getName(String id);
	public String getPw(String id);
	public int insertMember(MemberVO member);
	public int updateMember(MemberVO member);
	public int confirmId(String id);
	public int userCheck(String id, String pw);
	public String searchID(String name, String phoneNum);
	public String searchPW(String id, String name, String phoneNum);
	public MemberVO getMember(String id);
    
    
    
}
