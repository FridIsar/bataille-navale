public interface Bateau	{

	public enum Orientation	{
		Horizontal,
		Vertical,
		Diagonal,
		AntiDiagonal;
	}

	//public abstract void tirer();
	public abstract int getTaille();
	public abstract void fillBoat();
	public abstract int getResistance();
	public void randomizePosition();
	public abstract Orientation getOrientation();
	public abstract void setRandomOrientation();
	// public abstract void avancer();
	public abstract boolean isInside();
}
