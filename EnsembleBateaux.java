import java.util.Scanner;

public class EnsembleBateaux	{


	private Bateau[] ensemble = {
																	new SousMarin(),
																	new SousMarin(),
																	new SousMarin(),
																	new SousMarin(),
															};
	public EnsembleBateaux()	{
	}

	public Bateau[] getEnsemble()	{
		return this.ensemble;
	}

	public String getInfosBateaux()	{
		return "0. F1 (HP : "+ensemble[0].getResistance()+", AMMO : "+ensemble[0].getMunitions()+")\n1. F2 (HP : "+ensemble[1].getResistance()+", AMMO : "+ensemble[1].getMunitions()+")\n2. C1\n3. C2\n4. Stop";
	}

	public void initPlacements()	{
		boolean isvalid = false;

		while (!isvalid)	{
			for(int i = 0; i < ensemble.length; i++)	{
				ensemble[i].setRandomOrientation();
				ensemble[i].randomizePosition();
			}

			for(int i = 0; i < ensemble.length; i++)	{
				ensemble[i].fillBoat();
				if(!ensemble[i].isInside())	{
					ensemble[i].randomizePosition();
					i-=1;
				}
			}
			isvalid = true; //for now
			for(int i = 0; i < ensemble.length; i++)	{
				if(ensemble[i].touchesA(ensemble))	{
					isvalid = false;
					//System.out.println("on recommence");
				}
			}
		}
	}

	public boolean sontCoules()	{
		boolean sontTousCoules = false;
		int bateauxCoules = 0;
		for (int i = 0; i < ensemble.length; i++) {
			if (ensemble[i].estCoule())	{
				bateauxCoules++;
			}
		}
		if (bateauxCoules == ensemble.length) {
			sontTousCoules = true;
		}
		return sontTousCoules;
	}

	public boolean sontSansMun()	{
		boolean sontTousSansMun = false;
		int bateauxSansMun = 0;
		for (int i = 0; i < ensemble.length; i++) {
			if (!ensemble[i].aEncoreMunitions())	{
				bateauxSansMun++;
			}
		}
		if (bateauxSansMun == ensemble.length) {
			sontTousSansMun = true;
		}
		return sontTousSansMun;
	}


	public int choisirBateau()	{
		Scanner sc = new Scanner(System.in);
		boolean bonchoix = false;
		int choix = -1;
		while (!bonchoix)	{
			choix = sc.nextInt();
			if (choix < 0 || choix > 3) {
				System.out.println("Veuillez choisir un nombre entre 0 et 3 inclus !");
			}
			else	{
				if (ensemble[choix].estCoule()) {
					System.out.println("Vous ne pouvez choisir un bateau mort !");
				}
				else {
					bonchoix = true;
				}
			}
		}
		return choix;
	}

	public void actionsBateaux(int bateauChoisi, ChampBataille cb)	{
		Scanner sc = new Scanner(System.in);
		int choix = -1;
		while (choix < 1 || choix > 4)	{
			System.out.println("1. Pour avancer\n2. Pour reculer\n3. Pour tirer\n4. Pour position de la tête");
			choix = sc.nextInt();
		}

		if (choix == 1) {
			ensemble[bateauChoisi].avancer();
			if (!ensemble[bateauChoisi].isInside()) {
				System.out.println("Vous ne pouvez aller dehors ! retour à la position initiale");
				ensemble[bateauChoisi].reculer();
			}
			if (ensemble[bateauChoisi].touchesA(ensemble)) {
				System.out.println("Bateau touché ! vous perdez un point de résistance et retournez à la position initiale");
				ensemble[bateauChoisi].reculer();
			}
		}

		if (choix == 2) {
			ensemble[bateauChoisi].reculer();
			if (!ensemble[bateauChoisi].isInside()) {
				System.out.println("Vous ne pouvez aller dehors ! retour à la position initiale");
				ensemble[bateauChoisi].avancer();
			}
			if (ensemble[bateauChoisi].touchesA(ensemble)) {
				System.out.println("Bateau touché ! vous perdez un point de résistance et retournez à la position initiale");
				ensemble[bateauChoisi].avancer();
			}
		}

		if (choix == 3) {
			if (ensemble[bateauChoisi].aEncoreMunitions())	{
				ensemble[bateauChoisi].useMunition();
				int batTouche = ensemble[bateauChoisi].tirer(cb);
				if (batTouche > 0)	{
					ensemble[batTouche-1].refreshResistance(ensemble[bateauChoisi].getDegats());
					System.out.println("prend "+ensemble[bateauChoisi].getDegats()+" degats !");
				}
			}
			else	{
				System.out.println("no ammo left !");
			}
		}

		if (choix == 4) {
			System.out.println(ensemble[bateauChoisi].getEmplacements()[0]);
		}
	}

}
