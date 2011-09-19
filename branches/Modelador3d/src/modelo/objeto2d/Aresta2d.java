/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.objeto2d;

/**
 *
 * @author TyTu
 */
public class Aresta2d {
    private Ponto2d p1;
    private Ponto2d p2;

    public Aresta2d(Ponto2d p1, Ponto2d p2) {
        this.p1 = p1;
        this.p2 = p2;
    }    
    

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Aresta2d other = (Aresta2d) obj;
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

    public Ponto2d getP1() {
        return p1;
    }

    public Ponto2d getP2() {
        return p2;
    }
    
    
    
    
    
}
