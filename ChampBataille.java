
public class ChampBataille	{
  private int[][][] t;
	private int longueurChamp;
	private int profondeurChamp;

  public ChampBataille()	{  }

  public ChampBataille(int l, int p)	{
    t = new int[l][l][p];
    reset();
		this.longueurChamp = l;
  }

  public String toString() {
    String s = "\n";
		for (int z = 0; z < Globals.getProfondeurChampMax(); z++) {
      if (aUnBateau(z)) {
        s+="|P"+z+"|";
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
            int type = t[i][j][z];
            switch (type)  {
              case 0:
              s+="~~";
              break;
              case 1:
              s+="F1";
              break;
              case 2:
              s+="C1";
              break;
              case 3:
              s+="S1";
              break;
              case 4:
              s+="F2";
              break;
              case 5:
              s+="C2";
              break;
              case 6:
              s+="S2";
              break;
            }
            s+="|";
          }
          s+="\n";
        }
        s+="\n";
      }
		}
    return s;
  }

  public int[][][] getT() {
    return this.t;
  }

  public void reset() {
    for (int i = 0; i < t.length; i++) {
      for (int j = 0; j < t[i].length; j++) {
				for (int z = 0; z < t[i][j].length; z++) {
        t[i][j][z] = 0;
				}
      }
    }
  }

	public void refresh(Bateau[] bateaux)	{
    reset();
		for (int i = 0; i < bateaux.length; i++)	{
			if (!bateaux[i].estCoule())	{
	      Position[] emplacements = bateaux[i].getEmplacements();
				for (int j = 0; j < bateaux[i].getTaille(); j++)	{
					this.t[emplacements[j].getX()][emplacements[j].getY()][emplacements[j].getZ()] = i+1;
				}
			}
		}
  }

  public boolean aUnBateau(int z) {
    boolean cond = false;
    for (int i = 0; i < t.length && cond == false; i++)	{
      for (int j = 0; j < t[i].length && cond == false; j++) {
        if (t[i][j][z] != 0) {
          cond = true;
        }
      }
    }
    return cond;
  }

}
