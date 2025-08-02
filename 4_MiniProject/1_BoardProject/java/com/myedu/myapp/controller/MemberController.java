package com.myedu.myapp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.myedu.myapp.model.MemberVO;
import com.myedu.myapp.service.IMemberService;

@Controller
public class MemberController {
	
	@Autowired
	IMemberService memberService;
	
	@GetMapping("/member/login")
	public String memberLogin() {
		return "/member/memberLogin";
	}
	
	@GetMapping("/member/join")
	public String memberJoin() {
		return "/member/memberJoin";
	}
		
	@GetMapping("/member/search")
	public String memberSearch() {
		return "/member/memberSearch";
	}
	
	@PostMapping("/member/login")
	public String memberLogin(@RequestParam("id")String id, @RequestParam("pw")String pw, HttpServletRequest request) {
		HttpSession session = request.getSession();
		int check = memberService.userCheck(id, pw);
		if (check==1) {
			session.setAttribute("userId", id);
			session.setAttribute("userName", memberService.getName(id));
			session.setAttribute("isLoggedIn", true); // 예시로 로그인 상태를 저장
			request.setAttribute("check", check);
			return "/member/memberLoginOk";
		}
		return "/member/memberLogin";
	}
	
	@GetMapping("/member/logout")
	public String memberLogout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.invalidate();
		return "/main/main";
	}
	
	@GetMapping("/member/pwcheck")
	public String memberPwCheck() {
		return "/member/memberPWCheck";
	}
	
	@PostMapping("/member/pwcheck")
	public String memberPwCheck(HttpServletRequest request, @RequestParam("pw")String pw, RedirectAttributes redirectAttributes) {
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("userId");
		String dpPw = memberService.getPw(id);
		int pwCheck;
		
		if(pw=="") {
			pwCheck = -1;
			redirectAttributes.addFlashAttribute("pwCheck", pwCheck); 
			return "redirect:/member/pwcheck";
		} else if(pw.equals(dpPw)) {
			request.setAttribute("dto", memberService.getMember(id));
			return "/member/memberEdit";
		} else {
			pwCheck = 0;
			request.setAttribute("pwCheck", pwCheck);
			return "redirect:/member/pwcheck";
		}
	}
	
	@GetMapping("/member/main")
	public String memberMain(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("userId");

        if (id != null) {
        	request.setAttribute("dto", memberService.getMember(id));
        	return "/member/memberMain";
        }
		return "redirect:/member/memberLoginOk";
	}
	
	@PostMapping("/member/update")
	public String memberUpdate(MemberVO member) {
		try {
			System.out.println(member.getName());
			memberService.updateMember(member);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/member/main";
	}
	
	@PostMapping("/member/doublecheck")
	public String memberDoubleCheck(@RequestParam("id")String id, HttpServletRequest request) {
		int check = memberService.confirmId(id);
		if(id.length()<4) {
			check=2;
		}
		request.setAttribute("check", check);
		request.setAttribute("inputId", request.getParameter("id"));
		request.setAttribute("inputName", request.getParameter("name"));
		request.setAttribute("inputPW", request.getParameter("pw"));
		request.setAttribute("inputCfmPW", request.getParameter("cfm-pw"));
		request.setAttribute("inputEmail", request.getParameter("email"));
		request.setAttribute("inputPhone", request.getParameter("phone"));
		request.setAttribute("inputAddr", request.getParameter("address"));
		return "/member/memberJoin";
	}
	
	@PostMapping("/member/join")
	public String memberJoin(MemberVO member) {
		try {
			memberService.insertMember(member);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/member/login";
	}
	
	@PostMapping("/member/joinBuffer")
	public String memberJoinBuffer(HttpServletRequest request) {
		request.setAttribute("inputId", request.getParameter("id"));
		request.setAttribute("inputName", request.getParameter("name"));
		request.setAttribute("inputPW", request.getParameter("pw"));
		request.setAttribute("inputCfmPW", request.getParameter("cfm-pw"));
		request.setAttribute("inputEmail", request.getParameter("email"));
		request.setAttribute("inputPhone", request.getParameter("phone"));
		request.setAttribute("inputAddr", request.getParameter("address"));
		return "/member/memberJoin";
	}
	
	@PostMapping("/member/delete")
	public String memberDelete(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String id =(String) session.getAttribute("userId");
		session.invalidate();
		try {
			memberService.deleteMember(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/";
	}
	
	@PostMapping("/member/search")
	public String memberSearch(HttpServletRequest request) {
		String result=null;
		String formName = request.getParameter("formName");
		if (formName.equals("id")) {
			String name=request.getParameter("name");
			String phoneNum=request.getParameter("phoneNum");
			result = memberService.searchID(name, phoneNum);
		} else if (formName.equals("pw")) {
			String id=request.getParameter("id");
			String name=request.getParameter("name");
			String phoneNum=request.getParameter("phoneNum");
			result = memberService.searchPW(id, name, phoneNum);
		}
		
		request.setAttribute("result", result);
		return "/member/memberIDPWResult";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
