/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mod;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author TyTu
 */
public class Objeto {
    private ArrayList<Ponto> pontos;
    private ArrayList<Aresta> arestas;
    private ArrayList<Face> faces;

    public Objeto(ArrayList<Ponto> pontos, ArrayList<Aresta> arestas, ArrayList<Face> faces) {
        this.pontos = pontos;
        this.arestas = arestas;
        this.faces = faces;
    }

    public Objeto() {
        pontos = new ArrayList<Ponto>();
        arestas = new ArrayList<Aresta>();
        faces = new ArrayList<Face>();
               
    }
    
    
    
    
    
}
