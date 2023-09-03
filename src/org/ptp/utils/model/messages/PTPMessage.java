package org.ptp.utils.model.messages;


public class PTPMessage extends PTPMessageHeader{
	

	private Object data;

	public PTPMessage() {
		// TODO Auto-generated constructor stub
	}

	public PTPMessage(PTPMessageTypes type,Object data) {
		super(type);
		this.setData(data);
	
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

}
