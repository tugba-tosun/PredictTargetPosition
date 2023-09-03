package org.ptp.controlcenter.business;

import java.awt.Point;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

import org.ptp.utils.model.PhysicalEntity;
import org.ptp.utils.model.SensorData;
import org.ptp.utils.model.messages.PTPMessage;
import org.ptp.utils.model.messages.PTPMessageTypes;



public class ControlCenterService<T> implements Runnable{
	
	private static final int SLEEP_DURATION = 1000;
	
	private static final int MAX_DATA_READ_COUNT = 1000;
	
	
	private BlockingQueue<T> messages = new LinkedBlockingDeque<>();
	
	private ControlCenterManager manager;

	public ControlCenterService(ControlCenterManager manager) {
		this.manager = manager;
	}

	@Override
	public void run() {
		
		int readCount = 0;

		while(true) {
			
			//System.out.println("Sensor Data Service Scan");
			/*
			while(readCount < MAX_DATA_READ_COUNT &&  !messages.isEmpty()) {
				
				System.out.println("KAFKA MSG" + messages.poll().toString());
			}
			*/
			messages.add((T) new PTPMessage(PTPMessageTypes.DATA, new SensorData( new PhysicalEntity(new Point(-5,1)), 45.0)));
			messages.add((T) new PTPMessage(PTPMessageTypes.DATA, new SensorData( new PhysicalEntity(new Point(5,-1)), 315.0)));
			
			PTPMessage ptp = (PTPMessage)messages.peek();
			SensorData sdm = (SensorData)ptp.getData();
			System.out.println(">>"+sdm.getTime().toString());
			
			readCount = 0;
			
			try {
				Thread.sleep(SLEEP_DURATION);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	
	public void put(T msg) throws InterruptedException {
		
		getMessages().put(msg);
		
	}

	public BlockingQueue<T> getMessages() {
		return messages;
	}

	public void setMessages(BlockingQueue<T> messages) {
		this.messages = messages;
	}

}
