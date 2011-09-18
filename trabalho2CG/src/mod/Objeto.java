/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mod;

import java.awt.Color;
import java.util.ArrayList;

/**
 *
 * @author TyTu
 */
public class Objeto {

    private ArrayList<Ponto> pontos;
    private ArrayList<Aresta> arestas;
    private ArrayList<Face> faces;
    private Ponto centro;
    private Color cor;

    public void setCor(Color cor) {
        this.cor = cor;
    }

    public Color getCor() {
        return cor;
    }

    public Objeto(ArrayList<Ponto> pontos, ArrayList<Aresta> arestas, ArrayList<Face> faces) {
        this.pontos = pontos;
        this.arestas = arestas;
        this.faces = faces;
        this.cor = Color.WHITE;
        calculaCentro();
    }

    public Objeto() {
        pontos = new ArrayList<Ponto>();
        arestas = new ArrayList<Aresta>();
        faces = new ArrayList<Face>();
        this.cor = Color.WHITE;

    }

    public Ponto getCentro() {
        return centro;
    }

    public void setCentro(Ponto centro) {
        this.centro = centro;
    }

    public String exibirPontos() {
        String s = new String();
        for (int i = 0; i < pontos.size(); i++) {
            s = s + pontos.get(i).toString() + "\n";
        }
        s = s + "\n\n\n\n";
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
//
//    public int sizearestas() {
//        return arestas.size();
//    }
//
//    public Aresta setaresta(int index, Aresta element) {
//        return arestas.set(index, element);
//    }
//
//    public boolean removearesta(Object o) {
//        return arestas.remove(o);
//    }
//
//    public Aresta removearesta(int index) {
//        return arestas.remove(index);
//    }
//
//    public int lastIndexOfaresta(Object o) {
//        return arestas.lastIndexOf(o);
//    }
//
//    public boolean isEmptyaresta() {
//        return arestas.isEmpty();
//    }

//    public int indexOfaresta(Aresta o) {
//        if (o == null) {
//            return -1;
//        } else {
//            for (int i = 0; i < arestas.size(); i++) {
//                if (o.equals(arestas.get(i))) {
//                    return i;
//                }
//            }
//        }
//        return arestas.indexOf(o);
//    }
//    public Aresta getaresta(int index) {
//        return arestas.get(index);
//    }
//    public boolean containsaresta(Aresta o) {
//        if (indexOfaresta(o) > 0) {
//            return true;
//        } else {
//            return false;
//        }
//        return arestas.contains(o);
//    }
//    public void cleararesta() {
//        arestas.clear();
//    }
//    public void addaresta(int index, Aresta element) {
//        arestas.add(index, element);
//    }
//    public void addaresta(Aresta e) {
//        if (this.containsaresta(e)) {
//            e = arestas.get(indexOfaresta(e));
//        } else {
//            arestas.add(e);
//            addponto(e.getV1());
//            addponto(e.getV2());
//        }
//        arestas.add(e);
//    }
//    public int sizeface() {
//        return faces.size();
//    }
//    public Face setface(int index, Face element) {
//        return faces.set(index, element);
//    }
//
//    public boolean removeface(Object o) {
//        return faces.remove(o);
//    }
//
//    public Face removeface(int index) {
//        return faces.remove(index);
//    }
//
//    public int lastIndexOfface(Object o) {
//        return faces.lastIndexOf(o);
//    }
//
//    public boolean isEmptyface() {
//        return faces.isEmpty();
//    }
//
//    public int indexOfface(Object o) {
//        return faces.indexOf(o);
//    }
//
//    public Face getface(int index) {
//        return faces.get(index);
//    }
//
//    public boolean containsface(Object o) {
//        return faces.contains(o);
//    }
//
//    public Object cloneface() {
//        return faces.clone();
//    }
//
//    public void clearface() {
//        faces.clear();
//    }
//    public void addface(int index, Face element) {
//        faces.add(index, element);
//    }
// 
//    public boolean addface(Face e) {
//        for (int i = 0; i < e.getArestas().size(); i++) {
//            addaresta(e.getArestas().get(i));
//        }
//        this.calculaCentro();
//        return faces.add(e);
//    }
//    public int sizeponto() {
//        return pontos.size();
//    }
//    public Ponto setponto(int index, Ponto element) {
//        return pontos.set(index, element);
//    }
//    public boolean removeponto(Object o) {
//        return pontos.remove(o);
//    }
//    public Ponto removeponto(int index) {
//        return pontos.remove(index);
//    }
//    public int lastIndexOfponto(Object o) {
//        return pontos.lastIndexOf(o);
//    }
//    public boolean isEmptyponto() {
//        return pontos.isEmpty();
//    }
//    public int indexOfponto(Ponto o) {
////        if (o == null) {
////            return -1;
////        } else {
////            for (int i = 0; i < pontos.size(); i++) {
////                if (o.equals(pontos.get(i))) {
////                    return i;
////                }
////            }
////        }
////        return -1;
//        return pontos.indexOf(o);
//    }
//    public Ponto getponto(int index) {
//        return pontos.get(index);
//    }
//    public boolean containsponto(Ponto o) {
//        return pontos.contains(o);
//    }
//    public Object cloneponto() {
//        return pontos.clone();
//    }
//    public void clearponto() {
//        pontos.clear();
//    }
//    public void addponto(int index, Ponto element) {
//        pontos.add(index, element);
//    }
//
//    public void addponto(Ponto e) {
////        if (indexOfponto(e) > 0) {
////            e = pontos.get(indexOfponto(e));
////        } else {
////            pontos.add(e);
////
////            this.calculaCentro();
////
////        }
//        pontos.add(e);
//
//    }
    public void escala(double escala) {
        Ponto aux = new Ponto(this.centro.getX() * -1, this.centro.getY() * -1, this.centro.getZ() * -1);
        translacao(aux);
        for (int i = 0; i < pontos.size(); i++) {
            pontos.get(i).setX(pontos.get(i).getX() * escala);
            pontos.get(i).setY(pontos.get(i).getY() * escala);
            pontos.get(i).setZ(pontos.get(i).getZ() * escala);
        }
        translacao(centro);
    }

    public void translacao(Ponto translacao) {
        for (Ponto p : pontos) {
            p.setX(p.getX() + translacao.getX());
            p.setY(p.getY() + translacao.getY());
            p.setZ(p.getZ() + translacao.getZ());
        }
    }

    public void calculaCentro() {
        double minx = Double.MAX_VALUE, maxx = Double.MIN_VALUE, miny = Double.MAX_VALUE, maxy = Double.MIN_VALUE, minz = Double.MAX_VALUE, maxz = Double.MIN_VALUE;
        for (int i = 0; i < faces.size(); i++) {
            for (int j = 0; j < faces.get(i).getArestas().size(); j++) {
                if (minx > faces.get(i).getArestas().get(j).getV1().getX()) {
                    minx = faces.get(i).getArestas().get(j).getV1().getX();
                }
                if (minx > faces.get(i).getArestas().get(j).getV2().getX()) {
                    minx = faces.get(i).getArestas().get(j).getV2().getX();
                }
                if (miny > faces.get(i).getArestas().get(j).getV1().getY()) {
                    miny = faces.get(i).getArestas().get(j).getV1().getY();
                }
                if (miny > faces.get(i).getArestas().get(j).getV2().getY()) {
                    miny = faces.get(i).getArestas().get(j).getV2().getY();
                }
                if (minz > faces.get(i).getArestas().get(j).getV1().getZ()) {
                    minz = faces.get(i).getArestas().get(j).getV1().getZ();
                }
                if (minz > faces.get(i).getArestas().get(j).getV2().getZ()) {
                    minz = faces.get(i).getArestas().get(j).getV2().getZ();
                }
                if (maxx < faces.get(i).getArestas().get(j).getV1().getX()) {
                    maxx = faces.get(i).getArestas().get(j).getV1().getX();
                }
                if (maxx < faces.get(i).getArestas().get(j).getV2().getX()) {
                    maxx = faces.get(i).getArestas().get(j).getV2().getX();
                }
                if (maxy < faces.get(i).getArestas().get(j).getV1().getY()) {
                    maxy = faces.get(i).getArestas().get(j).getV1().getY();
                }
                if (maxy < faces.get(i).getArestas().get(j).getV2().getY()) {
                    maxy = faces.get(i).getArestas().get(j).getV2().getY();
                }
                if (maxz < faces.get(i).getArestas().get(j).getV1().getZ()) {
                    maxz = faces.get(i).getArestas().get(j).getV1().getZ();
                }
                if (maxz < faces.get(i).getArestas().get(j).getV2().getZ()) {
                    maxz = faces.get(i).getArestas().get(j).getV2().getZ();
                }
            }
        }
        Ponto v = new Ponto((maxx + minx) / 2, (maxy + miny) / 2, (maxz + minz) / 2);
        setCentro(v);
    }

    public void rotacionarEixoX(double angulo) {
        Ponto aux = new Ponto();
        Ponto tranaladarOrigem = new Ponto(getCentro().getX() * -1, getCentro().getY() * -1, getCentro().getZ() * -1);

        translacao(tranaladarOrigem);

        for (int i = 0; i < pontos.size(); i++) {
            aux.setX(pontos.get(i).getX());
            aux.setY((double) ((pontos.get(i).getY() * Math.cos(Math.toRadians(angulo))) + (pontos.get(i).getZ() * -Math.sin(Math.toRadians(angulo)))));
            aux.setZ((double) ((pontos.get(i).getY() * Math.sin(Math.toRadians(angulo))) + (pontos.get(i).getZ() * Math.cos(Math.toRadians(angulo)))));

            pontos.get(i).setX(aux.getX());
            pontos.get(i).setY(aux.getY());
            pontos.get(i).setZ(aux.getZ());
        }

        tranaladarOrigem.setX(getCentro().getX());
        tranaladarOrigem.setY(getCentro().getY());
        tranaladarOrigem.setZ(getCentro().getZ());

        translacao(tranaladarOrigem);
        calculaCentro();
    }

    public void rotacionarEixoY(double angulo) {
        Ponto aux = new Ponto();
        Ponto tranaladarOrigem = new Ponto(getCentro().getX() * -1, getCentro().getY() * -1, getCentro().getZ() * -1);
        translacao(tranaladarOrigem);

        for (int i = 0; i < pontos.size(); i++) {
            aux.setX((double) ((pontos.get(i).getX() * Math.cos(Math.toRadians(angulo))) + (pontos.get(i).getZ() * Math.sin(Math.toRadians(angulo)))));
            aux.setY(pontos.get(i).getY());
            aux.setZ((double) ((pontos.get(i).getX() * -Math.sin(Math.toRadians(angulo))) + (pontos.get(i).getZ() * Math.cos(Math.toRadians(angulo)))));

            pontos.get(i).setX(aux.getX());
            pontos.get(i).setY(aux.getY());
            pontos.get(i).setZ(aux.getZ());
        }

        tranaladarOrigem.setX(getCentro().getX());
        tranaladarOrigem.setY(getCentro().getY());
        tranaladarOrigem.setZ(getCentro().getZ());

        translacao(tranaladarOrigem);
        calculaCentro();
    }

    public void rotacionarEixoYs(double angulo) {
        Ponto aux = new Ponto();


        for (int i = 0; i < this.pontos.size(); i++) {
            aux.setX((double) ((this.pontos.get(i).getX() * Math.cos(Math.toRadians(angulo))) + (this.pontos.get(i).getZ() * Math.sin(Math.toRadians(angulo)))));
            aux.setY(this.pontos.get(i).getY());
            aux.setZ((double) ((this.pontos.get(i).getX() * -Math.sin(Math.toRadians(angulo))) + (this.pontos.get(i).getZ() * Math.cos(Math.toRadians(angulo)))));

            this.pontos.get(i).setX(aux.getX());
            this.pontos.get(i).setY(aux.getY());
            this.pontos.get(i).setZ(aux.getZ());
        }
        calculaCentro();
    }

    public void rotacionarEixoZ(double angulo) {
        Ponto aux = new Ponto();
        Ponto tranaladarOrigem = new Ponto(getCentro().getX() * -1, getCentro().getY() * -1, getCentro().getZ() * -1);

        translacao(tranaladarOrigem);

        for (int i = 0; i < pontos.size(); i++) {
            aux.setX((double) ((pontos.get(i).getX() * Math.cos(Math.toRadians(angulo))) + (pontos.get(i).getY() * (-1 * Math.sin(Math.toRadians(angulo))))));
            aux.setY((double) ((pontos.get(i).getX() * Math.sin(Math.toRadians(angulo))) + (pontos.get(i).getY() * Math.cos(Math.toRadians(angulo)))));
            aux.setZ(pontos.get(i).getZ());

            pontos.get(i).setX(aux.getX());
            pontos.get(i).setY(aux.getY());
            pontos.get(i).setZ(aux.getZ());
        }

        tranaladarOrigem.setX(tranaladarOrigem.getX() * -1);
        tranaladarOrigem.setY(tranaladarOrigem.getY() * -1);
        tranaladarOrigem.setZ(tranaladarOrigem.getZ() * -1);

        translacao(tranaladarOrigem);
        calculaCentro();
    }

    public Ponto rotacionarPontoEixoY(Ponto ponto, double angulo) {
        Ponto aux = new Ponto();
        aux.setX((double) ((ponto.getX() * Math.cos(Math.toRadians(angulo))) + (ponto.getZ() * Math.sin(Math.toRadians(angulo)))));
        aux.setY(ponto.getY());
        aux.setZ((double) ((ponto.getX() * -Math.sin(Math.toRadians(angulo))) + (ponto.getZ() * Math.cos(Math.toRadians(angulo)))));

        return aux;
    }

    @Override
    public Objeto clone() {
        Objeto copy = new Objeto();
        //clona centro
        copy.centro = this.centro.clone();
        //clona cor
        copy.cor = new Color(this.cor.getRGB());
        //clona faces
        for (Face f : faces) {
            copy.faces.add(f.clone());
            //
            for (Aresta a : f.getArestas()) {
                copy.arestas.add(a);
                copy.pontos.add(a.getV1());
                copy.pontos.add(a.getV2());
            }
        }
        //clona arestas
//        for(Aresta a : arestas){
//            aux.arestas.add(a.clone());
//        }
        //clona pontos

//        for(Ponto p : pontos){
//            aux.pontos.add(p.clone());
//        }
//        int tam = this.faces.size();
//        if (tam > 0) {
//            for (int i = 0; i < tam; i++) {
//                aux.addface(this.getface(i).clone());
//            }
//        } else {
//            tam = this.arestas.size();
//            for (int i = 0; i < tam; i++) {
//                aux.addaresta(this.getaresta(i).clone());
//            }
//        }
        return copy;
    }

    public void revolucao(int grid) {
        double angulo = 360 / (double) grid;
        Objeto aux1 = this.clone();
        Objeto aux2 = this;
        for (int i = 1; i < grid; i++) {
            aux1.rotacionarEixoYs(angulo);
            for (int j = 0; j < aux1.arestas.size(); j++) {
                Face f = new Face();
                Aresta a1 = new Aresta(aux1.arestas.get(j).getV1().clone(), aux2.arestas.get(j).getV1().clone());
                f.getArestas().add(a1);
                Aresta a2 = new Aresta(aux2.arestas.get(j).getV2().clone(), aux1.arestas.get(j).getV2().clone());
                f.getArestas().add(a2);


                Aresta aresta = new Aresta(aux1.arestas.get(j).getV1().clone(), aux1.arestas.get(j).getV2().clone());
                Aresta aresta2 = new Aresta(aux2.arestas.get(j).getV1().clone(), aux2.arestas.get(j).getV2().clone());


                f.getArestas().add(aresta);
                f.getArestas().add(aresta2);
                //this.addaresta(a1);
                //this.addaresta(a2); 
//                this.addface(f);
                faces.add(f);

            }
            aux2 = aux1.clone();
            aux1 = aux1.clone();
        }
        for (int j = 0; j < aux2.arestas.size(); j++) {
            Face f = new Face();
            f.getArestas().add(new Aresta(aux2.arestas.get(j).getV1().clone(), this.arestas.get(j).getV1().clone()));
            f.getArestas().add(new Aresta(this.arestas.get(j).getV2().clone(), aux2.arestas.get(j).getV2().clone()));
            f.getArestas().add(this.arestas.get(j).clone());
            f.getArestas().add(aux2.arestas.get(j).clone());
//            this.addface(f);
            faces.add(f);
        }
        //System.out.println(this.faces.size());
        //System.out.println(this.arestas.size());
        calculaCentro();
    }

    public void extrusao(double z) {

        if (!this.faces.isEmpty()) { // ve se exite alguma face
            Face faceAntiga = faces.get(0);
            Face faceNova = faceAntiga.clone(); //clona a face

            for (int i = 0; i < faceNova.getArestas().size(); i++) {//varre as arestas clonadas
                faceNova.getArestas().get(i).setZ(z); //set o z com o valor passado 
                //criar as novas arestas
                Aresta a1 = new Aresta(faceNova.getArestas().get(i).getV1(), faceAntiga.getArestas().get(i).getV1());
                Aresta a2 = new Aresta(faceAntiga.getArestas().get(i).getV2(), faceNova.getArestas().get(i).getV2());
                //criar nova face
                Face faceDaLigacao = new Face();
                faceDaLigacao.getArestas().add(a1);
                faceDaLigacao.getArestas().add(a2);
                faceDaLigacao.getArestas().add(faceAntiga.getArestas().get(i));
                faceDaLigacao.getArestas().add(faceNova.getArestas().get(i));
//                this.addface(f);
                faces.add(faceDaLigacao);
                arestas.add(a1);
                arestas.add(a2);
                arestas.add(faceNova.getArestas().get(i));
                if (!pontos.contains(faceNova.getArestas().get(i).getV1())) {
                    pontos.add(faceNova.getArestas().get(i).getV1());
                }
                if (!pontos.contains(faceNova.getArestas().get(i).getV2())) {
                    pontos.add(faceNova.getArestas().get(i).getV2());
                }
            }
//            this.addface(fa);
            faces.add(faceNova);
            //

        } else { //nao tem faces
            if (!this.arestas.isEmpty()) {//tem arestas?
                int tam = arestas.size();
                for (int j = 0; j < tam; j++) {//varre as arestas clonadas                 
                    //criar as novas arestas
                    Aresta a1 = arestas.get(j).clone();
                    a1.getV1().setZ(z);
                    a1.getV2().setZ(z);
                    //criar nova face
                    Face f = new Face();
                    f.getArestas().add(a1);
                    f.getArestas().add(this.getArestas().get(j));
                    f.getArestas().add(new Aresta(arestas.get(j).getV1(), a1.getV1()));
                    f.getArestas().add(new Aresta(arestas.get(j).getV2(), a1.getV2()));
//                    addface(f);
                    faces.add(f);
                }
            } else {// nao tem arestas, só um ponto
                Ponto p = this.pontos.get(0).clone();
                p.setZ(z);
                this.pontos.add(p);
                this.arestas.add(new Aresta(this.pontos.get(0), p));
            }
        }
        System.out.println(exibirPontos());
        translacao(new Ponto(10, 10, 10));
        System.out.println(exibirPontos());

        System.out.println("ARESTAS\n" + exibirAresta());
        System.out.println("OBJETO\n" + toString());
//        calculaCentro();
    }

//    public void arestasetz(double z) { //clona as arestas e seta o z
//        int tam = arestas.size();
//        for (int i = 0; i < tam; i++) {
//            Aresta a = arestas.get(i).clone();
//            a.setZ(z);
////            addaresta(a);
//            //addponto(a.getV1());
//        }
//
//    }
    public String exibirAresta() {
        String s = new String();
        for (int i = 0; i < arestas.size(); i++) {
            s = s + arestas.get(i).toString() + "\n";
        }
        s = s + "\n\n\n\n";
        return s;
    }

    private double maxx() {
        double x = Double.MIN_VALUE;
        for (int i = 0; i < pontos.size(); i++) {
            if (x < pontos.get(i).getX()) {
                x = pontos.get(i).getX();
            }
        }
        return x;
    }

    public boolean isEmpty() {
        return pontos.isEmpty();
    }

    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < faces.size(); i++) {
            s = s + "Face " + i + "\n";
            for (int j = 0; j < faces.get(i).getArestas().size(); j++) {
                s = s + faces.get(i).getArestas().get(j).toString();
            }
            s = s + "\n";
        }
        return s;
    }

    public boolean pertenceObjeto(Ponto p) {
        boolean res = false;
        for (int i = 0; i < faces.size(); i++) {
            if (faces.get(i).pertenceFace(p)) {
                res = true;
            }
        }
        return res;
    }

    public double minZ() {
        double res = Double.MAX_VALUE;
        for (int i = 0; i < pontos.size(); i++) {
            if (res > pontos.get(i).getZ()) {
                res = pontos.get(i).getZ();
            }
        }
        return res;
    }

    public double maxZ() {
        double res = Double.MIN_VALUE;
        for (int i = 0; i < pontos.size(); i++) {
            if (res < pontos.get(i).getZ()) {
                res = pontos.get(i).getZ();
            }
        }
        return res;
    }

    public Color getCor(Ponto p) {
        boolean res = false;
        for (int i = 0; i < arestas.size(); i++) {
            if (arestas.get(i).pertenceAresta(p)) {
                res = true;
            }
        }
        if (res) {
            return Color.BLACK;
        } else {
            return cor;
        }
    }

    public void arrumaPonto() {
        for (int i = 0; i < pontos.size(); i++) {
            for (int j = i; j < pontos.size(); j++) {
                if (pontos.get(i).equals(pontos.get(j))) {
                    pontos.set(j, pontos.get(i));
                    pontos.remove(j);
                }

            }
        }
    }
}
