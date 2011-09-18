/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mod;

import java.util.ArrayList;

/**
 *
 * @author TyTu
 */
public class Face {

    private ArrayList<Aresta> arestas;
    private double a, b, c, d;

    private void calculaEquacao() {
        Ponto p1, p2, p3;
        p1 = arestas.get(0).getV1();
        p2 = arestas.get(0).getV2();
        p3 = arestas.get(1).getV1();
        a = ((p3.getY() - p2.getY()) * (p1.getZ() - p2.getZ())) - ((p1.getY() - p2.getY()) * (p3.getZ() - p2.getZ()));
        b = ((p3.getZ() - p2.getZ()) * (p1.getX() - p2.getX())) - ((p1.getZ() - p2.getZ()) * (p3.getX() - p2.getX()));
        c = ((p3.getX() - p2.getX()) * (p1.getY() - p2.getY())) - ((p1.getX() - p2.getX()) * (p3.getY() - p2.getY()));
        d = -(a * p2.getX()) - (b * p2.getY()) - (c * p2.getZ());
    }

    private boolean pertencePlano(Ponto p) {
        double resp;
        resp = a * p.getX() + b * p.getY() + c * p.getZ() + d;
        if (resp > (double) -0.1 && resp < (double) 0.1) {
            return true;
        } else {
            return false;
        }
    }

    public boolean pertenceFace(Ponto p) {
        if (pertencePlano(p)) {
            double maxX = Double.MIN_VALUE;
            double maxY = Double.MIN_VALUE;
            for (int i = 0; i < arestas.size(); i++) {
                if (arestas.get(i).pertenceAresta(p)) {
                    return true;
                }
                if (arestas.get(i).getV1().getX() > maxX) {
                    maxX = arestas.get(i).getV1().getX();
                }
            }
            Ponto teste = p.clone();
            int a = 0;
            for (teste.getX(); teste.getX() < maxX + 1; teste.setX(teste.getX() + 1)) {
                teste.setZ((-this.a * teste.getX() - b * teste.getY() - d) / c);
                for (int i = 0; i < arestas.size(); i++) {
                    if (arestas.get(i).pertenceAresta(p)) {
                        if (a == 0) {
                            a = 1;
                        } else {
                            a = 0;
                        }
                    }
                }
            }
            if (a == 0) {
                return false;
            } else {
                return true;
            }

        } else {
            return false;
        }
    }

    public Face() {
        arestas = new ArrayList<Aresta>();
        a = b = c = d = 0;
    }

    public ArrayList<Aresta> getArestas() {
        return arestas;
    }

    public void setArestas(ArrayList<Aresta> arestas) {
        this.arestas = arestas;
        calculaEquacao();
    }

    @Override
    public Face clone() {
        Face aux = new Face();
        for(Aresta a : arestas){
            aux.arestas.add(a.clone());
        }
        aux.calculaEquacao();
        return aux;
    }
}
