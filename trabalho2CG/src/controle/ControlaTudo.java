/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.util.ArrayList;
import mod.Cena;
import mod.Objeto;
import visao.PainelTeste;


/**
 *
 * @author Heitor
 */

public class ControlaTudo {
    
    private static Cena cena= new Cena();
   
    public static void addObj(Objeto obj){
        cena.addObj(obj);
    }
    
    public static void desenhaFace1(){
        for(int i=0;i<cena.getListObj().get(0).getFaces().get(0).getArestas().size();i++){
            
            System.out.println("Aresta: "+i);
            System.out.println(" Vinicial: "+cena.getListObj().get(0).getFaces().get(0).getArestas().get(i).getV1());
            System.out.println(" Vfinal: "+cena.getListObj().get(0).getFaces().get(0).getArestas().get(i).getV2()+"\n");
        }
        
    }
    
    
    public static Cena getCena(){
        return cena;
    }
    
}

