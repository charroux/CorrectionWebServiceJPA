package com.univ.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * Hello world!
 *
 */
public class Main 
{
    public static void main( String[] args )
    {
    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("manager1");
		EntityManager entityManager = emf.createEntityManager();
		
		EntityTransaction tx = entityManager.getTransaction();
		
    	try{
    		
			tx.begin();
			
			Car ferrari = new Car();
			ferrari.setPlateNumber(111);
			ferrari.setModel("Ferrari");
			ferrari.setPrice(1000);
			ferrari.setRented(true);
			
			Person person = new Person();
			person.setName("Tintin");
			
			Rent rent1 = new Rent();
			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			Date beginDate = dateFormat.parse("23/09/2017");
			rent1.setDate(beginDate);
			Date endDate = dateFormat.parse("23/10/2017");
			rent1.setDate(endDate);
			
			rent1.setPerson(person);
			
			ferrari.getRents().add(rent1);
			rent1.setCar(ferrari);
			
			Rent rent2 = new Rent();
			beginDate = dateFormat.parse("23/09/2017");
			rent2.setDate(beginDate);
			endDate = dateFormat.parse("23/10/2018");
			rent2.setDate(endDate);
				
			rent2.setPerson(person);
			
			ferrari.getRents().add(rent2);
			rent2.setCar(ferrari);
			
			person.getRents().add(rent1);
			person.getRents().add(rent2);
			
			entityManager.persist(ferrari);
			
			
			Car renault = new Car();
			renault.setPlateNumber(222);
			renault.setModel("Renault");
			renault.setPrice(500);
			renault.setRented(false);
			
			entityManager.persist(renault);
			
			
			tx.commit();			
		
		}catch(Exception e){
			e.printStackTrace();
			tx.rollback();
		}
		
	}
}
