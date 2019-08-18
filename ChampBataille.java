
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
    String s = new String();
		System.out.println(Globals.getProfondeurChampMax());
		for (int z = 0; z < Globals.getProfondeurChampMax(); z++) {
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

}
