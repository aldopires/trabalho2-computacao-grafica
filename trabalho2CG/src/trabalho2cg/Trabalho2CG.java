/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho2cg;


import controle.Controle;
import java.util.ArrayList;
import javax.swing.JFrame;
import mod.AlvyRay;
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
    private static PainelTeste Painel2;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        
        new Controle();
        
        
        
        
        
        
        //Coordenada tica = new Coordenada(2, 3, 4);
        //System.out.println(tica.toString());


        //TelaInicial vai = new TelaInicial();
        //vai.setVisible(true);
        /*
        Objeto o = new Objeto();
        Objeto ob = new Objeto();
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
        System.out.println(o.exibirAresta());
        o.calculaCentro();
        
        Painel = new PainelTeste(o);
        Painel.setSize(400, 300);
        JFrame janela = new JFrame();
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setLocation(0, 0);
        janela.add(Painel);
        janela.setSize(500, 340);
        janela.setVisible(true);
        
        Thread.sleep(500);
        o.revolucao(36);
        
        o.calculaCentro();
        

        Ponto VRP = new  Ponto(100, 0, 0);
        Ponto P = new Ponto(0, 0, 0);
        Ponto viewUP = new Ponto(0, 1, 0);
        float minX=0; 
        float minY=0;
        float maxX=400;
        float maxY=300;
        float cu=0;
        float cv=0;
        float su = 200;
        float sv = 150;
        float near = -1000;
        float far= 1000;
        float distancia=100;
        AlvyRay aRay=new AlvyRay(VRP, P, viewUP, minX, minY, maxX,maxY,cu,cv,su,sv,near,far,distancia);
        
        aRay.geraMtp();
        aRay.geraMtp();
        ob=o.clone();
        ob.calculaCentro();
        ob.rotacionarEixoX(90);
        //ob.rotacionarEixoZ(90);
        
        //ob.translacao(new Ponto(100,30,30));
        Thread.sleep(500);
        System.out.println(ob.exibirAresta());
        System.out.println(ob.pontos());
        Painel2 = new PainelTeste(ob);
        Painel2.setSize(400, 300);
        JFrame janela2 = new JFrame();
        janela2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela2.setLocation(500, 0);
        janela2.add(Painel2);
        janela2.setSize(500, 340);
        janela2.setVisible(true);
         * 
         */
    }
}
