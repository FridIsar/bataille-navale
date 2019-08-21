public class Torpille extends Munition	{

	private int portee;
	private int puissance;
	private int profondeur;

	public Torpille()	{
    double portee =  Math.random() * (Globals.getLongueurChampMax()-1) + 1;
    double puissance =  Math.random() * 4 + 1;
    double profondeur =  Math.random() * (Globals.getProfondeurChampMax()-1) + 1;
    this.portee = (int) portee;
    this.puissance = (int) puissance;
    this.profondeur = (int) profondeur;
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
