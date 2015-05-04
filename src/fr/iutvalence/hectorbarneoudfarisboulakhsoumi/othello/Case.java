package fr.iutvalence.hectorbarneoudfarisboulakhsoumi.othello;

public class Case {

	private Pawn pawn;
	private Position position;
	/**
	 * @param pawn
	 * @param position
	 */
	
	public Case(Position position) {
		this.position=position;
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

	@Override
	public String toString()
	{
		return String.format("|-(%s)-|", this.pawn == null ? "" : pawn);
	}	
}
