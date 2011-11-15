/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.objeto3d;

import controlador.Raio;
import controlador.Vetor;
import java.awt.Color;

/**
 *
 * @author TyTu
 */
public class Face3d {

    private Ponto3d p1;
    private Ponto3d p2;
    private Ponto3d p3;
    private double a, b, c, d;
    private Ponto3d centro;
    private Color cor;
    


    public Face3d(Ponto3d p1, Ponto3d p2, Ponto3d p3, Color c) {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        cor=c;
        calculaEquacao();
    }
    private void calculaEquacao() {
        a = ((p3.getY() - p2.getY()) * (p1.getZ() - p2.getZ())) - ((p1.getY() - p2.getY()) * (p3.getZ() - p2.getZ()));
        b = ((p3.getZ() - p2.getZ()) * (p1.getX() - p2.getX())) - ((p1.getZ() - p2.getZ()) * (p3.getX() - p2.getX()));
        c = ((p3.getX() - p2.getX()) * (p1.getY() - p2.getY())) - ((p1.getX() - p2.getX()) * (p3.getY() - p2.getY()));
        d = -(a * p2.getX()) - (b * p2.getY()) - (c * p2.getZ());

    }
    
    private void calculaCentro(){
        centro = new Ponto3d((encontraMaior(p1.getX(), p2.getX(), p3.getX()) + encontraMenor(p1.getX(), p2.getX(), p3.getX()))/2,
                (encontraMaior(p1.getY(), p2.getY(), p3.getY()) + encontraMenor(p1.getY(), p2.getY(), p3.getY()))/2,
                (encontraMaior(p1.getZ(), p2.getZ(), p3.getZ()) + encontraMenor(p1.getZ(), p2.getZ(), p3.getZ()))/2 );
    }
    
    private double encontraMaior(double a, double b, double c){
        if(a>b){
            if(a>c){
                return a;
            }else{
                return c;
            }
        }else{
            if(b>c){
                return b;
            }else{
                return c;
            }
        }
    }
    
        private double encontraMenor(double a, double b, double c){
        if(a<b){
            if(a<c){
                return a;
            }else{
                return c;
            }
        }else{
            if(b<c){
                return b;
            }else{
                return c;
            }
        }
    }
    

    public double normal(Ponto3d p) {
        calculaEquacao();
        return (p.getX() * a) + (p.getY() * b) + (p.getZ() * c) + d;
    }

    public boolean addPonto(Ponto3d p) {
        if (p1 == null) {
            p1 = p;
            return true;
        } else {
            if (p2 == null && !p1.equals(p)) {
                p2 = p;
                return true;
            } else {
                if (p3 == null && !p1.equals(p) && !p2.equals(p)) {
                    p3 = p;
                    calculaEquacao();
                    return true;
                }
            }
        }
        return false;
    }

    public Ponto3d getP1() {
        return p1;
    }

    public Ponto3d getP2() {
        return p2;
    }

    public Ponto3d getP3() {
        return p3;
    }

    public Ponto3d getCentro() {
        calculaCentro();
        return centro;
    }
    
    void setP1(Ponto3d p) {
        p1 = p;
    }

    void setP2(Ponto3d p) {
        p2 = p;
    }

    void setP3(Ponto3d p) {
        p3 = p;
    }

    public Color getCor() {
        return cor;
    }

    public void setCor(Color cor) {
        this.cor = cor;
    }
    
    
  
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Face3d other = (Face3d) obj;
        if (this.p1 == other.p1 || (this.p1.equals(other.p1))) {
            if (this.p2 == other.p2 || (this.p2.equals(other.p2))) {
                if (this.p3 == other.p3 || (this.p3.equals(other.p3))) {
                    return true;
                }
            }
            if (this.p2 == other.p3 || (this.p2.equals(other.p3))) {
                if (this.p3 == other.p2 || (this.p3.equals(other.p2))) {
                    return true;
                }
            }

        }

        if (this.p1 == other.p2 || (this.p1.equals(other.p2))) {
            if (this.p2 == other.p3 || (this.p2.equals(other.p3))) {
                if (this.p3 == other.p1 || (this.p3.equals(other.p1))) {
                    return true;
                }
            }
            if (this.p2 == other.p1 || (this.p2.equals(other.p1))) {
                if (this.p3 == other.p3 || (this.p3.equals(other.p3))) {
                    return true;
                }
            }

        }

