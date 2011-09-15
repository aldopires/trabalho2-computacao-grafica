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
