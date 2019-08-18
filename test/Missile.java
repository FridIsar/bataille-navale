public class Missile	{

	private int portee;
	private int puissance;
	private static final int profondeur = 0;

	public Missile()	{	}

	public void setRandomAttributs()	{
		double portee =  Math.random() * Globals.getLongueurChampMax() + 1;
		double puissance =  Math.random() * 3 + 1;
		this.portee = (int) portee;
		this.puissance = (int) puissance;
	}
}
