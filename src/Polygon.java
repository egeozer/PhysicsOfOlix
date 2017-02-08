
public abstract class Polygon extends Fallable{
	boolean isSphere = false;
	public Polygon(int x, int y, int w, int h, int m, boolean s)
	{
		super(x, y, w, h, m);
		isSphere = s;
	}
	
}