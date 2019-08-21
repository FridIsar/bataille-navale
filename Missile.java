public class Missile extends Munition	{

	private int portee;
	private int puissance;
	private int profondeur;

	public Missile()	{
    this.profondeur = 0;
    double portee =  Math.random() * (Globals.getLongueurChampMax()-1) + 1;
    double puissance =  Math.random() * 3 + 1;
    this.portee = (int) portee;
    this.puissance = (int) puissance;
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
