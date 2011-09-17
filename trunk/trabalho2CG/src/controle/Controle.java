/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import mod.Cena;
import mod.Objeto;


/**
 *
 * @author TyTu
 */
public class Controle {

    public static void addObjeto(Objeto o) {
        cena.addObj(o);
    }
    private static Cena cena;

    public Controle() {
        cena = new Cena();
    }
    
    
    
    
}
