/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Heitor
 */
public class Circulo {
    private List<Coordenada> circulo = new LinkedList<Coordenada>();
    
    public void addNaLista(Coordenada vai){
        circulo.add(vai);
    }
    
}
