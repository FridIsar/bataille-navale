public class Mine extends Munition	{

	private int portee;
	private int puissance;
	private int profondeur;

	public Mine()	{
    this.portee = 0;
    double puissance =  Math.random() * 5 + 1;
    double profondeur =  Math.random() * (Globals.getProfondeurChampMax()-1) + 1;
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
