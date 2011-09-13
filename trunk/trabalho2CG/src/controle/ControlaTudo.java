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
    private static Cena cena;
    public void addObj(Objeto obj){
        cena.addObj(obj);
    }

}

