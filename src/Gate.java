import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;

import javax.swing.ImageIcon;


public class Gate extends ContactableObject {
	private int numberOfLocks;
	private boolean locked;
	static int width =50;
	static int height = 50;
	Image image1 = new ImageIcon("images/gate.png").getImage();

	public Gate(int x, int y,int n)
	{
		super(x, y);
	
		numberOfLocks = n;
	}
	 public Gate() {
		// TODO Auto-generated constructor stub
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
		
	public void setNumberOfLocks(int n)
	{
		numberOfLocks = n;
	}
	public void setLocked(boolean l)
	{
		locked = l;
	}
	public int getNumberOfLocks()
	{
		return numberOfLocks;
	}
	public boolean isLocked()
	{
		return locked;
	}


	@Override
	public void paint(Graphics g, Level a) {
		// TODO Auto-generated method stub
		 g.drawImage(image1, xPos, yPos, width, height, null);
	}

}
