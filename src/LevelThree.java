import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.Timer;


public class LevelThree extends Level  {
	boolean message1 = false;
	
	public LevelThree()
	{
		super();
		platforms.add(new Platform(760, 290, 150, 30, 0.5));
		platforms.add(new Platform(300, 350, 200, 30, 0.5));
		platforms.add(new Platform(100, 200, 150, 30, 0.5));
		platforms.add(new Platform(1020, 550, 150, 30, 0.5));
		platforms.add(new Platform(700, 450, 150, 30, 0.5));
		platforms.add(new Platform(1250, 320, 150, 30, 0.5));
		platforms.add(new Platform(490, 555, 150, 30, 0.5));
		platforms.add(new Platform(450, 160, 200, 30, 0.5));
		platforms.add(new Platform(1250, 320+30, 150, 350, true));
		platforms.add(new Platform(700, 450+30, 150, 350, true));
		platforms.add(new Platform(0, getHeight()-GROUNDHEIGHT, getWidth(), GROUNDHEIGHT, 0.5));
		platforms.add(new Platform(1400, getHeight()-GROUNDHEIGHT-5, 300, true));
		platforms.add(new Platform(489, 555, 180, 0.5, 230));
		platforms.add(new Platform(620, 554, 125, 0.5, 38));
		
		scoreObjects.add(new ScoreObject(610,200));
		scoreObjects.add(new ScoreObject(300,155));
		scoreObjects.add(new ScoreObject(1320,140));
		scoreObjects.add(new ScoreObject(485,160-30));
		
		scoreObjectsCopy.add(new ScoreObject(485,160-30));
		scoreObjects.add(new ScoreObject(485+30,160-30));
		scoreObjectsCopy.add(new ScoreObject(485+30,160-30));
		scoreObjects.add(new ScoreObject(485+60,160-30));
		scoreObjectsCopy.add(new ScoreObject(485+60,160-30));
		scoreObjects.add(new ScoreObject(485+90,160-30));
		scoreObjectsCopy.add(new ScoreObject(485+90,160-30));
		scoreObjectsCopy.add(new ScoreObject(610,200));
		scoreObjectsCopy.add(new ScoreObject(300,155));
		scoreObjectsCopy.add(new ScoreObject(1320,140));
		
		keys.add(new Key(100,200-new Key().height));
		keys.add(new Key(760,290-new Key().height));
		keys.add(new Key(1260,320-new Key().height));

		keysCopy.add(new Key(100,200-new Key().height));
		keysCopy.add(new Key(760,250-new Key().height));
		keysCopy.add(new Key(1260,320-new Key().height));
		
		gate = new Gate(380,350-50,3);
		gravity = 11;
	}
	public void paintComponent(Graphics g){
		g.drawImage(backgroundSky, 0, 0, getWidth(), getHeight(), null);
		super.paintComponent(g);
		checkMessages();
	
		if(message1){
			g.drawRect(getWidth()*5/7-10,50,410+10,60);
			g.setFont(new Font("Goudy Old Style", Font.BOLD, 25));
			g.drawString("Tip",getWidth()*5/7-10+185,70);
			g.setFont(new Font("Goudy Old Style", Font.PLAIN, 25));

			g.drawString("Get the key(s) to unlock the gate!",getWidth()*5/7,100);
		}
	}
	public void checkMessages()
	{
		if(player.getXPos()>=300)
			message1 = true;
	}
}