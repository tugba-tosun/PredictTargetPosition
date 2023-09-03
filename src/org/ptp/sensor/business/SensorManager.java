package org.ptp.sensor.business;

import org.ptp.sensor.model.Sensor;
import org.ptp.utils.model.IExecutable;
import org.ptp.utils.model.messages.PTPMessage;

public class SensorManager implements IExecutable{
	
	private Sensor sensor = new Sensor();
	
	private SensorDataController sensorDataController = new SensorDataController(this);
	
	private SensorDataService<PTPMessage> senorDataService = new SensorDataService<>();
	
	private SensorEngine sensorEngine = new SensorEngine(this);
	

	public SensorManager() {
		// TODO Auto-generated constructor stub
	}



	public Sensor getSensor() {
		return sensor;
	}


	public void setSensor(Sensor sensor) {
		this.sensor = sensor;
	}


	public SensorDataController getSensorDataController() {
		return sensorDataController;
	}


	public void setSensorDataController(SensorDataController sensorDataController) {
		this.sensorDataController = sensorDataController;
	}


	public SensorDataService<PTPMessage> getSenorDataService() {
		return senorDataService;
	}


	public void setSenorDataService(SensorDataService<PTPMessage> senorDataService) {
		this.senorDataService = senorDataService;
	}


	public SensorEngine getSensorEngine() {
		return sensorEngine;
	}


	public void setSensorEngine(SensorEngine sensorEngine) {
		this.sensorEngine = sensorEngine;
	}



	@Override
	public void exec() {
		
		Thread t1 = new Thread(senorDataService);
        t1.start();
        
        Thread t2 = new Thread(sensorEngine);
        t2.start();
		

	}

}
