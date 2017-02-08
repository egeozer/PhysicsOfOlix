import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class LevelCompleteMenu extends JPanel implements MouseListener{
	Image image = new ImageIcon("GUI_Images/statBar.png").getImage();
	boolean resumeClicked, highScore, bestTime;
	int score, minutes, seconds, milliseconds;
	
	public LevelCompleteMenu(){
		addMouseListener(this);
		setFocusable(true);
	}
	
	public LevelCompleteMenu(int score, int minutes, int seconds, int milliseconds, boolean time, boolean highScore)
	{
		addMouseListener(this);
		setFocusable(true);
		resumeClicked = false;
		this.score = score;
		this.minutes = minutes;
		this.seconds = seconds;
		this.milliseconds = milliseconds;
		bestTime = time;
		this.highScore = highScore;
	}
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.setFont(new Font("Goudy Old Style", Font.PLAIN, 20));

		g.drawImage(image, 0, 0, 400, 150, null);
		g.drawString((">Score " + score), 70, 90);
		if(seconds>9)
			g.drawString((">Time "+minutes+":"+seconds+":"+milliseconds), 70, 110);
		else
			g.drawString((">Time "+minutes+":0"+seconds+":"+milliseconds), 70, 110);
		g.setColor(Color.RED);
		if(highScore)
			g.drawString("New High Score!", 200, 90);
		if(bestTime)
			g.drawString("New Best Time!", 200, 110);
		g.setColor(Color.BLACK);
		g.drawString("Click here to continue to the next level", 40, 130);
	}
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		if(Game.scoreFrame.isVisible())
		{
			
			
			resumeClicked = true;
		}
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}