/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.objeto2d;

import java.util.HashSet;

/**
 *
 * @author TyTu
 */
public class Objeto2d {

    private HashSet<Face2d> faces;
    private HashSet<Ponto2d> pontos;
    private Face2d faceIncompleta = new Face2d();
    private Ponto2d centro;

    public Ponto2d getCentro() {
        return centro;
    }

    public Objeto2d() {
        faces = new HashSet<Face2d>();
        pontos = new HashSet<Ponto2d>();
    }

    public HashSet<Face2d> getFaces() {
        return faces;
    }

    public boolean addFace(Face2d face) {
        if (faces.add(face)) {
            addPontoFace(face.getP1());
            addPontoFace(face.getP2());
            addPontoFace(face.getP3());
            calculaCentro();
            return true;
        }
        return false;
    }

    private void addPontoFace(Ponto2d pontoNovo) {
        if (!pontos.add(pontoNovo)) {
            //o ponto existia e nada foi feito na lista; 
            //TODO: pegar referencia da lista 
            for (Ponto2d pontoLista : pontos) {
                if (pontoNovo.equals(pontoLista)) {
                    pontoNovo = pontoLista;
                    break;
                }
            }
        }
    }

    public boolean addPonto(Ponto2d pontoNovo) {
        if (faces.isEmpty()) {
            //primeira face do objeto
            faceIncompleta.addPonto(pontoNovo);
            if (faceIncompleta.getP3() != null) {
                addFace(faceIncompleta);
            }
            return true;
        } else {
            //ja existe uma face
            faceIncompleta = new Face2d();

            // procura os pontos mais perto do pontoNovo add na faceIncompleta
            Ponto2d pontoDisMin = pontoNovo;
            double distmin = Double.MAX_VALUE;
            for (Ponto2d pontoLista : pontos) {
                if (distmin > pontoNovo.distancia(pontoLista)) {
                    distmin = pontoNovo.distancia(pontoLista);
                    pontoDisMin = pontoLista;
                }
            }

            Ponto2d p1 = pontoDisMin;
            faceIncompleta.addPonto(p1);

            distmin = Double.MAX_VALUE;
            for (Ponto2d pontoLista : pontos) {
                if (distmin > pontoNovo.distancia(pontoLista) && !pontoLista.equals(p1)) {
                    distmin = pontoNovo.distancia(pontoLista);
                    pontoDisMin = pontoLista;
                }
            }
            faceIncompleta.addPonto(pontoDisMin);
            faceIncompleta.addPonto(pontoNovo);

            // add a face
            addFace(faceIncompleta);
        }
        return false;
    }

    public void escala(double x, double y) {
        double centrox=centro.getX(),
               centroy=centro.getY();
        translacao(-centrox, -centroy);
        for (Ponto2d pontoLista : pontos) {
            pontoLista.escala(x, y);
        }
        translacao(centrox, centroy);
    }

    public void translacao(double x, double y) {
        for (Ponto2d pontoLista : pontos) {
            pontoLista.translacao(x, y);
        }
        calculaCentro();
    }

    public HashSet<Aresta2d> getArestas() {
        HashSet<Aresta2d> arestas = new HashSet<Aresta2d>();
        if (!faces.isEmpty()) {
            for (Face2d face : faces) {
                arestas.add(new Aresta2d(face.getP1(), face.getP2()));
                arestas.add(new Aresta2d(face.getP2(), face.getP3()));
                arestas.add(new Aresta2d(face.getP3(), face.getP1()));
            }
        } else {
            if (faceIncompleta.getP2() != null) {
                arestas.add(new Aresta2d(faceIncompleta.getP1(), faceIncompleta.getP2()));
            } else {
                arestas.add(new Aresta2d(faceIncompleta.getP1(), faceIncompleta.getP1()));
            }
        }
        return arestas;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        Objeto2d copy = new Objeto2d();

        for (Face2d f : faces) {
            copy.addFace((Face2d) f.clone());
        }

        return copy;
    }

    public Objeto2d inverteFace() {
        for (Face2d f : faces) {
            f.inverteFace();
        }
        calculaCentro();

        return this;
    }

    public boolean isOnFaces(Ponto2d p) {
        for (Face2d f : faces) {
            if (f.isOnFace(p)) {
                return true;
            }
        }
        return false;
    }

    public boolean isEmpy() {
        return faces.isEmpty();
    }

    private void calculaCentro() {
        double minx = Double.MAX_VALUE, maxx = Double.MIN_VALUE, miny = Double.MAX_VALUE, maxy = Double.MIN_VALUE;
        for (Ponto2d p : pontos) {

            if (p.getX() < minx) {
                minx = p.getX();
            }

            if (p.getX() > maxx) {
                maxx = p.getX();
            }

            if (p.getY() < miny) {
                miny = p.getY();
            }

            if (p.getY() > maxy) {
                maxy = p.getY();
            }
        }
        centro = new Ponto2d(maxx - minx, maxy - miny);
    }

    public void rotaciona(double angulo) {
        calculaCentro();
        Ponto2d pc = centro;
        translacao(-pc.getX(), -pc.getY());
        for (Ponto2d p : pontos) {
            p.setX((double) ((p.getX() * Math.cos(Math.toRadians(angulo))) + (p.getY() * -Math.sin(Math.toRadians(angulo)))));
            p.setY((double) ((p.getX() * Math.sin(Math.toRadians(angulo))) + (p.getY() * Math.cos(Math.toRadians(angulo)))));
        }
        translacao(pc.getX(), pc.getY());
        
    }
}
