package org.ptp.controlcenter.business;

import java.awt.Point;
import java.util.ArrayList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

import org.ptp.utils.model.IConsumer;
import org.ptp.utils.model.KafkaConsumerService;
import org.ptp.utils.model.PhysicalEntity;
import org.ptp.utils.model.SensorData;
import org.ptp.utils.model.messages.PTPMessage;
import org.ptp.utils.model.messages.PTPMessageTypes;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;



public class ControlCenterService<T> implements Runnable{
	
	private static final int SLEEP_DURATION = 100;
	
	private static final int MAX_DATA_READ_COUNT = 1000;
	
	
	private BlockingQueue<T> messages = new LinkedBlockingDeque<>();
	
	private ControlCenterManager manager;
	
	private IConsumer consumer = new KafkaConsumerService();

	public ControlCenterService(ControlCenterManager manager) {
		this.manager = manager;
	}

	@Override
	public void run() {
		
		int readCount = 0;

		while(true) {
			
			//System.out.println("Sensor Data Service Scan");
			
			ArrayList list = consumer.consume();
		
			
			while(list.size() != 0)
			{
				String data = (String)list.remove(0);
				ObjectMapper mapper = new ObjectMapper();
				PTPMessage ptpMessage = null;
				try {
					ptpMessage = mapper.readValue(data, PTPMessage.class);
					
				} catch (JsonProcessingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(ptpMessage !=null)
					messages.add((T) ptpMessage);
			}
			
			//messages.add((T) new PTPMessage(PTPMessageTypes.DATA, new SensorData( new PhysicalEntity(new Point(-5,1)), 45.0)));
			//messages.add((T) new PTPMessage(PTPMessageTypes.DATA, new SensorData( new PhysicalEntity(new Point(5,-1)), 315.0)));
			
			PTPMessage ptp = (PTPMessage)messages.peek();
			if(ptp != null) {
				SensorData sdm = (SensorData)ptp.getData();
				
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
