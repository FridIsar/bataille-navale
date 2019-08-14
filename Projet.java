import java.util.Scanner;

public class Projet	{
// FAIRE AVANCER RECULER
// FAIRE TIRER ET RESISTANCE (mine pportée 0 !)
// AJOUTER LA 3E DIMENSION
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

		boolean isvalid = false;

		while (!isvalid)	{
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
			isvalid = true; //for now
			for(int i = 0; i < bateaux.length; i++)	{
				if(bateaux[i].touchesA(bateaux))	{
					isvalid = false;
					System.out.println("on recommence");
				}
			}
	}

		//f1.avancer();
		cb.refresh(bateaux);
    System.out.println(cb);

    Scanner sc = new Scanner(System.in);

    boolean game = true;

    while(game) {
      System.out.println("0. Stop\n1. F1\n2. F2\n3. C1\n4. C2");
      int choixBateau = sc.nextInt();
      if (choixBateau < 1 || choixBateau > 4) {
        System.out.println("Game over!");
        game = false;
      }
      else {
        System.out.println("1. Pour avancer\n2. Pour reculer\n3. Pour tirer\n4. Pour position de la tête");
        int choix = sc.nextInt();

        if (choix == 1) {
          bateaux[choixBateau-1].avancer();
          if (!bateaux[choixBateau-1].isInside()) {
            System.out.println("Vous ne pouvez aller dehors ! retour à la position initiale");
            bateaux[choixBateau-1].reculer();
          }
          if (bateaux[choixBateau-1].touchesA(bateaux)) {
            System.out.println("Bateau touché ! vous perdez un point de résistance et retournez à la position initiale");
            bateaux[choixBateau-1].reculer();
          }
        }

        if (choix == 2) {
          bateaux[choixBateau-1].reculer();
          if (!bateaux[choixBateau-1].isInside()) {
            System.out.println("Vous ne pouvez aller dehors ! retour à la position initiale");
            bateaux[choixBateau-1].avancer();
          }
          if (bateaux[choixBateau-1].touchesA(bateaux)) {
            System.out.println("Bateau touché ! vous perdez un point de résistance et retournez à la position initiale");
            bateaux[choixBateau-1].avancer();
          }
        }

        if (choix == 3) {
          bateaux[choixBateau-1].tirer(cb);
        }

        if (choix == 4) {
          System.out.println(bateaux[choixBateau-1].getEmplacements()[0]);
        }
        cb.refresh(bateaux);
        System.out.println(cb);
      }
  }
    // for (int i = 0; i < bateaux.length; i++)	{
    //   // bateaux[i].setRandomOrientation();
		// 	System.out.println(bateaux[i].getOrientation());
		// }
  }
}
