
public class ChampBataille	{
  private int[][] t;
	private int longueurChamp;

  public ChampBataille()	{  }

  public ChampBataille(int l)	{
    t = new int[l][l];
    reset();
		this.longueurChamp = l;
  }

  public String toString() {
    String s = new String();
    s+="|  |";
    for (int i = 0; i < t.length; i++)	{
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
      s+="|";
      if (i < 10)	{
        s+=" "+i;
      }
      else	{
        s+=i;
      }
      s+="|";
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

  public int[][] getT() {
    return this.t;
  }

  public void setBoat(int x, int y)	{
    this.t[x][y] = 1;
  }

  public void reset() {
    for (int i = 0; i < t.length; i++) {
      for (int j = 0; j < t[i].length; j++) {
        t[i][j] = 0;
      }
    }
  }

	public void refresh(Bateau[] bateaux)	{
		// Un bateau sera défini par 2 points (x+taille; y+taille | x; y+taille | x - taille; y | x - taille; y - taille)
		// String[] orientations = {"horizontal", "vertical", "diagonal", "antiDiagonal"};
		// à l'init coordonnées random + orientation random
		// méthode isOutside() à faire
    reset();
		for (int i = 0; i < bateaux.length; i++)	{
			if (!bateaux[i].estCoule())	{
	      Position[] emplacements = bateaux[i].getEmplacements();
				for (int j = 0; j < bateaux[i].getTaille(); j++)	{
					this.t[emplacements[j].getX()][emplacements[j].getY()] = i+1;
				}
			}
		}
  }

}
