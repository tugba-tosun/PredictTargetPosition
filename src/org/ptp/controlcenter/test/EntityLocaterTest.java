package org.ptp.controlcenter.test;

import static org.junit.Assert.assertEquals;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.ptp.controlcenter.business.EntityLocater;
import org.ptp.sensor.model.Sensor;
import org.ptp.utils.model.PhysicalEntity;
import org.ptp.utils.model.SensorData;

public class EntityLocaterTest {

	public EntityLocaterTest() {
		// TODO Auto-generated constructor stub
	}
	
	@Test
	public void twoPointTest() {
		
		Point p1 = new Point(-5,1);
		double angle1 = 45;
		Point p2 = new Point(5,-1);
		double angle2 = 315;
		
		ArrayList<SensorData> sensorData = new ArrayList<>();
		
		sensorData.add(new SensorData(UUID.randomUUID(), new PhysicalEntity(p1),angle1));
		sensorData.add(new SensorData(UUID.randomUUID(), new PhysicalEntity(p2),angle2));
		
		assertEquals(new Point(-1,5),EntityLocater.locate(sensorData).get());
		
		
		
	}
	
	@Test
	public void noIntersectionTest() {
		
		Point p1 = new Point(-1,0);
		double angle1 = 0;
		Point p2 = new Point(5,0);
		double angle2 = 0;
		
		ArrayList<SensorData> sensorData = new ArrayList<>();
		
		sensorData.add(new SensorData(UUID.randomUUID(), new PhysicalEntity(p1),angle1));
		sensorData.add(new SensorData(UUID.randomUUID(), new PhysicalEntity(p2),angle2));
		
		assertEquals(null,EntityLocater.locate(sensorData).orElse(null));
		
			
	}

}
