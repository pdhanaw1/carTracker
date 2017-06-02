package com.tests4geeks.tutorials.controllers;

import com.mongodb.BasicDBObject;
import com.mongodb.BulkWriteOperation;
import com.mongodb.DBCollection;
import com.tests4geeks.tutorials.model.VehicleDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.tests4geeks.tutorials.model.Car;
import com.tests4geeks.tutorials.repository.CarMongoRepository;
import com.tests4geeks.tutorials.repository.CarSearchRepository;

import java.util.Iterator;
import java.util.List;


//@CrossOrigin(origins="http://mocker.egen.io" ,maxAge = 3600)
@RestController
public class CarController {

	@Autowired
	CarMongoRepository carRepository;

	@Autowired
	CarSearchRepository searchRepository;

	@RequestMapping(value= "/readings", method=RequestMethod.POST, consumes="application/json",produces="application/json")
	public @ResponseBody Car home(@RequestBody Car car) {
		Car carSet = searchRepository.findByVin(car);
		//System.out.println(carSet.getEngineRpmAlert());
		//System.out.println(carSet.getFuelVolumeAlert());
		carRepository.save(carSet);
		return carSet;
	}
	

	@RequestMapping(method = RequestMethod.PUT, value = "/vehicles",consumes="application/json",produces="application/json")
	public @ResponseBody List<VehicleDetail> displayVehicles(@RequestBody List<VehicleDetail> vehicleDetail) {
		System.out.println("Vehicle Size " +  vehicleDetail.size());
		searchRepository.checkIfVinExist(vehicleDetail);
		return vehicleDetail;
	}
	
}
