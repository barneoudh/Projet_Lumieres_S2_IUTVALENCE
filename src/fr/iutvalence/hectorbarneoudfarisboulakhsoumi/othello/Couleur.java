package fr.iutvalence.hectorbarneoudfarisboulakhsoumi.othello;

public enum Couleur {
//  Enumeration: 2 Colors available for the pawns: BLACK or WHITE
	BLACK,
	WHITE;
	
//  WHITE pawns are drawn with a w, BLACK pawns are drawn with a b
	public String toString()
	{
		if (this == WHITE) return "w";
		else return "b";
	}

}
