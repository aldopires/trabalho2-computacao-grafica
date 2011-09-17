/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mod;

import java.util.ArrayList;

/**
 *
 * @author TyTu
 */
public class Face {
    private ArrayList<Aresta> arestas;

    public Face() {
        arestas= new ArrayList<Aresta>();
    }
    
    public ArrayList<Aresta> getArestas() {
        return arestas;
    }
    
    @Override
   public Face clone(){
       Face aux = new Face();
       for(int i=0;i<arestas.size();i++){
           aux.add(this.arestas.get(i).clone());
       }
       return aux;
   }      

    public void setArestas(ArrayList<Aresta> arestas) {
        this.arestas = arestas;
    }

    public int size() {
        return arestas.size();
    }

    public Aresta set(int index, Aresta element) {
        return arestas.set(index, element);
    }

    public boolean remove(Object o) {
        return arestas.remove(o);
    }

    public Aresta remove(int index) {
        return arestas.remove(index);
    }

    public boolean isEmpty() {
        return arestas.isEmpty();
    }

    public boolean contains(Object o) {
        return arestas.contains(o);
    }

    public void add(int index, Aresta element) {
        arestas.add(index, element);
    }

    public void add(Aresta e) {
        
            arestas.add(e);
        
       
    }

    
     

    
    
    
}
