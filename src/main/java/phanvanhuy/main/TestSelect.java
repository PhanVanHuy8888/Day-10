package phanvanhuy.main;

import java.util.List;

import phanvanhuy.dao.EmployeeDaoImpl;
import phanvanhuy.entity.Employee;

public class TestSelect {
	public static void main(String[] args) {
		List<Employee> employeeList = new EmployeeDaoImpl().getAllEmployee();
		if(employeeList == null) 
			return;
		for(Employee item:employeeList) {
			System.out.printf("\n%-10s", item.getEmpId());
			System.out.printf("%-15s", item.getEmpName());
		
		}
	}
}
