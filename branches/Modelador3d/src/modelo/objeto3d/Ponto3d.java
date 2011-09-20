/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.objeto3d;

/**
 *
 * @author TyTu
 */
public class Ponto3d {
    private double x;
    private double y;
    private double z;

    public Ponto3d(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    Ponto3d() {
        this.x = 0;
        this.y = 0;
        this.z = 0;
    }
    
 
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Ponto3d other = (Ponto3d) obj;
        if (Double.doubleToLongBits(this.x) != Double.doubleToLongBits(other.x)) {
            return false;
        }
        if (Double.doubleToLongBits(this.y) != Double.doubleToLongBits(other.y)) {
            return false;
        }
        if (Double.doubleToLongBits(this.z) != Double.doubleToLongBits(other.z)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + (int) (Double.doubleToLongBits(this.x) ^ (Double.doubleToLongBits(this.x) >>> 32));
        hash = 23 * hash + (int) (Double.doubleToLongBits(this.y) ^ (Double.doubleToLongBits(this.y) >>> 32));
        hash = 23 * hash + (int) (Double.doubleToLongBits(this.z) ^ (Double.doubleToLongBits(this.z) >>> 32));
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

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    @Override
    public String toString() {
        return "Ponto{" + "x=" + x + ", y=" + y + ", z=" + z + '}';
    }

    @Override
    public Object clone()  {
        return new Ponto3d(getX(),getY(),getZ());
    }

    void escala(double x, double y, double z) {
        this.x*=x;
        this.y*=y;
        this.z*=z;
    }

    void translacao(double x, double y, double z) {
        this.x+=x;
        this.y+=y;
        this.z+=z;
    }

    public Ponto3d rotacaoEixoYsemTranslacao(double angulo) {
        Ponto3d aux = new Ponto3d();
        aux.setX((double) ((this.getX() * Math.cos(Math.toRadians(angulo))) + (this.getZ() * Math.sin(Math.toRadians(angulo)))));
        aux.setY(this.getY());
        aux.setZ((double) ((this.getX() * -Math.sin(Math.toRadians(angulo))) + (this.getZ() * Math.cos(Math.toRadians(angulo)))));

        return aux;
    }
    
    
    
}
