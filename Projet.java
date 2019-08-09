public class Projet	{ //ajout
// le prof n'aime pas les returns dans boucle (à éviter)

  public static void main(String[] args)	{
    ChampBataille cb = new ChampBataille(Globals.getLongueurChampMax());
    System.out.println(cb);
    Position p1 = new Position(3,3);
    // Fregate f1 = new Fregate(5,5);
		// Fregate f2 = new Fregate(2,8);
		// Croiseur c1 = new Croiseur(1,1);
		// Croiseur c2 = new Croiseur(4,4);
    SousMarin s1 = new SousMarin();
    SousMarin s2 = new SousMarin();
    SousMarin s3 = new SousMarin();
    SousMarin s4 = new SousMarin();
		// SousMarin s2 = new SousMarin(3,6);
		// Bateau[] bateaux = {f1, f2, c1, c2, s1, s2};
    Bateau[] bateaux = {s1, s2, s3, s4};

    for(int i = 0; i < bateaux.length; i++)	{
			bateaux[i].setRandomOrientation();
      bateaux[i].randomizePosition();
		}
		for(int i = 0; i < bateaux.length; i++)	{
      bateaux[i].fillBoat();
			if(!bateaux[i].isInside())	{
				bateaux[i].randomizePosition();
				i-=1;
			}
		}

		//f1.avancer();
		cb.refresh(bateaux);
    System.out.println(cb);
    // for (int i = 0; i < bateaux.length; i++)	{
    //   // bateaux[i].setRandomOrientation();
		// 	System.out.println(bateaux[i].getOrientation());
		// }
  }
}
