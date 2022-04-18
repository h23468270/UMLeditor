package object;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

public class Port extends Rectangle{
	public List<Line> lines = new ArrayList<Line>(); 
	protected int x, y, PortEdge=5;
	
	public Port(int Portx, int Porty) {
		this.x = Portx;
		this.y = Porty;
		setBounds(x, y, PortEdge, PortEdge);
	}
	
	public void resetPort(int Portx, int Porty) {
		this.x = Portx-3;
		this.y = Porty-3;
		setBounds(x, y, PortEdge, PortEdge);
	}
	
	public void addLine(Line line) {
		this.lines.add(line);
	}
	
//	public void 
	
	public void resetLines() {
		for(int i = 0; i < this.lines.size(); i++){
			Line line = this.lines.get(i);
			line.resetPosition();
		}
	}

}
