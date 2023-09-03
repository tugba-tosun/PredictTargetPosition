package org.ptp.utils.model.messages;

public enum PTPMessageTypes {


	LOCATION(0),
	DATA(1);
	
	private int type;
	
	PTPMessageTypes(int type) {
	
		this.type = type;
	}
}
