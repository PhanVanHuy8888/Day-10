package phanvanhuy.dao;

import java.util.List;
import org.hibernate.Session;
import phanvanhuy.entity.Employee;
import phanvanhuy.utils.HibernateUtils;

public class EmployeeDaoImpl implements EmployeDAO {

	@Override
	public List<Employee> getAllEmployee() {
		Session session = 
				HibernateUtils.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			List<Employee> list = session.createQuery("from Employee").list();
			session.getTransaction().commit();
			session.close();
			return list;
		}catch(Exception ex) {
			ex.printStackTrace();
			session.close();
		}
		return null;
	}

	@Override
	public Employee getEmployeeById(String id) {
		Session session = 
				HibernateUtils.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			Employee employee = (Employee)session.createQuery("from Employee where EmpId = :empId").setParameter("empId", id).uniqueResult();			
			session.getTransaction().commit();
			session.close();
			return employee;
		}catch(Exception ex) {
			ex.printStackTrace();
			session.close();
		}
		return null;
	}

	@Override
	public boolean insertEmployee(Employee employee) {
		Session session = 
				HibernateUtils.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			session.save(employee);
			session.getTransaction().commit();
			session.close();
			return true;
		}catch(Exception ex) {
			ex.printStackTrace();
			session.close();
		}
		return false;
	}

	@Override
	public boolean updateEmployee(Employee employee) {
		Session session = 
				HibernateUtils.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			session.update(employee);
			session.getTransaction().commit();
			session.close();
			return true;
		}catch(Exception ex) {
			ex.printStackTrace();
			session.close();
		}
		return false;
	}

	@Override
	public boolean deleteEmployee(String id) {
		Session session = 
				HibernateUtils.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			int res = session.createQuery("delete from Employee where EmpId = :empId").setParameter("empId", id).executeUpdate();
			session.getTransaction().commit();
			session.close();
			if(res > 0)
				return true;
		}catch(Exception ex) {
			ex.printStackTrace();
			session.close();
		}
		return false;
	}

}
