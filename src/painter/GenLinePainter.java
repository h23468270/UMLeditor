package painter;

import java.awt.Point;

import object.GenLine;
import object.Line;

public class GenLinePainter extends Painter{
	public Line paint(Point P1, Point P2) {
		return new GenLine(P1.x, P1.y, P2.x, P2.y);
	}

}
