package Neurone;

/**
 * 
 * @author thomas
 *
 */
public class Perceptron extends Neurone {


	private double delta;
	private double seuil;
	
	/**
	 * Créer un perceptron , avec pour fonction f(x)=1/(1+e^-x)
	 * @param seuil
	 * @param poid_entree
	 */
	public Perceptron(double seuil,double poid_entree) {
		super(poid_entree);
		this.seuil = seuil;
	}

	@Override
	public void propagerVersAvant(){
		this.poid_entree = 0;
		for(Synapse s : entree)
			this.poid_entree += s.getEntree().poid_sortie*s.getCoeff();
		this.poid_entree+= seuil;
		this.poid_sortie = fonction(this.poid_entree);
	}
	
	@Override
	public double fonction(double x) {
		return 1/(1+Math.exp(-x));
	}

	@Override
	public double derive(double x) {
		return Math.exp(x)/Math.pow(1+Math.exp(x),2);
	}

	public double getSeuil() {
		return seuil;
	}

	public void setSeuil(double seuil) {
		this.seuil = seuil;
	}

	public double getDelta() {
		return delta;
	}

	public void setDelta(double delta) {
		this.delta = delta;
	}
	
	/**
	 * Calcul du delta pour la rétropropagation du gradient
	 */
	public void calculDelta(){
		this.delta = 0;
		for(Synapse s : sortie)
			this.delta+=s.getCoeff()*((Perceptron)s.getSortie()).getDelta();
		this.delta*=derive(poid_entree);
	}
	
	/**
	 * Met a jour les poids des synapses en ammont du perceptron
	 * @param alpha
	 *  Coefficient d'apprentissage
	 */
	public void miseAJour(double alpha){
		this.seuil+=alpha*delta;
		for(Synapse s : entree){
			//System.out.println("Mise a jour w : "+String.format("%1.4f",s.getCoeff()));
			//System.out.println(String.format("%1.4f+%1.4f*%1.4f*%1.4f",s.getCoeff(),alpha,((Perceptron)s.getEntree()).getPoid_sortie(),delta));
			s.setCoeff(s.getCoeff()+alpha*s.getEntree().getPoid_sortie()*delta);
			//System.out.println("new w : "+String.format("%1.4f",s.getCoeff()));
		}
	}
	
	/**
	 * Calcul du delta pour la retropropagation du gradient,
	 * pour un perceptron sur la couche de sortie
	 * @param erreur
	 *  valeur attendu - valeur obtenu
	 */
	public void calculDelta(double erreur){
		this.delta = derive(poid_entree)*erreur;
	}
	
	@Override
	public String type(){ return "Perceptron"; }
	
	@Override 
	public String toString(){
		return super.toString()+" seuil : "+String.format("%1.4f",this.seuil);
	}
}
