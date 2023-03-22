package painter;

import java.awt.Point;

import object.ComLine;
import object.Line;

public class ComLinePainter extends Painter{
	public Line paint(Point P1, Point P2) {
		return new ComLine(P1.x, P1.y, P2.x, P2.y);
	}
}
