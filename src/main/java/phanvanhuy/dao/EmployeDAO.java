package phanvanhuy.dao;

import java.util.List;
import phanvanhuy.entity.Employee;

public interface EmployeDAO {
	public List<Employee> getAllEmployee();
	public Employee getEmployeeById(String id);
	public boolean insertEmployee(Employee employee);
	public boolean updateEmployee(Employee employee);
	public boolean deleteEmployee(String id);
}
