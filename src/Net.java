import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Net extends ContactableObject{
	private int numberOfPolygons;

	Image image = new ImageIcon("images/Net.png").getImage();

	public Net(int x, int y, int n)
	{
		super(x, y,100,50);
	
		numberOfPolygons = n;
	}
	public void setNumberOfPolygons(int n)
	{
		numberOfPolygons = n;
	}
	
	public int getNumberOfPolygons()
	{
		return numberOfPolygons;
	}
	@Override
	public void paint(Graphics g, Level a) {
		//g.fillRect(getXPos(),getYPos(),getWidth(),getHeight());
		 g.drawImage(image, xPos, yPos, width, height, null );


		
	}
	
}
