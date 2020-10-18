package com.univ;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class CarRentalController {

	CarRepository carRepository;

	@Autowired
	public CarRentalController(CarRepository carRepository){
		this.carRepository = carRepository;
		Car ferrari = new Car();
		ferrari.setPlateNumber("11AA22");
		ferrari.setModel("Ferrari");
		ferrari.setPrice(1000);
		ferrari.setRented(false);
		carRepository.save(ferrari);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/cars")
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Iterable<Car> listOfCars(){
		return carRepository.findAll();
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping("/cars/{plateNumber}")
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Car rent(@PathVariable(name="plateNumber") String plateNumber, @RequestParam(name="louer", required=true) boolean louer) {
		Car car = carRepository.findByPlateNumber(plateNumber);
		car.setRented(louer);
		System.out.println(car);
		return car;
	}


}
