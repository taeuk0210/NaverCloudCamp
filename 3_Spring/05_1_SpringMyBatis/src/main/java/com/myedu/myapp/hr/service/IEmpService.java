package com.myedu.myapp.hr.service;

import java.util.List;
import java.util.Map;

import com.myedu.myapp.hr.model.EmpVO;

public interface IEmpService {
	int getEmpCount();
	int getEmpCount(int deptId);
	List<EmpVO> getEmpList();
	EmpVO getEmpInfo(int empId);
	void updateEmp(EmpVO emp);
	void insertEmp(EmpVO emp);
	void deleteEmp(int empid, String email);
	List<Map<String, Object>> getAllDeptId();
	List<Map<String, Object>> getAllJobId();
	List<Map<String, Object>> getAllManagerId();
}
