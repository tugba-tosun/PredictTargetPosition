package org.ptp.utils.model.messages;

import org.ptp.utils.model.SensorData;

public class PTPMessage extends PTPMessageHeader{
	

	private SensorData data;

	public PTPMessage() {
		// TODO Auto-generated constructor stub
	}

	public PTPMessage(PTPMessageTypes type,SensorData data) {
		super(type);
		this.setData(data);
	
	}

	public SensorData getData() {
		return data;
	}

	public void setData(SensorData data) {
		this.data = data;
	}

}
