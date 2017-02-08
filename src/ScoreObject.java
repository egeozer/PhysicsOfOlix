import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class ScoreObject extends Collectible{
	private int addToScore;
	int width =30;
	int height = 30;
	Image image = new ImageIcon("images/Coin.png").getImage();
	
	public ScoreObject(int x, int y)
	{
		super(x, y);
	}
	
	public ScoreObject() {
		
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
	
	public int getAddToScore()
	{
		return addToScore;
	}

	public void paint(Graphics g,Level a) {
		 g.drawImage(image, getXPos(), getYPos(), width, height, null );
		
	}
	
}
	
