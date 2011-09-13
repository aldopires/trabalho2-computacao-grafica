/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import modelo.Cena;
import modelo.Objeto;


/**
 *
 * @author Heitor
 */

public class ControlaTudo {
    
    private static Cena cena= new Cena();
   
    public static void addObj(Objeto obj){
        cena.addObj(obj);
    }
    
    public static Cena getCena(){
        return cena;
    }
    
}

