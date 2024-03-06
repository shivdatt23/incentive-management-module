package com.org.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.org.dto.HolidayPackage;

@Repository
public class HolidayPackageDao {

	public HolidayPackage addHoliday(HolidayPackage holidayPackage) {
		EntityManager em = Persistence.createEntityManagerFactory("shivdatt").createEntityManager();
		
		EntityTransaction et = em.getTransaction();
		
		
		
		et.begin();
		em.persist(holidayPackage);
		et.commit();
		
		return holidayPackage;
	}
	
	
	public List<HolidayPackage> fetchAll() {
		EntityManager em = Persistence.createEntityManagerFactory("shivdatt").createEntityManager();
		Query query = em.createQuery("select s from HolidayPackage s");
		List<HolidayPackage> list = query.getResultList();
		
		return list;
	}
	
	
	public HolidayPackage fetchById(int id) {
		EntityManager em = Persistence.createEntityManagerFactory("shivdatt").createEntityManager();
		Query query = em.createQuery("select s from HolidayPackage s where id=?1").setParameter(1, id);
		List<HolidayPackage> list = query.getResultList();
		HolidayPackage hpe = list.get(0);
		return hpe;
	}
	
	
	
	
	
	
//	public HolidayPackage deleteHoliday(int id) {
//		EntityManager em = Persistence.createEntityManagerFactory("shivdatt").createEntityManager();
//		
//		EntityTransaction et = em.getTransaction();
//		
//		et.begin();
//		em.persist(holidayPackage);
//		et.commit();
//		
//		return holidayPackage;
//	}
//	
//	
//	public HolidayPackage updateHoliday(HolidayPackage holidayPackage) {
//		EntityManager em = Persistence.createEntityManagerFactory("shivdatt").createEntityManager();
//		
//		EntityTransaction et = em.getTransaction();
//		
//		et.begin();
//		em.merge(holidayPackage);
//		et.commit();
//		
//		return holidayPackage;
//	}
//	
	
	
}
