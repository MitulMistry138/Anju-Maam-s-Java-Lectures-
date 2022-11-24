package com.employeemanagementdao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.employeemanagemententity.Employee;
import com.util.HibernateUtil;

public class EmployeeDao {

	/**
	 * Save Employeee
	 * 
	 * @param employee
	 */
	public void saveEmployee(Employee employee) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// save the employee object
			session.save(employee);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	/**
	 * Update Employee
	 * 
	 * @param instructor
	 */
	public void updateEmployee(Employee employee) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// save the employee object
			session.update(employee);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	/**
	 * Delete Employee
	 * 
	 * @param id
	 */
	public void deleteEmployee(int id) {

		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();

			// Delete a employeee object
			Employee employee = session.get(Employee.class, id);
			if (employee != null) {
				session.delete(employee);
				System.out.println("employee is deleted");
			}

			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	/**
	 * Get Employee By ID
	 * 
	 * @param id
	 * @return
	 */
	public Employee getEmployee(int id) {

		Transaction transaction = null;
		Employee employee = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// get an employee object
			employee = session.get(Employee.class, id);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return employee;
	}

	/**
	 * Get all Employee
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Employee> getAllEmployee() {

		Transaction transaction = null;
		List<Employee> listOfEmployee = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// get an employee object

			listOfEmployee = session.createQuery("from Employeee").getResultList();

			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return listOfEmployee;
	}
}
