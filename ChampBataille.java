
public class ChampBataille	{
  private int[][] t;

  public ChampBataille()	{  }

  public ChampBataille(int l)	{
    t = new int[l][l];
    for (int i = 0; i < t.length; i++) {
      for (int j = 0; j < t[i].length; j++) {
        t[i][j] = 0;
      }
    }
  }

  public String toString() {
    String s = new String();
    for (int i = 0; i < t.length; i++) {
      s+="|";
      for (int j = 0; j < t[i].length; j++) {
        switch (t[i][j])  {
          case 0:
            s+="~~";
          case 1:
            s+="F1";
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

}
