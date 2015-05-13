package fr.iutvalence.hectorbarneoudfarisboulakhsoumi.othello;

public class Case {
	private Pawn pawn;
	
	public Case() {
		this.pawn = null;
	}

	public Pawn getPawn()
	{
		return this.pawn;
	}
	
	public void putPawn(Pawn pawn)
	{
		this.pawn = pawn;	
	}

	public boolean isAvailable()
	{
		return this.pawn == null;
	}
	
	@Override
	public String toString()
	{
		return String.format("|-(%s)-|", this.pawn == null ? " " : pawn);
	}	
}
