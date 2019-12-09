import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import javax.swing.text.html.HTMLDocument.Iterator;

public class Graphe 
{
	/* classe qui definit mon graphe
	 * Pour cela jutilise un arrayList qui contient des LinkedList
	 * Dans ce exercice le graphe est considere non oriente
	 * 
	 * */
	
	private int nbre_sommet;
	private ArrayList<LinkedList<Integer>> mesElements=new ArrayList<LinkedList<Integer>>();
	 
	 //j'initialise mon graphe avec n sommet 
	
	
	public Graphe(int n) 
	
	{
        if (n < 1)
        throw new IllegalArgumentException("le nombre de sommets ne peut etre inferieur ou egal à zero");
        this.nbre_sommet = n;
        this.mesElements = new ArrayList<LinkedList<Integer>>(nbre_sommet);
        for (int i = 0; i < n; i++)
            mesElements.add(new LinkedList<Integer>());
        
        // jai desormais  n sommets dans mon graphe contenant de 0 à n comme valeur de sommet
    }

	/*implementon l'ajout d'un arc elle prend en compte les deux sommets i---j
	 * en effet si une arrete existe de i vers j alors je peux partir de i vers j et de j vers i
	 * */
	
	public void ajouteArete(int sommet_i, int sommet_j)
	{
        
        verifier_sommet(sommet_i);
        verifier_sommet(sommet_j);
        this.mesElements.get(sommet_i).add(sommet_j);
        this.mesElements.get(sommet_j).add(sommet_i);
    }
	//Iterator <String>  monIteration= maliste.iterator();
	
	//verifie si le sommet est belle et bien present dans la structure de graphe
	
	public boolean verifier_sommet (int i)
	{
		if (mesElements.contains(i))
		return true;
		return false;
	}
	
	 //verifie si deux noeuds sont voisins
	
	 public boolean sontVoisins(int u, int v)
	 {
	        return (mesElements.get(u).contains(v) || mesElements.get(v).contains(u));

	 }
	 
	 /*fonction qui retourne la liste des des voisins d'un noeud on lui donne le sommet en entre
	  * 
	  * */
	 
	  public List<Integer> voisins(int v)
	  {
	       if ( verifier_sommet(v))

	        return Collections.unmodifiableList(mesElements.get(v));
		    return null;           
	  }
	
	  /*
	   * degre d'un noeud*/
	  
	  public int degre(int v)
	  {
		  if ( verifier_sommet(v))
		  {
			  List<Integer> l=voisins(v);
			  return l.size();	 	        
	      }
	   
		  return -1 ;
	  }
	  
	  public int maxDegre() {
	        //a implementer
	        return -1;
	    }

	  
	  /*
	   * 
	   * 
	   * */
	  
	  
	  
	  
	  
}
