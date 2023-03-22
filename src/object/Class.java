package object;

import java.awt.Color;
import java.awt.Graphics;

public class Class extends Objects{
	public Class(int x1, int y1) {
		this.x1 = x1;
		this.y1 = y1;
		this.width = 80;
		this.height = 100;
		this.x2 = x1 + this.width;
		this.y2 = y1 + this.height;
		this.objectName = "Class Name";
		this.locatePorts();
	}
	public void draw(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(this.x1, this.y1, this.width, this.height);
		g.setColor(Color.black);
		g.drawRect(this.x1, this.y1, this.width, this.height);
		int Distance = this.height / 3;
		g.drawLine(this.x1, this.y1 + Distance, this.x2, this.y1 + Distance);
		g.drawLine(this.x1, this.y1 + Distance * 2, this.x2, this.y1 + Distance * 2);
	
		int stringWidth = g.getFontMetrics(this.font).stringWidth(this.objectName);
		double empty = (Math.abs(this.x1-this.x2) - stringWidth)/2;
		g.setFont(this.font);	
		g.drawString(this.objectName, this.x1 + (int)empty, this.y1 + 25);
	}
}
