/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import modelo.Cena;
import modelo.MatrizTransformacaoGeometrica;
import modelo.Objeto;
import modelo.Vertice;


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
            A.rotacaoEixoX(cena.getListObj().get(i), 90);
            
        }
    }
    
    public static void exibirTeste(){
        for(int i=0;i<cena.getListObj().get(0).getFaces().size();i++){
            System.out.println("face: "+i);
            for(int n=0;n<cena.getListObj().get(0).getFaces().get(i).getArestas().size();n++){
                
                System.out.println("Aresta: "+n);
                System.out.println(" Vinicial: "+cena.getListObj().get(0).getFaces().get(i).getArestas().get(n).getV1().toString());
                System.out.println(" Vfinal: "+cena.getListObj().get(0).getFaces().get(i).getArestas().get(n).getV2().toString()+"\n");
            }
        }
        
    }
    
    public static Cena getCena(){
        return cena;
    }
    
}

