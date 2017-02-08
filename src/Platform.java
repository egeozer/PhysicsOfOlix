import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.*;

import javax.swing.ImageIcon;

//
public class Platform extends ContactableObject{
	private double angle;
	private ImageIcon platform = new ImageIcon("images/Possible Platform 2 (cropped).png");
	private ImageIcon obstacle = new ImageIcon("images/obstacle.jpg");
	boolean wall = false;
	
	//For a normal platform
	public Platform(int x, int y, int w, int h, double f)
	{
		super(x, y, w, h, f);
		//System.out.println("x " + x + " y " + y + " width " + width )
		angle = 0;
	}
	//For a death platform (which I think we got rid of?)
	public Platform(int x, int y, int w, boolean d)
	{
		super(x, y, w, d);
		//System.out.println("x " + x + " y " + y + " width " + width )
		angle = 0;
	}
	//For an obstacle
	public Platform(int x, int y, int w, int h, boolean o)
	{
		super(x, y, w, h);
		wall= o;
		//System.out.println("x " + x + " y " + y + " width " + width )
		angle = 0;
	}
	//For an angled platform
	public Platform(int x, int y, int length, double f, double a)
	{
		super(x, y, length, f, a);
		angle = a;
	}
	public int getHeight()
	{
		return height;
	}
	public int getWidth()
	{
		return width;
	}
	public double getFriction()
	{
		return friction;
	}
	@Override
	public void paint(Graphics g, Level a) {
		if(angle > 0)
		{
			g.setColor(Color.black);
			g.drawLine(xPos, yPos, x2, y2);
		}
		else
		{
			if(!wall && !dead)
				g.drawImage(platform.getImage(), xPos, yPos, width, height, null);
			
			else if(wall)
				g.drawImage(obstacle.getImage(), xPos, yPos, width, height, null);
		}
	}
}
