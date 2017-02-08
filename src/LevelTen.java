import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.Timer;


public class LevelTen extends Level  {
	boolean message1;
	public LevelTen()
	{
		super();
		platforms.add(new Platform(0, getHeight()-GROUNDHEIGHT, getWidth(), GROUNDHEIGHT, 0.5));
		
		keys.add(new Key(185, 210));
		keys.add(new Key(1275, 210));
		keysCopy.add(new Key(185, 210));
		keysCopy.add(new Key(1275, 210));
		
		gate = new Gate(725,50,2);
		gravity = 2;
	}
	public void paintComponent(Graphics g){
		g.drawImage(backgroundSky, 0, 0, getWidth(), getHeight(), null);
		super.paintComponent(g);
		checkMessages();
		if(message1){
			g.setFont(new Font("Goudy Old Style", Font.BOLD, 25));
			g.setColor(Color.black);
			g.drawRect(getWidth()*5/7-10,50,410+10,130);
			g.drawString("Tip",getWidth()*5/7-10+185,70);
			g.setFont(new Font("Goudy Old Style", Font.PLAIN, 25));

			g.drawString(">This is the last level!",getWidth()*5/7,100);
			g.drawString(">Jump up to get back to the",getWidth()*5/7,130);
			g.drawString("Andromeda Galaxy!",getWidth()*5/7,160);
		}
	}
	public void checkMessages()
	{
		if(player.getXPos()>=10)
			message1 = true;
	}
}