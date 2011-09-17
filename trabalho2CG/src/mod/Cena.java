/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mod;

import modelo.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author TyTu
 */
public class Cena {
    private List<Objeto> objetos;
    
    public Cena() {
        objetos = new ArrayList<Objeto>();
    }
    
    public void addObj (Objeto obj){
        this.objetos.add(obj);
    }
    
    public List<Objeto> getListObj(){
        return this.objetos;
    }
    
    public boolean containsObj(Objeto obj){
        return this.objetos.contains(obj);
    }
    
    public int getIndexObj(Objeto obj){
        for(int i = 0 ; i<this.objetos.size() ; i++){
            if (this.objetos.get(i).equals(obj))
                return i;
        }
        return -1;
    }
    
    public int getSize(){
        return this.objetos.size();
    }

    public mod.Objeto getObj(int i) {
        return objetos.get(i);
    }

    public void limpa() {
        objetos.clear();
    }

    
    
}
