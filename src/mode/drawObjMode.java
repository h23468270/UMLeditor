package mode;

import java.awt.event.MouseEvent;

import object.Element;
import painter.Painter;

public class drawObjMode extends Mode{
	private Painter painter;
	
	public drawObjMode(Painter Painter) {
		this.painter = Painter;
	}
	
	public void mousePressed(MouseEvent e) {
		Element obj = this.painter.paintObject(e.getPoint());
		this.canvas.addElement(obj);
		this.canvas.repaint();
	}
}
