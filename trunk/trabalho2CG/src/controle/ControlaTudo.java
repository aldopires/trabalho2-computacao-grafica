/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import modelo.Cena;
import modelo.MatrizTransformacaoGeometrica;
import modelo.Objeto;
import modelo.Vertice;
import visao.PainelTeste;


/**
 *
 * @author Heitor
 */

public class ControlaTudo {
    
    private static Cena cena= new Cena();
   
    public static void addObj(Objeto obj){
        cena.addObj(obj);
        exibirTeste();
        testarRotacao();
        exibirTeste();
    }
    
    public static void desenhaFace1(){
        for(int i=0;i<cena.getListObj().get(0).getFaces().get(0).getArestas().size();i++){
            
            System.out.println("Aresta: "+i);
            System.out.println(" Vinicial: "+cena.getListObj().get(0).getFaces().get(0).getArestas().get(i).getV1());
            System.out.println(" Vfinal: "+cena.getListObj().get(0).getFaces().get(0).getArestas().get(i).getV2()+"\n");
        }
        
    }
    
    public static void testarRotacao(){
        MatrizTransformacaoGeometrica A = new MatrizTransformacaoGeometrica();
        Vertice aux;
        for(int i=0;i<cena.getListObj().size();i++){
            A.rotacaoEixoZ(cena.getListObj().get(i), 45);
            
        }
    }
    
    public static void exibirTeste(){
        ArrayList<Vertice> lista = new ArrayList<Vertice>();
        
        for(int i=0;i<cena.getListObj().get(0).getFaces().size();i++){
            System.out.println("face: "+i);
            for(int n=0;n<cena.getListObj().get(0).getFaces().get(i).getArestas().size();n++){
                
                System.out.println("Aresta: "+n);
                System.out.println(" Vinicial: "+cena.getListObj().get(0).getFaces().get(i).getArestas().get(n).getV1().toString());
                System.out.println(" Vfinal: "+cena.getListObj().get(0).getFaces().get(i).getArestas().get(n).getV2().toString()+"\n");
                lista.add(cena.getListObj().get(0).getFaces().get(i).getArestas().get(n).getV1());
                lista.add(cena.getListObj().get(0).getFaces().get(i).getArestas().get(n).getV2());
            }
        }
        PainelTeste Painel = new PainelTeste(lista);
        Painel.setSize(400, 300);
        JFrame janela = new JFrame();
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setLocation(300, 0);
        janela.add(Painel);
        janela.setSize(450, 350);
        janela.setVisible(true);
        
    }
    
    public static Cena getCena(){
        return cena;
    }
    
}

