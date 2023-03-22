package object;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;


public class GroupElements extends Element {
	private ArrayList<Element> elements = new ArrayList<Element>();
	private Rectangle bounds = new Rectangle();
	private Element selectedElement = null;
	public void draw(Graphics g) {
		for (int i = 0; i < this.elements.size(); i++) {
			Element element = this.elements.get(i);
			element.draw(g);
		}
	}

	public void show(Graphics g) {
		g.setColor(new Color(0, 0, 255, 50));
		g.fillRect(this.bounds.x, this.bounds.y, this.bounds.width, this.bounds.height);
		g.setColor(new Color(0, 0, 255));
		g.drawRect(this.bounds.x, this.bounds.y, this.bounds.width, this.bounds.height);
		g.setColor(Color.black);
		if (this.selectedElement != null) {
			this.selectedElement.show(g);
		}
	}

	public void resetPosition(int moveX, int moveY) {
		for (int i = 0; i < this.elements.size(); i++) {
			Element element = this.elements.get(i);
			element.resetPosition(moveX, moveY);
		}
		resetBounds(moveX, moveY);
	}

	public String mouselocation(Point p) {
		for (int i = 0; i < this.elements.size(); i++) {
			Element element = this.elements.get(i);
			String judgeInside = element.mouselocation(p);
			if (judgeInside != null) {
				this.selectedElement = element;
				return "4";
			}
		}
		return null;
	}

	public void changeName(String name) {
		this.selectedElement.changeName(name);
	}

	public void setUnselected() {
		this.selected = false;
		this.selectedElement = null;		
	}
		
		
	public void setBounds() {
		Point upPoint, bottomPoint;
		int Xstart = Integer.MAX_VALUE, Xend = Integer.MIN_VALUE;
		int Ystart = Integer.MAX_VALUE, Yend = Integer.MIN_VALUE;
		
		for (int i = 0; i < this.elements.size(); i++) {
			Element element = this.elements.get(i);
			Point P1 = element.getP1();
			Point P2 = element.getP2();
			
			if (P1.x < Xstart)
			{
				Xstart = P1.x;
			}
			if (P2.x > Xend) 
			{
				Xend = P2.x;
			}
			if (P1.y < Ystart)
			{
				Ystart = P1.y;
			}
			if (P2.y > Yend)
			{
				Yend = P2.y;			
			}
		}

		upPoint = new Point(Xstart, Ystart);
		bottomPoint = new Point(Xend, Yend);
		this.bounds.setBounds(upPoint.x, upPoint.y, Math.abs(upPoint.x - bottomPoint.x),
				Math.abs(upPoint.y - bottomPoint.y));

		this.x1 = this.bounds.x;
		this.y1 = this.bounds.y;
		this.x2 = this.bounds.x + this.bounds.width;
		this.y2 = this.bounds.y + this.bounds.height;
	}

	protected void resetBounds(int moveX, int moveY) {
		this.bounds.setLocation(this.bounds.x + moveX, this.bounds.y + moveY);
		this.x1 = this.bounds.x;
		this.y1 = this.bounds.y;
		this.x2 = this.bounds.x + this.bounds.width;
		y2 = bounds.y + bounds.height;
	}

	public void addElement(Element element) {
		elements.add(element);
	}

	public ArrayList<Element> getElementList() {
		return elements;
	}
	
	public boolean isGroup() {
		return true;
	}
}
