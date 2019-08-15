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
    EnsembleBateaux eb = new EnsembleBateaux();

		//f1.avancer();

    boolean game = true;
		eb.initPlacements();
		cb.refresh(eb.getEnsemble());
		System.out.println(cb);

    while(game) {
      System.out.println(eb.getInfosBateaux());

			if (eb.sontSansMun() || eb.sontCoules()) {
				System.out.println("Game over !");
				game = false;
			}

			else {
				int bateauChoisi = eb.choisirBateau();
				eb.actionsBateaux(bateauChoisi, cb);
				cb.refresh(eb.getEnsemble());
				System.out.println(cb);
			}
		}
	}
}
