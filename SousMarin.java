public class SousMarin implements Bateau	{
	public static final int resistance = 6;
	public static final int munitions = 10;
	public static final int taille = 2;

	private int x;
	private int y;

	public SousMarin()	{	}

	public SousMarin(int monX, int monY)	{
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

	public int getTaille()	{
		return this.taille;
	}

	public void avancer()	{
		this.x += 1;
	}
}
