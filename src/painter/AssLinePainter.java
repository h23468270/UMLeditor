package painter;

import java.awt.Point;

import object.AssLine;
import object.Line;

public class AssLinePainter extends Painter{
	
	public Line paint(Point P1, Point P2) {
		return new AssLine(P1.x, P1.y, P2.x, P2.y);
	}

}
