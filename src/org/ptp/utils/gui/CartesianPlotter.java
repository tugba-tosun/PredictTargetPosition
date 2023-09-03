package org.ptp.utils.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class CartesianPlotter extends JPanel {
	
	
		private ArrayList<Point> sensorPoints = new ArrayList<Point>();
		
		private Point targetPoint;
		
		private static final int MAX_X =  500;
		
		private static final int MIN_X = -500;
		
		private static final int MAX_Y =  500;
		
		private static final int MIN_Y = -500;
		
		
		
	
	 	int[] coordinates={100,20};
	 
	    int margin=0;
	    
	    protected void paintComponent(Graphics g){
	        super.paintComponent(g);
	       
	        
	        Graphics2D g1=(Graphics2D)g;
	        g1.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
	        
	        int width=getWidth();
	        int height=getHeight();
	        int labelmargin = 15;
	        
	        double midVerXStart = (width/2)+margin;  
	        double midVerXEnd = (width/2)-margin;
	        double midHorXStart = margin;
	        double midHorXEnd = width-margin;
	        
	        double midVerYStart = margin;  
	        double midVerYEnd = height - margin;
	        double midHorYStart = (height/2)+margin;
	        double midHorYEnd = (height/2)-margin;
	        
	
	        
	        // Vertical Line to Center
	        g1.draw(new Line2D.Double(midVerXStart,midVerYStart,midVerXEnd,midVerYEnd));
	        
	        // Horizontol Line to Center
	        g1.draw(new Line2D.Double(midHorXStart,midHorYStart,midHorXEnd,midHorYEnd));
	        
	      
	        // Labels
	        g1.drawString("X", (int)midHorXEnd-labelmargin, (int)(midHorYEnd-labelmargin));
	      
	        g1.drawString("Y", (int)midVerXStart+labelmargin, (int)(midVerYStart+labelmargin));
	        
	        g1.drawString("-500", (int)midHorXStart, (int)(midHorYStart+labelmargin));
	        g1.drawString("500", (int)midHorXEnd-20, (int)(midHorYEnd+labelmargin));
	        g1.drawString("-500", (int)midVerXEnd-30, (int)(midVerYEnd));
	        g1.drawString("500", (int)midVerXStart-30, (int)(midVerYStart+10));
	        
	       // double x=(double)(width-2*margin)/(coordinates.length-1);
	        //double scale=(double)(height-2*margin)/getMax();
	        
	        ArrayList<Point> sensorVisualPoints = new ArrayList<Point>();
	        
	        g1.setPaint(Color.BLUE);      
	        for(int i=0;i<getSensorPoints().size();i++){
	        	Point p = getScaledPoint(getSensorPoints().get(i));
	        	g1.fill(new Ellipse2D.Double(p.getX()-5,p.getY()-5,10,10));
	        	sensorVisualPoints.add(p);
	        }
	        
	        Point targetVisualPoint = null;
	        g1.setPaint(Color.RED);
	        if(getTargetPoint() != null) 
	        {
	        	Point p = getScaledPoint(getTargetPoint());
	        	targetVisualPoint = p;
	        	g1.fill(new Ellipse2D.Double(p.getX()-5,p.getY()-5,10,10));
	        }
	           
	        // draw line sensor to target
	        g1.setPaint(Color.CYAN);  
	        if(targetVisualPoint !=null) {
		        for(int i=0;i<sensorVisualPoints.size();i++){
		        	g1.draw(new Line2D.Double(sensorVisualPoints.get(i).getX(),sensorVisualPoints.get(i).getY(),targetVisualPoint.getX(),targetVisualPoint.getY()));
		        }
	        }
	        
	    }
	    
	    private Point getScaledPoint(Point p) {
	    	
	    	double rangeX = MAX_X - MIN_X;
	    	double rangeY = MAX_Y - MIN_Y;
	    	
	    	double width=getWidth();
	    	double height=getHeight();
	    
	    	int x = (int) ((width / rangeX) * (Math.abs(p.getX() + Math.abs(MIN_X))));
	    	int y = (int) ((height / rangeY) * (Math.abs(p.getY() - Math.abs(MIN_Y))));
	    	
	    	
	    	return new Point(x,y);
	    	
	    }
	    
	    public static void main(String args[]){
	        JFrame frame =new JFrame();
		    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    frame.add(new CartesianPlotter());
		    frame.setSize(400,400);
		    frame.setLocation(200,200);
		    frame.setVisible(true);
	    }

		public Point getTargetPoint() {
			return targetPoint;
		}

		public void setTargetPoint(Point targetPoint) {
			this.targetPoint = targetPoint;
		}

		public ArrayList<Point> getSensorPoints() {
			return sensorPoints;
		}

		public void setSensorPoints(ArrayList<Point> sensorPoints) {
			this.sensorPoints = sensorPoints;
		}

}
