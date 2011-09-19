/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.objeto2d;


/**
 *
 * @author TyTu
 */
public class Ponto2d {
    private double x;
    private double y;

    public Ponto2d(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Ponto2d other = (Ponto2d) obj;
        if (Double.doubleToLongBits(this.x) != Double.doubleToLongBits(other.x)) {
            return false;
        }
        if (Double.doubleToLongBits(this.y) != Double.doubleToLongBits(other.y)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + (int) (Double.doubleToLongBits(this.x) ^ (Double.doubleToLongBits(this.x) >>> 32));
        hash = 23 * hash + (int) (Double.doubleToLongBits(this.y) ^ (Double.doubleToLongBits(this.y) >>> 32));
        return hash;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }



    @Override
    public String toString() {
        return "Ponto{" + "x=" + x + ", y=" + y +  '}';
    }

    @Override
    protected Object clone() {
        return new Ponto2d(getX(),getY());
    }

    void escala(double x, double y) {
        this.x*=x;
        this.y*=y;
    }

    void translacao(double x, double y) {
        this.x+=x;
        this.y+=y;
    }

    double distancia(Ponto2d p) {
        return Math.sqrt(Math.pow(x-p.x,2)+Math.pow(y-p.y,2));
    }
    
    
    
}
