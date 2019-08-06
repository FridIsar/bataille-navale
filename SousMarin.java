public class SousMarin implements Bateau	{
	public static final int resistance = 4;
	public static final int munitions = 10;
	public static final int taille = 2;
	public Orientation orientation;
	//attaque ?


	private Position debut;
	private Position fin;

	public SousMarin()	{	}

	public SousMarin(Position deb, Position fin)	{
		this.debut = deb;
		this.fin = fin;
	}

	public int getX()	{
		return this.debut.getX();
	}

	public int getY()	{
		return this.fin.getX();
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
		this.x.setX(monX);
	}

	public void setY(int monY)	{
		this.y.setY(monY);
	}

	public void setPositionFin()	{
		if (this.orientation == Orientation.Horizontal)	{
			this.debut.setX() //a completer releg or not ?
		}
		if (this.orientation == Orientation.Vertical)	{
			this.y = this.x + taille;
		}
		if (this.orientation == Orientation.AntiDiagonal)	{
			this.y = this.x + taille;
		}
		if (this.orientation == Orientation.Diagonal)	{
			this.y = this.x + taille;
		}
	}

	public int getResistance()	{
		return this.resistance;
	}

	public int getTaille()	{
		return this.taille;
	}

	public boolean isInside()	{
		return (this.debut.isInside() && this.fin.isInside());
	}

	// public void avancer()	{
	// 	this.x += 1;
	// }
}
