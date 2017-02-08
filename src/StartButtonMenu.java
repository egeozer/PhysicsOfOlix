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


public class StartButtonMenu extends JPanel implements MouseListener{
	Image startSub = new ImageIcon("GUI_Images/StartMenu.png").getImage();
	Image startB = new ImageIcon("GUI_Images/startB.png").getImage();
	Image backB = new ImageIcon("GUI_Images/backB.png").getImage();
	Image continueB = new ImageIcon("GUI_Images/continueB.png").getImage();
	Image chooseB = new ImageIcon("GUI_Images/chooseB.png").getImage();


	boolean startClicked;
	boolean backClicked;
	boolean continueClicked;
	boolean chooseClicked;




	

	Level a = new Level();
	
	public StartButtonMenu(){
		addMouseListener(this);
	}
	

	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		 g.drawImage(startSub, 0, 0, a.getWidth(), a.getHeight(), null );
			g.drawImage(startB, a.getWidth()/10, a.getHeight()*2/3, a.getWidth()/5, a.getHeight()/7, null );
			g.drawImage(continueB, a.getWidth()*3/10, a.getHeight()*2/3, a.getWidth()/5, a.getHeight()/7, null );

			g.drawImage(chooseB, a.getWidth()*1/2, a.getHeight()*2/3, a.getWidth()/5, a.getHeight()/7, null );
			g.drawImage(backB, a.getWidth()*7/10, a.getHeight()*2/3, a.getWidth()/5, a.getHeight()/7, null );



	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		PointerInfo c = MouseInfo.getPointerInfo();
		Point b = c.getLocation();
		SwingUtilities.convertPointFromScreen(b, e.getComponent());	//converting the mouseLocation into the panel

		int x = (int) b.getX();
		int y = (int) b.getY();
		
		if((x>a.getWidth()/10 && x<(a.getWidth()/10+a.getWidth()/5)) && (y>a.getHeight()*2/3 && y<(a.getHeight()*2/3+a.getHeight()/7)))
			setStartClicked(true);	
		
		if((x>a.getWidth()*3/10 && x<(a.getWidth()*3/10+a.getWidth()/5)) && (y>a.getHeight()*2/3 && y<(a.getHeight()*2/3+a.getHeight()/7)))
			setContinueClicked(true);
		
		if((x>a.getWidth()*1/2 && x<(a.getWidth()*1/2+a.getWidth()/5)) && (y>a.getHeight()*2/3 && y<(a.getHeight()*2/3+a.getHeight()/7)))
			setChooseClicked(true);

		
		if((x>a.getWidth()*7/10 && x<(a.getWidth()*7/10+a.getWidth()/5)) && (y>a.getHeight()*2/3 && y<(a.getHeight()*2/3+a.getHeight()/7)))
			setBackClicked(true);


		
	}
	
	public boolean isChooseClicked() {
		return chooseClicked;
	}



	public void setChooseClicked(boolean chooseClicked) {
		this.chooseClicked = chooseClicked;
	}



	public boolean isContinueClicked() {
		return continueClicked;
	}



	public void setContinueClicked(boolean continueClicked) {
		this.continueClicked = continueClicked;
	}
	public boolean isBackClicked() {
		return backClicked;
	}



	public void setBackClicked(boolean backClicked) {
		this.backClicked = backClicked;
	}

	public boolean isStartClicked() {
		return startClicked;
	}



	public void setStartClicked(boolean startClicked) {
		this.startClicked = startClicked;
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
