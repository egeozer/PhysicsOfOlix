import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;


public class storyEnd extends JPanel implements MouseListener{
	Image storyEnd = new ImageIcon("GUI_Images/endStory.png").getImage();
	Image continueB = new ImageIcon("GUI_Images/continueB.png").getImage();
boolean continueClicked;


	Level a = new Level();
	
	public storyEnd(){
		addMouseListener(this);
	
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);	
		g.drawImage(storyEnd, 0, 0, a.getWidth(), a.getHeight(), null );
		g.drawImage(continueB, a.getWidth()*9/12, a.getHeight()*5/6, a.getWidth()/5, a.getHeight()/7, null );
		
		
	}
	
	
	
	@Override
	public void mouseClicked(MouseEvent e) {
		PointerInfo c = MouseInfo.getPointerInfo();
		Point b = c.getLocation();
		SwingUtilities.convertPointFromScreen(b, e.getComponent());	//converting the mouseLocation into the panel
		
		int x = (int) b.getX();
		int y = (int) b.getY();
		
		if((x>a.getWidth()*9/12 && x<(a.getWidth()*9/12+a.getWidth()/5)) && (y>a.getHeight()*5/6 && y<(a.getHeight()*5/6+a.getHeight()/7)))
			setContinueClicked(true);
		
		
	}
	
	
	public boolean isContinueClicked() {
		return continueClicked;
	}

	public void setContinueClicked(boolean continueClicked) {
		this.continueClicked = continueClicked;
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub	
	}
	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub	
	}
	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub	
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub	
	}
}