import java.util.Scanner;

public class Projet	{
// FAIRE AVANCER RECULER
// FAIRE TIRER ET RESISTANCE (mine pportée 0 !)
// Faire que le main soit propre a la fin
// Faire une classe EnsembleBateaux
// AJOUTER LA 3E DIMENSION
// selon https://stackoverflow.com/questions/45244647/how-can-i-use-while-loops-in-a-text-based-game-java
// ^ eviter les boucles dans le main, plutot releger a chaque classe et faire des if

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
      System.out.println("0. Stop\n1. F1 (HP : "+bateaux[0].getResistance()+", AMMO : "+bateaux[0].getMunitions()+")\n2. F2 (HP : "+bateaux[1].getResistance()+", AMMO : "+bateaux[1].getMunitions()+")\n3. C1\n4. C2");

			int bateauxSansMun = 0;
			int bateauxCoules = 0;
			for (int i = 0; i < bateaux.length; i++) {
				if (!bateaux[i].aEncoreMunitions())	{
					bateauxSansMun++;
				}
				if (bateaux[i].estCoule())	{
					bateauxCoules++;
				}
			}
			if (bateauxSansMun == bateaux.length || bateauxCoules == bateaux.length) {
				System.out.println("Game over !");
				game = false;
			}

			else {
				int choixBateau = sc.nextInt();
				if (choixBateau < 1 || choixBateau > 4) {
					System.out.println("Veuillez choisir un nombre entre 1 et 4 inclus !");
				}

				else	{
					if (bateaux[choixBateau-1].estCoule()) {
						System.out.println("Vous ne pouvez choisir un bateau mort !");
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
							if (bateaux[choixBateau-1].aEncoreMunitions())	{
								bateaux[choixBateau-1].useMunition();
								int batTouche = bateaux[choixBateau-1].tirer(cb);
								if (batTouche > 0)	{
									bateaux[batTouche-1].refreshResistance(bateaux[choixBateau-1].getDegats());
									System.out.println("prend "+bateaux[choixBateau-1].getDegats()+" degats !");
								}
							}
							else	{
								System.out.println("no ammo left !");
							}
						}

						if (choix == 4) {
							System.out.println(bateaux[choixBateau-1].getEmplacements()[0]);
						}
						cb.refresh(bateaux);
						System.out.println(cb);
					}
				}
			}
		}
  }
}
