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
    
    public boolean pertenceAresta(Ponto p){
        if(pertenceReta(p)){
            if(p.getX()<v1.getX()){
                if(p.getX()>v2.getX()){
                    return true;
                }else{
                    return false;
                }
            }else{
                if(p.getX()<v2.getX()){
                    return true;
                }else{
                    return false;
                }
            }
        }else{
            return false;
        }
    }
    
    private boolean pertenceReta(Ponto p){
        if(p.equals(v1)||p.equals(v2)){
            return true;
        }
        else{
            double e=this.determinante(p);
            if(e<(double)0.1 && e>(double)-0.1){
                return true;
            }else{
                return false;
            }
        }
    }
    
    private double determinante(Ponto p){
        return (v1.getX()*v2.getY()*p.getZ())+(v1.getY()*v2.getZ()*p.getX())+(v1.getZ()*v2.getX()*p.getZ())
                -(p.getZ()*v2.getX()*v1.getY())-(p.getX()*v2.getY()*v1.getZ())-(p.getY()*v2.getZ()*v1.getX());
    }

    public Aresta() {
        v1 = new Ponto();
        v2 = new Ponto();
    }

    @Override
    public Aresta clone() {
        return (new Aresta(v1.clone(), v2.clone()));
    }

    public boolean equals(Aresta obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        if (obj.v1.equals(this.v1)) {
            if (obj.v2.equals(this.v2)) {
                return true;
            }
        }

        if (obj.v1.equals(this.v2)) {
            if (obj.v2.equals(this.v1)) {
                return true;
            }
        }
        return false;

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

    void setZ(double z) {
        v1.setZ(z);
        v2.setZ(z);
    }

    @Override
    public String toString() {
        return "Aresta{" + "v1=" + v1 + ", v2=" + v2 + '}';
    }
}
