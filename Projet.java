import java.util.Scanner;

public class Projet	{
// (mine pportee 0 !)
// AJOUTER LA 3E DIMENSION


// le prof n'aime pas les returns dans boucle (a eviter)
  public static void main(String[] args)	{

    ChampBataille cb = new ChampBataille(Globals.getLongueurChampMax(), Globals.getProfondeurChampMax());
    System.out.println(cb);
    EnsembleBateaux eb = new EnsembleBateaux();

    boolean game = true;
    String messages = "";
    int nbTours = 1;

		eb.initPlacements();
		cb.refresh(eb.getEnsemble());
		System.out.println(cb);

    while(game) {
      if (Globals.getTourDuJoueur())  { //si c'est le tour du joueur
        System.out.println("Tour "+nbTours+" :\n");
        nbTours++;
        messages = "";
        System.out.println(eb.getInfosBateaux());
      }

			if (eb.noMunOrCoules()) { //si plus d'ammo ou bateaux
				System.out.println("Game over.");
        if (Globals.getTourDuJoueur())  {
          System.out.println("Vous avez perdu...");
        }
        else  {
          System.out.println("Vous avez gagne !");
        }
				game = false;
			}

			else {
				int bateauChoisi = eb.choisirBateau();
				eb.actionsBateaux(bateauChoisi, cb);
				cb.refresh(eb.getEnsemble());

        messages += Globals.getMessage()+"\n"; //affichage actions

        if (!Globals.getTourDuJoueur())  {
          System.out.println(cb);
          System.out.println(messages);
        }

        Globals.toggleTourDuJoueur();
			}
		}
	}
}
