package com.org.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.org.dto.Employee;

@Repository
public class EmployeeDao {

	public Employee saveEmployee(Employee employee) {
		// TODO Auto-generated method stub
		EntityManager em = Persistence.createEntityManagerFactory("shivdatt").createEntityManager();
		
		EntityTransaction et = em.getTransaction();
		
		//incentive calculation logic
		
		
		
		
		
		
		et.begin();
		em.persist(employee);
		et.commit();
		
		return employee;
	}

	public Employee verifyUser(String email, String password) {
		// TODO Auto-generated method stub
		EntityManager em = Persistence.createEntityManagerFactory("shivdatt").createEntityManager();
		Query query = em.createQuery("select s from Employee s where email=?1 and password=?2").setParameter(1, email).setParameter(2, password);
		
		List<Employee> list = query.getResultList();
		if(list==null) return null;
		Employee employee = list.get(0);
		
		return employee;
		
	}
	
	
	public List<Employee> fetchAll(){
		
		EntityManager em = Persistence.createEntityManagerFactory("shivdatt").createEntityManager();
		Query query = em.createQuery("select s from Employee s");
		
		List<Employee> list = query.getResultList();
		
		return list;
	}
	
	
	
	public Employee fetchUserById(int id) {
		EntityManager em = Persistence.createEntityManagerFactory("shivdatt").createEntityManager();
		Query query = em.createQuery("select s from Employee s where id=?1").setParameter(1, id);
		List<Employee> list = query.getResultList();
		Employee employee = list.get(0);
		return employee;
		
		
	}
	
	public Employee updateUser(Employee employee) {
		
		EntityManager em = Persistence.createEntityManagerFactory("shivdatt").createEntityManager();
		
		System.out.print(employee.getIncentivePercentage());
		
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		Employee emp = em.merge(employee);
		et.commit();
		
		return emp;
	}
	
	
	public void deleteUser(int id) {
		EntityManager em = Persistence.createEntityManagerFactory("shivdatt").createEntityManager();
		Query query = em.createQuery("delete from Employee e where e.id=?1").setParameter(1, id);
		
		EntityTransaction et = em.getTransaction();
		
		Employee employee = fetchUserById(id);
		
		
		et.begin();
		query.executeUpdate();
		//em.remove(employee);
		et.commit();
		
		System.out.print("deleted successfully");
		
		
	}
	
	
public Employee addUser(Employee employee) {
		
		EntityManager em = Persistence.createEntityManagerFactory("shivdatt").createEntityManager();
		
		System.out.print(employee.getIncentivePercentage());
		int sales=employee.getTotalSales();
		if(sales>=10000) {
			if(sales<20000) {
					employee.setIncentivePercentage(1.5);
			
			}else if(sales<30000) {
				employee.setIncentivePercentage(3.0);
			}else if(sales<50000) {
				employee.setIncentivePercentage(3.5);
				employee.setBonus(1000);
			}else {
				employee.setIncentivePercentage(5.0);
				employee.setHpe("Yes");
				}
		}
		
		
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		Employee emp = em.merge(employee);
		et.commit();
		
		return emp;
	}
	
	
	
	

	
}
