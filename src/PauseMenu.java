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

public class PauseMenu extends JPanel implements MouseListener,KeyListener{
	Image pauseMenu = new ImageIcon("GUI_Images/pauseMenu.png").getImage();
	//Image resumeB = new ImageIcon("GUI_Images/resume.png").getImage();
	//Image restart = new ImageIcon("GUI_Images/restart.png").getImage();
	//Image exitB = new ImageIcon("GUI_Images/exit.png").getImage();
	boolean resumeClicked, restartClicked, menuClicked;
	//Level a = new Level();
	
	public PauseMenu(){
		addMouseListener(this);
		addKeyListener(this);
		setFocusable(true);
	}
	
	public boolean isResumeClicked() {
		return resumeClicked;
	}
	public void setResumeClicked(boolean resumeClicked) {
		this.resumeClicked = resumeClicked;
	}
	public boolean isRestartClicked() {
		return restartClicked;
	}
	public void setRestartClicked(boolean restartClicked) {
		this.restartClicked = restartClicked;
	}
	public boolean isMenuClicked() {
		return menuClicked;
	}
	public void setMenuClicked(boolean menuClicked) {
		this.menuClicked = menuClicked;
	}
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawImage(pauseMenu, 0, 0, 400, 150, null);
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		PointerInfo c = MouseInfo.getPointerInfo();
		Point b = c.getLocation();
		SwingUtilities.convertPointFromScreen(b, e.getComponent());	//converting the mouseLocation into the panel
		
		int x = (int) b.getX();
		int y = (int) b.getY();
		
		if((x>0 && x<(0+getWidth()/3)) && (y>getHeight()/3 && y<(getHeight()/3+getHeight()/3)))
			setResumeClicked(true);
		if((x>getWidth()/3 && x<(getWidth()/3+getWidth()/3)) && (y>getHeight()/3 && y<(getHeight()/3+getHeight()/3)))	
			setMenuClicked(true);
		if((x>getWidth()*2/3 && x<(getWidth()*2/3+getWidth()/3)) && (y>getHeight()/3 && y<(getHeight()/3+getHeight()/3)))
			setRestartClicked(true);
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
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode()==KeyEvent.VK_ESCAPE)
		{
			if(Game.pauseFrame.isVisible())
				Game.pauseFrame.setVisible(false);
			//	a.k++;
			//System.out.println(a.k);
			repaint();
			validate();
			//levels[i].space();
		}
	}
	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
	}
	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
	}
}