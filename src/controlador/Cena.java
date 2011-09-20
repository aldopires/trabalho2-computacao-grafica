/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;


import java.util.HashSet;
import modelo.objeto3d.Objeto3d;

/**
 *
 * @author TyTu
 */
public class Cena {
    private HashSet<Objeto3d> cena= new HashSet<Objeto3d> ();
    
    public HashSet<Objeto3d> getCena(){
        return cena;        
    }
    
    public boolean addObjeto(Objeto3d o){
        return cena.add(o);
    }
    
    public boolean removeObjeto(Objeto3d o){
        return cena.remove(o);
    }
    
    @Override
    public HashSet<Objeto3d> clone(){
        HashSet<Objeto3d> copy= new HashSet<Objeto3d>();
        for(Objeto3d o:cena){
            copy.add(o.clone());
        }
        return copy;
    }
}