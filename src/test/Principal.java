package test;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFrame;

import Neurone.Neurone;
import Neurone.NeuroneEntree;
import Neurone.Perceptron;
import Neurone.Synapse;

/**
 * 
 * @author thomas
 *
 */
public class Principal {

	public static final double ALPHA=0.1;
	
	public static void main(String [] args){
		long tps_actuel,tps_precedent;
		tps_precedent = System.currentTimeMillis();
		and();
		tps_actuel = System.currentTimeMillis();
		System.out.println("Durée : "+(tps_actuel-tps_precedent)+" ms");
		tps_precedent = System.currentTimeMillis();
		xor();
		tps_actuel = System.currentTimeMillis();
		System.out.println("Durée : "+(tps_actuel-tps_precedent)+" ms");
		image();
	}
	
	public static void image(){
		JFrame frame = new JFrame();
		frame.setTitle("Reconnaissance d'image");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		PanelCompare cmp = new PanelCompare();
		cmp.setPreferredSize(new Dimension(500,500));
		frame.setContentPane(cmp);
		frame.pack();
		frame.setVisible(true);
		
		NeuroneEntree [][] entree = new NeuroneEntree[5][5];
		ArrayList<Synapse> s = new ArrayList<>();
		Perceptron [] sortie = new Perceptron[11];
		
		for(int i=0;i<sortie.length;i++){
			sortie[i] = new Perceptron(Math.random(),0);
		}
		for(int i=0;i<entree.length;i++){
			for(int j=0;j<entree[i].length;j++){
				entree[i][j] = new NeuroneEntree(0);
			}
		}
		for(int i=0;i<entree.length;i++){
			for(int j=0;j<entree[i].length;j++){
				for(int k=0;k<sortie.length;k++){
					s.add(new Synapse(Math.random(),entree[i][j],sortie[k]));
				}
			}
		}
		for(int i=0;i<entree.length;i++){
			for(int j=0;j<entree[i].length;j++){
				entree[i][j].propagerVersAvant();
			}
		}
		
		for(int i=0;i<sortie.length;i++){
			sortie[i].propagerVersAvant();
		}
		
		int [][]e0 = {
				{0,1,1,1,0},
				{1,0,0,0,1},
				{1,0,0,0,1},
				{1,0,0,0,1},
				{0,1,1,1,0},
		};
		
		int [][]e1 = {
				{0,0,1,0,0},
				{0,1,1,0,0},
				{0,0,1,0,0},
				{0,0,1,0,0},
				{0,1,1,1,0},
		};
		
		int [][]e2 = {
				{0,1,1,1,0},
				{1,0,0,1,0},
				{0,0,1,0,0},
				{0,1,0,0,0},
				{1,1,1,1,1},
		};
		
		int[][] e3 = {
				{0,1,1,1,0},
				{1,0,0,0,1},
				{0,0,1,1,1},
				{1,0,0,0,1},
				{0,1,1,1,0},
		};
		
		int[][] e4 = {
				{0,0,0,1,0},
				{0,0,1,0,0},
				{0,1,0,0,1},
				{1,1,1,1,1},
				{0,0,0,0,1},
		};
		
		int[][] e5 = {
				{1,1,1,1,1},
				{1,0,0,0,0},
				{1,1,1,1,0},
				{0,0,0,0,1},
				{1,1,1,1,1},
		};
		
		int[][] e6 = {
				{1,1,1,1,0},
				{1,0,0,0,0},
				{1,1,1,1,0},
				{1,0,0,1,0},
				{1,1,1,1,0},
		};
		
		int[][] e7 = {
				{0,1,1,1,1},
				{0,0,0,0,1},
				{0,0,0,1,0},
				{0,0,1,0,0},
				{0,1,0,0,0},
		};
		
		int[][] e8 = {
				{0,1,1,1,0},
				{1,0,0,0,1},
				{0,1,1,1,0},
				{1,0,0,0,1},
				{0,1,1,1,0},
		};
		
		int[][] e9 = {
				{0,1,1,1,1},
				{1,0,0,0,1},
				{0,1,1,1,1},
				{0,0,0,0,1},
				{0,1,1,1,0},
		};
		int[][][] e = {e0,e1,e2,e3,e4,e5,e6,e7,e8,e9};
		int res[][] = {
				{1,0,0,0,0,0,0,0,0,0,0},
				{0,1,0,0,0,0,0,0,0,0,0},
				{0,0,1,0,0,0,0,0,0,0,0},
				{0,0,0,1,0,0,0,0,0,0,0},
				{0,0,0,0,1,0,0,0,0,0,0},
				{0,0,0,0,0,1,0,0,0,0,0},
				{0,0,0,0,0,0,1,0,0,0,0},
				{0,0,0,0,0,0,0,1,0,0,0},
				{0,0,0,0,0,0,0,0,1,0,0},
				{0,0,0,0,0,0,0,0,0,1,0},
				{0,0,0,0,0,0,0,0,0,0,1}
		};
		
		int essais = 0;
		int rand;
		while(essais<100000){
			rand = (int)(Math.random()*e.length);
			for(int i=0;i<e[rand].length;i++){
				for(int j=0;j<e[rand][i].length;j++){
					entree[i][j].setPoid_entree(e[rand][i][j]);
				}
			}

			for(int i=0;i<entree.length;i++){
				for(int j=0;j<entree[i].length;j++){
					entree[i][j].propagerVersAvant();
				}
			}

			for(int i=0;i<sortie.length;i++){
				sortie[i].propagerVersAvant();
				sortie[i].calculDelta(res[rand][i]-sortie[i].getPoid_sortie());
			}

			for(int i=0;i<sortie.length;i++){
				sortie[i].miseAJour(ALPHA);
			}

			cmp.setEntree(entree);
			cmp.setSortie(sortie);
			frame.repaint();
			essais++;
			if(essais>(100000-10)){
				try{
					Thread.sleep(500);
				}catch(Exception ex){
					ex.printStackTrace();
				}
			}
		}
		System.out.println("Test ... ");
		try{
			Thread.sleep(1000);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
		int[][] ex = {
				{0,0,0,1,0},
				{0,0,1,0,0},
				{0,1,0,0,1},
				{1,1,1,0,1},
				{0,0,0,0,0},
		};
		for(int i=0;i<ex.length;i++){
			for(int j=0;j<ex[i].length;j++){
				entree[i][j].setPoid_entree(ex[i][j]);
			}
		}

		for(int i=0;i<entree.length;i++){
			for(int j=0;j<entree[i].length;j++){
				entree[i][j].propagerVersAvant();
			}
		}

		for(int i=0;i<sortie.length;i++){
			sortie[i].propagerVersAvant();
		}
		cmp.setEntree(entree);
		cmp.setSortie(sortie);
		frame.repaint();
		for(Neurone n : sortie)
			System.out.println(Math.round(n.getPoid_sortie()));
	}
	
	public static void and(){
		System.out.println("Apprentissage du and");
		int essais = 0;
		double [] [] echantillon = {
				{0,0,0},
				{0,1,0},
				{1,0,0},
				{1,1,1}
		};
		Neurone x1 = new NeuroneEntree(0);
		Neurone x2 = new NeuroneEntree(0);
		Neurone coucheE[] = new Neurone[]{x1,x2};
		Perceptron sortie = new Perceptron(0.3,0);
		Synapse s[] = {
				new Synapse(0.5,x1,sortie),
				new Synapse(-0.2,x2,sortie)
		};
		int rand;
		while(essais < 1000){
			rand = (int)(Math.random()*echantillon.length);
			x1.setPoid_entree(echantillon[rand][0]);
			x2.setPoid_entree(echantillon[rand][1]);
			for(Neurone n : coucheE)
				n.propagerVersAvant();
			sortie.propagerVersAvant();
			//System.out.println(x1);
			//System.out.println(x2);
			//System.out.println(sortie);
			double erreur = echantillon[rand][2]-sortie.getPoid_sortie();
			//System.out.println("Erreur : "+String.format("%1.4f",erreur));
			sortie.calculDelta(erreur);
			sortie.miseAJour(ALPHA);
			essais++;
		}
		
		for(double[] donnee : echantillon){
			x1.setPoid_entree(donnee[0]);
			x2.setPoid_entree(donnee[1]);
			for(Neurone e : coucheE)
				e.propagerVersAvant();
			sortie.propagerVersAvant();
			System.out.println("Sortie : "+Math.round(sortie.getPoid_sortie())+" , désirée : "+(int)donnee[2]);
		}
		
	}
	public static void xor(){
		System.out.println("Apprentissage du xor");
		int essais = 0;
		double [] [] echantillon = {
				{0,0,0},
				{0,1,1},
				{1,0,1},
				{1,1,0}
		};
		
		Neurone x1 = new NeuroneEntree(0);
		Neurone x2 = new NeuroneEntree(0);
		
		Neurone coucheE[] = new Neurone[]{x1,x2};		
		
		Perceptron z1 = new Perceptron(0.4,0);
		Perceptron z2 = new Perceptron(0.6,0);
		
		Neurone coucheC[] = new Neurone[]{z1,z2};
		
		Perceptron y = new Perceptron(-0.3,0);
		
		Synapse s[] =
		{
				new Synapse(0.7,x1,z1),
				new Synapse(-0.4,x1,z2),
				new Synapse(-0.2,x2,z1),
				new Synapse(0.3,x2,z2),
				new Synapse(0.5,z1,y),
				new Synapse(0.1,z2,y)
		};
		
		int rand;
		while(essais < 100000){
			rand = (int)(Math.random()*echantillon.length);
			x1.setPoid_entree(echantillon[rand][0]);
			x2.setPoid_entree(echantillon[rand][1]);
			for(Neurone e : coucheE)
				e.propagerVersAvant();
			for(Neurone c : coucheC)
				c.propagerVersAvant();
			y.propagerVersAvant();
			/*System.out.println("X1 ["+x1+"]");
			System.out.println("X2 ["+x2+"]");
			System.out.println("Z1 ["+z1+"]");
			System.out.println("Z2 ["+z2+"]");
			System.out.println("Y ["+y+"]");*/

			double erreur = echantillon[rand][2]-y.getPoid_sortie();
			//System.out.println("Erreur : "+String.format("%1.4f",erreur));
			y.calculDelta(erreur);

			//System.out.println("DeltaK : "+String.format("%1.4f",y.getDelta()));

			z1.calculDelta();
			z2.calculDelta();
			/*System.out.println("DeltaJ1 : "+String.format("%1.4f",z1.getDelta()));
			System.out.println("DeltaJ2 : "+String.format("%1.4f",z2.getDelta()));*/

			y.miseAJour(ALPHA);
			z1.miseAJour(ALPHA);
			z2.miseAJour(ALPHA);

			/*System.out.println(y);
			System.out.println(z1);
			System.out.println(z2);*/
			essais++;
		}
		
		for(double[] donnee : echantillon){
			x1.setPoid_entree(donnee[0]);
			x2.setPoid_entree(donnee[1]);
			for(Neurone e : coucheE)
				e.propagerVersAvant();
			for(Neurone c : coucheC)
				c.propagerVersAvant();
			y.propagerVersAvant();
			System.out.println("Sortie : "+Math.round(y.getPoid_sortie())+" , désirée : "+(int)donnee[2]);
		}
	}
}
