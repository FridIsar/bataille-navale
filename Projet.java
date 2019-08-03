public class Projet {

  public static final int L_CHAMP = 10;
  public static final int P_CHAMP = 1;

  public static void main(String[] args) {
    ChampBataille cb = new ChampBataille(L_CHAMP);
    System.out.println(cb);
    cb.setBoat(3,4);
    cb.setBoat(2,7);
    cb.setBoat(5,1);
    cb.setBoat(9,6);
    System.out.println(cb);
  }
}
