/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mod;

/**
 *
 * @author TyTu
 */
class Aresta {
    private Ponto v1;
    private Ponto v2;

    public Aresta(Ponto v1, Ponto v2) {
        this.v1 = v1;
        this.v2 = v2;
    }

    public Aresta() {
        v1 = new Ponto();
        v2 = new Ponto();
    }
    
    

    public Ponto getV1() {
        return v1;
    }

    public void setV1(Ponto v1) {
        this.v1 = v1;
    }

    public Ponto getV2() {
        return v2;
    }

    public void setV2(Ponto v2) {
        this.v2 = v2;
    }

    
}
