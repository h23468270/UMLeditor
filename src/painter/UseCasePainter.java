package painter;

import java.awt.Point;

import object.Object;
import object.UseCase;

public class UseCasePainter extends Painter{
	public Object paintObject(Point p) {
		return new UseCase(p.x, p.y);
	}

}
