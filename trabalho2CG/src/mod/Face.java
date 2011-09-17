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
    
    
            
    private double a,b,c,d;
    
    private void calculaEquacao(){
        Ponto p1,p2,p3;
        p1=arestas.get(0).getV1();
        p2=arestas.get(0).getV2();
        p3=arestas.get(1).getV1();
        a=( (p3.getY()-p2.getY()) * (p1.getZ()-p2.getZ()) )-( (p1.getY()-p2.getY()) * (p3.getZ()-p2.getZ())) ;
        b=( (p3.getZ()-p2.getZ()) * (p1.getX()-p2.getX()) )-( (p1.getZ()-p2.getZ()) * (p3.getX()-p2.getX())) ;
        c=( (p3.getX()-p2.getX()) * (p1.getY()-p2.getY()) )-( (p1.getX()-p2.getX()) * (p3.getY()-p2.getY())) ;
        d= -(a*p2.getX())-(b*p2.getY())-(c*p2.getZ());        
    }
    
    public boolean pertencePlano(Ponto p){
        double resp;
        resp= a*p.getX() + b*p.getY() + c*p.getZ() + d ;
        if(resp==0)
            return true;
        else
            return false;
    }

    public Face() {
        arestas= new ArrayList<Aresta>();
        a=b=c=d=0;
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
        calculaEquacao();
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
            if(arestas.size()>1){
                calculaEquacao();
            }
        
       
    }

    
     

    
    
    
}
