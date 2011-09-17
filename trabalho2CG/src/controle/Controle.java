/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import mod.Cena;
import mod.Objeto;
import visao.TelaInicial;


/**
 *
 * @author TyTu
 */
public class Controle {

    public static void addObjeto(Objeto o) {
        cena.addObj(o);
    }
    private static Cena cena;
    private static TelaInicial t;

    public static Cena getCena() {
        return cena;
    }

   

    public Controle() {
        cena = new Cena();
        t= new TelaInicial();
        t.setVisible(true);
    }
    
    
    
    
}
