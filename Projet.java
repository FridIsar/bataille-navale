public class Projet	{ //ajout

  public static final int L_CHAMP = 10;
  public static final int P_CHAMP = 1;

  public static void main(String[] args)	{
    ChampBataille cb = new ChampBataille(L_CHAMP);
    System.out.println(cb);
    Fregate f1 = new Fregate(5,5);
		Fregate f2 = new Fregate(2,8);
		Croiseur c1 = new Croiseur(1,1);
		Croiseur c2 = new Croiseur(4,4);
		SousMarin s1 = new SousMarin(2,2);
		SousMarin s2 = new SousMarin(3,6);
		Bateau[] bateaux = {f1, f2, c1, c2, s1, s2};
		cb.refresh(bateaux);
    System.out.println(cb);
		//f1.avancer();
		cb.refresh(bateaux); //était setboat, à méditer
    for (int i = 0; i < bateaux.length; i++)	{
			System.out.println(bateaux[i].getOrientation());
		}
  }
}
