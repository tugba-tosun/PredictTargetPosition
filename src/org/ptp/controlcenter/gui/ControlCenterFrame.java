package org.ptp.controlcenter.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JTextArea;
import java.awt.GridLayout;
import java.awt.Dimension;

public class ControlCenterFrame extends JFrame {

	private JPanel contentPane;

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

	/**
	 * Create the frame.
	 */
	public ControlCenterFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 778, 566);
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
		
		JTextArea infoTextArea = new JTextArea();
		bottomPanel.add(infoTextArea);
		infoTextArea.setPreferredSize(new Dimension(5, 100));
		infoTextArea.setMinimumSize(new Dimension(5, 100));
	}

}
