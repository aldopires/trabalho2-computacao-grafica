/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;
import mod.Objeto;
import modelo.Vertice;

/**
 *
 * @author Andre
 */
public class PainelTeste extends JPanel {
    Objeto obj;
    
    public PainelTeste(Objeto l){
        obj=l;  
    }
    
    public void paintComponent( Graphics g ){
        super.paintComponent( g );
        
        for(int i=0;i<obj.getFaces().size();i++){
            for(int n=0;n<obj.getFaces().get(i).getArestas().size();n++){
                int xi = Math.round(obj.getFaces().get(i).getArestas().get(n).getV1().getX());
                int yi = Math.round(obj.getFaces().get(i).getArestas().get(n).getV1().getY());
                int xf = Math.round(obj.getFaces().get(i).getArestas().get(n).getV2().getX());
                int yf = Math.round(obj.getFaces().get(i).getArestas().get(n).getV2().getY());
                g.drawLine(xi, yi, xf, yf);
            }
        }
    }
}
