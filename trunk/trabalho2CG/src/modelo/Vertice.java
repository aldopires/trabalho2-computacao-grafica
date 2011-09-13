/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Heitor
 */
public class Vertice {
    private float x, y, z;

    public Vertice(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vertice() {
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

    @Override
    public String toString() {
        return "Vertice{" + "x=" + x + ", y=" + y + ", z=" + z + '}';
    }
    
    
}
