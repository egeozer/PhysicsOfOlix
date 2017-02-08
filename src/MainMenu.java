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


public class MainMenu extends JPanel implements MouseListener{
	Image image = new ImageIcon("GUI_Images/BetterGui.png").getImage();
	ImageIcon image1 =  new ImageIcon("GUI_Images/start.png");
	Image startB = new ImageIcon("GUI_Images/startB.png").getImage();
	Image optionsB = new ImageIcon("GUI_Images/optionsB.png").getImage();
	Image exitB = new ImageIcon("GUI_Images/exitB.png").getImage();
	boolean startClicked;
	boolean exitClicked;
	boolean optionClicked;


	
	

	public boolean isOptionClicked() {
		return optionClicked;
	}

	public void setOptionClicked(boolean optionClicked) {
		this.optionClicked = optionClicked;
	}

	JLabel start = new JLabel(image1);
	
	JLabel continu = new JLabel("GUI_Images/GuiBetter.png");
	JLabel exit = new JLabel("GUI_Images/GuiBetter.png");
	Level a = new Level();
	
	public MainMenu(){
		addMouseListener(this);
	}
	
	public boolean isStartClicked() {
		return startClicked;
	}

	public void setStartClicked(boolean startCliked) {
		this.startClicked = startCliked;
	}

	public boolean isExitClicked() {
		return exitClicked;
	}

	public void setExitClicked(boolean exitClicked) {
		this.exitClicked = exitClicked;
	}

	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		 g.drawImage(image, 0, 0, a.getWidth(), a.getHeight(), null );
		g.drawImage(startB, a.getWidth()/8, a.getHeight()*2/3, a.getWidth()/5, a.getHeight()/7, null );
		g.drawImage(optionsB, a.getWidth()*39/99, a.getHeight()*2/3, a.getWidth()/5, a.getHeight()/7, null );
		g.drawImage(exitB, a.getWidth()*2/3, a.getHeight()*2/3, a.getWidth()/5, a.getHeight()/7, null );

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
		// TODO Auto-generated method stub
		PointerInfo c = MouseInfo.getPointerInfo();
		Point b = c.getLocation();
		SwingUtilities.convertPointFromScreen(b, e.getComponent());	//converting the mouseLocation into the panel

		int x = (int) b.getX();
		int y = (int) b.getY();
		
		if((x>a.getWidth()/8 && x<(a.getWidth()/8+a.getWidth()/5)) && (y>a.getHeight()*2/3 && y<(a.getHeight()*2/3+a.getHeight()/7)))
			setStartClicked(true);
		
		if((x>a.getWidth()*39/99 && x<(a.getWidth()*39/99+a.getWidth()/5)) && (y>a.getHeight()*2/3 && y<(a.getHeight()*2/3+a.getHeight()/7)))
			setOptionClicked(true);
		
		if((x>a.getWidth()*2/3 && x<(a.getWidth()*2/3+a.getWidth()/5)) && (y>a.getHeight()*2/3 && y<(a.getHeight()*2/3+a.getHeight()/7)))
			setExitClicked(true);

		//System.out.println("s");
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		//System.out.println("kkkkkkkkkkks");
		
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
