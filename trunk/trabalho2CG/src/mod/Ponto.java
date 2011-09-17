/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mod;

/**
 *
 * @author TyTu
 */
public class Ponto {

    private double x, y, z;

    public Ponto(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Ponto() {
        this.x = 0;
        this.y = 0;
        this.z = 0;
    }

    @Override
    public String toString() {
        return "( " + x + " , " + y + " , " + z + " )";
    }

    public boolean equals(Ponto obj) {
        if (obj.x == this.x) {
            if (obj.y == this.y) {
                if (obj.z == this.z) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public Ponto clone() {
        Ponto p=new Ponto();
        p.setX(x);
        p.setY(y);
        p.setZ(z);
        return (p);
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
}
