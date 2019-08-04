public class Fregate implements Bateau	{
	public static final int resistance = 6;
	public static final int munitions = 10;
	public static final int taille = 4;

	private int x;
	private int y;

	public Fregate()	{	}

	public Fregate(int monX, int monY)	{
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

	public int getResistance()	{
		return this.resistance;
	}

	public int getPosition()	{
		return this.resistance;
	}

	public void avancer()	{
		this.x += 1;
	}
}
