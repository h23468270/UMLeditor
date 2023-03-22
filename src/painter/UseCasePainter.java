package painter;

import java.awt.Point;

import object.Objects;
import object.UseCase;

public class UseCasePainter extends Painter{
	public Objects paint(Point p) {
		return new UseCase(p.x, p.y);
	}

}
