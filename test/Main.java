public class Main	{

  public static void main(String[] args)	{
		Daughter d1 = new Daughter();
		d1.setResistance(4);
		System.out.println(d1.getResistance());
		d1.addOneRes();
		System.out.println(d1.getResistance());
	}
}
