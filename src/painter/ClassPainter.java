package painter;

import java.awt.Point;

import object.Class;
import object.Object;

public class ClassPainter extends Painter{
	public Object paintObject(Point p) {
		return new Class(p.x, p.y);
	}
}
