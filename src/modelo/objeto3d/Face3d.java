/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.objeto3d;

/**
 *
 * @author TyTu
 */
public class Face3d {

    private Ponto3d p1;
    private Ponto3d p2;
    private Ponto3d p3;
    
    
    private double a, b, c, d;

    private void calculaEquacao() {
        
            a = ((p3.getY() - p2.getY()) * (p1.getZ() - p2.getZ())) - ((p1.getY() - p2.getY()) * (p3.getZ() - p2.getZ()));
            b = ((p3.getZ() - p2.getZ()) * (p1.getX() - p2.getX())) - ((p1.getZ() - p2.getZ()) * (p3.getX() - p2.getX()));
            c = ((p3.getX() - p2.getX()) * (p1.getY() - p2.getY())) - ((p1.getX() - p2.getX()) * (p3.getY() - p2.getY()));
            d = -(a * p2.getX()) - (b * p2.getY()) - (c * p2.getZ());
        
    }
    
    public double normal(Ponto3d p){
        return (p.getX()*a)+(p.getY()*b)+(p.getZ()*c)+d;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Face3d other = (Face3d) obj;
        if (this.p1 != other.p1 && (this.p1 == null || !this.p1.equals(other.p1))) {
            return false;
        }
        if (this.p2 != other.p2 && (this.p2 == null || !this.p2.equals(other.p2))) {
            return false;
        }
        if (this.p3 != other.p3 && (this.p3 == null || !this.p3.equals(other.p3))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + (this.p1 != null ? this.p1.hashCode() : 0);
        hash = 59 * hash + (this.p2 != null ? this.p2.hashCode() : 0);
        hash = 59 * hash + (this.p3 != null ? this.p3.hashCode() : 0);
        return hash;
    }

    public Face3d(Ponto3d p1, Ponto3d p2, Ponto3d p3) {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        calculaEquacao();
    }

    @Override
    public String toString() {
        return "Face{" + "p1=" + p1 + ", p2=" + p2 + ", p3=" + p3 + '}';
    }

    public boolean addPonto(Ponto3d p) {
        if (p1 == null) {
            p1 = p;
            return true;
        } else {
            if (p2 == null&&!p1.equals(p)) {
                p2 = p;
                return true;
            } else {
                if (p3 == null&&!p1.equals(p)&&!p2.equals(p)) {
                    p3 = p;
                    calculaEquacao();
                    return true;
                } 
            }
        }
        return false;
    }

    public Ponto3d getP1() {
        return p1;
    }  
    
    public Ponto3d getP2() {
        return p2;
    }

    public Ponto3d getP3() {
        return p3;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return new Face3d( (Ponto3d) p1.clone(), (Ponto3d) p2.clone(), (Ponto3d) p3.clone());
    }
    
    
}