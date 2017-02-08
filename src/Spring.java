import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Spring extends ContactableObject{
	private boolean activated;
	private Image image = new ImageIcon("images/compression_spring.png").getImage();
	public Spring(int x, int y, int w, int h, double s)
	{
		super(x, y, w, h, s, true);
		activated = false;
	}
	public void setHeight(int h)
	{
		height = h;
	}
	public void setActivated(boolean a)
	{
		activated = a;
	}
	public double getSpringConstant()
	{
		return springConstant;
	}
	public boolean isActivated()
	{
		return activated;
	}
	@Override
	public void paint(Graphics g, Level a) {
		// TODO Auto-generated method stub
		//g.fillRect(xPos, yPos, width, height);
		g.drawImage(image, xPos, yPos, width, height, null);
	}
}
