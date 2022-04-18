package object;

import java.awt.Graphics;


public class AssLine extends Line{
	private int arrowW = 10, arrowH = 10;
	
	public AssLine() {
	}
	
	public AssLine(int x1, int y1, int x2, int y2) {		
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
	}

	public void draw(Graphics g) {
		
		g.drawLine(this.x1, this.y1, this.x2, this.y2);
		
		int dx = this.x2 - this.x1, dy = this.y2 - this.y1;
		double D = Math.sqrt(dx*dx + dy*dy);
		double xm = D - this.arrowW, xn = xm, ym = this.arrowH, yn = -this.arrowH, x;
		double sin = dy/D, cos = dx/D;
		
		x = xm*cos - ym*sin + this.x1;
        ym = xm*sin + ym*cos + this.y1;
        xm = x;
        
        x = xn*cos - yn*sin + this.x1;
        yn = xn*sin + yn*cos + this.y1;
        xn = x;
        
        g.drawLine((int)xm, (int)ym, this.x2, this.y2);   
        g.drawLine((int)xn, (int)yn, this.x2, this.y2);   
        
		
	}

}
