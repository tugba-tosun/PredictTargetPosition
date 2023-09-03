package org.ptp.sensor.business;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

import org.ptp.utils.model.messages.PTPMessage;



public class SensorDataService<T> implements Runnable{
	
	private static final int SLEEP_DURATION = 1000;
	
	private static final int MAX_DATA_READ_COUNT = 1000;
	
	
	private BlockingQueue<T> messages = new LinkedBlockingDeque<>();

	public SensorDataService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void run() {
		
		int readCount = 0;

		while(true) {
			
			//System.out.println("Sensor Data Service Scan");
			
			while(readCount < MAX_DATA_READ_COUNT &&  !messages.isEmpty()) {
				
				System.out.println("KAFKA MSG" + messages.poll().toString());
			}
			
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
