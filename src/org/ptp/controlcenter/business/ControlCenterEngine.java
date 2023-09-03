package org.ptp.controlcenter.business;

import java.util.ArrayList;

import org.ptp.utils.model.SensorData;
import org.ptp.utils.model.messages.PTPMessage;
import org.ptp.utils.model.messages.PTPMessageTypes;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;



public class ControlCenterEngine implements Runnable{

	private static final int EXEC_PERIOD_MS = 200;

	private static final int MAX_READ_COUNT = 1000;

	private ControlCenterManager manager;


	public ControlCenterEngine(ControlCenterManager manager) {

		this.manager = manager;
	}


	@Override
	public void run() {

		int readCount = 0;

		while(true) {

			// Read Message From Queue

			//sensorManager.getSenorDataService().put(new PTPMessage(PTPMessageTypes.DATA, new SensorData(sensorManager.getSensor().getId(), 
			//																								sensorManager.getSensor().getLocation(), 
			//																								sensorManager.getSensor().getBearings())));
			readCount = 0;

			while(readCount < MAX_READ_COUNT && !manager.getDataService().getMessages().isEmpty())	
			{
				readCount++;
				
				PTPMessage message = manager.getDataService().getMessages().poll();
				
				if(message != null) {

					switch(message.getType()) {

					case DATA:
						Object objData =null;
						ObjectMapper mapper = new ObjectMapper();
						//objData = mapper.convertValue(message.getData(), SensorData.class);
						/*
						String msgData = (String)message.getData();
						
						try {
							objData = mapper.readValue(msgData, SensorData.class);
						} catch (JsonMappingException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (JsonProcessingException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						*/
						//message.setData(objData);
						SensorData sensorData =  (SensorData)message.getData();
						manager.getEntityLocater().put(sensorData);
						break;

					}

					manager.getController().calcAndUpdateEntityLocations();

				}
			}	
			
		

			try {
				Thread.sleep(EXEC_PERIOD_MS);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}


	}


}
