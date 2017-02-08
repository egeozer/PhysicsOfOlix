public abstract class Collectible extends ContactableObject{
	private boolean picked;
	public Collectible(int x, int y)
	{
		super(x, y);
		picked = false;
	}
	 Collectible(){
		 
	 }
	public void setPicked(boolean p)
	{
		picked = p;
	}
	public boolean isPicked()
	{
		return picked;
	}
}
