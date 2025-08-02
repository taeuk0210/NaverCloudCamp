package com.myedu.myapp.hr;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.myedu.myapp.hr.model.EmpVO;
import com.myedu.myapp.hr.service.IEmpService;

public class EmpMain {

	public static void main(String[] args) {
		AbstractApplicationContext context = 
				new GenericXmlApplicationContext("spring/application-config.xml");
		IEmpService empService = context.getBean("empService", IEmpService.class);
		
		
		System.out.print("-- 전체 사원의 수 조회 : ");
		System.out.println(empService.getEmpCount());
		System.out.print("-- 부서가 50인 사원의 수 조회 : ");
		System.out.println(empService.getEmpCount(50));
		
		System.out.println("-- 103번 사원의 정보 조회 : ");
		System.out.println(empService.getEmpInfo(103));
		
		System.out.println("-- 사원 전체 정보 조회 : ");
		System.out.println(empService.getEmpList());
		
		System.out.print("-- 신규 사원 정보 입력 : ");
		EmpVO emp = new EmpVO();
		emp.setEmployeeId(210);
		emp.setFirstName("taeuk");
		emp.setLastName("kang");
		emp.setEmail("naver");
		emp.setPhoneNumber("222-222");
//		emp.getHireDate();
		emp.setJobId("IT_PROG");
		emp.setSalary(8000);		
		emp.setCommissionPct(0.2);
		emp.setManagerId(100);
		emp.setDepartmentId(10);
		try {
			empService.deleteEmp(210, "naver");
			empService.insertEmp(emp);
			System.out.println("입력 완료");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("-- 신규 사원 정보 조회 : ");
		System.out.println(empService.getEmpInfo(210));
		
		System.out.println("-- 모든 부서 정보 조회 : ");
		empService.getAllDeptId().stream().forEach(System.out::println);
		
		System.out.println("-- 모든 직무 정보 조회 : ");
		empService.getAllJobId().stream().forEach(System.out::println);
		
		System.out.println
		("-- 모든 팀장 정보 조회 : ");
		empService.getAllManagerId().stream().forEach(System.out::println);
		
		context.close();
	}

}
