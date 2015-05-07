package fr.iutvalence.hectorbarneoudfarisboulakhsoumi.othello;

public enum Couleur {
	
	BLACK,
	WHITE;

	public String toString()
	{
		if (this == WHITE) return "w";
		else return "b";
	}

}
