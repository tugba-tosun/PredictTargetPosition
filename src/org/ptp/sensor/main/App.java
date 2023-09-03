package org.ptp.sensor.main;

import org.ptp.sensor.business.SensorManager;
import org.ptp.sensor.gui.SensorJFrame;

public class App {

	public App() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Sensor Started..");
		
		SensorManager sm = new SensorManager();
		
		new SensorJFrame(sm).setVisible(true);
		
		sm.exec();
		

	}

}
