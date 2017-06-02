package com.tests4geeks.tutorials.model;

import com.sun.istack.internal.Nullable;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Document(collection = "cars")
public class Car {

	private String vin;
	private Float latitude;
	private Float longitude;
	private Date timestamp;
	private Integer fuelVolume;
	private Integer speed;
	private Integer engineHp;
	private boolean checkEngineLightOn;
	private boolean engineCoolantLow;
	private boolean cruiseControlOn;
	private Integer engineRpm;
	private Tires tires;
	private String engineRpmAlert;
	private String fuelVolumeAlert;

	private String tirePressureAlert;

	public String getEngineRpmAlert() {
		return engineRpmAlert;
	}

	public void setEngineRpmAlert(String engineRpmAlert) {
		this.engineRpmAlert = engineRpmAlert;
	}

	public String getFuelVolumeAlert() {
		return fuelVolumeAlert;
	}

	public void setFuelVolumeAlert(String fuelVolumeAlert) {
		this.fuelVolumeAlert = fuelVolumeAlert;
	}

	public String getTirePressureAlert() {
		return tirePressureAlert;
	}

	public void setTirePressureAlert(String tirePressureAlert) {
		this.tirePressureAlert = tirePressureAlert;
	}

	public void setTires(Tires tires) {
		this.tires = tires;
	}

	public Tires getTires() {
		return tires;
	}

	public String getVin() {
		return vin;
	}

	public void setVin(String vin) {
		this.vin = vin;
	}


	public Integer getFuelVolume() {
		return fuelVolume;
	}

	public void setFuelVolume(Integer fuelVolume) {
		this.fuelVolume = fuelVolume;
	}

	public Integer getSpeed() {
		return speed;
	}

	public void setSpeed(Integer speed) {
		this.speed = speed;
	}

	public Integer getEngineHp() {
		return engineHp;
	}

	public void setEngineHp(Integer engineHp) {
		this.engineHp = engineHp;
	}


	public Integer getEngineRpm() {
		return engineRpm;
	}

	public void setEngineRpm(Integer engineRpm) {
		this.engineRpm = engineRpm;
	}


	public Float getLatitude() {
		return latitude;
	}

	public void setLatitude(Float latitude) {
		this.latitude = latitude;
	}

	public Float getLongitude() {
		return longitude;
	}

	public void setLongitude(Float longitude) {
		this.longitude = longitude;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public boolean isCheckEngineLightOn() {
		return checkEngineLightOn;
	}

	public void setCheckEngineLightOn(boolean checkEngineLightOn) {
		this.checkEngineLightOn = checkEngineLightOn;
	}

	public boolean isEngineCoolantLow() {
		return engineCoolantLow;
	}

	public void setEngineCoolantLow(boolean engineCoolantLow) {
		this.engineCoolantLow = engineCoolantLow;
	}

	public boolean isCruiseControlOn() {
		return cruiseControlOn;
	}

	public void setCruiseControlOn(boolean cruiseControlOn) {
		this.cruiseControlOn = cruiseControlOn;
	}

	@Override
	public String toString() {
		return "Car{" +
				"vin='" + vin + '\'' +
				", latitude=" + latitude +
				", longitude=" + longitude +
				", timestamp=" + timestamp +
				", fuelVolume=" + fuelVolume +
				", speed=" + speed +
				", engineHp=" + engineHp +
				", checkEngineLightOn=" + checkEngineLightOn +
				", engineCoolantLow=" + engineCoolantLow +
				", cruiseControlOn=" + cruiseControlOn +
				", engineRpm=" + engineRpm +
				", tires=" + tires +
				", engineRpmAlert='" + engineRpmAlert + '\'' +
				", fuelVolumeAlert='" + fuelVolumeAlert + '\'' +
				", tirePressureAlert='" + tirePressureAlert + '\'' +
				'}';
	}
}
