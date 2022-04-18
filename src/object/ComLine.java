package object;

import java.awt.Graphics;

public class ComLine extends Line{
	private int diamondW = 10, diamondH = 10;
	public ComLine() {
	}

	public ComLine(int x1, int y1, int x2, int y2) {
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
	}
	
	public void draw(Graphics g) {
		g.drawLine(this.x1, this.y1, this.x2, this.y2);
		
		int dx = this.x2 - this.x1, dy = this.y2 - this.y1;
		double D = Math.sqrt(dx*dx + dy*dy);
		double xm = D - this.diamondW, xn = xm, ym = this.diamondH, yn = -this.diamondH, x;
		double sin = dy/D, cos = dx/D;
		
		x = xm*cos - ym*sin + this.x1;
        ym = xm*sin + ym*cos + this.y1;
        xm = x;

        x = xn*cos - yn*sin + this.x1;
        yn = xn*sin + yn*cos + this.y1;
        xn = x;
        
        double xq = (this.diamondH*2/D)*this.x1 + ((D-this.diamondH*2)/D)*this.x2;
        double yq = (this.diamondH*2/D)*this.y1 + ((D-this.diamondH*2)/D)*this.y2;
   
        int[] xpoints = {this.x2, (int) xm, (int) xq, (int) xn};
        int[] ypoints = {this.y2, (int) ym, (int) yq, (int) yn};

        g.fillPolygon(xpoints, ypoints, 4);
	}
}
