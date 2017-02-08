import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Player extends Fallable{
	boolean walking;
	boolean contact;
	double accelForce = 400;
	int rightIndex = 0;
	int leftIndex = 0;
	ImageIcon walkingAnim;
	Image rest = new ImageIcon("images/Olix Not Moving.png").getImage();
	Image restLeft = new ImageIcon("images/Olix Not Moving Left.png").getImage();
	Image[] right = {new ImageIcon("images/Olix Moving Right 1.png").getImage(), new ImageIcon("images/Olix Moving Right 2.png").getImage(), new ImageIcon("images/Olix Moving Right 3.png").getImage()};
	Image[] left = {new ImageIcon("images/Olix Moving Left 1.png").getImage(), new ImageIcon("images/Olix Moving Left 2.png").getImage(), new ImageIcon("images/Olix Moving Left 3.png").getImage()};
	Image currentImage = rest;
	
	public Player(){
		super(0, 600, 40, 40, 3, true, 50);
	}
	public boolean isWalking() {
		return walking;
	}
	public void setWalking(boolean isWalking) {
		this.walking = isWalking;
	}
	public  void paint(Graphics g, Level a){	//method that updates the ball's position
		g.drawImage(currentImage, xPos, yPos, width, height, null);
	}
}