package com.univ.web;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.univ.model.Car;
import com.univ.model.Person;
import com.univ.model.Rent;

@RestController
public class CarRentalController {
		
	EntityManager entityManager;
	
	public CarRentalController(){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("manager1");
		entityManager = emf.createEntityManager();
	}
	
	
	@RequestMapping(value = "/cars", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<Car> listOfCars(){
		return entityManager.createQuery("select c from Car c").getResultList();
	}
	
	@RequestMapping(value = "/cars/{plateNumber}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Car aCar(@PathVariable("plateNumber") String plateNumber) throws Exception{
		return (Car) entityManager.createQuery("select c from Car c where plateNumber like '" + plateNumber + "'").getSingleResult();
	}
	
	
	@RequestMapping(value = "/cars/{plateNumber}", method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	void rent(@PathVariable(name="plateNumber") String plateNumber, @RequestParam(name="louer", required=true) boolean louer) {
		EntityTransaction tx = entityManager.getTransaction();
		tx.begin();
		try {
			Car car = (Car) entityManager.createQuery("select c from Car c where c.plateNumber like :plateNumber").setParameter("plateNumber", plateNumber ).getSingleResult();
			List<Rent> rents = car.getRents();
			if(rents.size() == 0){
				Rent rent = new Rent();
				rents.add(rent);
				rent.setCar(car);
			} else {
				rents.remove(0);
			}
			entityManager.persist(car);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		
	}

}
