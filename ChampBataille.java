
public class ChampBataille	{
  private int[][] t;
	private int longueurChamp;

  public ChampBataille()	{  }

  public ChampBataille(int l)	{
    t = new int[l][l];
    for (int i = 0; i < t.length; i++) {
      for (int j = 0; j < t[i].length; j++) {
        t[i][j] = 0;
      }
    }
		this.longueurChamp = l;
  }

  public String toString() {
    String s = new String();
    s+="|  |";
    for (int i = 1; i < t.length+1; i++)	{
      if (i < 10)	{
        s+=" "+i;
      }
      else	{
        s+=i;
      }
      s+="|";
    }
    s+="\n";
    for (int i = 0; i < t.length; i++)	{
      s+="| "+(char) (i+65)+"|";
      for (int j = 0; j < t[i].length; j++) {
        int type = t[i][j];
        switch (type)  {
          case 0:
            s+="~~";
            break;
          case 1:
            s+="F1";
						break;
					case 2:
						s+="F2";
						break;
					case 3:
						s+="C1";
						break;
					case 4:
						s+="C2";
						break;
					case 5:
						s+="S1";
						break;
					case 6:
						s+="S2";
						break;
        }
        s+="|";
      }
      s+="\n";
    }
    return s;
  }

  public void setBoat(int x, int y)	{
    this.t[x][y] = 1;
  }

	public void refresh(Bateau[] bat)	{
		// Un bateau sera défini par 2 points (x+taille; y+taille | x; y+taille | x - taille; y | x - taille; y - taille)
		// String[] orientations = {"horizontal", "vertical", "diagonal", "antiDiagonal"};
		// à l'init coordonnées random + orientation random
		// méthode isOutside() à faire
		for (int i = 0; i < bat.length; i++)	{
			this.t[bat[i].getX()-1][bat[i].getY()-1] = i+1;
			for (int j = 0; j < bat[i].getTaille(); j++)	{
				this.t[bat[i].getX()-1+j][bat[i].getY()-1] = i+1;
			}
		}
  }

}
