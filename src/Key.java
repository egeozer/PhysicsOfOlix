import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Key extends Collectible{
	int width = 40;
	int height = 20;
	Image image = new ImageIcon("images/Key.png").getImage();

	public Key(int x, int y)
	{
		super(x, y);
	}
	 public Key() {
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


	@Override
	public void paint(Graphics g, Level a) {
		 g.drawImage(image, getXPos(), getYPos(), width, height, null );

		
	}
	
}
