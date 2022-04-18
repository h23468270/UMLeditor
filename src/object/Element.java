package object;

import java.awt.Graphics;
import java.awt.Point;

public abstract class Element {
	protected int x1, x2, y1, y2;
	protected boolean selected = false;
	protected String objectName = "Object Name";
	
	public abstract void draw(Graphics g);
	public void changeName(String name) {};
	public String getObjectName() {
		return this.objectName;
	}
	
	// get mouse in which location of the element
	public abstract String mouselocation(Point p);
	public abstract void show(Graphics g);
	public Port getPort(int portIndex) {
		return null;
	};
	

	// Group
	public void resetSelectedElement() {};
	public Element getSelectedElement() {
		return null;
	};
	
	public void resetPosition() {}
	public void resetPosition(int X, int Y) {}
	
	
	public Point getP1() {
		Point P1 = new Point(this.x1, this.y1);
		return P1;
	}
	
	public Point getP2() {
		Point P2 = new Point(this.x2, this.y2);
		return P2;
	}

	// get this element is group-selected or not
	public void setSelected() {
		this.selected = true;
	}
	
	public void setUnselected() {
		this.selected = false;
	}
	
	public boolean isSelected() {
		return this.selected;
	}
	
	public boolean isGroup() {
		return false;
	}
	
}
