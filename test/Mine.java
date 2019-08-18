public class Mine	{

	private static final int portee = 0;
	private int puissance;
	private int profondeur;

	public Mine()	{	}

	public void setRandomAttributs()	{
		double puissance =  Math.random() * 5 + 1;
		double profondeur =  Math.random() * Globals.getProfondeurChampMax() + 1;
		this.puissance = (int) puissance;
		this.profondeur = (int) profondeur;
	}
}
