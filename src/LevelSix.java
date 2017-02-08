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


public class LevelSix extends Level  {
	boolean message1;
	
	public LevelSix()
	{
		super();
		platforms.add(new Platform(0, getHeight()-GROUNDHEIGHT, getWidth(), GROUNDHEIGHT, 0.5));
		platforms.add(new Platform(165, 570, 150, 30, 0.5));
		platforms.add(new Platform(350, 500, 150, 30, 0.5));
		platforms.add(new Platform(105, 430, 150, 30, 0.5));
		platforms.add(new Platform(380, 300, 150, 30, 0.5));
		platforms.add(new Platform(220, 180, 150, 30, 0.5));
		platforms.add(new Platform(790, 120, 150, 30, 0.5));
		platforms.add(new Platform(955, 230, 150, 30, 0.5));
		platforms.add(new Platform(530,300, 300, 0.5, 60));
		platforms.add(new Platform(530, 301, 100, 370, true));
		
		keys.add(new Key(290,160-new Key().height));
		keysCopy.add(new Key(290,160-new Key().height));
		
		polygons.add(new Sphere(830,100,20,20,20));
		polygonsCopy.add(new Sphere(830,100,20,20,20));
		
		scoreObjects.add(new ScoreObject(200,getHeight()-GROUNDHEIGHT-new ScoreObject().height));
		
		gate = new Gate(1000,230-50,1);
		gravity = 10;
		net = new Net(25,getHeight()-50-GROUNDHEIGHT,1);
	}
	public void paintComponent(Graphics g){
		g.drawImage(background, 0, 0, getWidth(), getHeight(), null);
		super.paintComponent(g);
	}
}