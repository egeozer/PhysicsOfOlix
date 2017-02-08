import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Image;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.*;

public class Game extends JApplet implements ActionListener, KeyListener {
	ArrayList <Level> levels = new ArrayList<Level>();
	private Timer timer = new Timer(20, this);
	private MainMenu mainMenu = new MainMenu();
	private StartButtonMenu startSub = new StartButtonMenu();
	private ExitButtonMenu exitSub = new ExitButtonMenu();
	private OptionsMenu optionsMenu = new OptionsMenu();
	private statsMenu statsMenu = new statsMenu();
	private storyEnd endStory = new storyEnd();
	private credits credits = new credits();
	private StoryPanel1 story1 = new StoryPanel1();
	private StoryPanel2 story2 = new StoryPanel2();
	
	private boolean inMenu = true;
	boolean isHoldingR= false;
	boolean isHoldingL= false;
	boolean isHoldingS= false;
	boolean isHoldingX= false;
	
	URL url = this.getClass().getClassLoader().getResource("sounds/theme1.wav");
	URL urlSpring = this.getClass().getClassLoader().getResource("sounds/spring.wav");
	URL urlClick = this.getClass().getClassLoader().getResource("sounds/click.wav");
	URL urlIntro1 = this.getClass().getClassLoader().getResource("sounds/Narration/Intro 1.wav");
	URL urlIntro2 = this.getClass().getClassLoader().getResource("sounds/Narration/Intro 2.wav");
	URL urlLevel1 = this.getClass().getClassLoader().getResource("sounds/Narration/level 1.wav");
	URL urlLevel2a = this.getClass().getClassLoader().getResource("sounds/Narration/level 2a.wav");
	URL urlLevel2b = this.getClass().getClassLoader().getResource("sounds/Narration/level 2b.wav");
	URL urlLevel3 = this.getClass().getClassLoader().getResource("sounds/Narration/level 3.wav");
	URL urlLevel4 = this.getClass().getClassLoader().getResource("sounds/Narration/level 4.wav");
	URL urlLevel5 = this.getClass().getClassLoader().getResource("sounds/Narration/level 5.wav");
	URL urlEpilogue = this.getClass().getClassLoader().getResource("sounds/Narration/Epilogue.wav");
	URL urlComplete = this.getClass().getClassLoader().getResource("sounds/complete.wav");

	AudioClip mainTheme = Applet.newAudioClip(url);
	AudioClip springS = Applet.newAudioClip(urlSpring);
	AudioClip click = Applet.newAudioClip(urlClick);
	AudioClip intro1 = Applet.newAudioClip(urlIntro1);
	AudioClip intro2 = Applet.newAudioClip(urlIntro2);
	AudioClip level1 = Applet.newAudioClip(urlLevel1);
	AudioClip level2a = Applet.newAudioClip(urlLevel2a);
	AudioClip level2b = Applet.newAudioClip(urlLevel2b);
	AudioClip level3 = Applet.newAudioClip(urlLevel3);
	AudioClip level4 = Applet.newAudioClip(urlLevel4);
	AudioClip level5 = Applet.newAudioClip(urlLevel5);
	AudioClip epilogue = Applet.newAudioClip(urlEpilogue);
	AudioClip complete = Applet.newAudioClip(urlComplete);

	AudioClip[] narration = {level1, level2a, level3, level4, level5};
	
	boolean[] narrationPlayed = {false, false, false, false, false, false, false};
	boolean level2bPlayed = false;
	
	final JFileChooser fileMenu = new JFileChooser("levels");
	ArrayList<File> saveData = new ArrayList<File>();
	File file ;
	File lastSave = new File("savedLevel.txt");
	static boolean lowerTime;
	
	PrintWriter writeLog = null;
	PrintWriter write =null;
	
	Level one = new LevelOne();
	Level two = new LevelTwo();
	Level three = new LevelThree();
	Level four = new LevelFour();
	Level five = new LevelFive();
	Level six = new LevelSix();
	Level seven = new LevelSeven();
	Level eight = new LevelEight();
	Level nine = new LevelNine();
	Level ten = new LevelTen();
	
