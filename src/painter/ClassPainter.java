package painter;

import java.awt.Point;

import object.Class;
import object.Objects;

public class ClassPainter extends Painter{
	public Objects paint(Point p) {
		return new Class(p.x, p.y);
	}
}
