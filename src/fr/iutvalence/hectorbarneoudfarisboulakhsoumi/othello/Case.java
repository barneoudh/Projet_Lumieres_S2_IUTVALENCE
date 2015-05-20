package fr.iutvalence.hectorbarneoudfarisboulakhsoumi.othello;

public class Case {
//	A case could contain a pawn 
	private Pawn pawn;
//  The constructor create a case without pawn
	public Case() {
		this.pawn = null;
	}
//  This method return the color of the pawn in the current case
	public Couleur color()
	{
		return this.pawn != null ? this.pawn.getCouleur() : null;
	}
//  This method return the pawn in the current case	
	public Pawn getPawn(){
		return this.pawn;
	}
//  Tell if the case is available, if there is any pawn on it
	public boolean isAvailable()
	{
		return this.pawn == null;
	}
//  Put a pawn in the case	
	public void putPawn(Pawn pawn) {
		this.pawn = pawn;
	}
	
//  ToString method to show the cases 
	public String toString()
	{
		return String.format("|-(%s)-|", this.pawn == null ? " " : pawn);
	}



}
