/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mod;

import java.util.ArrayList;
import java.util.Collection;
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
    
    public void revolucao(float z){
        Objeto aux= new Objeto();
        aux.setPontos( this.getPontos() );
        aux.setArestas( this.getArestas() );
        aux.setFaces ( this.getFaces() );
        int tam = aux.sizeponto();
        for (int i = 0; i<tam;i++){
            
        }
        
    }

    public ArrayList<Aresta> getArestas() {
        return arestas;
    }

    public void setArestas(ArrayList<Aresta> arestas) {
        this.arestas = arestas;
    }

    public ArrayList<Face> getFaces() {
        return faces;
    }

    public void setFaces(ArrayList<Face> faces) {
        this.faces = faces;
    }

    public ArrayList<Ponto> getPontos() {
        return pontos;
    }

    public void setPontos(ArrayList<Ponto> pontos) {
        this.pontos = pontos;
    }


    public int sizearestas() {
        return arestas.size();
    }

    public Aresta setaresta(int index, Aresta element) {
        return arestas.set(index, element);
    }

    public boolean removearesta(Object o) {
        return arestas.remove(o);
    }

    public Aresta removearesta(int index) {
        return arestas.remove(index);
    }

    public int lastIndexOfaresta(Object o) {
        return arestas.lastIndexOf(o);
    }

    public boolean isEmptyaresta() {
        return arestas.isEmpty();
    }

    public int indexOfaresta(Object o) {
        return arestas.indexOf(o);
    }

    public Aresta getaresta(int index) {
        return arestas.get(index);
    }

    public boolean containsaresta(Object o) {
        return arestas.contains(o);
    }

    public Object clonearesta() {
        return arestas.clone();
    }

    public void cleararesta() {
        arestas.clear();
    }


    public void addaresta(int index, Aresta element) {
        arestas.add(index, element);
    }

    public boolean addaresta(Aresta e) {
        return arestas.add(e);
    }

    public int sizeface() {
        return faces.size();
    }

    public Face setface(int index, Face element) {
        return faces.set(index, element);
    }

    public boolean removeface(Object o) {
        return faces.remove(o);
    }

    public Face removeface(int index) {
        return faces.remove(index);
    }

    public int lastIndexOfface(Object o) {
        return faces.lastIndexOf(o);
    }

    public boolean isEmptyface() {
        return faces.isEmpty();
    }

    public int indexOfface(Object o) {
        return faces.indexOf(o);
    }

    public Face getface(int index) {
        return faces.get(index);
    }

    public boolean containsface(Object o) {
        return faces.contains(o);
    }

    public Object cloneface() {
        return faces.clone();
    }

    public void clearface() {
        faces.clear();
    }

    public void addface(int index, Face element) {
        faces.add(index, element);
    }

    public boolean addface(Face e) {
        return faces.add(e);
    }

   
    public int sizeponto() {
        return pontos.size();
    }

    public Ponto setponto(int index, Ponto element) {
        return pontos.set(index, element);
    }

    public boolean removeponto(Object o) {
        return pontos.remove(o);
    }

    public Ponto removeponto(int index) {
        return pontos.remove(index);
    }

    public int lastIndexOfponto(Object o) {
        return pontos.lastIndexOf(o);
    }

    public boolean isEmptyponto() {
        return pontos.isEmpty();
    }

    public int indexOfponto(Object o) {
        return pontos.indexOf(o);
    }

    public Ponto getponto(int index) {
        return pontos.get(index);
    }

   

    public boolean containsponto(Object o) {
        return pontos.contains(o);
    }

    public Object cloneponto() {
        return pontos.clone();
    }

    public void clearponto() {
        pontos.clear();
    }

  
    public void addponto(int index, Ponto element) {
        pontos.add(index, element);
    }

    public boolean addponto(Ponto e) {
        return pontos.add(e);
    }

    
    
    
    
    
}
