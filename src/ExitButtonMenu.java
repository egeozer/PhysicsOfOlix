import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;


public class ExitButtonMenu extends JPanel implements MouseListener{
	Image exitSub = new ImageIcon("GUI_Images/exitMenu.png").getImage();

	Image exitB = new ImageIcon("GUI_Images/exitB.png").getImage();
	Image backB = new ImageIcon("GUI_Images/backB.png").getImage();
	boolean backClicked;
	boolean exitClicked;


	Level a = new Level();
	
	public ExitButtonMenu(){
		addMouseListener(this);
		//setRelativeTo(null);
	}
	

	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		 g.drawImage(exitSub, 0, 0, a.getWidth(), a.getHeight(), null );
		
			g.drawImage(exitB, a.getWidth()*5/9, a.getHeight()*2/3, a.getWidth()/5, a.getHeight()/7, null );
			g.drawImage(backB, a.getWidth()/4, a.getHeight()*2/3, a.getWidth()/5, a.getHeight()/7, null );
			//g.draw



	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		PointerInfo c = MouseInfo.getPointerInfo();
		Point b = c.getLocation();
		SwingUtilities.convertPointFromScreen(b, e.getComponent());	//converting the mouseLocation into the panel

		int x = (int) b.getX();
		int y = (int) b.getY();
		
		if((x>a.getWidth()*5/9 && x<(a.getWidth()*5/9+a.getWidth()/5)) && (y>a.getHeight()*2/3 && y<(a.getHeight()*2/3+a.getHeight()/7)))
			setExitClicked(true);	
		

		if((x>a.getWidth()/4 && x<(a.getWidth()/4+a.getWidth()/5)) && (y>a.getHeight()*2/3 && y<(a.getHeight()*2/3+a.getHeight()/7)))
			setBackClicked(true);


		
	}
	public boolean isExitClicked() {
		return exitClicked;
	}



	public void setExitClicked(boolean exitClicked) {
		this.exitClicked = exitClicked;
	}



	public boolean isBackClicked() {
		return backClicked;
	}



	public void setBackClicked(boolean backClicked) {
		this.backClicked = backClicked;
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
