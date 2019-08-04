public class Projet	{ //ajout

  public static final int L_CHAMP = 10;
  public static final int P_CHAMP = 1;

  public static void main(String[] args)	{
    ChampBataille cb = new ChampBataille(L_CHAMP);
    System.out.println(cb);
    Fregate f1 = new Fregate(5,5);
		cb.refresh(f1);
    System.out.println(cb);
		f1.avancer();
		cb.refresh(f1); //était setboat, à méditer
		System.out.println(cb);
  }
}
