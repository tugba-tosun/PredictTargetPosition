package org.ptp.sensor.model;

public class SensorConfiguration {
	
	private Sensor sensor;
	
	public SensorConfiguration() {
		// TODO Auto-generated constructor stub
	}

	
	public SensorConfiguration(Sensor s) {
		this.setSensor(s);
	}


	public Sensor getSensor() {
		return sensor;
	}


	public void setSensor(Sensor sensor) {
		this.sensor = sensor;
	}
}
