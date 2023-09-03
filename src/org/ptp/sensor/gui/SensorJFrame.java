package org.ptp.sensor.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.ptp.sensor.business.SensorDataController;
import org.ptp.sensor.business.SensorManager;
import org.ptp.sensor.model.Sensor;



import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.FlowLayout;
import java.awt.Point;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SensorJFrame extends JFrame {

	private JPanel contentPane;
	private JTextField locationXTextField;
	private JTextField locationYTextField;
	private JTextField bearingTextField;
	
	private SensorManager sensorManager;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SensorJFrame frame = new SensorJFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	public SensorJFrame(SensorManager sensorManager) {
		
		this();
		
		this.sensorManager = sensorManager;
		
		this.setTitle(sensorManager.getSensor().getId().toString());
	}

	/**
	 * Create the frame.
	 */
	public SensorJFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 757, 134);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel topPanel = new JPanel();
		FlowLayout fl_topPanel = (FlowLayout) topPanel.getLayout();
		fl_topPanel.setAlignment(FlowLayout.LEFT);
		contentPane.add(topPanel, BorderLayout.NORTH);
		
		JLabel locationXLabel = new JLabel("Location X");
		topPanel.add(locationXLabel);
		
		locationXTextField = new JTextField();
		topPanel.add(locationXTextField);
		locationXTextField.setColumns(10);
		
		JLabel locationYLabel = new JLabel("Location Y");
		topPanel.add(locationYLabel);
		
		locationYTextField = new JTextField();
		topPanel.add(locationYTextField);
		locationYTextField.setColumns(10);
		
		JLabel bearingsLabel = new JLabel("Bearings");
		topPanel.add(bearingsLabel);
		
		bearingTextField = new JTextField();
		topPanel.add(bearingTextField);
		bearingTextField.setColumns(10);
		
		JButton submitButton = new JButton("Submit");
		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int xLocation = 0;
				int yLocation = 0;
				double bearings = 0;
				
				
				try {
					
					xLocation = Integer.parseInt(locationXTextField.getText().toString());
					if(xLocation < -500 || xLocation > 500)
						throw new Exception();
					
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "X Location must be >= -500 and <=500");
					return;
				}
				
				try {
					
					yLocation = Integer.parseInt(locationYTextField.getText().toString());
					if(yLocation < -500 || yLocation > 500)
						throw new Exception();
					
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Y Location must be >= -500 and <=500");
					return;
				}
				
				
				try {
					
					bearings =  Double.parseDouble(bearingTextField.getText().toString());
					if(bearings < 0 || bearings > 360)
						throw new Exception();
					
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "bearings >= 0 and <= 360");
					return;
				}
				
				sensorManager.getSensorDataController().initSensor(new Point(xLocation,yLocation), bearings);
	
				
			}
		});
		topPanel.add(submitButton);
		
		JPanel mainPanel = new JPanel();
		mainPanel.setBackground(Color.BLACK);
		contentPane.add(mainPanel, BorderLayout.CENTER);
	}

}
