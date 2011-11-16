/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.Serializable;
import modelo.objeto3d.Face3d;

/**
 *
 * @author Marcos
 */
public class DistanciaFace implements Serializable{
    private Face3d face;
    private double distancia;

    public DistanciaFace(Face3d face, double distancia) {
        this.face = face;
        this.distancia = distancia;
    }

    public double getDistancia() {
        return distancia;
    }

    public Face3d getFace() {
        return face;
    }
    
    
    
}
