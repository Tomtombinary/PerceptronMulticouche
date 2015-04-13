package Neurone;

/**
 * 
 * @author thomas
 *
 */
public class NeuroneEntree extends Neurone{

	/**
	 * Créer un neurone d'entrée , avec pour fonction f(x)=x
	 * @param poid_entree
	 *  poid du neurone en entrée 
	 */
	public NeuroneEntree(double poid_entree) {
		super(poid_entree);
	}

	@Override
	public double fonction(double x) {
		return x;
	}

	@Override
	public double derive(double x) {
		return 1;
	}

	@Override
	public String type(){ return "NeuroneEntree"; }
	
}
