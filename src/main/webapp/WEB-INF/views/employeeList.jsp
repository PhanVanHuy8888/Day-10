<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Employee List</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
    <jsp:include page="_header.jsp"></jsp:include>
    <jsp:include page="_navTop.jsp"></jsp:include>
    
    <section class="container">
        <h3>Employee List</h3>
        <a href="employeeCreate" class="btn btn-primary">Create Employee</a>
        <p style="color: red;">${requestScope.errorString}</p>
        <table class="table table-bordered">
            <thead style="background: #f1f1f1;">
                <tr>
                    <th>Name</th>
                    <th>Emp_No</th>
                    <th>Job</th>
                    <th>Salary</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${employeeList}" var="employee">
                    <tr>
                        <td>${employee.EmpName}</td>
                        <td>${employee.EmpNo}</td>
                        <td>${employee.Job}</td>
                        <td>${employee.Salary}</td>
                        <td>
                            <a href="employeeEdit?EmpId=${employee.EmpId}" class="btn btn-success">Edit</a>
                            <a href="employeeDelete?EmpId=${employee.EmpId}" class="btn btn-danger">Delete</a>
                        </td>                   
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </section>
    <jsp:include page="_footer.jsp"></jsp:include>
</body>
</html>
