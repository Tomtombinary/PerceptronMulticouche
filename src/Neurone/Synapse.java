package Neurone;

/**
 * 
 * @author thomas
 *
 */
public class Synapse {

	private double coeff;
	private Neurone entree;
	private Neurone sortie;
	
	/**
	 * Construit une synapse
	 * @param coeff
	 *  poid synaptique 
	 * @param entree
	 *  neurone en ammont de la synapse
	 * @param sortie
	 *  neurone en aval de la synapse
	 */
	public Synapse(double coeff,Neurone entree,Neurone sortie){
		this.coeff = coeff;
		this.entree = entree;
		this.sortie = sortie;
		this.entree.addSortie(this);
		this.sortie.addEntree(this);
	}

	public double getCoeff() {
		return coeff;
	}

	public void setCoeff(double coeff) {
		this.coeff = coeff;
	}

	public Neurone getEntree() {
		return entree;
	}

	public void setEntree(Neurone entree) {
		this.entree = entree;
	}

	public Neurone getSortie() {
		return sortie;
	}

	public void setSortie(Neurone sortie) {
		this.sortie = sortie;
	}
}
