public class Munition	{

	private int portee;
	private int puissance;
	private int profondeur;

	public Munition()	{	}

	public void setRandomAttributs(Bateau bat)	{ // TORPILLE
		this.portee = 0;
		this.puissance = 0;
		this.profondeur = 0;
		if (bat instanceof SousMarin)	{
			double portee =  Math.random() * Globals.getLongueurChampMax() + 1;
			double puissance =  Math.random() * 4 + 1;
			double profondeur =  Math.random() * Globals.getProfondeurChampMax() + 1;
			this.portee = (int) portee;
			this.puissance = (int) puissance;
			this.profondeur = (int) profondeur;
		}
		else	{
			if (bat instanceof Fregate)	{ // MISSILE
				double portee =  Math.random() * Globals.getLongueurChampMax() + 1;
				double puissance =  Math.random() * 3 + 1;
				this.portee = (int) portee;
				this.puissance = (int) puissance;
			}
			else	{
				if (bat instanceof Croiseur)	{ // MINE
					double puissance =  Math.random() * 5 + 1;
					double profondeur =  Math.random() * Globals.getProfondeurChampMax() + 1;
					this.puissance = (int) puissance;
					this.profondeur = (int) profondeur;
				}
			}
		}
	}

	public int getPuissance()	{
		return this.puissance;
	}

	public int getPortee()	{
		return this.portee;
	}

	public int getProfondeur()	{
		return this.profondeur;
	}
}
