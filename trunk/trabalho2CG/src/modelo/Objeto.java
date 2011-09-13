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
public class Objeto {
    private List<Face> faces;
    private Vertice centro;

    public Objeto() {
        faces =  new ArrayList<Face>();
    }

    public List<Face> getFaces() {
        return faces;
    }
    
    public boolean addFace(Face f){
        try{
            faces.add(f);
            atualizaCentro();
            return true;
        }catch(Exception e){
            return false;
        }
    }

    public Vertice getCentro() {
        return centro;
    }
    
    
    
    public void atualizaCentro(){
        float minx=9999,maxx=-9999,miny=9999,maxy=-9999,minz=9999,maxz=-9999;
        for(int i=0;i<faces.size();i++){
            for(int j=0;j<faces.get(i).getArestas().size();j++){
                if(minx>faces.get(i).getArestas().get(j).getV1().getX())                    
                    minx=faces.get(i).getArestas().get(j).getV1().getX();
                if(minx>faces.get(i).getArestas().get(j).getV2().getX())
                    minx=faces.get(i).getArestas().get(j).getV2().getX();
                if(miny>faces.get(i).getArestas().get(j).getV2().getY())
                    miny=faces.get(i).getArestas().get(j).getV1().getY();
                if(miny>faces.get(i).getArestas().get(j).getV2().getY())
                    miny=faces.get(i).getArestas().get(j).getV2().getY();
                if(minz>faces.get(i).getArestas().get(j).getV2().getZ())
                    minz=faces.get(i).getArestas().get(j).getV1().getZ();
                if(minz>faces.get(i).getArestas().get(j).getV2().getZ())
                    minz=faces.get(i).getArestas().get(j).getV2().getZ();
                if(maxx<faces.get(i).getArestas().get(j).getV1().getX())                    
                    maxx=faces.get(i).getArestas().get(j).getV1().getX();
                if(maxx<faces.get(i).getArestas().get(j).getV2().getX())
                    maxx=faces.get(i).getArestas().get(j).getV2().getX();
                if(maxy<faces.get(i).getArestas().get(j).getV2().getY())
                    maxy=faces.get(i).getArestas().get(j).getV1().getY();
                if(maxy<faces.get(i).getArestas().get(j).getV2().getY())
                    maxy=faces.get(i).getArestas().get(j).getV2().getY();
                if(maxz<faces.get(i).getArestas().get(j).getV2().getZ())
                    maxz=faces.get(i).getArestas().get(j).getV1().getZ();
                if(maxz<faces.get(i).getArestas().get(j).getV2().getZ())
                    maxz=faces.get(i).getArestas().get(j).getV2().getZ();
            }
        }
        Vertice v = new Vertice((maxx-minx)/2, (maxy-miny)/2, (maxz-minz)/2);
        centro=v;
    }

    public int getSize(){
        return this.faces.size();
    }

    void setCentro(Vertice vertice) {
        centro=vertice;
    }
    
   

    
    
}
