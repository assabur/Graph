import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;



public class Graphe 
{
	/* classe qui definit mon graphe
	 * Pour cela jutilise un arrayList qui contient des LinkedList
	 * Dans ce exercice le graphe est considere non oriente
	 * 
	 * */
	private LinkedList<Integer> adjancence[]; //elle correspond à ma liste d'adjencence
	private static final int V = 0;
	private int nbre_sommet;
	
	public int getNbre_sommet() {
		return nbre_sommet;
	}

	public void setNbre_sommet(int nbre_sommet) {
		this.nbre_sommet = nbre_sommet;
	}



	private ArrayList<LinkedList<Integer>> mesElements=new ArrayList<LinkedList<Integer>>();
	 
	 //j'initialise mon graphe avec n sommet de valeur i allant de 0 à n
	
	
	public Graphe(int n) 
	
	{
        if (n < 1)
        throw new IllegalArgumentException("le nombre de sommets ne peut etre inferieur ou egal à zero");
        this.nbre_sommet = n;
        this.mesElements = new ArrayList<LinkedList<Integer>>(nbre_sommet);
        
        
        for (int i = 0; i < n; i++)
        { 
        	LinkedList<Integer> a=new LinkedList<Integer>();
        	mesElements.add(new LinkedList<Integer>());
        	a.add(i);
        	mesElements.add(a);
        }  
        
       
        
        // jai desormais  n sommets dans mon graphe contenant de 0 à n comme valeur de sommet
    }

	/*implementon l'ajout d'un arc elle prend en compte les deux sommets i---j
	 * en effet si une arrete existe de i vers j alors je peux partir de i vers j et de j vers i
	 * */
	
	public void ajouteArete(int sommet_i, int sommet_j)
	{
        if (verifier_sommet(sommet_i )&& verifier_sommet(sommet_j))
        {
      
        this.mesElements.get(sommet_i).add(sommet_j);
        this.mesElements.get(sommet_j).add(sommet_i);
        }
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
	  
	  //degre max d'unn graphe  Iterator <String>  monIteration= maliste.iterator();
	  public int maxDegre( ArrayList<LinkedList<Integer>> mon_graphe)
	  {
		  int i=0; int temp =0, temp1=0,  max =0; 
		  //LinkedList<Integer> a;
		  while (i  < nbre_sommet -1)
		  {
			 // a=mon_graphe.get(i);
			  temp=degre(i);
			  temp1=degre(i+1);
			  if (temp1>temp)
				  max=temp1;
			  else
			  {
				  max=temp;
			  }
			  
			  i++;
		  }
		  return max;
	    }

	  
	  
	  //somme des degres dans un graphe
	  public int SommeDegre()
	  {
	        int somme=0,i=0;
	
	     while (i  < nbre_sommet -1)
		 {
				somme=somme+degre(i);	  
				  i++;
		 }
	        
	        return somme;
	   }
	  
	  //le nombre d'arrete est egale au nombre de la somme des degre divise par 2
	  public int nbAretes()
	  {
		  
		  return SommeDegre()/2;
	       
	  }

	  
	  // parcours en largeur
	  
      void BFS(int s) 
      { 
          /** Principe : je marque tout les sommets non visités par defaut tous mes sommets son a FALSE
           *
           * */ 
    	
          boolean passage[] = new boolean[V]; 
    
          // je creer une file 
          LinkedList<Integer> file = new LinkedList<Integer>(); 
    
          // je marque le Noeud courant en mettantr true
          	
          passage[s]=true; 
          file.add(s); 
    
          while (file.size() != 0) 
          { 
              // tant qu'il ya encore des elements dans la liste defiler 
              s = file.poll(); 
              System.out.print(s+" "); 
    
              // Get all adjacent vertices of the dequeued vertex s 
              // If a adjacent has not been visited, then mark it 
              // visited and enqueue it 
              
              Iterator <Integer> i = adjancence[s].listIterator(); 
              while (i.hasNext()) 
              { 
                  int n = i.next(); 
                  if (!passage[n]) 
                  { 
                      passage[n] = true; 
                      file.add(n); 
                  } 
              } 
          } 
	  
	  
}
}