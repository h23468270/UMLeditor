package mode;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.List;

import object.Element;

public class SelectMode extends Mode{
	private List<Element> elements;
	private Point point = null;
	private String position = null;
	
	public void mousePressed(MouseEvent e) {
		this.point = e.getPoint();
		this.elements = this.canvas.getElementList();
		// reset
		this.canvas.reset();

		/* find which basic object, record its reference */
		this.canvas.resetElementList();
		for (int i = this.elements.size() - 1 ; i >= 0 ; i--) {
			if (this.canvas.getSelectObj() == null) {
				Element element = this.elements.get(i);
				this.position = element.mouselocation(e.getPoint());
				if (this.position != null) {
					this.canvas.setSelectObj(element);
					element.setSelected();
					break;
				}
			}
		}
		this.canvas.repaint();
		
	}

	public void mouseDragged(MouseEvent e) {
		
		this.canvas.resetElementListInSelect();
		
		int moveX = e.getX() - this.point.x;
		int moveY = e.getY() - this.point.y;
		
		if (this.canvas.getSelectObj() != null) {
			this.canvas.getSelectObj().resetPosition(moveX, moveY);
			this.point.x = e.getX();
			this.point.y = e.getY();
		}
		else {			
			if (e.getX() > this.point.x && e.getY() > this.point.y)	{
				this.canvas.setZoneBounds(this.point.x, this.point.y, Math.abs(moveX), Math.abs(moveY));
			}
			else if (e.getX() > this.point.x && e.getY() < this.point.y){
				this.canvas.setZoneBounds(this.point.x, e.getY(), Math.abs(moveX), Math.abs(moveY));
			}
			else if (e.getX() < this.point.x && e.getY() > this.point.y){
				this.canvas.setZoneBounds(e.getX(), this.point.y, Math.abs(moveX), Math.abs(moveY));
			}
			else{
				this.canvas.setZoneBounds(e.getX(), e.getY(), Math.abs(moveX), Math.abs(moveY));
			}
		}
		this.canvas.repaint();
	}

	public void mouseReleased(MouseEvent e) {
		this.canvas.checkselectObj();
		this.canvas.setZoneBounds(0,0,0,0);
		this.canvas.repaint();
	}
	

}
