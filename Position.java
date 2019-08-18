public class Position	{

	private int x;
	private int y;
	private int z;

	public Position()	{	}

	public Position(int monX, int monY, int monZ)	{
		this.x = monX;
		this.y = monY;
		this.z = monZ;
	}

	public Position(Position pos)	{
		this.x = pos.getX();
		this.y = pos.getY();
		this.z = pos.getZ();
	}

	public int getX()	{
		return this.x;
	}

  public int getY()	{
		return this.y;
	}

	public int getZ()	{
		return this.z;
	}

	public void setX(int monX)	{
		this.x = monX;
	}

	public void setY(int monY)	{
		this.y = monY;
	}

	public void setZ(int monZ)	{
		this.z = monZ;
	}

	public boolean equals(Position pos)	{
		return (this.x == pos.getX() && this.y == pos.getY() && this.z == pos.getZ());
	}

  public boolean isInside()	{
    return ((this.x >= 0 && this.x < Globals.getLongueurChampMax()) &&
						(this.y >= 0 && this.y < Globals.getLongueurChampMax()) &&
						(this.z >= 0 && this.z < Globals.getProfondeurChampMax()));
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

	public void avanceeProfondeur()	{
		this.z+=1;
	}

	public void reculeeHorizontale()	{
		this.y-=1;
	}

	public void reculeeVerticale()	{
		this.x-=1;
	}

	public void reculeeDiagonale()	{
		this.x-=1;
		this.y-=1;
	}

	public void reculeeAntiDiagonale()	{
		this.x-=1;
		this.y+=1;
	}

	public void reculeeProfondeur()	{
		this.z-=1;
	}

	public String toString()	{
		String s = "(" + this.x + "; " + this.y + "; " + this.z + ")";
		return s;
	}
}
