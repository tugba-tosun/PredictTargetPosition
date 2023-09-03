package org.ptp.controlcenter.business;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Optional;

import org.ptp.controlcenter.gui.ControlCenterFrame;
import org.ptp.sensor.model.Sensor;
import org.ptp.utils.model.PhysicalEntity;
import org.ptp.utils.model.SensorData;

public class ControlCenterController {
	
	private ControlCenterManager manager;
	
	private ControlCenterFrame view;

	public ControlCenterController(ControlCenterManager cm) {
		this.manager = cm;

	}
	
	public void calcAndUpdateEntityLocations() {
		
		ArrayList <SensorData> sensors = manager.getEntityLocater().getTwoSensorData();
		
		Optional<Point> targetPoint = EntityLocater.locate(sensors);
		
		updateEntityLocations(sensors,new PhysicalEntity(targetPoint.orElse(null)));
		
	}
	
	private void updateEntityLocations(ArrayList<SensorData> sensors, PhysicalEntity targetEntity) {
		
		getView().updateEntityLocations(sensors, targetEntity);
		
	}


	public ControlCenterFrame getView() {
		return view;
	}


	public void setView(ControlCenterFrame view) {
		this.view = view;
	}
	

}
