package mode;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import object.Element;
import object.GroupElements;
import object.Line;
import painter.Painter;

public class drawLineMode extends Mode{
	private Painter painter;
	private Point point1 = null;
	private ArrayList<Element> elements;
	private int Port1 = -1, Port2 = -1;
	private Element element1 = null, element2 = null;
	
	
	public drawLineMode(Painter Painter) {
		this.painter = Painter;
	}

	public void mousePressed(MouseEvent e) {
		this.elements = canvas.getElementList();
		this.point1 = findConnectedObj(e.getPoint(), 1);
	}
	//label override+
	public void mouseDragged(MouseEvent e) {
		if (this.point1 != null) {
			Line line = this.painter.paint(this.point1, e.getPoint());
			this.canvas.setLine(line);
			this.canvas.repaint();
		}
	}

	public void mouseReleased(MouseEvent e) {
		Point point2 = null;
		if (this.point1 != null) {
			
			point2 = findConnectedObj(e.getPoint(), 2);
			
			if (point2 != null) {
				Line line = this.painter.paint(this.point1, point2);
				
				this.canvas.addElement(line);
				line.setPorts(this.element1.getPort(this.Port1), this.element2.getPort(this.Port2));
				this.element1.getPort(this.Port1).addLine(line);
				this.element2.getPort(this.Port2).addLine(line);
			}
			// reset
			this.point1 = null;
			this.canvas.setLine(null);
			this.canvas.repaint();
			
		}
	}

	private Point findConnectedObj(Point p, int target) {
		for (int i = 0; i < elements.size(); i++) {
			Element element = elements.get(i);

			int portIndex = 0;
			String position = element.mouselocation(p);
			if (position != null) {
				if(position == "4"){  
					ArrayList<Element> g_elements = ((GroupElements)element).getElementList();
					boolean check_empty = true;
					for(int j = 0 ; j < g_elements.size(); j++)
					{
						element = g_elements.get(j);
						
						if(element.mouselocation(p)!=null) {
							portIndex = Integer.parseInt(element.mouselocation(p));
							check_empty = false;
							break;
						}
					}
					
					if(check_empty)
					{
						return null;
					}
				}
				else{
					portIndex = Integer.parseInt(position);
				}
				
				
				if(target==1){
					this.element1 = element;
					this.Port1 = portIndex;
				}
				else{
					this.element2 = element;
					this.Port2 = portIndex;
					if(this.element2 == this.element1){
						return null;
					}
					
				}
				Point portLocation = new Point();
				portLocation.setLocation(element.getPort(portIndex).getCenterX(), 
						                 element.getPort(portIndex).getCenterY());
				return portLocation;
			}

		}
		return null;
	}
}
