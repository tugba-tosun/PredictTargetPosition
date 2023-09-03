package org.ptp.utils.model.messages;

import java.time.LocalTime;

public class PTPMessageHeader {
	
	private LocalTime time;
	
	private PTPMessageTypes type;

	public PTPMessageHeader() {
		// TODO Auto-generated constructor stub
	}

	public PTPMessageHeader(LocalTime time, PTPMessageTypes type) {
	
		this.time = time;
		this.type = type;
	}
	
	public PTPMessageHeader( PTPMessageTypes type) {
		
		this(LocalTime.now(),type);
	}

	public LocalTime getTime() {
		return time;
	}

	public void setTime(LocalTime time) {
		this.time = time;
	}

}
