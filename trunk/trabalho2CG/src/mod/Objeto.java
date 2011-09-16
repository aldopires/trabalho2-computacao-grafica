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
    private Ponto centro;

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

    public Ponto getCentro() {
        return centro;
    }

    public void setCentro(Ponto centro) {
        this.centro = centro;
    }
    
    public void extrusao(float z){
        
        
            this.addface(faces.get(0).clone()); //clona as faces
        
        //for (int i=tam;i<this.faces.size();i++){//varre as faces clonadas
            for(int j=0;j<this.faces.get(0).getArestas().size();j++){//varre as arestas clonadas
                this.faces.get(0).getArestas().get(j).setZ(z); //set o z com o valor passado 
                
                
                
                //criar as novas arestas
                Aresta a1 = new Aresta(this.faces.get(1).getArestas().get(j).getV1(), this.faces.get(0).getArestas().get(j).getV1());
                Aresta a2 = new Aresta(this.faces.get(0).getArestas().get(j).getV2(), this.faces.get(1).getArestas().get(j).getV2() );
               
                
                //criar nova face
                Face f = new Face();
                f.add(a1);
                f.add(a2);
                f.add(this.faces.get(0).getArestas().get(j));
                f.add(this.faces.get(1).getArestas().get(j));
                
                faces.add(f);
            }
            
        //}
        
       
        
    }
    
    public String pontos(){
        String s= new String();
        for(int i=0;i<pontos.size();i++){
            s=s+pontos.get(i).toString()+"\n";
        }
        s=s+"\n\n\n\n";
        return s;
        
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
        for(int i=0;i<e.getArestas().size();i++){
            pontos.add(e.getArestas().get(i).getV1());
            arestas.add(e.getArestas().get(i));
        }
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

    @Override
    public String toString() {
       
        return super.toString();
    }

 

    
    
    public void escala(float escala){
        for(int i=0;i<pontos.size();i++){
            pontos.get(i).setX(pontos.get(i).getX() *escala);
            pontos.get(i).setY(pontos.get(i).getY() *escala);
            pontos.get(i).setZ(pontos.get(i).getZ() *escala);
        }
    }
    
    public void translacao(Ponto translacao){
        
        for(int i=0;i<pontos.size();i++){
            pontos.get(i).setX(pontos.get(i).getX() *translacao.getX());
            pontos.get(i).setY(pontos.get(i).getY() *translacao.getY());
            pontos.get(i).setZ(pontos.get(i).getZ() *translacao.getZ());
        }
    }
    
    public void calculaCentro(){
        float minx=9999,maxx=-9999,miny=9999,maxy=-9999,minz=9999,maxz=-9999;
        for(int i=0;i<faces.size();i++){
            for(int j=0;j<faces.get(i).getArestas().size();j++){
                if(minx>faces.get(i).getArestas().get(j).getV1().getX())                    
                    minx=faces.get(i).getArestas().get(j).getV1().getX();
                if(minx>faces.get(i).getArestas().get(j).getV2().getX())
                    minx=faces.get(i).getArestas().get(j).getV2().getX();
                if(miny>faces.get(i).getArestas().get(j).getV1().getY())
                    miny=faces.get(i).getArestas().get(j).getV1().getY();
                if(miny>faces.get(i).getArestas().get(j).getV2().getY())
                    miny=faces.get(i).getArestas().get(j).getV2().getY();
                if(minz>faces.get(i).getArestas().get(j).getV1().getZ())
                    minz=faces.get(i).getArestas().get(j).getV1().getZ();
                if(minz>faces.get(i).getArestas().get(j).getV2().getZ())
                    minz=faces.get(i).getArestas().get(j).getV2().getZ();
                if(maxx<faces.get(i).getArestas().get(j).getV1().getX())                    
                    maxx=faces.get(i).getArestas().get(j).getV1().getX();
                if(maxx<faces.get(i).getArestas().get(j).getV2().getX())
                    maxx=faces.get(i).getArestas().get(j).getV2().getX();
                if(maxy<faces.get(i).getArestas().get(j).getV1().getY())
                    maxy=faces.get(i).getArestas().get(j).getV1().getY();
                if(maxy<faces.get(i).getArestas().get(j).getV2().getY())
                    maxy=faces.get(i).getArestas().get(j).getV2().getY();
                if(maxz<faces.get(i).getArestas().get(j).getV1().getZ())
                    maxz=faces.get(i).getArestas().get(j).getV1().getZ();
                if(maxz<faces.get(i).getArestas().get(j).getV2().getZ())
                    maxz=faces.get(i).getArestas().get(j).getV2().getZ();
            }
        }
        Ponto v = new Ponto ((maxx+minx)/2, (maxy+miny)/2, (maxz+minz)/2);
        setCentro(v);
    }
    
    public void rotacionarEixoX(double angulo){
        Ponto aux = new Ponto();
        Ponto tranaladarOrigem = new Ponto(getCentro().getX()*-1, getCentro().getY()*-1,  getCentro().getZ()*-1);
        
        translacao(tranaladarOrigem);
        
        for(int i=0;i<pontos.size();i++){
            aux.setX(pontos.get(i).getX());
            aux.setY((float)((pontos.get(i).getY()* Math.cos(Math.toRadians(angulo)))+(pontos.get(i).getZ() * -Math.sin(Math.toRadians(angulo)))));
            aux.setZ((float)((pontos.get(i).getY()* Math.sin(Math.toRadians(angulo)))+(pontos.get(i).getZ() * Math.cos(Math.toRadians(angulo)))));
            
            pontos.get(i).setX(aux.getX());
            pontos.get(i).setY(aux.getY());
            pontos.get(i).setZ(aux.getZ());
        }
        
        tranaladarOrigem.setX(tranaladarOrigem.getX()*-1);
        tranaladarOrigem.setY(tranaladarOrigem.getY()*-1);
        tranaladarOrigem.setZ(tranaladarOrigem.getZ()*-1);
        
        translacao(tranaladarOrigem);
        calculaCentro();
    }
    
    public void rotacionarEixoY(double angulo){
        Ponto aux = new Ponto();
        Ponto tranaladarOrigem = new Ponto(getCentro().getX()*-1, getCentro().getY()*-1,  getCentro().getZ()*-1);
        
        translacao(tranaladarOrigem);
        
        for(int i=0;i<pontos.size();i++){
            aux.setX((float)((pontos.get(i).getX()* Math.cos(Math.toRadians(angulo)))+(pontos.get(i).getZ() * Math.sin(Math.toRadians(angulo)))));
            aux.setY(pontos.get(i).getY());
            aux.setZ((float)((pontos.get(i).getX()* -Math.sin(Math.toRadians(angulo)))+(pontos.get(i).getZ() * Math.cos(Math.toRadians(angulo)))));
            
            pontos.get(i).setX(aux.getX());
            pontos.get(i).setY(aux.getY());
            pontos.get(i).setZ(aux.getZ());
        }
        
        tranaladarOrigem.setX(tranaladarOrigem.getX()*-1);
        tranaladarOrigem.setY(tranaladarOrigem.getY()*-1);
        tranaladarOrigem.setZ(tranaladarOrigem.getZ()*-1);
        
        translacao(tranaladarOrigem);
        calculaCentro();
    }
    
    public void rotacionarEixoZ(double angulo){
        Ponto aux = new Ponto();
        Ponto tranaladarOrigem = new Ponto(getCentro().getX()*-1, getCentro().getY()*-1,  getCentro().getZ()*-1);
        
        translacao(tranaladarOrigem);
        
        for(int i=0;i<pontos.size();i++){
            aux.setX((float)((pontos.get(i).getX()* Math.cos(Math.toRadians(angulo)))+(pontos.get(i).getY() * (-1*Math.sin(Math.toRadians(angulo))))));
            aux.setY((float)((pontos.get(i).getX()* Math.sin(Math.toRadians(angulo)))+(pontos.get(i).getY() * Math.cos(Math.toRadians(angulo)))));
            aux.setZ(pontos.get(i).getZ());
            
            pontos.get(i).setX(aux.getX());
            pontos.get(i).setY(aux.getY());
            pontos.get(i).setZ(aux.getZ());
        }
        
        tranaladarOrigem.setX(tranaladarOrigem.getX()*-1);
        tranaladarOrigem.setY(tranaladarOrigem.getY()*-1);
        tranaladarOrigem.setZ(tranaladarOrigem.getZ()*-1);
        
        translacao(tranaladarOrigem);
        calculaCentro();
    }
}