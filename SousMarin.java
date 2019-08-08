public class SousMarin implements Bateau	{
	public static final int resistance = 4;
	public static final int munitions = 10;
	public static final int taille = 8;
	public Orientation orientation;
	//attaque ?

	private Position tete = new Position(3, 3);
	private Position[] emplacements = new Position[taille];

	public SousMarin()	{	}

	public SousMarin(Position pos)	{	// position de départ
		this.tete = pos;
	}

	public Position[] getEmplacements()	{
		return this.emplacements;
	}

	public int getResistance()	{
		return this.resistance;
	}

	public int getTaille()	{
		return this.taille;
	}

	public void fillBoat()	{	// position de départ
		this.emplacements[0] = tete;
		for (int i = 1; i < taille; i++)	{
			this.emplacements[i] = new Position(this.emplacements[i-1]);
														// evite de pointer sur la m position
			if (this.orientation == Orientation.Horizontal)	{
				this.emplacements[i].avanceeHorizontale();
			}
			if (this.orientation == Orientation.Vertical)	{
				this.emplacements[i].avanceeVerticale();
			}
			if (this.orientation == Orientation.AntiDiagonal)	{
				this.emplacements[i].avanceeAntiDiagonale();
			}
			if (this.orientation == Orientation.Diagonal)	{
				this.emplacements[i].avanceeDiagonale();
			}
		}
	}

	public void affBoat() {
    System.out.println(this.getOrientation());
    for (int i = 0; i < this.getTaille(); i++)  {
      System.out.println(this.getEmplacements()[i]);
    }
  }

	public void randomizePosition()	{
		double yAleatoire =  Math.random() * Globals.getLongueurChampMax() + 1;
		double xAleatoire =  Math.random() * Globals.getLongueurChampMax() + 1;
		this.tete = new Position((int) xAleatoire, (int) yAleatoire);
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

	public boolean isInside()	{
		boolean inside = true;
		for (int i = 0; i < this.taille; i++)	{
			if ((this.emplacements[i].getX() > Globals.getLongueurChampMax() ||
			 							this.emplacements[i].getX() < 1) ||
										(this.emplacements[i].getY() > Globals.getLongueurChampMax() ||
										 							this.emplacements[i].getY() < 1))	{
				inside = false;
			}
		}
		return inside;
	}

	// public void avancer()	{
	// 	this.x += 1;
	// }
}