	private PauseMenu pauseMenu = new PauseMenu();
	static JFrame pauseFrame = new JFrame();
	private LevelCompleteMenu levelCompleteMenu = new LevelCompleteMenu();
	static JFrame scoreFrame = new JFrame();
	static int totalScore = 0;
	
	int i=0;
	
	public Game(){	
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
		
		pauseFrame.add(pauseMenu);
		pauseFrame.setSize(415,190);
		scoreFrame.add(levelCompleteMenu);
		scoreFrame.setSize(415,190);
		
		levels.add(one);
		levels.add(two);
		levels.add(three);
		levels.add(four);
		levels.add(five);
		levels.add(six);
		levels.add(seven);
		levels.add(eight);
		levels.add(nine);
		levels.add(ten);
		
		add(mainMenu);
		addKeyListener(this);
		setFocusable(true);
		timer.start(); 	
	}
	public static void main(String[]args) throws IOException{
		JFrame frame = new JFrame(); 
		Game game = new Game();
		game.init();
		game.setSize(1500,700);
		frame.add(game);
		
		frame.setVisible(true);
		frame.setSize(1520,745);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void init(){
		mainTheme.loop();
		setSize(1500,700);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(pauseFrame.isVisible()||scoreFrame.isVisible()){
			levels.get(i).time.stop();
			levels.get(i).game.stop();
		}
		else{
			levels.get(i).time.start();
			levels.get(i).game.start();
		}
		
		if(levelCompleteMenu.resumeClicked)
		{
			scoreFrame.setVisible(false);
			levelCompleteMenu.resumeClicked = false;
			if(i!=levels.size()-1){
				setHoldingR(false);
				setHoldingL(false);
				inMenu = false;
				levels.get(i).resetLevel();
				getContentPane().removeAll();
				//levels.remove(i);
				if(i!=levels.size()-1){
					i++;
					levels.get(i).setFocusable(true);
					levels.get(i).resetLevel();
					
					add(levels.get(i));
					try{
						write = new PrintWriter(lastSave);
						write.println(i);
						write.close();
					}
					catch(Exception e){				
						e.printStackTrace();
					}
					validate();
					repaint();
				}
				else
					i=0;
			}
			else
			{
				getContentPane().remove(levels.get(i));
				add(endStory);
				if(OptionsMenu.j%2==0)
				{
					epilogue.play();
				}
				validate();
				repaint();
			}
		}
		if(levels.get(i).levelCompleted()&&!inMenu){
			totalScore+=levels.get(i).score;
			if(OptionsMenu.j%2==0 && i<5)
			{
				narration[i].stop();
				if(i==1)
					level2b.stop();
			}
			//Printing high score and best time to a file
			try{
				boolean highScore;
				Scanner scanner =null;
				scanner = new Scanner(saveData.get(i));
				String s = scanner.nextLine();		 
				String t = scanner.nextLine();
				int h = Integer.parseInt(s);
				int v = Integer.parseInt(t);
				scanner.close();
				if(levels.get(i).score>h)
					highScore = true;
				else
					highScore = false;
				if(levels.get(i).seconds*1000+levels.get(i).minutes*60000+levels.get(i).milliseconds<v||v==0)
					lowerTime=true;
				else
					lowerTime=false;
				
				writeLog=new PrintWriter(saveData.get(i));
				if(highScore)
					writeLog.println(levels.get(i).score);
				else
					writeLog.println(h);
				if(lowerTime)
					writeLog.println(levels.get(i).seconds*1000+levels.get(i).minutes*60000+levels.get(i).milliseconds);
				else
					writeLog.println(v);
				writeLog.close();
				
				levelCompleteMenu.highScore = highScore;
				levelCompleteMenu.bestTime = lowerTime;
				levelCompleteMenu.score = levels.get(i).score;
				levelCompleteMenu.minutes = levels.get(i).minutes;
				levelCompleteMenu.seconds = levels.get(i).seconds;
				levelCompleteMenu.milliseconds = levels.get(i).milliseconds;
			}
			catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			scoreFrame.setVisible(true);
			complete.play();

			inMenu = true;
			levels.get(i).setFocusable(false);
			scoreFrame.setFocusable(true);
			levelCompleteMenu.setFocusable(true);
			scoreFrame.setLocationRelativeTo(this);
			setHoldingL(false);
			setHoldingR(false);
			setHoldingS(false);
			setHoldingX(false);
			repaint();
			validate();
		}
		
		if(endStory.isContinueClicked()){
			if(OptionsMenu.j%2==0)
			{
				click.play();
				epilogue.stop();
			}
			getContentPane().remove(endStory);
			add(credits);
			endStory.setContinueClicked(false);
			validate();
			repaint();
		}
		if(credits.isContinueClicked()){
			if(OptionsMenu.j%2==0)
				click.play();
			getContentPane().remove(credits);
			add(mainMenu);
			credits.setContinueClicked(false);
			validate();
			repaint();
		}
		
		if(mainMenu.isStartClicked()){
			if(OptionsMenu.j%2==0)
				click.play();
			getContentPane().remove(mainMenu);
			add(startSub);
			mainMenu.setStartClicked(false);
			validate();
			repaint();
		}	
		if(startSub.isStartClicked()){
			if(OptionsMenu.j%2==0)
			{
				click.play();
				intro1.play();
			}
			getContentPane().remove(startSub);
			startSub.setStartClicked(false);
			add(story1);
			validate();
			repaint();
		}
		if(story1.isContinueClicked()){
			if(OptionsMenu.j%2==0)
			{
				click.play();
				intro1.stop();
				intro2.play();
			}
			getContentPane().remove(story1);
			story1.setContinueClicked(false);
			add(story2);
			validate();
			repaint();
		}
		if(story2.isStartClicked()){
			i=0;
			try{
				 write = new PrintWriter(lastSave);
				 write.println(i);
				 write.close();
			}
			catch(Exception e){				
				e.printStackTrace();
			}
			if(OptionsMenu.j%2==0)
			{
				click.play();
				intro2.stop();
			}
			inMenu=false;
			getContentPane().remove(story2);
			levels.get(i).resetLevel();
			add(levels.get(i));
			story2.setStartClicked(false);
			validate();
			repaint();
		}
		if(startSub.isBackClicked()){
			if(OptionsMenu.j%2==0)
				click.play();
			getContentPane().remove(startSub);
			add(mainMenu);
			startSub.setBackClicked(false);
			validate();
			repaint();
		}
		//not finished
		if(startSub.isContinueClicked()){
			if(OptionsMenu.j%2==0)
				click.play();

			inMenu=false;
			getContentPane().remove(startSub);
			Scanner scanner = null;
			try {
				scanner = new Scanner(lastSave);
				String s = scanner.nextLine();
				int h = Integer.parseInt(s);
				i=h;
				levels.get(i).resetLevel();
				add( levels.get(i));
			}
			catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			scanner.close();
			startSub.setContinueClicked(false);
			validate();
			repaint();
		}
		
		if(startSub.isChooseClicked()){
			if(OptionsMenu.j%2==0)
				click.play();
			
			Scanner scanner = null;
			try { 
				file=null;
				int retval = fileMenu.showOpenDialog(this);
				if(retval==JFileChooser.APPROVE_OPTION){
					file = fileMenu.getSelectedFile();
					scanner=new Scanner(file);
					String s = scanner.nextLine();
					int h = Integer.parseInt(s); 
					i=h;
					getContentPane().remove(startSub);
					levels.get(i).resetLevel();
					add(levels.get(i));
					inMenu=false;
				}
			}
			catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try{
				write = new PrintWriter(lastSave);
				write.println(i);
				write.close();
			}
			catch(Exception e){				
				e.printStackTrace();
			}
			
			startSub.setChooseClicked(false);
			validate();
			repaint();
		}
		if(mainMenu.isOptionClicked()){
			if(OptionsMenu.j%2==0)
				click.play();
			getContentPane().remove(mainMenu);
			add(optionsMenu);
			mainMenu.setOptionClicked(false);
			validate();
			repaint();
		}
		if(optionsMenu.isSoundClicked()){
			if(OptionsMenu.j%2==0)
				click.play();
			optionsMenu.setSoundClicked(false);
		}
		if(optionsMenu.isMusicClicked()){
			if(OptionsMenu.j%2==0)
				click.play();
			if(optionsMenu.i%2!=0)
				mainTheme.stop();
			else if(optionsMenu.i%2==0) 
				mainTheme.loop();
			
			optionsMenu.setMusicClicked(false);
		}
		if(optionsMenu.isBackClicked()){
			if(OptionsMenu.j%2==0)
				click.play();
			getContentPane().remove(optionsMenu);
			add(mainMenu);
			optionsMenu.setBackClicked(false);
			validate();
			repaint();
		}
		if(optionsMenu.isStatsClicked()){
			if(OptionsMenu.j%2==0)
				click.play();
			getContentPane().remove(optionsMenu);
			add(statsMenu);
			optionsMenu.setStatsClicked(false);
			validate();
			repaint();
		}
		
		if(statsMenu.isBackClicked()){
			if(OptionsMenu.j%2==0)
				click.play();
			getContentPane().remove(statsMenu);
			add(optionsMenu);
			statsMenu.setBackClicked(false);
			validate();
			repaint();
		}
		if(statsMenu.isResetClicked()){
			if(OptionsMenu.j%2==0)
				click.play();
			try {
				for(int i = 0; i<saveData.size();i++){
					writeLog=new PrintWriter(saveData.get(i));
					writeLog.println(0);
					writeLog.println(0);
					writeLog.close();
				}
			}
			catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			statsMenu.setResetClicked(false);
			validate();
			repaint();
		}
		
		if(mainMenu.isExitClicked()){
			if(OptionsMenu.j%2==0)
				click.play();
			getContentPane().remove(mainMenu);
			add(exitSub);
			mainMenu.setExitClicked(false);
			validate();
			repaint();
		}
		if(exitSub.isBackClicked()){
			if(OptionsMenu.j%2==0)
				click.play();
			getContentPane().remove(exitSub);
			add(mainMenu);
			exitSub.setBackClicked(false);
			validate();
			repaint();
		}
		if(exitSub.isExitClicked()){
			if(OptionsMenu.j%2==0)
				click.play();
			System.exit(0);
		}
		if(pauseMenu.isResumeClicked()){
			if(OptionsMenu.j%2==0)
				click.play();
			pauseFrame.setVisible(false);
			pauseMenu.setResumeClicked(false);
			validate();
			repaint();
		}
		if(pauseMenu.isMenuClicked()){
			if(OptionsMenu.j%2==0)
				click.play();
			levels.get(i).resetLevel();
			
			inMenu=true;
			pauseFrame.setVisible(false);
			getContentPane().remove(levels.get(i));
			add(mainMenu);
			
			pauseMenu.setMenuClicked(false);
			validate();
			repaint();
		}
		if(pauseMenu.isRestartClicked()){
			if(OptionsMenu.j%2==0)
				click.play();
			pauseFrame.setVisible(false);
			levels.get(i).resetLevel();
			
			pauseMenu.setRestartClicked(false);
		}
		
		//The majority of the narration stuff is here
		if(OptionsMenu.j%2==0)
		{
			if(!inMenu && i==0 && !narrationPlayed[0])
			{
				narration[0].play();
				narrationPlayed[0] = true;
			}
			else if(i==1 && !narrationPlayed[1])
			{
				narration[1].play();
				narrationPlayed[1] = true;
			}
			else if(i==2 && !narrationPlayed[2] && levels.get(i).player.currentPlatform>-1 && levels.get(i).platforms.get(levels.get(i).player.currentPlatform).x2>-1)
			{
				narration[2].play();
				narrationPlayed[2] = true;
			}
			else if(i==3 && !narrationPlayed[3] && levels.get(i).currentPoly>-1)
			{
				narration[3].play();
				narrationPlayed[3] = true;
			}
			else if(i==4 && !narrationPlayed[4] && levels.get(i).currentSpring>-1)
			{
				narration[4].play();
				narrationPlayed[4] = true;
			}
		}
		
		if(isHoldingX() && isHoldingR()){	
			levels.get(i).xRight();
		}
		if(isHoldingX() && isHoldingL())
		{
			levels.get(i).xLeft();
		}
		
		for(int j = 0; j<levels.get(i).polygons.size();j++)
		{
			if(levels.get(i).hitDetected(levels.get(i).springs,levels.get(i).player)>-1  && levels.get(i).hitDetected(levels.get(i).springs,levels.get(i).polygons.get(j))>-1 && isHoldingS()){	
				levels.get(i).polygonJump(levels.get(i).polygons.get(j));
				if(OptionsMenu.j%2==0)
					springS.play();
			}
			else if(levels.get(i).hitDetected(levels.get(i).springs,levels.get(i).player)>-1 && isHoldingS()){	
				if(OptionsMenu.j%2==0)
					springS.play();
			}
		}
		
		if(isHoldingR()){
			levels.get(i).slowRight = false;
			levels.get(i).right();
		}
		if(isHoldingL()){
			levels.get(i).slowLeft = false;
			levels.get(i).left();	
		}
		if(isHoldingS()){
			levels.get(i).space();
			if(i==1 && !level2bPlayed)
			{
				if(OptionsMenu.j%2==0)
				{
					narration[1].stop();
					level2b.play();
					level2bPlayed = true;
				}
			}
		}
	}
	public boolean isHoldingR() {
		return isHoldingR;
	}
	public void setHoldingR(boolean isHoldingR) {
		this.isHoldingR = isHoldingR;
	}
	public boolean isHoldingL() {
		return isHoldingL;
	}
	public void setHoldingL(boolean isHoldingL) {
		this.isHoldingL = isHoldingL;
	}
	public boolean isHoldingS() {
		return isHoldingS;
	}
	public void setHoldingS(boolean isHoldingS) {
		this.isHoldingS = isHoldingS;
	}
	public boolean isHoldingX() {
		return isHoldingX;
	}
	public void setHoldingX(boolean isHoldingX) {
		this.isHoldingX = isHoldingX;
	}
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_RIGHT)
		{
			setHoldingR(true);
		}
		else if(e.getKeyCode()==KeyEvent.VK_LEFT)
		{
			setHoldingL(true);
		}
		else if(e.getKeyCode()==KeyEvent.VK_SPACE && !scoreFrame.isVisible())
		{
			setHoldingS(true);
		}
		else if(e.getKeyCode()==KeyEvent.VK_SPACE && scoreFrame.isVisible()){
			levelCompleteMenu.resumeClicked = true;
		}
		else if(e.getKeyCode()==KeyEvent.VK_X)
		{
			setHoldingX(true);
		}
		else if(e.getKeyCode()==KeyEvent.VK_ESCAPE)
		{
			setHoldingL(false);
			setHoldingR(false);
			setHoldingS(false);
			setHoldingX(false);
			if(!inMenu){
				pauseFrame.setLocationRelativeTo(this);
				pauseFrame.setVisible(true);
				repaint();
				validate();
			}
		}
		else if(e.getKeyCode()==KeyEvent.VK_ALT)
		{
			setHoldingL(false);
			setHoldingR(false);
			setHoldingS(false);
			setHoldingX(false);
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_RIGHT)
		{
			levels.get(i).releasedRight();
			setHoldingR(false);
			levels.get(i).player.xVelocity= 2;
		}
		else if(e.getKeyCode()==KeyEvent.VK_LEFT)
		{
			levels.get(i).releasedLeft();
			setHoldingL(false);
			levels.get(i).player.xVelocity= 2;
		}
		else if(e.getKeyCode()==KeyEvent.VK_SPACE)
		{
			setHoldingS(false);
		}
		else if(e.getKeyCode()==KeyEvent.VK_X)
		{
			setHoldingX(false);
			levels.get(i).currentPoly = -1;
		}
		else if(e.getKeyCode()==KeyEvent.VK_ESCAPE)
		{
			pauseFrame.setLocationRelativeTo(this);
		}
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}
}