        if (this.p1 == other.p3 || (this.p1.equals(other.p3))) {
            if (this.p2 == other.p1 || (this.p2.equals(other.p1))) {
                if (this.p3 == other.p2 || (this.p3.equals(other.p2))) {
                    return true;
                }
            }
            if (this.p2 == other.p2 || (this.p2.equals(other.p2))) {
                if (this.p3 == other.p1 || (this.p3.equals(other.p1))) {
                    return true;
                }
            }

        }

        return false;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + (this.p1 != null ? this.p1.hashCode() : 0);
        hash = 59 * hash + (this.p2 != null ? this.p2.hashCode() : 0);
        hash = 59 * hash + (this.p3 != null ? this.p3.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return "Face{" + "p1=" + p1 + ", p2=" + p2 + ", p3=" + p3 + '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return new Face3d((Ponto3d) p1.clone(), (Ponto3d) p2.clone(), (Ponto3d) p3.clone(), cor);
    }
    
    public Ponto3d getIntersecao(Raio raio) {

    Vetor v1 = new Vetor(this.getP1(), this.getP2());
    Vetor v2 = new Vetor(this.getP1(), this.getP3());

    Vetor N = Vetor.produtoVetorial(raio.getDirecao(),v2);

    double det = Vetor.produtoInterno(v1,N);

    if (det == 0) {
      return null;
    }

    double invDet = 1 / det;

    Vetor tVec = new Vetor(this.getP1(),raio.getOrigem());

    double u =  Vetor.produtoInterno(tVec,N)*invDet;

    if (u < 0 || u > 1) {
      return null;
    }

    Vetor qVec = Vetor.produtoVetorial(tVec, v1);

    double v = Vetor.produtoInterno(raio.getDirecao(),qVec)*invDet;

    if (v < 0 || u + v > 1) {
      return null;
    }

    double t = Vetor.produtoInterno(v2,qVec)*invDet;

    Vetor vec = Vetor.produtoVetorial(tVec,v1);

    double dist = invDet * Vetor.produtoInterno(v2,vec);

    if (dist < 0) {
      return null;
    }

    double x = (1-(u+v))*this.getP1().getX() + u*this.getP2().getX() + v*this.getP3().getX();
    double y = (1-(u+v))*this.getP1().getY() + u*this.getP2().getY() + v*this.getP3().getY();
    double z = (1-(u+v))*this.getP1().getZ() + u*this.getP2().getZ() + v*this.getP3().getZ();

    Ponto3d p = new Ponto3d(x,y,z);
    return p;
  }

        public Ponto3d getIntersecao2(Raio raio) {
      Ponto3d retorno = null;
      Ponto3d Pa = raio.getOrigem().sub( this.getP3());
      Ponto3d Pb = this.getP1().sub( this.getP3());
      Ponto3d Pc = this.getP2().sub( this.getP3());
      Vetor inverteD = Vetor.mult( -1, raio.getDirecao());
      Ponto3d D = (new Ponto3d(0, 0, 0)).soma( inverteD);
      double d = this.determinante(Pb, Pc, D);
      double dalfa = this.determinante(Pa, Pc, D);
      double dbeta = this.determinante(Pb, Pa, D);
      double dt = this.determinante(Pb, Pc, Pa);
      if (d == 0) {
        return retorno;
      }
      double alfa = dalfa / d;
      if (alfa < 0 || alfa > 1) {
        return retorno;
      }
      double beta = dbeta / d;
      if (beta < 0 || beta > 1) {
        return retorno;
      }
      double gama = 1 - (alfa + beta);
      if (gama < 0 || gama > 1) {
        return retorno;
      }
      double t = dt / d;
      if (t < 0) {
        return retorno;
      }
      
      
      retorno = raio.getOrigem().soma(Vetor.mult(t, raio.getDirecao()) );
      return retorno;
    }
        
         private double determinante(Ponto3d a, Ponto3d b, Ponto3d c) {
      double soma = ( (a.getX() * b.getY() * c.getZ()) +
                    (b.getX() * c.getY() * a.getZ()) +
                    (c.getX() * a.getY() * b.getZ()));
      double diferenca = ( (c.getX() * b.getY() * a.getZ()) +
                         (a.getX() * c.getY() * b.getZ()) +
                         (b.getX() * a.getY() * c.getZ()));

      return (soma - diferenca);
    }
    
}
