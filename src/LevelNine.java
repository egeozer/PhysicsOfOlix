import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.Timer;


public class LevelNine extends Level  {
	boolean startLevel = false;
	public LevelNine()
	{
		super();
		player.xPos = 10;
		player.yPos = 0;
		platforms.add(new Platform(0, getHeight()-GROUNDHEIGHT, getWidth(), GROUNDHEIGHT, 0.5));
		platforms.add(new Platform(0, 100, 1400, 0.5, 90));
		platforms.add(new Platform(100, 200, 1400, 0.5, 90));
		platforms.add(new Platform(0, 300, 1400, 0.5, 90));
		platforms.add(new Platform(100, 400, 1400, 0.5, 90));
		platforms.add(new Platform(0, 500, 1400, 0.5, 90));
		
		scoreObjects.add(new ScoreObject(750,590));
		scoreObjects.add(new ScoreObject(1050,275));
		scoreObjects.add(new ScoreObject(395,290));
		scoreObjects.add(new ScoreObject(1270,275));
		
		scoreObjectsCopy.add(new ScoreObject(750,590));
		scoreObjectsCopy.add(new ScoreObject(1050,275));
		scoreObjectsCopy.add(new ScoreObject(395,290));
		scoreObjectsCopy.add(new ScoreObject(1270,275));
		
		gate = new Gate(200,getHeight()-GROUNDHEIGHT-50,0);
		gravity = 5;
	}
	public void paintComponent(Graphics g){
		if(!startLevel)
		{
			startLevel = true;
			player.xPos = 10;
			player.yPos = 0;
		}
		g.drawImage(backgroundSky, 0, 0, getWidth(), getHeight(), null);
		super.paintComponent(g);
	}
}