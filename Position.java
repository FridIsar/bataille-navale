public class Position	{

	private int x;
	private int y;

	public Position()	{	}

	public Position(int monX, int monY)	{
		this.x = monX;
		this.y = monY;
	}

	public Position(Position pos)	{
		this.x = pos.getX();
		this.y = pos.getY();
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
    return ((this.x >= 0 && this.x <= Globals.getLongueurChampMax()) && (this.y >= 0 && this.y <= Globals.getLongueurChampMax()));
  }

	public void avanceeHorizontale()	{
		this.y+=1;
	}

	public void avanceeVerticale()	{
		this.x+=1;
	}

	public void avanceeDiagonale()	{
		this.x+=1;
		this.y+=1;
	}

	public void avanceeAntiDiagonale()	{
		this.x+=1;
		this.y-=1;
	}

	public String toString()	{
		String s = "(" + this.x + "; " + this.y + ")";
		return s;
	}
}
