public class Croiseur implements Bateau	{
	public static final int resistance = 10;
	public static final int munitions = 10;
	public static final int taille = 3;
	public Orientation orientation;

	private int x;
	private int y;

	public Croiseur()	{	}

	public Croiseur(int monX, int monY)	{
		this.x = monX;
		this.y = monY;
	}

	public int getX()	{
		return this.x;
	}

	public int getY()	{
		return this.y;
	}

	public Orientation getOrientation()	{
		return this.orientation;
	}

	public void setRandomOrientation()	{
		double nbAleatoire =  Math.random() * 4 + 1;
		switch ((int) nbAleatoire)	{
			case 1:
					this.orientation = Orientation.Horizontal;
					break;
			case 2:
					this.orientation = Orientation.Vertical;
					break;
			case 3:
					this.orientation = Orientation.AntiDiagonal;
					break;
			case 4:
					this.orientation = Orientation.Diagonal;
					break;
		}
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

	public boolean isInside()	{
		return ((this.x >= 0 && this.x <= Globals.getLongueurChampMax()) && (this.y >= 0 && this.y <= Globals.getLongueurChampMax()));
	}

	public void avancer()	{
		this.x += 1;
	}
}
