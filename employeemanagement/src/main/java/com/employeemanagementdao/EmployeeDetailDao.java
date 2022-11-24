package com.employeemanagementdao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.employeemanagemententity.EmployeeDetail;
import com.util.HibernateUtil;

public class EmployeeDetailDao {

	public void saveEmployeeDetail(EmployeeDetail employeeDetail) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// save the employee object
			session.save(employeeDetail);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	public void updateEmployeeDetail(EmployeeDetail employeeDetail) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// save the employee object
			session.update(employeeDetail);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	public EmployeeDetail getEmployeeDetail(int id) {

		Transaction transaction = null;
		EmployeeDetail employee = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// get an employee object
			employee = session.get(EmployeeDetail.class, id);
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

	public void deleteEmployeeDetail(int id) {

		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();

			// Delete a instructor object
			EmployeeDetail employeedetail = session.get(EmployeeDetail.class, id);
			if (employeedetail != null) {
				session.delete(employeedetail);
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

	public double incrementEmployeeSalary(int id, double percent) {

		Transaction transaction = null;

		EmployeeDetail employee = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// get an employee object
			employee = session.get(EmployeeDetail.class, id);

			employee.setSalary(employee.getSalary() + (employee.getSalary() * percent / 100));

			session.update(employee);
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return employee.getSalary();
	}

}
