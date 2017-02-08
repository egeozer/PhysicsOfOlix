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


public class StoryPanel2 extends JPanel implements MouseListener{

	Image storyP2 = new ImageIcon("GUI_Images/storyP2.png").getImage();
	Image startB = new ImageIcon("GUI_Images/startB.png").getImage();

	boolean startClicked;

	Level a = new Level();
	
	public StoryPanel2(){
		addMouseListener(this);
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);	
		 g.drawImage(storyP2, 0, 0, a.getWidth(), a.getHeight(), null );
			g.drawImage(startB, a.getWidth()/10, a.getHeight()*4/5, a.getWidth()/5, a.getHeight()/7, null );
	}
	
	public boolean isStartClicked() {
		return startClicked;
	}
	public void setStartClicked(boolean startClicked) {
		this.startClicked = startClicked;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
				PointerInfo c = MouseInfo.getPointerInfo();
				Point b = c.getLocation();
				SwingUtilities.convertPointFromScreen(b, e.getComponent());	//converting the mouseLocation into the panel
				
				int x = (int) b.getX();
				int y = (int) b.getY();
				
				if((x>a.getWidth()/10 && x<(a.getWidth()/10+a.getWidth()/5)) && (y>a.getHeight()*4/5 && y<(a.getHeight()*4/5+a.getHeight()/7)))
					setStartClicked(true);	
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub	
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub	
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub	
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub	
	}
}