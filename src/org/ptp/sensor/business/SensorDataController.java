package org.ptp.sensor.business;

import java.awt.Point;

import org.ptp.sensor.model.Sensor;

public class SensorDataController {
	
	 private SensorManager sensorManager;

	public SensorDataController(SensorManager sm) {
		this.sensorManager = sm;
	}
	
	
	public void initSensor(Point sensorLocation, double bearing) {
		
		if(sensorManager.getSensor() == null) {
			sensorManager.setSensor(new Sensor(sensorLocation,bearing));
			sensorManager.getSensor().setActive(true);
		}else {
			sensorManager.setSensor(new Sensor(sensorManager.getSensor().getId(),sensorLocation,bearing));
			sensorManager.getSensor().setActive(true);
		}
		
	}

}
