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

    public Objeto() {
        faces =  new ArrayList<Face>();
    }
    
    public boolean addFace(Face f){
        try{
            faces.add(f);
            return true;
        }catch(Exception e){
            return false;
        }
    }
    public int getSize(){
        return this.faces.size();
    }
    
    public List<Face> getFaces(){
        return this.faces;
    }
    
    
}
