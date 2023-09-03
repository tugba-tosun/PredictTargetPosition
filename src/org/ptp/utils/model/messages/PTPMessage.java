package org.ptp.utils.model.messages;

import java.time.LocalTime;

public class PTPMessage extends PTPMessageHeader{
	

	private Object data;

	public PTPMessage() {
		// TODO Auto-generated constructor stub
	}

	public PTPMessage(PTPMessageTypes type,Object data) {
		super(type);
		this.data = data;
	
	}

}
