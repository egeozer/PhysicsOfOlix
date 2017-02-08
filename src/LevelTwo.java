import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.Timer;
//

public class LevelTwo extends Level  {
	boolean message1 = false;
	boolean message2 = false;
	boolean message3 = false;
	public LevelTwo()
	{
		super();
		platforms.add(new Platform(120, 570, 150, 30, 0.5));
		platforms.add(new Platform(310, 450, 150, 30, 0.5));
		platforms.add(new Platform(565, 350, 150, 30, 0.5));
		platforms.add(new Platform(250, 150, 150, 30, 0.5));
		platforms.add(new Platform(800, 300, 150, 30, 0.5));
		platforms.add(new Platform(525, 200, 150, 30, 0.5));
		platforms.add(new Platform(1100, 420, 150, 30, 0.5));
		platforms.add(new Platform(970, 555, 150, 30, 0.5));
		platforms.add(new Platform(760, 114, 150, 30, 0.5));
		platforms.add(new Platform(800, 330, 150, 350, true));
		platforms.add(new Platform(310, 450+30, 150, 350, true));
		platforms.add(new Platform(565, 350+30, 150, 350, true));
		platforms.add(new Platform(460, getHeight()-GROUNDHEIGHT-5, 100, true));
		platforms.add(new Platform(714, getHeight()-GROUNDHEIGHT-5, 100, true));
		platforms.add(new Platform(0, getHeight()-GROUNDHEIGHT, getWidth(), GROUNDHEIGHT, 0.5));
		
		scoreObjects.add(new ScoreObject(250,150-new ScoreObject().height));
		scoreObjects.add(new ScoreObject(270,150-new ScoreObject().height));
		scoreObjects.add(new ScoreObject(290,150-new ScoreObject().height));
		scoreObjects.add(new ScoreObject(540,200-new ScoreObject().height));
		scoreObjects.add(new ScoreObject(560,200-new ScoreObject().height));
		scoreObjects.add(new ScoreObject(580,200-new ScoreObject().height));
		scoreObjects.add(new ScoreObject(770,114-new ScoreObject().height));
		scoreObjects.add(new ScoreObject(790,114-new ScoreObject().height));
		scoreObjects.add(new ScoreObject(810,114-new ScoreObject().height));
		scoreObjects.add(new ScoreObject(9,186));
		scoreObjects.add(new ScoreObject(9,186-new ScoreObject().height));
		
		scoreObjectsCopy.add(new ScoreObject(250,150-new ScoreObject().height));
		scoreObjectsCopy.add(new ScoreObject(270,150-new ScoreObject().height));
		scoreObjectsCopy.add(new ScoreObject(290,150-new ScoreObject().height));
		scoreObjectsCopy.add(new ScoreObject(540,200-new ScoreObject().height));
		scoreObjectsCopy.add(new ScoreObject(560,200-new ScoreObject().height));
		scoreObjectsCopy.add(new ScoreObject(580,200-new ScoreObject().height));
		scoreObjectsCopy.add(new ScoreObject(770,114-new ScoreObject().height));
		scoreObjectsCopy.add(new ScoreObject(790,114-new ScoreObject().height));
		scoreObjectsCopy.add(new ScoreObject(810,114-new ScoreObject().height));
		scoreObjectsCopy.add(new ScoreObject(9,186));
		scoreObjectsCopy.add(new ScoreObject(9,186-new ScoreObject().height));
		
		gate = new Gate(getWidth()-100,getHeight()-GROUNDHEIGHT-50,0);
		
		gravity = 12;
	}
	public void paintComponent(Graphics g){
		g.drawImage(backgroundSky, 0, 0, getWidth(), getHeight(), null);
		super.paintComponent(g);
		checkMessages();
		if(message1){
			g.setColor(Color.black);
			g.drawRect(getWidth()*5/7-10,50,410+10,220);
			g.setFont(new Font("Goudy Old Style", Font.BOLD, 25));
			g.drawString("Tip",getWidth()*5/7-10+185,70);	
			g.setFont(new Font("Goudy Old Style", Font.PLAIN, 25));
			g.drawString(">Use SPACE Bar to JUMP!",getWidth()*5/7,100);
		}
		if(message2){
			g.drawString(">If you get stuck, you will need to restart!",getWidth()*5/7,130);
			g.drawString(">Press ESC then click 'Restart'",getWidth()*5/7,160);
		}
		if(message3){
			g.drawString(">Accelerate to jump farther!",getWidth()*5/7,190);
			g.drawString(">Don't forget to collect coins!",getWidth()*5/7,220);
		}
	}
	public void checkMessages()
	{
		if(player.getXPos()>=0)
			message1 = true;
		if(player.getXPos()>=300)
			message2 = true;
		if(player.getXPos()>550)
			message3 =  true;
	}
}