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

public class LevelSeven extends Level  {
	boolean message1;
	
	public LevelSeven()
	{
		super();
		platforms.add(new Platform(1230, getHeight()-GROUNDHEIGHT-5, 500, true));
		platforms.add(new Platform(0, getHeight()-GROUNDHEIGHT, getWidth(), GROUNDHEIGHT, 0.5));
		platforms.add(new Platform(500, 250, 150, 30, 0.5));
		platforms.add(new Platform(830, 200, 250, 30, 0.5));
		platforms.add(new Platform(1340, 220, 150, 30, 0.5));
		platforms.add(new Platform(645,250, 210, 0.5, 75));
		platforms.add(new Platform(240,300, 275, 0.5, 79));
		platforms.add(new Platform(0,560, 150, 0.5, 90));
		platforms.add(new Platform(0,415, 150, 0.5, 90));
		platforms.add(new Platform(830,370, 150,30, 0.5));
		platforms.add(new Platform(680,490, 150,30, 0.5));
		platforms.add(new Platform(150, 300, 100, 370, true));
		platforms.add(new Platform(1130, 371, 100, 300, true));
		
		polygons.add(new Sphere(830,100,20,20,10));	
		polygons.add(new Sphere(940,350-20,20,20,10));
		polygons.add(new Sphere(360,650,20,20,10));
		
		polygonsCopy.add(new Sphere(830,100,20,20,10));
		polygonsCopy.add(new Sphere(940,350-20,20,20,10));
		polygonsCopy.add(new Sphere(360,650,20,20,10));
		
		springs.add(new Spring(400, getHeight()-GROUNDHEIGHT-70, 80, 70, 20));
		
		gate = new Gate(185,300-50,0);
		gravity = 12;
		net = new Net(500,250-50,3);
	}
	public void paintComponent(Graphics g){
		g.drawImage(background, 0, 0, getWidth(), getHeight(), null);
		super.paintComponent(g);
		if(message1){
			g.setColor(Color.black);
			g.drawRect(getWidth()*5/7-10,50,410+10,160);
			g.setFont(new Font("Goudy Old Style", Font.BOLD, 25));
			g.drawString("Tip",getWidth()*5/7-10+185,70);
			g.setFont(new Font("Goudy Old Style", Font.PLAIN, 25));
			
			g.drawString(">The player and a polygon can go ",getWidth()*5/7,100);
			g.drawString("through an angled platform from below.",getWidth()*5/7,130);
			g.drawString(">If you jump on a spring while there",getWidth()*5/7,160);
			g.drawString("are polygons on it, they will also jump",getWidth()*5/7,190);
		}
		checkMessages();
		
	}
	public void checkMessages()
	{
		if(player.getXPos()>=10)
			message1 = true;
		
	}
}