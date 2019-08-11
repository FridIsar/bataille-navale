public abstract class Mother	{

	public static int resistance;

	public abstract int getResistance();
	public abstract void setResistance(int a); //pas oublier les params en abs!

	public void addOneRes()	{
		this.setResistance(this.getResistance()+1);
	}
}
