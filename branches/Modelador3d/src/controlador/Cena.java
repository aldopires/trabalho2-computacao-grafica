/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;


import java.awt.Color;
import java.io.Serializable;
import java.util.HashSet;
import modelo.objeto3d.Objeto3d;
import modelo.objeto3d.Ponto3d;

/**
 *
 * @author TyTu
 */
public class Cena implements Serializable {
    private HashSet<Objeto3d> cena= new HashSet<Objeto3d> ();
    private Color cor=  Color.white;
    private Luz luz=new Luz(new Ponto3d(300, 300, 300), Color.white);

    public Luz getLuz() {
        return luz;
    }

    public void setLuz(Luz luz) {
        this.luz = luz;
    }
    
    public HashSet<Objeto3d> getCena(){
        return cena;        
    }

    public Color getCor() {
        return cor;
    }

    public void setCor(Color cor) {
        this.cor = cor;
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
