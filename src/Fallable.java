import java.awt.Graphics;


public abstract class Fallable extends ContactableObject implements Cloneable {
	double xVelocity;
	double yVelocity;
	boolean falling;
	//boolean onAngledPlatform = false;
	int currentPlatform = -1;
	int mass;

	public Fallable(){
		//
	}
	public Fallable(int x, int y, int w, int h, int xVel, boolean f, int m)
	{
		super(x, y, w, h);
		xVelocity = xVel;
		yVelocity = 0;
		falling = f;
		mass = m;
	}
	public Fallable(int x, int y, int w, int h, int m) {
		super(x, y, w, h);
		mass = m;
		xVelocity = 0;
		yVelocity = 0;
	}
	public boolean isFalling() {
		return falling;
	}
	public void setFalling(boolean falling) {
		this.falling = falling;
	}
	public double getxVelocity() {
		return xVelocity;
	}
	public void setxVelocity(double xVelocity) {
		this.xVelocity = xVelocity;
	}
	public double getyVelocity() {
		return yVelocity;
	}
	public void setyVelocity(double yVelocity) {
		this.yVelocity = yVelocity;
	}
	public double getMass()
	{
		return mass;
	}
	public void setMass(int mass)
	{
		this.mass = mass;
	}
}