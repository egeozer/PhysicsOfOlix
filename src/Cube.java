import java.awt.Color;
import java.awt.Graphics;


public class Cube extends Polygon{
	public Cube(int x, int y, int w, int h, int m)
	{
		super(x, y, w, h, m, false);
	}
	@Override
	public void paint(Graphics g, Level a) {
		g.setColor(Color.blue);
		g.fillRect(xPos,yPos,width,height);
	}
}
