/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;
import modelo.Vertice;

/**
 *
 * @author Andre
 */
public class PainelTeste extends JPanel {
    ArrayList<Vertice> lista;
    
    public PainelTeste(ArrayList<Vertice> l){
        lista=l;  
    }
    
    public void paintComponent( Graphics g ){
        super.paintComponent( g );
        
        for(int i=1;i<lista.size();i++){
            int xi = Math.round(lista.get(i-1).getX());
            int yi = Math.round(lista.get(i-1).getY());
            int xf = Math.round(lista.get(i).getX());
            int yf = Math.round(lista.get(i).getY());
            g.drawLine(xi, yi, xf, yf);
        }
    }
}
