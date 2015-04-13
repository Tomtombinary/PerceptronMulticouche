package Neurone;
import java.util.ArrayList;

/**
 * 
 * @author thomas
 *
 */
public abstract class Neurone {

	protected double poid_sortie;
	protected double poid_entree;
	protected ArrayList<Synapse> entree;
	protected ArrayList<Synapse> sortie;
	
	/**
	 * Créer un neurone formel
	 * @param poid_entree
	 *  poid à l'entrée du neurone
	 */
	public Neurone(double poid_entree){
		this.entree = new ArrayList<>();
		this.sortie = new ArrayList<>();
		this.poid_entree = poid_entree;
		this.poid_sortie = fonction(poid_entree);
	}
	
	/**
	 * Ajoute une synapse a l'entrée du neurone
	 * @param s
	 *  la synapse
	 */
	public void addEntree(Synapse s){
		this.entree.add(s);
	}
	
	/**
	 * Ajoute une synapse a la sortie du neurone
	 * @param s
	 *  la synapse
	 */
	public void addSortie(Synapse s){
		this.sortie.add(s);
	}
	
	/**
	 * Calcul l'entrée du neurone , et le poid de sortie du neurone 
	 */
	public void propagerVersAvant(){
		if(entree.size()>0){
			this.poid_entree = 0;
			for(Synapse s : entree)
				this.poid_entree += s.getEntree().poid_sortie*s.getCoeff();
		}
		this.poid_sortie = fonction(this.poid_entree);
	}
	
	/**
	 * Fonction d'activation du neurone
	 * @param x
	 *  x
	 * @return
	 *  f(x)
	 */
	public abstract double fonction(double x);
	/**
	 * Dérivé de la fonction d'activation du neurone
	 * @param x
	 *  x
	 * @return
	 *  f'(x)
	 */
	public abstract double derive(double x);
	/**
	 * Retourne le type du neurone (neurone d'entrée , perceptron)
	 * @return
	 *  le type du neurone
	 */
	public abstract String type();

	public double getPoid_sortie() {
		return poid_sortie;
	}

	public void setPoid_sortie(double poid_sortie) {
		this.poid_sortie = poid_sortie;
	}

	public double getPoid_entree() {
		return poid_entree;
	}

	public void setPoid_entree(double poid_entree) {
		this.poid_entree = poid_entree;
	}

	public ArrayList<Synapse> getEntree() {
		return entree;
	}

	public void setEntree(ArrayList<Synapse> entree) {
		this.entree = entree;
	}

	public ArrayList<Synapse> getSortie() {
		return sortie;
	}

	public void setSortie(ArrayList<Synapse> sortie) {
		this.sortie = sortie;
	}
	
	@Override
	public String toString(){
		return type()+" entree : "+String.format("%4.4f",this.poid_entree)+" sortie : "+String.format("%4.4f",this.poid_sortie);
	}
}
