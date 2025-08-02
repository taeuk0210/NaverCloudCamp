package com.myedu.myapp.hr.dao;

import java.util.List;


import com.myedu.myapp.hr.model.DeptVO;

public interface IDeptRepository {

	public List<DeptVO> getAllDeptInfo();

	public int insertDept(DeptVO dept);

	public int updateDept(DeptVO dept);
	
	public int deleteDept(DeptVO dept);
}
