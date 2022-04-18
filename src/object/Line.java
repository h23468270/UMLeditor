package object;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public abstract class Line extends Element{
	protected Port[] ports = new Port[2];
	public abstract void draw(Graphics g);
	
	public Line() {
		
	}
	
	public Port getPort(int portIndex){
		return null;
	}
	
	public void setPorts(Port port1, Port port2) {
		this.ports[0] = port1;
		this.ports[1] = port2;
	}
	
	public void resetPosition(){
		this.x1 = (int) this.ports[0].x;
		this.y1 = (int) this.ports[0].y;
		this.x2 = (int) this.ports[1].x;
		this.y2 = (int) this.ports[1].y;
	}
	
	public void show(Graphics g) {
		g.setColor(Color.black);
	}
	
	@Override
	public String mouselocation(Point p) {
		return null;
	}

	
}
