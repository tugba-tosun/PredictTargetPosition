package org.ptp.utils.model;

import java.awt.Point;
import java.time.LocalDateTime;
import java.util.UUID;

public class SensorBasicData{
	
	private String time = LocalDateTime.now().toString();
	
	private UUID id;
	
	private PhysicalEntity physicalEntity;

	public SensorBasicData(UUID id, PhysicalEntity phyEnt) {
		this();
		time = LocalDateTime.now().toString();
		this.id = id;
		this.setPhysicalEntity(phyEnt);
	}

	public SensorBasicData() {
		// TODO Auto-generated constructor stub
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public PhysicalEntity getPhysicalEntity() {
		return physicalEntity;
	}

	public void setPhysicalEntity(PhysicalEntity physicalEntity) {
		this.physicalEntity = physicalEntity;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}


}
