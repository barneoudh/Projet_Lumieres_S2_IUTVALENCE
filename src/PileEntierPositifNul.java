public class PileEntierPositifNul 
{
	private final int capacite;
	private int taille;
	private int pile[];
	private int indice_pile;
	
	public void empiler(int entier)
	
	{
 //aaaaaaaaaaaaaaaaaaaaaaa
		
		if(taille != capacite) // si pile pas pleine
		{
			if(entier < 0) // si l'entier est strictement négatif
			{
				System.out.println("Entier négatif !");
			}
			else // si l'entier est positif ou nul
			{
			pile[indice_pile] = entier; // on place l'entier à l'indice dans le tab
			taille = taille+1; // on modifie la taille
			indice_pile = indice_pile-1; // case suivante
			System.out.println("Succès !");
			}		
		}
		else // si pile pleine
		{
			System.out.println("Pile Pleine !");
		}
	
	} // fin empiler

	public int depiler()
	{
	
		int element_depile = -2000;

		if(taille != 0) // si pile pas pleine
		{
		
			element_depile = pile[indice_pile];
			pile[indice_pile] = -1000; // on met la case à null...
			taille = taille-1; // on modifie la taille
			indice_pile = indice_pile+1; // case suivante
			System.out.println("Succès !");
			return(element_depile);		
		}
		else // si pile pleine
		{
			System.out.println("Pile Vide !");
			return(element_depile);
		}
	
	} // fin depiler

	public int taille()
	{

		return(taille);
			
	} // fin taille

	public int sommet()
	{

		return(indice_pile);
			
	} // fin taille


	public PileEntierPositifNul(int capacite) {
		this.capacite = capacite;
		this.taille = 0;
		this.pile = new int[capacite];
		this.indice_pile = -4;
	}

	
}
