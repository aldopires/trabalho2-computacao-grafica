/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho2cg;


import java.util.ArrayList;
import javax.swing.JFrame;
import mod.Objeto;
import mod.Ponto;
import mod.Aresta;
import mod.Face;
import modelo.MatrizTransformacaoGeometrica;
import modelo.Vertice;
import visao.PainelTeste;
import visao.TelaInicial;


/**
 *
 * @author Heitor
 */
public class Trabalho2CG {
    private static PainelTeste Painel;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Coordenada tica = new Coordenada(2, 3, 4);
        //System.out.println(tica.toString());


        //TelaInicial vai = new TelaInicial();
        //vai.setVisible(true);
        
        Objeto o = new Objeto();
        Ponto p1= new Ponto(100, 100, 0);
        Ponto p2= new Ponto(200, 100, 0);
        Ponto p3= new Ponto(200, 200, 0);
        Ponto p4= new Ponto(100, 200, 0);
        Aresta a1 = new Aresta(p1,p2);
        Aresta a2 = new Aresta(p2,p3);
        Aresta a3 = new Aresta(p3,p4);
        Aresta a4 = new Aresta(p4,p1);
        Face f = new Face();
        
        f.add(a4);
        f.add(a3);
        f.add(a2);
        f.add(a1);
        
        o.addface(f);
        System.out.println(o.pontos());
        
        o.extrusao(10);
        System.out.println(o.pontos());

        Painel = new PainelTeste(o);
        Painel.setSize(400, 300);
        JFrame janela = new JFrame();
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setLocation(0, 0);
        janela.add(Painel);
        janela.setSize(500, 340);
        janela.setVisible(true);
    }
}
