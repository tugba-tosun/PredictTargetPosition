package org.ptp.controlcenter.main;

import java.util.UUID;

import org.ptp.controlcenter.business.ControlCenterManager;
import org.ptp.controlcenter.gui.ControlCenterFrame;
import org.ptp.sensor.business.SensorManager;
import org.ptp.sensor.gui.SensorJFrame;

public class App {

	public App() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		System.out.println("Sensor Started..");
		
		ControlCenterManager ccm = new ControlCenterManager();
		
		ControlCenterFrame ccf = new ControlCenterFrame(ccm);
		ccf.setVisible(true);
		
		ccm.getController().setView(ccf);
		
		ccm.exec();
	}

}
