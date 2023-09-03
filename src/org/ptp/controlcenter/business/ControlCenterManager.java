package org.ptp.controlcenter.business;

import java.util.ArrayList;

import org.ptp.sensor.model.Sensor;
import org.ptp.utils.model.IExecutable;
import org.ptp.utils.model.PhysicalEntity;
import org.ptp.utils.model.SensorData;
import org.ptp.utils.model.messages.PTPMessage;

public class ControlCenterManager implements IExecutable{


	private ArrayList<SensorData> sensorData = new ArrayList<>();
	
	private PhysicalEntity target = new PhysicalEntity();


	private ContolCenterController controller = new ContolCenterController(this);

	private ControlCenterService<PTPMessage> dataService = new ControlCenterService<>(this);

	private ControlCenterEngine engine = new ControlCenterEngine(this);
	
	private EntityLocater entityLocater = new EntityLocater();


	public ControlCenterManager() {
		// TODO Auto-generated constructor stub
	}


	@Override
	public void exec() {

		Thread t1 = new Thread(dataService);
		t1.start();

		Thread t2 = new Thread(engine);
		t2.start();


	}


	public ContolCenterController getController() {
		return controller;
	}



	public void setController(ContolCenterController controller) {
		this.controller = controller;
	}



	public ControlCenterService<PTPMessage> getDataService() {
		return dataService;
	}








	public void setDataService(ControlCenterService<PTPMessage> dataService) {
		this.dataService = dataService;
	}



	public ControlCenterEngine getEngine() {
		return engine;
	}


	public void setEngine(ControlCenterEngine engine) {
		this.engine = engine;
	}


	public EntityLocater getEntityLocater() {
		return entityLocater;
	}


	public void setEntityLocater(EntityLocater entityLocater) {
		this.entityLocater = entityLocater;
	}

}
