import java.awt.Graphics;
import java.awt.Image;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;


public class StoryPanel1 extends JPanel implements MouseListener{

	Image storyP1 = new ImageIcon("GUI_Images/storyP1.png").getImage();
	Image continueB = new ImageIcon("GUI_Images/continueB.png").getImage();
	Level a = new Level();
	boolean continueClicked;

	public StoryPanel1(){
		addMouseListener(this);
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawImage(storyP1, 0, 0, a.getWidth(), a.getHeight(), null);
		g.drawImage(continueB, a.getWidth()*7/10, a.getHeight()*3/4, a.getWidth()/5, a.getHeight()/7, null);
	}
	
	public boolean isContinueClicked() {
		return continueClicked;
	}
	
	public void setContinueClicked(boolean continueClicked) {
		this.continueClicked = continueClicked;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
			PointerInfo c = MouseInfo.getPointerInfo();
			Point b = c.getLocation();
			SwingUtilities.convertPointFromScreen(b, e.getComponent());	//converting the mouseLocation into the panel
			
			int x = (int) b.getX();
			int y = (int) b.getY();	
			
			if((x>a.getWidth()*7/10 && x<(a.getWidth()*3/4+a.getWidth()/5)) && (y>a.getHeight()*3/4 && y<(a.getHeight()*3/4+a.getHeight()/7)))
				setContinueClicked(true);
				//System.out.println("s");		
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