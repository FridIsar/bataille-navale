import java.util.Scanner;

public class EnsembleBateaux	{


	private Bateau[] ensemble = {
																	new Fregate(),
																	new Croiseur(),
																	new SousMarin(),
																	new Fregate(),
																	new Croiseur(),
																	new SousMarin()
															};

	public EnsembleBateaux()	{
	}

	public Bateau[] getEnsemble()	{
		return this.ensemble;
	}

	public String getInfosBateaux()	{
		String infos = "Vos bateaux :\n";
		String[] noms = {"F1", "C1", "S1", "F2", "C2", "S2"};
		for (int i = 0; i < ensemble.length-3; i++) {
			infos+=(i+1)+". "+noms[i]+" (VIE : "+ensemble[i].getResistance()+" MUNITIONS : "+ensemble[i].getMunitions()+")\n";
		}
		infos += "\nBateaux ennemis :\n";
		for (int i = 3; i < ensemble.length; i++) {
			infos+=(i+1)+". "+noms[i]+" (VIE : "+ensemble[i].getResistance()+" MUNITIONS : "+ensemble[i].getMunitions()+")\n";
		}

		return infos;
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
				ensemble[i].initMunitions();
			}
		}
	}

	public boolean noMunOrCoules()	{
		boolean sontTousMorts = false;
		int bateauxMorts = 0;
		for (int i = 0; i < ensemble.length; i++) {
			if (ensemble[i].estCoule() || !ensemble[i].aEncoreMunitions())	{
				bateauxMorts++;
			}
		}
		if (bateauxMorts == ensemble.length) {
			sontTousMorts = true;
		}
		return sontTousMorts;
	}

	public int choisirBateau()	{
		Scanner sc = new Scanner(System.in);
		boolean bonchoix = false;
		int choix = -1;
		while (!bonchoix)	{
			if (Globals.getTourDuJoueur())	{
				choix = sc.nextInt();
			}
			else {
				double choixAleatoire =  Math.random() * 3 + 4; //rand entre 4 et 6
				choix = (int) choixAleatoire;
			}
			if ((choix < 1 || choix > 3) && Globals.getTourDuJoueur()) {
				System.out.println("Veuillez choisir un nombre entre 1 et 3 inclus !");
			}
			else	{
				if (ensemble[choix-1].estCoule()) {
					System.out.println("Vous ne pouvez choisir un bateau mort !");
				}
				else {
					bonchoix = true;
				}
			}
		}
		Globals.appendMessage(ensemble[choix-1].toString());
		return choix-1; //-1 pour adapter à l'array
	}

	public void actionsBateaux(int bateauChoisi, ChampBataille cb)	{
		Scanner sc = new Scanner(System.in);
		int choix = -1;
		int choixMax = 3;
		String propositions = "1. Pour avancer\n2. Pour reculer\n3. Pour tirer";
		if (ensemble[bateauChoisi] instanceof SousMarin)	{
			propositions+="\n4. Pour remonter\n5. Pour plonger";
			choixMax = 5;
		}
		while (choix < 1 || choix > choixMax)	{
			if (Globals.getTourDuJoueur())	{
				System.out.println(propositions);
				choix = sc.nextInt();
			}
			else {
				double choixAleatoire =  Math.random() * choixMax + 1;
				choix = (int) choixAleatoire;
			}
		}

		if (choix == 1) {
			ensemble[bateauChoisi].avancer();
			Globals.appendMessage(" avance d'une case "+ensemble[bateauChoisi].getOrientation()+"ement");
			if (!ensemble[bateauChoisi].isInside()) {
				Globals.appendMessage(" mais ne peut aller dehors ! Retour à sa position initiale");
				ensemble[bateauChoisi].reculer();
			}
			if (ensemble[bateauChoisi].touchesA(ensemble)) {
				Globals.appendMessage(" mais il percute un bateau ! Il perd un point de résistance et retourne à sa position initiale");
				ensemble[bateauChoisi].refreshResistance(1);
				ensemble[bateauChoisi].reculer();
			}
		}

		if (choix == 2) {
			ensemble[bateauChoisi].reculer();
			Globals.appendMessage(" recule d'une case "+ensemble[bateauChoisi].getOrientation()+"ement");
			if (!ensemble[bateauChoisi].isInside()) {
				Globals.appendMessage(" mais ne peut aller dehors ! Retour à sa position initiale");
				ensemble[bateauChoisi].avancer();
			}
			if (ensemble[bateauChoisi].touchesA(ensemble)) {
				Globals.appendMessage(" mais il percute un bateau ! Il perd un point de résistance et retourne à sa position initiale");
				ensemble[bateauChoisi].refreshResistance(1);
				ensemble[bateauChoisi].avancer();
			}
		}

		if (choix == 3) {
			if (ensemble[bateauChoisi].aEncoreMunitions())	{
				ensemble[bateauChoisi].useMunition();
				int batTouche = ensemble[bateauChoisi].tirer(cb);
				if (batTouche > 0)	{
					ensemble[batTouche-1].refreshResistance(ensemble[bateauChoisi].getDegats());
				}
			}
			else	{
				Globals.appendMessage(" n'a plus de munitions !");
			}
		}

		if (choix == 4) {
			((SousMarin) ensemble[bateauChoisi]).remonter();
			Globals.appendMessage(" remonte d'une case");
			if (!((SousMarin) ensemble[bateauChoisi]).isInside()) {
				Globals.appendMessage(" mais ne peut aller dehors ! Retour à sa position initiale");
				((SousMarin) ensemble[bateauChoisi]).plonger();
			}
			if (((SousMarin) ensemble[bateauChoisi]).touchesA(ensemble)) {
				Globals.appendMessage(" mais il percute un bateau ! Il perd un point de résistance et retourne à sa position initiale");
				((SousMarin) ensemble[bateauChoisi]).refreshResistance(1);
				((SousMarin) ensemble[bateauChoisi]).plonger();
			}
		}

		if (choix == 5) {
			((SousMarin) ensemble[bateauChoisi]).plonger();
			Globals.appendMessage(" plonge d'une case");
			if (!((SousMarin) ensemble[bateauChoisi]).isInside()) {
				Globals.appendMessage(" mais ne peut aller dehors ! Retour à sa position initiale");
				((SousMarin) ensemble[bateauChoisi]).remonter();
			}
			if (((SousMarin) ensemble[bateauChoisi]).touchesA(ensemble)) {
				Globals.appendMessage(" mais il percute un bateau ! Il perd un point de résistance et retourne à sa position initiale");
				((SousMarin) ensemble[bateauChoisi]).refreshResistance(1);
				((SousMarin) ensemble[bateauChoisi]).remonter();
			}
		}
	}

}
