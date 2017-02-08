import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;


public class Sphere extends Polygon {
	double xVelocity = 5;
	double yVelocity = 0;
	boolean falling;
	int width;
	int heigth;
	
	
	public Sphere(int x, int y, int w, int h, int m)
	{
		super(x, y, w, h, m, true);
		width=w;
		heigth=h;
	}
	public Sphere(int x, int y, int d, int m)
	{
		super(x, y, d, d, m, true);
	}

	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeigth() {
		return heigth;
	}
	public void setHeigth(int heigth) {
		this.heigth = heigth;
	}
	
	@Override
	public void paint(Graphics g, Level a) {
		g.setColor(Color.blue);
		g.fillOval(xPos,yPos,getWidth(),getHeigth());		
	}
}
