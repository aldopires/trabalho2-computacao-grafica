/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.ArrayList;
import modelo.objeto3d.Face3d;
import modelo.objeto3d.Ponto3d;

/**
 *
 * @author Marcos
 */
public class ZBuffer {
    
    private ArrayList<DistanciaFace> lista = new ArrayList<DistanciaFace>();
    private Ponto3d observador ;

    /**
     * 
     * @param observador 
     */
    public ZBuffer(Ponto3d observador) {
        this.observador = observador;
    }
    
    /**
     * Armazena em ordem crescente em relação a distancia do observador ao centro da face
     * @param f 
     */
    public void add(Face3d f){
        double distancia = calculaDistancia(f);
        for(int i = 0 ; i <lista.size();i++){
            if(lista.get(i).getDistancia()>distancia){
                lista.add(i, new DistanciaFace(f, distancia));
                return;
            }
        }
        lista.add( new DistanciaFace(f, distancia));
        
    }
    
    private double calculaDistancia(Face3d f){
        double distX = f.getCentro().getX() - observador.getX();
        double distY = f.getCentro().getY() - observador.getY();
        double distZ = f.getCentro().getZ() - observador.getZ();
	return(Math.sqrt(distX*distX + distY*distY + distZ*distZ)) ;
    }
    
    
}
