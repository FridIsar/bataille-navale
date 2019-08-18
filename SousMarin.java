public class SousMarin extends Bateau	{
	private int resistance = 4;
	private int NB_MUNITIONS = 10;
	private Munition[] munitions = new Munition[NB_MUNITIONS];
	public static final int taille = 2;
	public Orientation orientation;
	//attaque ?

	private Position tete;
	private Position[] emplacements = new Position[taille];

	public SousMarin()	{	}

	public SousMarin(Position pos)	{	// position de départ
		this.tete = pos;
	}

	public Orientation getOrientation()	{
		return this.orientation;
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

	public int getDegats()	{
		return this.getMunitionCourante().getPuissance();
	}

	public Munition getMunitionCourante()	{
		return this.munitions[NB_MUNITIONS-1];
	}

	public Position getTete()	{
		return this.tete;
	}

	public int getMunitions()	{
		return this.NB_MUNITIONS;
	}

	public int getProfondeur()	{
		return this.emplacements[0].getZ();
	}

	public void setMunition(int nb)	{
		this.NB_MUNITIONS = nb;
	}

	public void setResistance(int nb)	{
		this.resistance = nb;
	}

	public void setAvancee(int index, Orientation o)	{
		if (o == Orientation.Horizontal)	{
			this.emplacements[index].avanceeHorizontale();
		}
		if (o == Orientation.Vertical)	{
			this.emplacements[index].avanceeVerticale();
		}
		if (o == Orientation.AntiDiagonal)	{
			this.emplacements[index].avanceeAntiDiagonale();
		}
		if (o == Orientation.Diagonal)	{
			this.emplacements[index].avanceeDiagonale();
		}
	}

	public void setReculee(int index, Orientation o)	{
		if (o == Orientation.Horizontal)	{
			this.emplacements[index].reculeeHorizontale();
		}
		if (o == Orientation.Vertical)	{
			this.emplacements[index].reculeeVerticale();
		}
		if (o == Orientation.AntiDiagonal)	{
			this.emplacements[index].reculeeAntiDiagonale();
		}
		if (o == Orientation.Diagonal)	{
			this.emplacements[index].reculeeDiagonale();
		}
	}

	public void setTete(Position pos)	{
		this.tete = pos;
	}

	public void setOrientation(Orientation o)	{
		this.orientation = o;
	}

	public void setEmplacements(int index, Position pos)	{
		this.emplacements[index] = pos;
	}


	public void plonger()	{
		for (int i = 0; i < this.emplacements.length; i++) {
			emplacements[i].avanceeProfondeur();
		}
	}

	public void remonter()	{
		for (int i = 0; i < this.emplacements.length; i++) {
			emplacements[i].reculeeProfondeur();
		}
	}

	public void affBoat()	{
		for (int i = 0; i < this.emplacements.length; i++) {
			System.out.println(this.emplacements[i]);
		}
	}

	public void initMunitions()	{
		for (int i = 0; i < this.munitions.length; i++) {
			munitions[i] = new Munition();
			munitions[i].setRandomAttributs(this); // this indique objet
		}
	}
}
