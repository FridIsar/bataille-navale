public class Globals	{

  private static final int L_CHAMP = 10;
  private static final int P_CHAMP = 4;

  private static boolean tourDuJoueur = true;

  private static String message = "";

  public static int getLongueurChampMax() {
    return L_CHAMP;
  }

	public static int getProfondeurChampMax() {
		return P_CHAMP;
	}

  public static boolean getTourDuJoueur()  {
    return tourDuJoueur;
  }

  public static void toggleTourDuJoueur()  {
    tourDuJoueur = !tourDuJoueur;
    message = "";
  }

  public static String getMessage() {
    return message+"\n";
  }

  public static void appendMessage(String toAdd)  {
    message+=toAdd;
  }
}
