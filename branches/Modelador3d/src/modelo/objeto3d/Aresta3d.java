/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.objeto3d;

import java.io.Serializable;


/**
 *
 * @author TyTu
 */
public class Aresta3d implements Serializable{
    private Ponto3d p1;
    private Ponto3d p2;

    public Aresta3d(Ponto3d p1, Ponto3d p2) {
        this.p1 = (Ponto3d) p1.clone();
        this.p2 = (Ponto3d) p2.clone();
    }    
    

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Aresta3d other = (Aresta3d) obj;
        if (this.p1.equals(other.p1)&&this.p2.equals(other.p2)){
            return true;
        }
        if (this.p2.equals(other.p1)&&this.p1.equals(other.p2)){
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + (this.p1 != null ? this.p1.hashCode() : 0);
        hash = 47 * hash + (this.p2 != null ? this.p2.hashCode() : 0);
        return hash;
    }

    public Ponto3d getP1() {
        return p1;
    }

    public Ponto3d getP2() {
        return p2;
    }
    
    
    
    
    
}
