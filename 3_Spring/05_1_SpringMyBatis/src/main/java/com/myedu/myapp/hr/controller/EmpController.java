package com.myedu.myapp.hr.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.myedu.myapp.hr.model.EmpVO;
import com.myedu.myapp.hr.service.IEmpService;

@Controller
public class EmpController {
	
	@Autowired
	IEmpService empService;
	
	@GetMapping(value="/hr/count")
	public String empCount(
			@RequestParam(value="deptid", required=false, defaultValue="0")int deptid,
			Model model) {
		if (deptid==0) {
			model.addAttribute("count", empService.getEmpCount());
		} else {
			model.addAttribute("count", empService.getEmpCount(deptid));
		}
		return "hr/count";
	}
	
	@GetMapping({"/hr", "/hr/list"})
	public String getAllEmps(Model model) {
		List<EmpVO> empList = empService.getEmpList();
		model.addAttribute("empList", empList);
		return "hr/list";
	}
	
	@GetMapping("/hr/{employeeId}")
	public String getEmpInfo(@PathVariable int employeeId, Model model) {
		EmpVO emp = empService.getEmpInfo(employeeId);
		model.addAttribute("emp", emp);
		return "hr/view";
	}
	
	@GetMapping("/hr/insert")
	public String insertEmp(Model model) {
		model.addAttribute("deptList", empService.getAllDeptId());
		model.addAttribute("jobList", empService.getAllJobId());
		model.addAttribute("managerList", empService.getAllManagerId());
		return "hr/insertform";
	}
	
	@PostMapping("/hr/insert")
	public String insertEmp(EmpVO emp, Model model) {
		try { 
			empService.insertEmp(emp);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/hr";
	}
	
	@GetMapping("hr/update")
	public String updateEmp(int empid, Model model) {
		model.addAttribute("emp", empService.getEmpInfo(empid));
		model.addAttribute("deptList", empService.getAllDeptId());
		model.addAttribute("jobList", empService.getAllJobId());
		model.addAttribute("managerList", empService.getAllManagerId());
		return "hr/updateform";
	}
	
	@PostMapping("/hr/update")
	public String updateEmp(EmpVO emp, Model model) {
		try { 
			empService.updateEmp(emp);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "redirect:/hr/"+emp.getEmployeeId();
	}
	
	@GetMapping("/hr/delete")
	public String deleteEmp(int empid, Model model) {
		model.addAttribute("emp", empService.getEmpInfo(empid));
		return "hr/deleteform";
	}
	
	@PostMapping("/hr/delete")
	public String deleteEmp(int empid, String email, Model model) {
		try { 
			empService.deleteEmp(empid, email);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "redirect:/hr";
	}
	
	@ExceptionHandler({RuntimeException.class})
	public ModelAndView runtimeException(HttpServletRequest request, Exception ex) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("uri", request.getRequestURI());
		mav.addObject("exception", ex);
		mav.setViewName("error/runtime");
		return mav;
	}
	
	@GetMapping("/hr/json")
	public @ResponseBody List<EmpVO> getEmpJSONList() {
		List<EmpVO> empList = empService.getEmpList();
		return empList;
	}
	
	@GetMapping("/hr/json/{employeeId}")
	public @ResponseBody EmpVO getEmpJSONInfo(@PathVariable int employeeId) {
		EmpVO emp = empService.getEmpInfo(employeeId);
		return emp;
	}
	
	@GetMapping("/hr/ajax")
	public @ResponseBody EmpVO getEmpJSONInfo(@RequestBody List<Map<String, Object>> datas) {
		Map<String, Object> data = datas.get(0);
		int employeeId = Integer.parseInt((String)data.get("value"));
		EmpVO emp = empService.getEmpInfo(employeeId);
		return emp;
	}
	
	
}
