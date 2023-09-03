package org.ptp.utils.model.messages;

import java.time.LocalDateTime;

public class PTPMessageHeader {
	
	private LocalDateTime time;
	
	private PTPMessageTypes type;

	public PTPMessageHeader() {
		// TODO Auto-generated constructor stub
	}

	public PTPMessageHeader(LocalDateTime time, PTPMessageTypes type) {
	
		this.time = time;
		this.setType(type);
	}
	
	public PTPMessageHeader( PTPMessageTypes type) {
		
		this(LocalDateTime.now(),type);
	}

	public LocalDateTime getTime() {
		return time;
	}

	public void setTime(LocalDateTime time) {
		this.time = time;
	}

	public PTPMessageTypes getType() {
		return type;
	}

	public void setType(PTPMessageTypes type) {
		this.type = type;
	}

}
