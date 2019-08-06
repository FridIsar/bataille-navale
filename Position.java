public class Position	{

	private int x;
	private int y;

	public Position()	{	}

	public Position(int monX, int monY)	{
		this.x = monX;
		this.y = monY;
	}

	public int getX()	{
		return this.x;
	}

  public int getY()	{
		return this.y;
	}

	public void setX(int monX)	{
		this.x = monX;
	}

	public void setY(int monY)	{
		this.y = monY;
	}

  public boolean isInside()	{
    return ((this.x >= 0 && this.x <= L_CHAMP) && (this.y >= 0 && this.y <= L_CHAMP));
  }

}
