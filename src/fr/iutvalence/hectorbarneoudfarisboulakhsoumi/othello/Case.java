package fr.iutvalence.hectorbarneoudfarisboulakhsoumi.othello;

public class Case {
	private Pawn pawn;
	
	public Case() {
		this.pawn = null;
	}

	public Couleur color()
	{
		return this.pawn != null ? this.pawn.getCouleur() : null;
	}
	

	public boolean isAvailable()
	{
		return this.pawn == null;
	}
	
	public void putPawn(Pawn pawn) {
		this.pawn = pawn;
	}
	
	@Override
	public String toString()
	{
		return String.format("|-(%s)-|", this.pawn == null ? " " : pawn);
	}



}
