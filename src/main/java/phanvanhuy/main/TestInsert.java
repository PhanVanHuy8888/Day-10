package phanvanhuy.main;


import java.math.BigInteger;

import phanvanhuy.dao.EmployeeDaoImpl;
import phanvanhuy.entity.Department;
import phanvanhuy.entity.Employee;


public class TestInsert {
	public static void main(String[] args) {
		Employee p = new Employee();
		p.setEmpId(BigInteger.valueOf(79797));
		p.setEmpName("Jone");
		Department department = new Department();
		p.setDepartment(department);
		boolean flag = new EmployeeDaoImpl().insertEmployee(p);
		if(flag == true) {
			System.out.printf("Thêm mới thành công !!!");
		}else {
			System.out.printf("Xảy ra lỗi khi thêm mới sản phẩm :))");
		}
	}
}
