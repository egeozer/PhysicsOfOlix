import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.Timer;


public class LevelFour extends Level  {
	boolean message1;
	boolean message2;
	public LevelFour()
	{
		super();
		platforms.add(new Platform(360, 200, 150, 30, 0.5));
		platforms.add(new Platform(0, 270, 150, 30, 0.5));
		platforms.add(new Platform(150, 400, 150, 30, 0.5));
		platforms.add(new Platform(300, 500, 150, 30, 0.5));
		platforms.add(new Platform(0, getHeight()-GROUNDHEIGHT, getWidth(), GROUNDHEIGHT, 0.5));
		platforms.add(new Platform(900,getHeight()-GROUNDHEIGHT, 500, 0.5, 60));
		platforms.add(new Platform(1330, 400, 150, 30, 0.5));
		
		polygons.add(new Cube(1360,400-10,20,20,20));
		polygons.add(new Cube(255,400-10,20,20,20));
		polygons.add(new Cube(425,200-10,20,20,20));
		polygons.add(new Sphere(20,270-10,20,20,20));
		
		polygonsCopy.add(new Cube(1360,400-10,20,20,20));
		polygonsCopy.add(new Cube(255,400-10,20,20,20));
		polygonsCopy.add(new Cube(425,200-10,20,20,20));
		polygonsCopy.add(new Sphere(20,270-10,20,20,20));
		
		scoreObjects.add(new ScoreObject(450,100-new ScoreObject().height));
		scoreObjects.add(new ScoreObject(450,100-new ScoreObject().height));
		scoreObjects.add(new ScoreObject(980,583));
		scoreObjects.add(new ScoreObject(1030,553));
		scoreObjects.add(new ScoreObject(1105,510));
		
		scoreObjectsCopy.add(new ScoreObject(450,100-new ScoreObject().height));
		scoreObjectsCopy.add(new ScoreObject(450,100-new ScoreObject().height));
		scoreObjectsCopy.add(new ScoreObject(980,583));
		scoreObjectsCopy.add(new ScoreObject(1030,553));
		scoreObjectsCopy.add(new ScoreObject(1105,510));
		
		gate = new Gate(getWidth()-100,getHeight()-GROUNDHEIGHT-50,0);
		
		gravity = 10;
		net = new Net(800,getHeight()-50-GROUNDHEIGHT,4);
	}
	public void paintComponent(Graphics g){
		g.drawImage(backgroundSky, 0, 0, getWidth(), getHeight(), null);
		super.paintComponent(g);
		
		checkMessages();
		if(message1){
			g.setFont(new Font("Goudy Old Style", Font.BOLD, 25));
			g.setColor(Color.black);
			g.drawRect(getWidth()*5/7-10,50,410+10,200);
			g.drawString("Tip",getWidth()*5/7-10+185,70);
			g.setFont(new Font("Goudy Old Style", Font.PLAIN, 25));

			g.drawString(">Gather all the polygons" ,getWidth()*5/7,100);
			g.drawString("inside the net",getWidth()*5/7,130);
			g.drawString("in order to unlock the gate!",getWidth()*5/7,160);
			g.drawString(">Hold the 'X' key to push",getWidth()*5/7,190);
		}
		if(message2){
			g.drawString(">Use the slide to roll the sphere!",getWidth()*5/7,220);
		}
	}
	public void checkMessages()
	{
		if(player.getXPos()>=100)
			message1 = true;
		if(player.getXPos()>=800)
			message2 = true;
	}
}