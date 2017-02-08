import java.awt.BorderLayout;
import java.awt.Color;
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


public class OptionsMenu extends JPanel implements MouseListener{
	Image optionsSub = new ImageIcon("GUI_Images/OptionsMenu.png").getImage();
	
	Image backB = new ImageIcon("GUI_Images/backB.png").getImage();
	Image check = new ImageIcon("GUI_Images/check.png").getImage();
	Image stats = new ImageIcon("GUI_Images/statsB.png").getImage();

	int i = 0;
	static int j = 0;


	
	boolean backClicked;
	boolean soundClicked;
	boolean musicClicked;
	boolean statsClicked;
	




	

	Level a = new Level();
	
	public OptionsMenu(){
		addMouseListener(this);
	}
	

	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		 g.drawImage(optionsSub, 0, 0, a.getWidth(), a.getHeight(), null );
	
			g.drawImage(backB, a.getWidth()*7/10, a.getHeight()*2/3, a.getWidth()/5, a.getHeight()/7, null );
			
			g.drawImage(stats, a.getWidth()*5/11, a.getHeight()*2/3, a.getWidth()/5, a.getHeight()/7, null );

			//g.drawRect(242,473,50,50 );

			if(j%2==0)
		
				g.drawImage(check,242,473,50,50,null);
			//else if(j%2!=0)
			//	g.drawImage(check,400,473,50,50,null);

			if(i%2==0)
				
				g.drawImage(check,242,543,50,50,null);
				



	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		PointerInfo c = MouseInfo.getPointerInfo();
		Point b = c.getLocation();
		SwingUtilities.convertPointFromScreen(b, e.getComponent());	//converting the mouseLocation into the panel

		int x = (int) b.getX();
		int y = (int) b.getY();
		
		
		
		
		if((x>a.getWidth()*7/10 && x<(a.getWidth()*7/10+a.getWidth()/5)) && (y>a.getHeight()*2/3 && y<(a.getHeight()*2/3+a.getHeight()/7)))
			setBackClicked(true);

		if((x>242 && x<240+50) && (y>543 && y<543+50)){
			setMusicClicked(true);
			i++;
			}
		
		if((x>242 && x<240+50) && (y>473 && y<473+50)){
			setSoundClicked(true);
			
			j++;
			if(j%2==0)
				System.out.println("even");
			
			
		}
		if((x>a.getWidth()*5/11 && x<(a.getWidth()*5/11+a.getWidth()/5)) && (y>a.getHeight()*2/3 && y<(a.getHeight()*2/3+a.getHeight()/7)))
			setStatsClicked(true);

		

		repaint();
		
	}
	
	



	public boolean isStatsClicked() {
		return statsClicked;
	}



	public void setStatsClicked(boolean statsClicked) {
		this.statsClicked = statsClicked;
	}



	public boolean isSoundClicked() {
		return soundClicked;
	}



	public void setSoundClicked(boolean soundClicked) {
		this.soundClicked = soundClicked;
	}



	public boolean isMusicClicked() {
		return musicClicked;
	}



	public void setMusicClicked(boolean musicClicked) {
		this.musicClicked = musicClicked;
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
		System.out.println("submenu");
		
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
