package com.tka.DatabaseDemo2.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tka.DatabaseDemo2.entity.Country;
import com.tka.DatabaseDemo2.entity.Employee;

@Repository
public class EmployeeDao<msg, user> {

	@Autowired
	SessionFactory factory;
	private Employee employee;

	public String addRecord(Employee employee) {
		Session session = null;
		Transaction tx = null;
		String msg = null;

		try {

			session = factory.openSession();
			tx = session.beginTransaction();
			session.persist(employee);
			tx.commit();
			msg = "Employee Added Successfully...";

		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return msg;
	}

	public String updateRecord(Employee employee, int id) {
		Session session = null;
		Transaction tx = null;
		String msg = null;

		try {

			session = factory.openSession();
			tx = session.beginTransaction();
			Employee e1 = session.get(Employee.class, id);
			e1.setName(employee.getName());
			e1.setEmailId(employee.getEmailId());
			e1.setMobileNo(employee.getMobileNo());
			e1.setSalary(employee.getSalary());
			session.merge(e1);
			tx.commit();
			msg = "Employee Updated Successfully...";

		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return msg;
	}

	public String deleteRecord(int id) {
		Session session = null;
		Transaction tx = null;
		String msg = null;

		try {

			session = factory.openSession();
			tx = session.beginTransaction();
			Employee e1 = session.get(Employee.class, id);

			session.remove(e1);
			tx.commit();
			msg = "Employee Deleted Successfully...";

		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return msg;
	}

	public List<Employee> getAllRecord() {
		Session session = null;
		Transaction tx = null;
		List<Employee> list=null;

		try {

			session = factory.openSession();
			tx = session.beginTransaction();
			String hqlQuery = "from Employee";
			
			Query<Employee> query = session.createQuery(hqlQuery, Employee.class);
			list = query.list();
			tx.commit();
			

		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return list;
	}

	public Employee getById(int id) {
		Session session = null;
		Transaction tx = null;
		Employee employee=null;

		try {

			session = factory.openSession();
			tx = session.beginTransaction();
			employee= session.get(Employee.class, id);
			tx.commit();
			

		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return employee;
	}

	public Employee userLogin(Employee employee) {
		Session session = null;
		Transaction tx = null;
		Employee emp1=null;
		

		try {

			session = factory.openSession();
			tx = session.beginTransaction();
			String hqlQuery = "from Employee where emailId=:emailId and mobileNo=:mobileNo";
			
			Query<Employee> query = session.createQuery(hqlQuery, Employee.class);
			query.setParameter("emailId", employee.getEmailId());
			query.setParameter("mobileNo", employee.getMobileNo());
			emp1 = query.uniqueResult();
			tx.commit();
			

		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return emp1;
		
	}

	public List<Employee> getBySalaryRange(double salary1, double salary2) {
		Session session = null;
		Transaction tx = null;
		List<Employee> list=null;

		try {

			session = factory.openSession();
			tx = session.beginTransaction();
			String hqlQuery = "from Employee where salary between :salary1 and :salary2";
			
			Query<Employee> query = session.createQuery(hqlQuery, Employee.class);
			query.setParameter("salary1", salary1);
			query.setParameter("salary2", salary2);
			list = query.list();
			tx.commit();
			

		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return list;
	}

	public List<Employee> getByStatus(String status) {
		Session session = null;
		Transaction tx = null;
		List<Employee> list=null;

		try {

			session = factory.openSession();
			tx = session.beginTransaction();
			String hqlQuery = "from Employee where status=:status";
			
			Query<Employee> query = session.createQuery(hqlQuery, Employee.class);
			query.setParameter("status", status);
			
			list = query.list();
			tx.commit();
			

		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return list;
	}

	public Employee updateByStatus(int id) {
		Session session = null;
		Transaction tx = null;
		Employee e1 = null;
		
		

		try {

			session = factory.openSession();
			tx = session.beginTransaction();
			e1 = session.get(Employee.class, id);
			
			if (e1.getStatus().equals("active")) {
				e1.setStatus("inactive");
			}else if (e1.getStatus().equals("inactive")) {
				e1.setStatus("active");
			}
			else if (e1.getStatus().equals("suspend")) {
				e1.setStatus("suspend");
			}
			
			session.merge(e1);
			
			tx.commit();
			

		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return e1;
	}

	

}
