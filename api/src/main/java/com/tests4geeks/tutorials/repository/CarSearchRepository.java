package com.tests4geeks.tutorials.repository;

import java.util.*;

import com.fasterxml.jackson.databind.deser.DataFormatReaders;
import com.fasterxml.jackson.databind.util.ISO8601DateFormat;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.tests4geeks.tutorials.model.VehicleDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.tests4geeks.tutorials.model.Car;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

@Repository
public class CarSearchRepository {

	@Autowired
	MongoTemplate mongoTemplate;
	
	public Collection<Car> searchCars(String text) {
		return mongoTemplate.find(query(new Criteria()
						.orOperator(where("description").regex(text, "i"),
									where("make").regex(text, "i"),
									where("model").regex(text, "i"))
						), Car.class);
	}


	public void checkIfVinExist(List<VehicleDetail> vehiList) {
		System.out.println("inside checkIfVinExist");
		for (VehicleDetail vehicl : vehiList) {
			Query query = new Query(Criteria.where("vin").is(vehicl.getVin()));
			DBObject dbDoc = new BasicDBObject();
			mongoTemplate.getConverter().write(vehicl, dbDoc); //it is the one spring use for convertions.
			Update update = Update.fromDBObject(dbDoc);
			mongoTemplate.upsert(query, update, vehicl.getClass());
			//Query q = new Query();
			//q.addCriteria(Criteria.where("vin").is(vehicl.getVin()));
			//VehicleDetail vehicl2 = mongoTemplate.findOne(q, VehicleDetail.class);
			System.out.println("query - " + query.toString());
			System.out.println("Vehicle record  - " + vehicl.getVin());
		}

	}
	public Car findByVin(Car car){
		System.out.println("Car find by vin");
		Query query = new Query();
		query.addCriteria(Criteria.where("vin").is(car.getVin()));
		VehicleDetail VD = mongoTemplate.findOne(query, VehicleDetail.class);

		if(null == VD) {
            car.setEngineRpmAlert("NOTHING");
            car.setFuelVolumeAlert("NOTHING");
            car.setTirePressureAlert("NOTHING");

            return car;
        } else{
            //System.out.println("query - " + query.toString());
            //System.out.println("Vehicle record  - " + VD.getVin() + " Vehicle Engine RPM reading " + VD.getRedlineRpm() + "Vehicle MaxFuelVolume " + VD.getMaxFuelVolume());
            if (car.getEngineRpm() > VD.getRedlineRpm()) {
                car.setEngineRpmAlert("HIGH");
            } else {
                car.setEngineRpmAlert("NOTHING");
            }
            double checkEngineFuel = 0.1 * VD.getMaxFuelVolume();
            if (car.getFuelVolume() < checkEngineFuel) {
                car.setFuelVolumeAlert("MEDIUM");
            } else {
                car.setFuelVolumeAlert("NOTHING");
            }
            int frntLeft = Integer.parseInt(car.getTires().getFrontLeft());
            int frntRight = Integer.parseInt(car.getTires().getFrontRight());
            int rearLeft = Integer.parseInt(car.getTires().getRearLeft());
            int rearRight = Integer.parseInt(car.getTires().getRearRight());
            boolean generated = checkAllTirePressure(frntLeft, frntRight, rearLeft, rearRight);
            car.setTirePressureAlert("LOW");
            return car;
        }
	}


	public static boolean isBetween(int value, int min, int max)
	{
		return((value < min) || (value > max));
	}


	public static boolean checkAllTirePressure(int frntLeft,int frntRight,int rearLeft,int rearRight)
	{
	    HashMap<String,Boolean> storingData = new HashMap<String,Boolean>();
        boolean chkFL = isBetween(frntLeft,32,36);
        storingData.put("frntLeft" , chkFL);
        boolean chkFR = isBetween(frntRight,32,36);
        storingData.put("frntRight" , chkFR);
        boolean chkRL = isBetween(rearLeft,32,36);
        storingData.put("rearLeft" , chkRL);
        boolean chkRR = isBetween(rearRight,32,36);
        storingData.put("rearRight" , chkRR);


        if(storingData.containsValue(false)) {
            return false;
        }
        return true;


    }


    public static Date MillisToDateTime(final long milliseconds) {
        if (milliseconds < 1) {
            return null;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(milliseconds);
        return calendar.getTime();
    }
}
