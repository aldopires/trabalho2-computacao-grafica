/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mod;

import java.awt.Color;
import modelo.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author TyTu
 */
public class Cena {
    private List<Objeto> objetos;
    private Color fundo= Color.WHITE;
    
    public Cena() {
        objetos = new ArrayList<Objeto>();
        fundo= Color.WHITE;
    }

    public Color getFundo() {
        return fundo;
    }

    public void setFundo(Color fundo) {
        this.fundo = fundo;
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

    public double minZ() {
        double res= Double.MAX_VALUE;
        for(int i = 0 ; i<this.objetos.size() ; i++){
            if(res>objetos.get(i).minZ()){
                res=objetos.get(i).minZ();
            }
        }
        return res;
    }
    
    public double maxZ() {
        double res= Double.MIN_VALUE;
        for(int i = 0 ; i<this.objetos.size() ; i++){
            if(res<objetos.get(i).maxZ()){
                res=objetos.get(i).maxZ();
            }
        }
        return res;
    }

    
    
}
