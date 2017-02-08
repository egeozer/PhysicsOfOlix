import java.awt.Graphics;

public abstract class ContactableObject {
	int xPos, yPos, width, height, extension;
	int x2 = -1;
	int y2 = -1;
	int decompressDelay = 4;
	double friction, springConstant, angle;
	boolean dead = false;
	
	public ContactableObject(){}
	public ContactableObject(int x, int y)
	{
		xPos = x;
		yPos = y;
	}
	//Constructor for angled platforms
	public ContactableObject(int x, int y, int length, double f, double a)
	{
		int[] points = calculatePoints(x, y, length, a);
		if(a>90&&a<180)
		{
			a+=180;
			xPos = points[0];
			yPos = points[1];
			x2 = x;
			y2 = y;
		}
		else if(a>180&&a<270)
		{
			a-=180;
			xPos = points[0];
			yPos = points[1];
			x2 = x;
			y2 = y;
		}
		else
		{
			xPos = x;
			yPos = y;
			x2 = points[0];
			y2 = points[1];	
		}
		friction = f;
		angle = a;
	}
	public ContactableObject(int x, int y, int w, int h)
	{
		xPos = x;
		yPos = y;
		width = w;
		height = h;
	}
	public ContactableObject(int x, int y, int w, int h, double f)
	{
		xPos = x;
		yPos = y;
		width = w;
		height = h;
		friction = f;
	}
	public ContactableObject(int x, int y, int w, boolean d)
	{
		xPos = x;
		yPos = y;
		width = w;
		height = 2;
		friction = 0.5;
		dead =  d;
	}
	public ContactableObject(int x, int y, int w, int h, double s, boolean spring)
	{
		xPos = x;
		yPos = y;
		width = w;
		height = h;
		springConstant = s;
		extension = 0;
	}
	public  int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public void setXPos(int x)
	{
		xPos = x;
	}
	public void setYPos(int y)
	{
		yPos = y;
	}
	
	public int getXPos()
	{
		return xPos;
	}
	public int getYPos()
	{
		return yPos;
	}
	
	public int[] calculatePoints(int x, int y, int l, double a)
	{
		int[] points = new int[2];
		if(a<90)
		{
			a = Math.toRadians(a);
			points[0] = (int)(x+Math.sin(a)*l);
			points[1] = (int)(y-Math.cos(a)*l);
		}
		else if(a<180)
		{
			a = Math.toRadians(a-90);
			points[0] = (int)(x+Math.cos(a)*l);
			points[1] = (int)(y+Math.sin(a)*l);
		}
		else if(a<270)
		{
			a = Math.toRadians(a-180);
			points[0] = (int)(x-Math.sin(a)*l);
			points[1] = (int)(y+Math.cos(a)*l);
		}
		else
		{
			a = Math.toRadians(a-270);
			points[0] = (int)(x-Math.cos(a)*l);
			points[1] = (int)(y-Math.sin(a)*l);
		}
		return points;
	}
	public abstract void paint(Graphics g, Level a);
}