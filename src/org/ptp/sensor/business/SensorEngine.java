package org.ptp.sensor.business;

import org.ptp.utils.model.PhysicalEntity;
import org.ptp.utils.model.SensorData;
import org.ptp.utils.model.messages.PTPMessage;
import org.ptp.utils.model.messages.PTPMessageTypes;



public class SensorEngine implements Runnable{
	
	private static final int EXEC_PERIOD_MS = 1000;
	
	private SensorManager sensorManager;

	
	public SensorEngine(SensorManager sensorManager) {
	
		this.sensorManager = sensorManager;
	}


	@Override
	public void run() {


		while(true) {
			
			//System.out.println("Sensor Engine Scan");
			
			if(sensorManager.getSensor().isActive()) {
				try {
					sensorManager.getSenorDataService().put(new PTPMessage(PTPMessageTypes.DATA, new SensorData(sensorManager.getSensor().getId(), 
																													new PhysicalEntity(sensorManager.getSensor().getLocation()), 
																													sensorManager.getSensor().getBearings())));
					
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
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
