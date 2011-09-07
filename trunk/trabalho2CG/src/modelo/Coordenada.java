/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Heitor
 */
public class Coordenada {
    private float x, y, z;

    public Coordenada(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Coordenada() {
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
        return "Coordenada{" + "x=" + x + ", y=" + y + ", z=" + z + '}';
    }
    
    
}
