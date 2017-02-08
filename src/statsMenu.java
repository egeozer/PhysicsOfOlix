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


public class statsMenu extends JPanel implements MouseListener{
	Image statsMenu = new ImageIcon("GUI_Images/StatsMenu.png").getImage();
	ArrayList<File> saveData = new ArrayList<File>();
	Image backB = new ImageIcon("GUI_Images/backB.png").getImage();
	Image resetB = new ImageIcon("GUI_Images/resetB.png").getImage();

	boolean backClicked;
	boolean resetClicked;

	Level a = new Level();
	
	public statsMenu(){
		addMouseListener(this);
		saveData.add(new File("stats/oneStats"));
		saveData.add(new File("stats/twoStats"));
		saveData.add(new File("stats/threeStats"));
		saveData.add(new File("stats/fourStats"));
		saveData.add(new File("stats/fiveStats"));
		saveData.add(new File("stats/sixStats"));
		saveData.add(new File("stats/sevenStats"));
		saveData.add(new File("stats/eightStats"));
		saveData.add(new File("stats/nineStats"));
		saveData.add(new File("stats/tenStats"));
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);	
		g.drawImage(statsMenu, 0, 0, a.getWidth(), a.getHeight(), null );
		g.drawImage(backB, a.getWidth()*9/12, a.getHeight()*2/3, a.getWidth()/5, a.getHeight()/7, null );
		g.drawImage(resetB, a.getWidth()*9/12, a.getHeight()*4/5, a.getWidth()/5, a.getHeight()/7, null );
		
		int j=400;
		for(int i = 0; i<saveData.size()-4;i++,j+=40)
			printStats(g,saveData.get(i),400,j,i+1);
		j=400;
		for(int i = 6; i<saveData.size();i++,j+=40)
			printStats(g,saveData.get(i),800,j,i+1);
	}
	public int[] calculateTime(int totalMilliseconds){
		int minutes = totalMilliseconds/60000;
		int seconds = totalMilliseconds/1000-minutes*60;
		int milliseconds = totalMilliseconds-(minutes*60000+seconds*1000);
		return new int[]{minutes,seconds,milliseconds};
	}
	public void printStats(Graphics g, File f,int width, int height, int i){
		Scanner scanner;
		try {
			scanner = new Scanner(f);
			String s = scanner.nextLine();		
			System.out.println(s);
			String t = scanner.nextLine();
			int h = Integer.parseInt(s);
			int v = Integer.parseInt(t);
			g.setFont(new Font("Goudy Old Style",Font.BOLD,20));
			if(calculateTime(v)[1]>=10)
				g.drawString("Level "+ i+ ": lowest time: "+calculateTime(v)[0]+":"+calculateTime(v)[1]+":"+calculateTime(v)[2]+" Score:"+h,width,height);
			else
				g.drawString("Level "+ i+ ": lowest time: "+calculateTime(v)[0]+":0"+calculateTime(v)[1]+":"+calculateTime(v)[2]+" Score:"+h,width,height);
		} 
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean isBackClicked() {
		return backClicked;
	}
	
	public void setBackClicked(boolean backClicked) {
		this.backClicked = backClicked;
	}
	
	public boolean isResetClicked() {
		return resetClicked;
	}
	
	public void setResetClicked(boolean resetClicked) {
		this.resetClicked = resetClicked;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		PointerInfo c = MouseInfo.getPointerInfo();
		Point b = c.getLocation();
		SwingUtilities.convertPointFromScreen(b, e.getComponent());	//converting the mouseLocation into the panel
		
		int x = (int) b.getX();
		int y = (int) b.getY();
		
		if((x>a.getWidth()*9/12 && x<(a.getWidth()*9/12+a.getWidth()/5)) && (y>a.getHeight()*2/3 && y<(a.getHeight()*2/3+a.getHeight()/7)))
			setBackClicked(true);
		
		if((x>a.getWidth()*9/12 && x<(a.getWidth()*9/12+a.getWidth()/5)) && (y>a.getHeight()*4/5 && y<(a.getHeight()*4/5+a.getHeight()/7)))
			setResetClicked(true);
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