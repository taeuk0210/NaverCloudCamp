<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>사원 정보 수정</h1>
	<form action="/hr/update" method="post">
		<table border="1">
			<tr>
				<th>EMPLOYEE_ID</th>
				<td><input type="number" name="employeeId"  value="${emp.employeeId }" readonly/></td>
			</tr>
			<tr>
				<th>FIRST_NAME</th>
				<td><input type="text" name="firstName" value="${emp.firstName }" required/></td>
			</tr>
			<tr>
				<th>LAST_NAME</th>
				<td><input type="text" name="lastName" value="${emp.lastName }" required/></td>
			</tr>
			<tr>
				<th>EMAIL</th>
				<td><input type="text" name="email" value="${emp.email }" required/></td>
			</tr>
			<tr>
				<th>PHONE_NUMBER</th>
				<td><input type="text" name="phoneNumber" value="${emp.phoneNumber }" required/></td>
			</tr>
			<tr>
				<th>HIRE_DATE</th>
				<td><input type="date" name="hireDate" value="${emp.hireDate }" required/></td>
			</tr>
			<tr>
				<th>JOB_ID</th>
				<td>
					<select name="jobId">
						<c:forEach var="job" items="${jobList }">
							<c:if test="${emp.jobId==job.jobId }">
								<option value="${job.jobId }" selected >${job.title }</option>
							</c:if>
							<c:if test="${emp.jobId!=job.jobId }">
								<option value="${job.jobId }">${job.title }</option>
							</c:if>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<th>SALARY</th>
				<td><input type="number" name="salary" value="${emp.salary }" required/></td>
			</tr>
			<tr>
				<th>COMMISSION_PCT</th>
				<td><input type="number" name="commissionPct" step="0.1" min="0" max="0.99" value="${emp.commissionPct }"/></td>
			</tr>
			<tr>
				<th>MANAGER_ID</th>
				<td>
					<select name="managerId">
						<c:forEach var="manager" items="${managerList }">
							<c:if test="${emp.managerId==manager.managerId }">
								<option value="${manager.managerId }" selected >${manager.firstName }</option>
							</c:if>
							<c:if test="${emp.managerId!=manager.managerId }">
								<option value="${manager.managerId }" >${manager.firstName }</option>
							</c:if>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<th>DEPARTMENT_ID</th>
				<td>
					<select name="departmentId">
						<c:forEach var="department" items="${deptList }">
							<c:if test="${emp.departmentId==department.departmentId }">
								<option value="${department.departmentId }" selected >${department.departmentName }</option>
							</c:if>
							<c:if test="${emp.departmentId!=department.departmentId }">
								<option value="${department.departmentId }" >${department.departmentName }</option>
							</c:if>
						</c:forEach>
					</select>
				</td>
			</tr>
			<tr>
				<th>&nbsp;</th>
				<td>
					<input type="submit" value="저장"/>
					<input type="reset" value="취소"/>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>