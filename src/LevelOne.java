import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.SwingUtilities;
import javax.swing.Timer;


public class LevelOne extends Level  {
	boolean message1 = false;
	boolean message2 = false;
	boolean message3 = false;
	
	public LevelOne()
	{
		super();
		platforms.add(new Platform(0, getHeight()-GROUNDHEIGHT, getWidth(), GROUNDHEIGHT, 0.5));

		gate = new Gate(getWidth()-100,getHeight()-GROUNDHEIGHT-50,0);

		gravity = 10;
		scoreObjects.add(new ScoreObject(200,getHeight()-GROUNDHEIGHT-new ScoreObject().height));
		scoreObjects.add(new ScoreObject(230,getHeight()-GROUNDHEIGHT-new ScoreObject().height));
		scoreObjects.add(new ScoreObject(260,getHeight()-GROUNDHEIGHT-new ScoreObject().height));
		scoreObjects.add(new ScoreObject(560,500));
		scoreObjects.add(new ScoreObject(590,500));
		scoreObjects.add(new ScoreObject(320,611));
		scoreObjects.add(new ScoreObject(370,580));
		scoreObjects.add(new ScoreObject(426,550));
		scoreObjects.add(new ScoreObject(489,520));
		scoreObjects.add(new ScoreObject(647,525));
		scoreObjects.add(new ScoreObject(688,547));
		scoreObjects.add(new ScoreObject(739,585));
		scoreObjects.add(new ScoreObject(785,632));
		
		scoreObjectsCopy.add(new ScoreObject(200,getHeight()-GROUNDHEIGHT-new ScoreObject().height));
		scoreObjectsCopy.add(new ScoreObject(230,getHeight()-GROUNDHEIGHT-new ScoreObject().height));
		scoreObjectsCopy.add(new ScoreObject(260,getHeight()-GROUNDHEIGHT-new ScoreObject().height));
		scoreObjectsCopy.add(new ScoreObject(560,500));
		scoreObjectsCopy.add(new ScoreObject(590,500));
		scoreObjectsCopy.add(new ScoreObject(320,611));
		scoreObjectsCopy.add(new ScoreObject(370,580));
		scoreObjectsCopy.add(new ScoreObject(426,550));
		scoreObjectsCopy.add(new ScoreObject(489,520));
		scoreObjectsCopy.add(new ScoreObject(647,525));
		scoreObjectsCopy.add(new ScoreObject(688,547));
		scoreObjectsCopy.add(new ScoreObject(739,585));
		scoreObjectsCopy.add(new ScoreObject(785,632));
		//scoreObjects.add(new ScoreObject(886,523));
		//	setFocusable(true)
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

			g.drawString(">Welcome to the Physics of Olix!",getWidth()*5/7,100);
			
			g.drawString(">Use LEFT and RIGHT arrows",getWidth()*5/7,160);
			g.drawString("keys to walk around",getWidth()*5/7,190);
		}
		if(message2){
			g.drawString(">Collect coins for bonus score!",getWidth()*5/7,220);
		}
		if(message3){	
			g.drawString(">Walk into the gate to procede",getWidth()*5/7,250);
		}
	}
	
	public void checkMessages()
	{
		if(player.getXPos()>=0)
			message1 = true;
		if(player.getXPos()>=50)
			message2 = true;
		if(player.getXPos()>550)
			message3 =  true;
	}
}