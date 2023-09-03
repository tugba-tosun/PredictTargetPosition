package org.ptp.controlcenter.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.ptp.controlcenter.business.ControlCenterManager;
import org.ptp.sensor.business.SensorManager;
import org.ptp.utils.gui.CartesianPlotter;
import org.ptp.utils.model.PhysicalEntity;
import org.ptp.utils.model.SensorData;

import java.awt.BorderLayout;
import javax.swing.JTextArea;
import java.awt.GridLayout;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;
import java.awt.Dimension;

public class ControlCenterFrame extends JFrame {

	private JPanel contentPane;
	
	private ControlCenterManager manager;
	
	private CartesianPlotter cartesianPlotter = new CartesianPlotter();
	
	
	private JTextArea infoTextArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ControlCenterFrame frame = new ControlCenterFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public ControlCenterFrame(ControlCenterManager manager) {
		
		this();
		
		this.manager = manager;
		
		this.setTitle("Control Center");
	}

	/**
	 * Create the frame.
	 */
	public ControlCenterFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 986, 691);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel topPanel = new JPanel();
		contentPane.add(topPanel, BorderLayout.NORTH);
		topPanel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel midPanel = new JPanel();
		contentPane.add(midPanel, BorderLayout.CENTER);
		midPanel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel bottomPanel = new JPanel();
		contentPane.add(bottomPanel, BorderLayout.SOUTH);
		bottomPanel.setLayout(new GridLayout(0, 1, 0, 0));
		
		infoTextArea = new JTextArea();
		bottomPanel.add(infoTextArea);
		infoTextArea.setPreferredSize(new Dimension(5, 100));
		infoTextArea.setMinimumSize(new Dimension(5, 100));
		
		midPanel.add(cartesianPlotter);
	}
	
	public void updateEntityLocations(ArrayList<SensorData> sensors, PhysicalEntity targetEntity) {
		
		// Update Coordinate System
		
		// Update Console
		String output = "";
		
		for(SensorData sData : sensors)
			output += sData.getTime().toString()+ " "+"ID : "+sData.getId()+" Location : X: "+ sData.getPhysicalEntity().getLocation().getX()+
			" Y:"+sData.getPhysicalEntity().getLocation().getY()
			+ " Bearings : "+sData.getBearings()+"\n";

		if(targetEntity.getLocation() != null )
			output +="Target Location : X: "+ targetEntity.getLocation().getX()+" Y: "+targetEntity.getLocation().getY();
		
		putConsoleMessage(output);
		
		ArrayList<Point> sensorPoints = new ArrayList<Point>();
		
		for(SensorData sensData : sensors)
		{
			sensorPoints.add(sensData.getPhysicalEntity().getLocation());
		}
		
		cartesianPlotter.setSensorPoints(sensorPoints);
		cartesianPlotter.setTargetPoint(targetEntity.getLocation());
		cartesianPlotter.repaint();
		
		
		
	}
	
	private void putConsoleMessage(String message) {
		infoTextArea.setText(message);
	}


	

}
