package object;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;

public abstract class Object extends Element{
	private int portNum = 4;
	protected Port[] ports = new Port[portNum];
	protected int width, height;
	protected Font font = new Font(Font.DIALOG, Font.BOLD, 12);
	
	public abstract void draw(Graphics g);
	
	public void show(Graphics g) {
		g.setColor(Color.red);
		for(Port port : this.ports) {
			g.fillRect(port.x, port.y, port.width, port.height);
		}
		g.setColor(Color.black);
	}
	
	public Port getPort(int index) {
		return this.ports[index];
	}
	
	@Override
	public String mouselocation (Point p) {
		Point center = new Point();
		center.x = (this.x1 + this.x2) / 2;
		center.y = (this.y1 + this.y2) / 2;
		Point[] points = { new Point(this.x1, this.y1), new Point(this.x2, this.y1), new Point(this.x2, this.y2), new Point(this.x1, this.y2) };
		
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
		return null;
	}
	
	protected void locatePorts() {
		int[] Xs = {(this.x1 + this.x2)/2, this.x2, 
				    (this.x1 + this.x2)/2, this.x1};
		int[] Ys = {this.y1, (this.y1 + this.y2)/2,
				    this.y2, (this.y1 + this.y2)/2};
		for(int i = 0; i < this.portNum; i++) {
			Port port = new Port(Xs[i], Ys[i]);
			this.ports[i] = port;

		}
	}
	
	@Override
	public void changeName(String name){
		this.objectName = name;
	}
	
	@Override
	public void resetPosition(int moveX, int moveY) {
		int x1 = this.x1 + moveX;
		int y1 = this.y1 + moveY;
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x1 + this.width;
		this.y2 = y1 + this.height;
		int[] Xs = {(this.x1 + this.x2)/2, this.x2, 
			    (this.x1 + this.x2)/2, this.x1};
		int[] Ys = {this.y1, (this.y1 + this.y2)/2,
			    this.y2, (this.y1 + this.y2)/2};
		for(int i = 0; i < this.portNum; i++) {
			this.ports[i].resetPort(Xs[i], Ys[i]);
			this.ports[i].resetLines();
		}
	}
	
}
