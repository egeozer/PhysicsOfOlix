import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.Timer;


public class LevelEight extends Level  {
	public LevelEight()
	{
		super();
		platforms.add(new Platform(140, 320, 150, 30, 0.5));
		platforms.add(new Platform(360, 190, 150, 30, 0.5));
		platforms.add(new Platform(1210, 320, 150, 30, 0.5));
		platforms.add(new Platform(990, 190, 150, 30, 0.5));
		platforms.add(new Platform(0, getHeight()-GROUNDHEIGHT, getWidth(), GROUNDHEIGHT, 0.5));
		platforms.add(new Platform(660, 540, 180, 30, 0.5));
		platforms.add(new Platform(510, 195, 150, 375, true));
		platforms.add(new Platform(840, 195, 150, 375, true));
		
		springs.add(new Spring(0, getHeight()-GROUNDHEIGHT-50, 50, 50, 20));
		springs.add(new Spring(50, getHeight()-GROUNDHEIGHT-50, 50, 50, 20));
		springs.add(new Spring(100, getHeight()-GROUNDHEIGHT-50, 50, 50, 20));
		springs.add(new Spring(150, getHeight()-GROUNDHEIGHT-50, 50, 50, 20));
		springs.add(new Spring(200, getHeight()-GROUNDHEIGHT-50, 50, 50, 20));
		springs.add(new Spring(250, getHeight()-GROUNDHEIGHT-50, 50, 50, 20));
		springs.add(new Spring(300, getHeight()-GROUNDHEIGHT-50, 50, 50, 20));
		springs.add(new Spring(350, getHeight()-GROUNDHEIGHT-50, 50, 50, 20));
		springs.add(new Spring(400, getHeight()-GROUNDHEIGHT-50, 50, 50, 20));
		springs.add(new Spring(450, getHeight()-GROUNDHEIGHT-50, 50, 50, 20));
		springs.add(new Spring(500, getHeight()-GROUNDHEIGHT-50, 50, 50, 20));
		springs.add(new Spring(550, getHeight()-GROUNDHEIGHT-50, 50, 50, 20));
		springs.add(new Spring(600, getHeight()-GROUNDHEIGHT-50, 50, 50, 20));
		springs.add(new Spring(650, getHeight()-GROUNDHEIGHT-50, 50, 50, 20));
		springs.add(new Spring(700, getHeight()-GROUNDHEIGHT-50, 50, 50, 20));
		springs.add(new Spring(750, getHeight()-GROUNDHEIGHT-50, 50, 50, 20));
		springs.add(new Spring(800, getHeight()-GROUNDHEIGHT-50, 50, 50, 20));
		springs.add(new Spring(850, getHeight()-GROUNDHEIGHT-50, 50, 50, 20));
		springs.add(new Spring(900, getHeight()-GROUNDHEIGHT-50, 50, 50, 20));
		springs.add(new Spring(950, getHeight()-GROUNDHEIGHT-50, 50, 50, 20));
		springs.add(new Spring(1000, getHeight()-GROUNDHEIGHT-50, 50, 50, 20));
		springs.add(new Spring(1050, getHeight()-GROUNDHEIGHT-50, 50, 50, 20));
		springs.add(new Spring(1100, getHeight()-GROUNDHEIGHT-50, 50, 50, 20));
		springs.add(new Spring(1150, getHeight()-GROUNDHEIGHT-50, 50, 50, 20));
		springs.add(new Spring(1200, getHeight()-GROUNDHEIGHT-50, 50, 50, 20));
		springs.add(new Spring(1250, getHeight()-GROUNDHEIGHT-50, 50, 50, 20));
		springs.add(new Spring(1300, getHeight()-GROUNDHEIGHT-50, 50, 50, 20));
		springs.add(new Spring(1350, getHeight()-GROUNDHEIGHT-50, 50, 50, 20));
		springs.add(new Spring(1400, getHeight()-GROUNDHEIGHT-50, 50, 50, 20));
		springs.add(new Spring(1450, getHeight()-GROUNDHEIGHT-50, 50, 50, 20));
		
		scoreObjects.add(new ScoreObject(750,590));
		scoreObjects.add(new ScoreObject(1050,275));
		scoreObjects.add(new ScoreObject(395,290));
		scoreObjects.add(new ScoreObject(1270,275));
		
		scoreObjectsCopy.add(new ScoreObject(750,590));
		scoreObjectsCopy.add(new ScoreObject(1050,275));
		scoreObjectsCopy.add(new ScoreObject(395,290));
		scoreObjectsCopy.add(new ScoreObject(1270,275));
		
		gate = new Gate(725, 490, 0);
		gravity = 10;
	}
	public void paintComponent(Graphics g){
		g.drawImage(backgroundSky, 0, 0, getWidth(), getHeight(), null);
		super.paintComponent(g);
	}
}