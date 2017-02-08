import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.Timer;


public class LevelFive extends Level  {
	boolean message1;
	public LevelFive()
	{
		super();
		platforms.add(new Platform(140, 320, 150, 30, 0.5));
		platforms.add(new Platform(360, 200, 150, 30, 0.5));
		platforms.add(new Platform(890, 245, 150, 430, true));
		platforms.add(new Platform(0, getHeight()-GROUNDHEIGHT, getWidth(), GROUNDHEIGHT, 0.5));
		
		springs.add(new Spring(840, getHeight()-GROUNDHEIGHT-50, 50, 50, 20));
		
		polygons.add(new Sphere(140,320-10,20,20,20));
		polygons.add(new Cube(380,200-10,20,20,20));
		
		polygonsCopy.add(new Sphere(140,320-10,20,20,20));
		polygonsCopy.add(new Cube(380,200-10,20,20,20));
		
		scoreObjects.add(new ScoreObject(450,100-new ScoreObject().height));
		scoreObjects.add(new ScoreObject(855,20));
		scoreObjects.add(new ScoreObject(855,50));
		scoreObjects.add(new ScoreObject(855,80));
		
		scoreObjectsCopy.add(new ScoreObject(450,100-new ScoreObject().height));
		scoreObjectsCopy.add(new ScoreObject(855,20));
		scoreObjectsCopy.add(new ScoreObject(855,50));
		scoreObjectsCopy.add(new ScoreObject(855,80));
		
		gate = new Gate(getWidth()-100,getHeight()-GROUNDHEIGHT-50,0);
		gravity = 10;
		net = new Net(500,getHeight()-50-GROUNDHEIGHT,2);
	}
	public void paintComponent(Graphics g){
		g.drawImage(backgroundSky, 0, 0, getWidth(), getHeight(), null);
		super.paintComponent(g);
		checkMessages();
		if(message1){
			g.setFont(new Font("Goudy Old Style", Font.BOLD, 25));
			g.setColor(Color.black);
			g.drawRect(getWidth()*5/7-10,50,410+10,170);
			g.drawString("Tip",getWidth()*5/7-10+185,70);
			g.setFont(new Font("Goudy Old Style", Font.PLAIN, 25));

			g.drawString(">Use the spring to jump higher!",getWidth()*5/7,100);
			g.drawString(">The more it compresses,",getWidth()*5/7,130);
			g.drawString("The higher you can jump!",getWidth()*5/7,160);
		}
	}
	public void checkMessages()
	{
		if(player.getXPos()>=100)
			message1 = true;
	}
}