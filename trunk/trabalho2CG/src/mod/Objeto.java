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
public class Objeto {

    private ArrayList<Ponto> pontos;
    private ArrayList<Aresta> arestas;
    private ArrayList<Face> faces;
    private Ponto centro;

    public Objeto(ArrayList<Ponto> pontos, ArrayList<Aresta> arestas, ArrayList<Face> faces) {
        this.pontos = pontos;
        this.arestas = arestas;
        this.faces = faces;
        calculaCentro();
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

    public String pontos() {
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

    public int indexOfaresta(Aresta o) {
        if (o == null) {
	    return -1;
	} else {
	    for (int i = 0; i < arestas.size(); i++)
		if (o.equals(arestas.get(i)))
		    return i;
	}
	return -1;
    }

    public Aresta getaresta(int index) {
        return arestas.get(index);
    }

    public boolean containsaresta(Object o) {
        return arestas.contains(o);
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
        for (int i = 0; i < e.getArestas().size(); i++) {
            if(indexOfponto(e.getArestas().get(i).getV1())<0){
                pontos.add(e.getArestas().get(i).getV1());
            }
            else{
                e.getArestas().get(i).setV1(this.getponto(indexOfponto(e.getArestas().get(i).getV1())));
            }
            if(indexOfponto(e.getArestas().get(i).getV2())<0){
                pontos.add(e.getArestas().get(i).getV2());
            }
            else{
                e.getArestas().get(i).setV2(this.getponto(indexOfponto(e.getArestas().get(i).getV2())));
            }
            if(indexOfaresta(e.getArestas().get(i))<0){
                this.addaresta(e.getArestas().get(i));
            }
            else{
                e.getArestas().set(i, this.getaresta(indexOfaresta(e.getArestas().get(i))));
            }
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

    public int indexOfponto(Ponto o) {
        if (o == null) {
	    return -1;
	} else {
	    for (int i = 0; i < pontos.size(); i++)
		if (o.equals(pontos.get(i)))
		    return i;
	}
	return -1;
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

        return pontos();
    }

    public void escala(float escala) {
        for (int i = 0; i < pontos.size(); i++) {
            pontos.get(i).setX(pontos.get(i).getX() * escala);
            pontos.get(i).setY(pontos.get(i).getY() * escala);
            pontos.get(i).setZ(pontos.get(i).getZ() * escala);
        }
    }

    public void translacao(Ponto translacao) {

        for (int i = 0; i < pontos.size(); i++) {
            pontos.get(i).setX(pontos.get(i).getX() + translacao.getX());
            pontos.get(i).setY(pontos.get(i).getY() + translacao.getY());
            pontos.get(i).setZ(pontos.get(i).getZ() + translacao.getZ());
        }
    }

    public void calculaCentro() {
        float minx = 9999, maxx = -9999, miny = 9999, maxy = -9999, minz = 9999, maxz = -9999;
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
            aux.setY((float) ((pontos.get(i).getY() * Math.cos(Math.toRadians(angulo))) + (pontos.get(i).getZ() * -Math.sin(Math.toRadians(angulo)))));
            aux.setZ((float) ((pontos.get(i).getY() * Math.sin(Math.toRadians(angulo))) + (pontos.get(i).getZ() * Math.cos(Math.toRadians(angulo)))));

            pontos.get(i).setX(aux.getX());
            pontos.get(i).setY(aux.getY());
            pontos.get(i).setZ(aux.getZ());
        }

        tranaladarOrigem.setX(getCentro().getX());
        tranaladarOrigem.setY(getCentro().getY());
        tranaladarOrigem.setZ(getCentro().getY());

        translacao(tranaladarOrigem);
        calculaCentro();
    }

    public void rotacionarEixoY(double angulo) {
        Ponto aux = new Ponto();
        Ponto tranaladarOrigem = new Ponto(getCentro().getX() * -1, getCentro().getY() * -1, getCentro().getZ() * -1);
        System.out.println(centro);
        translacao(tranaladarOrigem);

        for (int i = 0; i < pontos.size(); i++) {
            aux=this.rotacionarPontoEixoY(this.getponto(i), angulo);
             
            
            pontos.set(i,aux);
        }

        tranaladarOrigem.setX(tranaladarOrigem.getX() * -1);
        tranaladarOrigem.setY(tranaladarOrigem.getY() * -1);
        tranaladarOrigem.setZ(tranaladarOrigem.getZ() * -1);

        translacao(tranaladarOrigem);
        calculaCentro();
    }

    public void rotacionarEixoZ(double angulo) {
        Ponto aux = new Ponto();
        Ponto tranaladarOrigem = new Ponto(getCentro().getX() * -1, getCentro().getY() * -1, getCentro().getZ() * -1);

        translacao(tranaladarOrigem);

        for (int i = 0; i < pontos.size(); i++) {
            aux.setX((float) ((pontos.get(i).getX() * Math.cos(Math.toRadians(angulo))) + (pontos.get(i).getY() * (-1 * Math.sin(Math.toRadians(angulo))))));
            aux.setY((float) ((pontos.get(i).getX() * Math.sin(Math.toRadians(angulo))) + (pontos.get(i).getY() * Math.cos(Math.toRadians(angulo)))));
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
        aux.setX((float) ((ponto.getX() * Math.cos(Math.toRadians(angulo))) + (ponto.getZ() * Math.sin(Math.toRadians(angulo)))));
        aux.setY(ponto.getY());
        aux.setZ((float) ((ponto.getX() * -Math.sin(Math.toRadians(angulo))) + (ponto.getZ() * Math.cos(Math.toRadians(angulo)))));
        
        return aux;
    }
    
   

    @Override
    public Objeto clone(){
        Objeto aux = new Objeto();
        int tam=this.faces.size();
        for(int i=0;i<tam;i++){
            aux.addface(this.getface(i).clone());
        }
        return aux;
    }
    
    public void revolucao(int grid) {
        double angulo = 360 / grid;
        Objeto aux1 = this.clone();
        Objeto aux2 = this;
        for (int i = 1; i < grid; i++) {
            aux1.rotacionarEixoY(angulo);
            for(int j=0;j<aux1.arestas.size();j++){
                Face f= new Face();
                f.add(new Aresta(aux1.arestas.get(j).getV1(),aux2.arestas.get(j).getV1() ));
                f.add(new Aresta(aux2.arestas.get(j).getV2(),aux1.arestas.get(j).getV2() ));
                f.add(aux1.arestas.get(j));
                f.add(aux2.arestas.get(j));
                this.addface(f);
            }
            aux2=aux1;
            aux1= aux1.clone();
        }
        for(int j=0;j<aux2.arestas.size();j++){
                Face f= new Face();
                f.add(new Aresta(aux2.arestas.get(j).getV1(),this.arestas.get(j).getV1() ));
                f.add(new Aresta(this.arestas.get(j).getV2(),aux2.arestas.get(j).getV2() ));
                f.add(this.arestas.get(j));
                f.add(aux2.arestas.get(j));
                this.addface(f);
            }

    }

    public void extrusao(float z) {
        if (!this.faces.isEmpty()) { // ve se exite alguma face
            Face fa= (faces.get(0).clone()); //clona a face
            
            
            for (int j = 0; j < fa.getArestas().size(); j++) {//varre as arestas clonadas
                fa.getArestas().get(j).setZ(z); //set o z com o valor passado 
                //criar as novas arestas
                Aresta a1 = new Aresta(fa.getArestas().get(j).getV1(), this.faces.get(0).getArestas().get(j).getV1());
                Aresta a2 = new Aresta(this.faces.get(0).getArestas().get(j).getV2(), fa.getArestas().get(j).getV2());
                //criar nova face
                Face f = new Face();
                f.add(a1);
                f.add(a2);
                f.add(this.faces.get(0).getArestas().get(j));
                f.add(fa.getArestas().get(j));
                this.addface(f);
            }
            this.addface(fa);
        } else { //nao tem faces
            if (!this.arestas.isEmpty()) {//tem arestas?
                int tam = arestas.size();
                this.arestasetz(z);
                for (int j = tam; j < tam * 2; j++) {//varre as arestas clonadas                 
                    //criar as novas arestas
                    Aresta a1 = new Aresta(this.arestas.get(j).getV1(), this.arestas.get(j - tam).getV1());
                    Aresta a2 = new Aresta(this.arestas.get(j - tam).getV2(), this.arestas.get(j).getV2());
                    //criar nova face
                    Face f = new Face();
                    f.add(a1);
                    f.add(a2);
                    f.add(this.faces.get(0).getArestas().get(j));
                    f.add(this.faces.get(1).getArestas().get(j));
                    faces.add(f);
                }
            } else{// nao tem arestas, só um ponto
                Ponto p = this.pontos.get(0).clone();
                p.setZ(z);
                this.pontos.add(p);
                this.arestas.add(new Aresta(this.pontos.get(0), p));
            }
        }
        calculaCentro();
    }

    public void arestasetz(float z) { //clona as arestas e seta o z
        int tam = arestas.size();
        for (int i = 0; i < tam; i++) {
            Aresta a = arestas.get(i).clone();
            a.setZ(z);
            arestas.add(a);
            pontos.add(a.getV1());
        }

    }
    
    public String exibirAresta(){
        String s = new String();
        for (int i = 0; i < arestas.size(); i++) {
            s = s + arestas.get(i).toString() + "\n";
        }
        s = s + "\n\n\n\n";
        return s;
    }
}
