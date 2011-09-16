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

    private float x, y, z;

    public Ponto(float x, float y, float z) {
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
        return (new Ponto(x, y, z));
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }
}
