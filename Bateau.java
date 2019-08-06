public interface Bateau	{

	public enum Orientation	{
		Horizontal,
		Vertical,
		Diagonal,
		AntiDiagonal;
	}

	//public abstract void tirer();
	public abstract int getX();
	public abstract int getY();
	public abstract int getTaille();
	public abstract int getResistance();
	public abstract Orientation getOrientation();
	public abstract void setRandomOrientation();
	public abstract void avancer();
	public abstract boolean isInside();
}
