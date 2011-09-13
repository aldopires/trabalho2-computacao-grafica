/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author TyTu
 */
class Face {
    
    private List<Aresta> arestas= new ArrayList<Aresta>();
    
    public boolean addAresta(Aresta f){
        try{
            arestas.add(f);
            return true;
        }catch(Exception e){
            return false;
        }
    }
    
}
