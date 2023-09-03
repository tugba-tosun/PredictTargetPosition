package org.ptp.utils.model;

import java.awt.Point;

public class PhysicalEntity {
	
	private Point location = null;

	public PhysicalEntity() {
		// TODO Auto-generated constructor stub
	}
	
	public PhysicalEntity(Point loc) {
		this.location = loc;
	}

	public Point getLocation() {
		return location;
	}

	public void setLocation(Point location) {
		this.location = location;
	}

}
