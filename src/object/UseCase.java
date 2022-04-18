package object;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;

public class UseCase extends Object{
	public UseCase(int x1, int y1) {
		this.x1 = x1;
		this.y1 = y1;
		this.width = 100;
		this.height = 69;
		this.x2 = x1 + this.width;
		this.y2 = y1 + this.height;
		this.objectName = "Use Case Name";
		this.locatePorts();
	}
	public void draw(Graphics g) {
		g.setColor(Color.white);
		g.fillOval(this.x1, this.y1, this.width, this.height);
		g.setColor(Color.black);
		g.drawOval(this.x1, this.y1, this.width, this.height);
		int stringWidth = g.getFontMetrics(this.font).stringWidth(this.objectName);
		double empty = (Math.abs(this.x1-this.x2) - stringWidth)/2;
		g.setFont(this.font);	
		g.drawString(this.objectName, this.x1 + (int)empty, this.y1 + 40);
	}
	public String mouselocation (Point p) {
		Point center = new Point();
		center.x = (this.x1 + this.x2) / 2;
		center.y = (this.y1 + this.y2) / 2;
		Point[] points = { new Point(this.x1, this.y1), new Point(this.x2, this.y1), new Point(this.x2, this.y2), new Point(this.x1, this.y2) };
		
		long bPart = (long)(Math.pow(this.height/2 , 2))*(long)(Math.pow(p.x - center.x , 2));
		long aPart = (long)(Math.pow(this.width/2 , 2))*(long)(Math.pow(p.y - center.y , 2));
		long abPart = (long)(Math.pow(this.width/2 , 2))*(long)(Math.pow(this.height/2 , 2));
		
		if(bPart + aPart <= abPart)
		{
			for (int i = 0; i < points.length; i++) {
				Polygon t = new Polygon();
				int secondIndex = ((i + 1) % 4);
				t.addPoint(points[i].x, points[i].y);
				t.addPoint(points[secondIndex].x, points[secondIndex].y);
				t.addPoint(center.x, center.y);

				if (t.contains(p)) {
					return Integer.toString(i);
				}
			}
		}
		return null;
	}
}
