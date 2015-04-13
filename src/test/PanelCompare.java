package test;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;

import Neurone.Neurone;


/**
 * 
 * @author thomas
 *
 */
public class PanelCompare extends JPanel{
	
	private Neurone [][] entree;
	private Neurone []sortie;
	
	private JLabel s;
	
	public PanelCompare(){
		s = new JLabel("Sortie : ");
		add(s);
	}
	
	@Override
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		if(entree!=null){
			g.setColor(Color.WHITE);
			g.fillRect(0,0,entree[0].length*25,entree.length*25);
			g.setColor(Color.BLACK);
			for(int i=0;i<entree.length;i++){
				for(int j=0;j<entree[i].length;j++){
					if(Math.round(entree[i][j].getPoid_entree())==1)
						g.fillRect(j*25,i*25,25,25);
				}
			}
		}
	}

	public void setEntree(Neurone[][] entree) {
		this.entree = entree;
	}

	public void setSortie(Neurone[]sortie) {
		this.sortie = sortie;
		for(int i=0;i<sortie.length;i++){
			if(Math.round(sortie[i].getPoid_sortie())==1)
				s.setText("C'est un "+i);
		}
	}
}
