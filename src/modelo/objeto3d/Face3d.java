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
    private Ponto3d centro;
    


    public Face3d(Ponto3d p1, Ponto3d p2, Ponto3d p3) {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        calculaEquacao();
    }
    private void calculaEquacao() {
        a = ((p3.getY() - p2.getY()) * (p1.getZ() - p2.getZ())) - ((p1.getY() - p2.getY()) * (p3.getZ() - p2.getZ()));
        b = ((p3.getZ() - p2.getZ()) * (p1.getX() - p2.getX())) - ((p1.getZ() - p2.getZ()) * (p3.getX() - p2.getX()));
        c = ((p3.getX() - p2.getX()) * (p1.getY() - p2.getY())) - ((p1.getX() - p2.getX()) * (p3.getY() - p2.getY()));
        d = -(a * p2.getX()) - (b * p2.getY()) - (c * p2.getZ());

    }
    
    private void calculaCentro(){
        centro = new Ponto3d((encontraMaior(p1.getX(), p2.getX(), p3.getX()) + encontraMenor(p1.getX(), p2.getX(), p3.getX()))/2,
                (encontraMaior(p1.getY(), p2.getY(), p3.getY()) + encontraMenor(p1.getY(), p2.getY(), p3.getY()))/2,
                (encontraMaior(p1.getZ(), p2.getZ(), p3.getZ()) + encontraMenor(p1.getZ(), p2.getZ(), p3.getZ()))/2 );
    }
    
    private double encontraMaior(double a, double b, double c){
        if(a>b){
            if(a>c){
                return a;
            }else{
                return c;
            }
        }else{
            if(b>c){
                return b;
            }else{
                return c;
            }
        }
    }
    
        private double encontraMenor(double a, double b, double c){
        if(a<b){
            if(a<c){
                return a;
            }else{
                return c;
            }
        }else{
            if(b<c){
                return b;
            }else{
                return c;
            }
        }
    }
    

    public double normal(Ponto3d p) {
        calculaEquacao();
        return (p.getX() * a) + (p.getY() * b) + (p.getZ() * c) + d;
    }

    public boolean addPonto(Ponto3d p) {
        if (p1 == null) {
            p1 = p;
            return true;
        } else {
            if (p2 == null && !p1.equals(p)) {
                p2 = p;
                return true;
            } else {
                if (p3 == null && !p1.equals(p) && !p2.equals(p)) {
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

    public Ponto3d getCentro() {
        calculaCentro();
        return centro;
    }
    
    void setP1(Ponto3d p) {
        p1 = p;
    }

    void setP2(Ponto3d p) {
        p2 = p;
    }

    void setP3(Ponto3d p) {
        p3 = p;
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
        if (this.p1 == other.p1 || (this.p1.equals(other.p1))) {
            if (this.p2 == other.p2 || (this.p2.equals(other.p2))) {
                if (this.p3 == other.p3 || (this.p3.equals(other.p3))) {
                    return true;
                }
            }
            if (this.p2 == other.p3 || (this.p2.equals(other.p3))) {
                if (this.p3 == other.p2 || (this.p3.equals(other.p2))) {
                    return true;
                }
            }

        }

        if (this.p1 == other.p2 || (this.p1.equals(other.p2))) {
            if (this.p2 == other.p3 || (this.p2.equals(other.p3))) {
                if (this.p3 == other.p1 || (this.p3.equals(other.p1))) {
                    return true;
                }
            }
            if (this.p2 == other.p1 || (this.p2.equals(other.p1))) {
                if (this.p3 == other.p3 || (this.p3.equals(other.p3))) {
                    return true;
                }
            }

        }

        if (this.p1 == other.p3 || (this.p1.equals(other.p3))) {
            if (this.p2 == other.p1 || (this.p2.equals(other.p1))) {
                if (this.p3 == other.p2 || (this.p3.equals(other.p2))) {
                    return true;
                }
            }
            if (this.p2 == other.p2 || (this.p2.equals(other.p2))) {
                if (this.p3 == other.p1 || (this.p3.equals(other.p1))) {
                    return true;
                }
            }

        }

        return false;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + (this.p1 != null ? this.p1.hashCode() : 0);
        hash = 59 * hash + (this.p2 != null ? this.p2.hashCode() : 0);
        hash = 59 * hash + (this.p3 != null ? this.p3.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return "Face{" + "p1=" + p1 + ", p2=" + p2 + ", p3=" + p3 + '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return new Face3d((Ponto3d) p1.clone(), (Ponto3d) p2.clone(), (Ponto3d) p3.clone());
    }

}
