/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mod;

/**
 *
 * @author TyTu
 */
public class Aresta {
    private Ponto v1;
    private Ponto v2;

    public Aresta(Ponto v1, Ponto v2) {
        this.v1 = v1;
        this.v2 = v2;
    }

    public Aresta() {
        v1 = new Ponto();
        v2 = new Ponto();
    }
    
    @Override
    public Aresta clone(){
        return (new Aresta(v1.clone(), v2.clone()));
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Aresta other = (Aresta) obj;
        if (this.v1 != other.v1 && (this.v1 == null || !this.v1.equals(other.v1))) {
            return false;
        }
        if (this.v2 != other.v2 && (this.v2 == null || !this.v2.equals(other.v2))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + (this.v1 != null ? this.v1.hashCode() : 0);
        hash = 79 * hash + (this.v2 != null ? this.v2.hashCode() : 0);
        return hash;
    }
    
    

    public Ponto getV1() {
        return v1;
    }

    public void setV1(Ponto v1) {
        this.v1 = v1;
    }

    public Ponto getV2() {
        return v2;
    }

    public void setV2(Ponto v2) {
        this.v2 = v2;
    }

    void setZ(float z) {
        v1.setZ(z);
        v2.setZ(z);
    }

    @Override
    public String toString() {
        return "Aresta{" + "v1=" + v1 + ", v2=" + v2 + '}';
    }

    
}
