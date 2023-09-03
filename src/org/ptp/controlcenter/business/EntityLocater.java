package org.ptp.controlcenter.business;

import java.awt.Point;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.ptp.utils.model.SensorData;

public class EntityLocater {
	
	private static final long DATA_EXPIRE_DURATION_SECONDS = 10;
	
	
	private HashMap<UUID, SensorData> sensorData = new LinkedHashMap<>();

	public void put(SensorData data) {
				
		sensorData.put(data.getId(), data);
		
		if(sensorData.size() > 0) {
			SensorData sd = (SensorData)sensorData.values().toArray()[0];
			LocalDateTime minusDate = LocalDateTime.now();
			minusDate = minusDate.minusSeconds(10);
		
			
		}
		
		// Delete old data
		// if current time minus DATA_EXPIRE_DURATION_SECONDS is less than sensor data time, sensor data is stale, 
		sensorData.entrySet().removeIf(entry ->  LocalDateTime.parse(entry.getValue().getTime()).compareTo(LocalDateTime.now().minusSeconds(DATA_EXPIRE_DURATION_SECONDS))< 0 );
		
		
			
	}
	
	public ArrayList<SensorData> getTwoSensorData(){
		
		ArrayList<SensorData> sd = sensorData.values().stream().collect(
	                    Collectors.toCollection(ArrayList::new));
	
		if(sd.size() <= 2)
			return sd;
		
		return new ArrayList<>(sd.subList(0, 2));
	}

	public static Optional<Point> locate(ArrayList<SensorData> sensorData) {

		if (sensorData.size() < 2)
			return Optional.empty();

		// Sort Data according to most uptodate

		sensorData.sort(new Comparator<SensorData>() {

			@Override
			public int compare(SensorData o1, SensorData o2) {
				// TODO Auto-generated method stub
				return o1.getTime().compareTo(o2.getTime());
			}

		});

		// Get most recent two distinct sensor data

		// Find position of target
		Optional<Point> targertLocation = intersectionPointOfTwoLines(
				sensorData.get(0).getPhysicalEntity().getLocation(), sensorData.get(0).getBearings(),
				sensorData.get(1).getPhysicalEntity().getLocation(), sensorData.get(1).getBearings());

		// Return position of target

		return targertLocation;

	}

	private static double getB(Point p1, double angle1) {

		return p1.getY() - Math.tan(Math.toRadians(angle1)) * p1.getX();
	}

	private static Optional<Point> intersectionPointOfTwoLines(Point p1, double angle1, Point p2, double angle2) {

		if (p1 == null || p2 == null)
			return Optional.empty();

		double b1 = getB(p1, angle1);
		double b2 = getB(p2, angle2);

		return calculateIntersectionPoint(angle1, b1, angle2, b2);
	}

	private static Optional<Point> calculateIntersectionPoint(double m1, double b1, double m2, double b2) {

		if (m1 == m2) {
			return Optional.empty();
		}

		double x = (b2 - b1) / (Math.tan(Math.toRadians(m1)) - Math.tan(Math.toRadians(m2)));
		double y = Math.tan(Math.toRadians(m1)) * x + b1;

		Point point = new Point();
		point.setLocation(x, y);
		return Optional.of(point);
	}

}
