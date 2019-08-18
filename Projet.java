import java.util.Scanner;

public class Projet	{
// (mine pportée 0 !)
// AJOUTER LA 3E DIMENSION


// le prof n'aime pas les returns dans boucle (à éviter)
  public static void main(String[] args)	{

    ChampBataille cb = new ChampBataille(Globals.getLongueurChampMax(), Globals.getProfondeurChampMax());
    System.out.println(cb);
    EnsembleBateaux eb = new EnsembleBateaux();

    boolean game = true;
		eb.initPlacements();
		cb.refresh(eb.getEnsemble());
		System.out.println(cb);

    while(game) {
      System.out.println(eb.getInfosBateaux());

			if (eb.noMunOrCoules()) {
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
