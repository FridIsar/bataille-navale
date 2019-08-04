
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
    s+="|  |";
    for (int i = 1; i < t.length+1; i++)  {
      if (i < 10) {
        s+=" "+i;
      }
      else  {
        s+=i;
      }
      s+="|";
    }
    s+="\n";
    for (int i = 0; i < t.length; i++)  {
      s+="| "+(char) (i+65)+"|";
      for (int j = 0; j < t[i].length; j++) {
        int type = t[i][j];
        switch (type)  {
          case 0:
            s+="~~";
            break;
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
