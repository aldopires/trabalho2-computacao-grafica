/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.objeto3d;

import java.awt.Color;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author TyTu
 */
public class Objeto3d {

    private HashSet<Face3d> faces;
    private HashSet<Ponto3d> pontos;
    private Ponto3d centro;
    private String nome;
    private Color cor= Color.BLACK;

    public Color getCor() {
        return cor;
    }

    public void setCor(Color cor) {
        for(Face3d f:faces){
            f.setCor(cor);
        }
        this.cor = cor;
    }    
    
    

    @Override
    public String toString() {
        return "Objeto3d{" + nome+ '}';
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    

    public Ponto3d getCentro() {
        return centro;
    }

    public Objeto3d() {
        faces = new HashSet<Face3d>();
        pontos = new HashSet<Ponto3d>();        
    }

    public boolean addFace(Face3d face) {        
        
        if (faces.add(face)) {
            addPontoFace(face.getP1());
            addPontoFace(face.getP2());
            addPontoFace(face.getP3());
            calculaCentro();
            arrumaReferenciaDosPontos();
            return true;
            
        }
        else{
            return false;
            
        }
        
    }

    private void addPontoFace(Ponto3d pontoNovo) {
        if (!pontos.add(pontoNovo)) {
            //o ponto existia e nada foi feito na lista; 
            //TODO: pegar referencia da lista 
            for (Ponto3d pontoLista : pontos) {
                if (pontoNovo.equals(pontoLista)) {
                    pontoNovo = pontoLista;
                    if(pontoNovo!=pontoLista)
                        System.out.println("Add um ponto numa face q não ta lista de ponto");
                    break;
                }
            }
        }
    }

    public void escala(double x, double y, double z) {
        for (Ponto3d pontoLista : pontos) {
            pontoLista.escala(x, y, z);
        }
        calculaCentro();
    }

    public void translacao(double x, double y, double z) {
        for (Ponto3d pontoLista : pontos) {
            pontoLista.translacao(x, y, z);
        }
    }

    private void calculaCentro() {
        double minx = Double.MAX_VALUE, maxx = Double.MIN_VALUE, miny = Double.MAX_VALUE, maxy = Double.MIN_VALUE, minz = Double.MAX_VALUE, maxz = Double.MIN_VALUE;
        for (Ponto3d p : pontos) {
            if (p.getX() < minx) {
                minx = p.getX();
            }
            if (p.getY() < miny) {
                miny = p.getY();
            }
            if (p.getZ() < minz) {
                minz = p.getZ();
            }
            if (p.getX() > maxx) {
                maxx = p.getX();
            }
            if (p.getY() > maxy) {
                maxy = p.getY();
            }
            if (p.getZ() > maxz) {
                maxz = p.getZ();
            }
        }
        centro = new Ponto3d((maxx + minx)/2, (maxy + miny)/2, (maxz + minz)/2);
    }

    public void rotacaoEixoX(double angulo) {
        Ponto3d aux = new Ponto3d();
        Ponto3d transladarOrigem = new Ponto3d(getCentro().getX() * -1, getCentro().getY() * -1, getCentro().getZ() * -1);

        translacao(transladarOrigem.getX(), transladarOrigem.getY(), transladarOrigem.getZ());

        for (Ponto3d pontoLista : pontos) {
            aux.setX(pontoLista.getX());
            aux.setY((double) ((pontoLista.getY() * Math.cos(Math.toRadians(angulo))) + (pontoLista.getZ() * -Math.sin(Math.toRadians(angulo)))));
            aux.setZ((double) ((pontoLista.getY() * Math.sin(Math.toRadians(angulo))) + (pontoLista.getZ() * Math.cos(Math.toRadians(angulo)))));

            pontoLista.setX(aux.getX());
            pontoLista.setY(aux.getY());
            pontoLista.setZ(aux.getZ());
        }

        transladarOrigem.setX(getCentro().getX());
        transladarOrigem.setY(getCentro().getY());
        transladarOrigem.setZ(getCentro().getZ());

        translacao(transladarOrigem.getX(), transladarOrigem.getY(), transladarOrigem.getZ());
        calculaCentro();
    }

    public void rotacaoEixoY(double angulo) {
        Ponto3d aux = new Ponto3d();
        Ponto3d transladarOrigem = new Ponto3d(getCentro().getX() * -1, getCentro().getY() * -1, getCentro().getZ() * -1);

        translacao(transladarOrigem.getX(), transladarOrigem.getY(), transladarOrigem.getZ());

        for (Ponto3d pontoLista : pontos) {
            aux.setX((double) ((pontoLista.getX() * Math.cos(Math.toRadians(angulo))) + (pontoLista.getZ() * -Math.sin(Math.toRadians(angulo)))));
            aux.setY(pontoLista.getY());
            aux.setZ((double) ((pontoLista.getX() * Math.sin(Math.toRadians(angulo))) + (pontoLista.getZ() * Math.cos(Math.toRadians(angulo)))));

            pontoLista.setX(aux.getX());
            pontoLista.setY(aux.getY());
            pontoLista.setZ(aux.getZ());
        }

        transladarOrigem.setX(getCentro().getX());
        transladarOrigem.setY(getCentro().getY());
        transladarOrigem.setZ(getCentro().getZ());

        translacao(transladarOrigem.getX(), transladarOrigem.getY(), transladarOrigem.getZ());
        calculaCentro();
    }

    public void rotacaoEixoZ(double angulo) {
        Ponto3d aux = new Ponto3d();
        Ponto3d transladarOrigem = new Ponto3d(getCentro().getX() * -1, getCentro().getY() * -1, getCentro().getZ() * -1);

        translacao(transladarOrigem.getX(), transladarOrigem.getY(), transladarOrigem.getZ());

        for (Ponto3d pontoLista : pontos) {
            aux.setX((double) ((pontoLista.getX() * Math.cos(Math.toRadians(angulo))) + (pontoLista.getY() * -Math.sin(Math.toRadians(angulo)))));
            aux.setY((double) ((pontoLista.getX() * Math.sin(Math.toRadians(angulo))) + (pontoLista.getY() * Math.cos(Math.toRadians(angulo)))));
            aux.setZ(pontoLista.getZ());

            pontoLista.setX(aux.getX());
            pontoLista.setY(aux.getY());
            pontoLista.setZ(aux.getZ());
        }

        transladarOrigem.setX(getCentro().getX());
        transladarOrigem.setY(getCentro().getY());
        transladarOrigem.setZ(getCentro().getZ());

        translacao(transladarOrigem.getX(), transladarOrigem.getY(), transladarOrigem.getZ());
        calculaCentro();
    }

    public HashSet<Aresta3d> getArestas() {
        HashSet<Aresta3d> arestas = new HashSet<Aresta3d>();
        if (!faces.isEmpty()) {
            for (Face3d face : faces) {
                arestas.add(new Aresta3d(face.getP1(), face.getP2()));
                arestas.add(new Aresta3d(face.getP2(), face.getP3()));
                arestas.add(new Aresta3d(face.getP3(), face.getP1()));
            }
        } else {
            System.out.println("Objeto vazio mano!!");
        }
        return arestas;
    }
    
    @Override
    public Objeto3d clone(){
        Objeto3d copy=new Objeto3d();
        
        for(Face3d f:faces){
            try {
                copy.addFace((Face3d) f.clone());
            } catch (CloneNotSupportedException ex) {
                Logger.getLogger(Objeto3d.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        copy.setCor(cor);
        return copy;
    }

    public void addObj(Objeto3d outro) {
        for(Face3d f:outro.clone().faces){
            this.addFace(f);
        }
    }

    public HashSet<Face3d> getFaces() {
        return faces;
    }
    
    public void elminacaoFaceOculta(Ponto3d p){
        //System.out.println(faces.size());
        HashSet<Face3d> copy=(HashSet<Face3d>) faces.clone();
        for(Face3d f: faces){
            if(f.normal(p)<0){      //elmina a face se for menor q zero
                copy.remove(f);
            }
        }
        faces=copy;
        
    }

    public void rotacaoEixoYsemTranslacao(double angulo) {
        Ponto3d aux = new Ponto3d();       

        for (Ponto3d pontoLista : pontos) {
            aux.setX((double) ((pontoLista.getX() * Math.cos(Math.toRadians(angulo))) + (pontoLista.getZ() * -Math.sin(Math.toRadians(angulo)))));
            aux.setY(pontoLista.getY());
            aux.setZ((double) ((pontoLista.getX() * Math.sin(Math.toRadians(angulo))) + (pontoLista.getZ() * Math.cos(Math.toRadians(angulo)))));

            pontoLista.setX(aux.getX());
            pontoLista.setY(aux.getY());
            pontoLista.setZ(aux.getZ());
        }
        
    }
    
    public void arrumaReferenciaDosPontos(){
        for(Face3d f:faces){
            for(Ponto3d p:pontos){
                if(f.getP1()!=p&&p.equals(f.getP1()))
                    f.setP1(p);
                if(f.getP2()!=p&&p.equals(f.getP2()))
                    f.setP2(p);
                if(f.getP3()!=p&&p.equals(f.getP3()))
                    f.setP3(p);
            }            
        }
    }

    public HashSet<Ponto3d> getPontos() {
        return pontos;
    }

    
}
