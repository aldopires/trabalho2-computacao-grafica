/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.awt.Point;
import java.util.LinkedList;
import java.util.List;
import modelo.Circulo;
import modelo.Coordenada;
import modelo.Objeto;

/**
 *
 * @author Heitor
 */
public class ControlaTudo {

    public void chamaDesenha(List<Point> listaDePontos, int grid, boolean xEnabled) {
        boolean eixoX = false;
        Objeto  objeto = new Objeto();
        Coordenada coordenada = new Coordenada();
        Circulo circulo = new Circulo();
        
        //calculamos o incremento
        float angulo = 360 / grid, dist;

        for (int i = 0; i < listaDePontos.size(); i++) {
            objeto.lista.add(circulo);
            if (eixoX) {
                for (int j = 0;j<grid;j++){
                    coordenada.setX(listaDePontos.get(i).getX());
                    coordenada.setY((listaDePontos.get(i).getY()*Math.cos(Math.toRadians(angulo)))-());
                    
                    
                    
                    
                    objeto.lista.get(i).addNaLista(coordenada);
                    
                    
                    
                    
                    
                    
                    
                    
                }
            }

        }




        // TODO add your handling code here:
    }
}
