/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.objeto2d;

/**
 *
 * @author TyTu
 */
public class Face2d {

    private Ponto2d p1;
    private Ponto2d p2;
    private Ponto2d p3;

    public Face2d() {
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Face2d other = (Face2d) obj;
        if (this.p1 != other.p1 && (this.p1 == null || !this.p1.equals(other.p1))) {
            return false;
        }
        if (this.p2 != other.p2 && (this.p2 == null || !this.p2.equals(other.p2))) {
            return false;
        }
        if (this.p3 != other.p3 && (this.p3 == null || !this.p3.equals(other.p3))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + (this.p1 != null ? this.p1.hashCode() : 0);
        hash = 59 * hash + (this.p2 != null ? this.p2.hashCode() : 0);
        hash = 59 * hash + (this.p3 != null ? this.p3.hashCode() : 0);
        return hash;
    }

    public Face2d(Ponto2d p1, Ponto2d p2, Ponto2d p3) {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
    }

    @Override
    public String toString() {
        return "Face{" + "p1=" + p1 + ", p2=" + p2 + ", p3=" + p3 + '}';
    }

    public boolean addPonto(Ponto2d p) {
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
                    //coloca em ordem pra depois fazer o calculo da normal

                    ordena();

                    return true;
                }
            }
        }
        return false;
    }

    public Ponto2d getP1() {
        return p1;
    }

    public Ponto2d getP2() {
        return p2;
    }

    public Ponto2d getP3() {
        return p3;
    }

    @Override
    public Object clone(){
        return new Face2d((Ponto2d) p1.clone(), (Ponto2d) p2.clone(), (Ponto2d) p3.clone());
    }
    
    public Face2d inverteFace(){
        Ponto2d aux;
        aux=p3;
        p3=p2;
        p2=aux;
        return this;
    }

    private void ordena() {
        
        if (p1.getX() <= p2.getX() ) { //p1 < p2
            if (p1.getX() <= p3.getX() ) { //p1 < p3 && p1<p2
                if (p2.getX() <= p3.getX() ) { //p1<p2<p3
                    if(p2.getY()<=p3.getY()){
                        
                    }else{
                        inverteFace();
                    }
                }else{//p1<p3<p2
                    if(p2.getY()<=p3.getY()){
                        
                    }else{
                        inverteFace();
                    }
                }
            }else{// p3<p1<p2 
                if(p1.getY()<=p2.getY()&&p1.getY()<=p3.getY()){
                    
                }else{
                    inverteFace();
                }
            }
        }else{ //p2<p1
            if (p2.getX() <= p3.getX() ) {
                if(p1.getX()<=p3.getX()){//p2<p1<p3
                    if(p1.getY()>=p3.getY()){
                        
                    }else{
                        inverteFace();
                    }
                }else{//p2<p3<p1
                    if(p1.getY()>=p3.getY()){
                        
                    }else{
                        inverteFace();
                    }
                }
            
            }else{// p3<p2<p1
                if(p2.getY()>=p3.getY()){
                        
                    }else{
                        inverteFace();
                    }
            }
        }

    }

    public boolean isOnFace(Ponto2d p) {
        double minx= Double.MAX_VALUE,maxx=Double.MIN_VALUE,miny= Double.MAX_VALUE,maxy=Double.MIN_VALUE;
        if(p1.getX()<minx)
            minx=p1.getX();
        if(p2.getX()<minx)
            minx=p2.getX();
        if(p2.getX()<minx)
            minx=p3.getX();
        if(p1.getX()>maxx)
            maxx=p1.getX();
        if(p2.getX()>maxx)
            maxx=p2.getX();
        if(p3.getX()>maxx)
            maxx=p3.getX();
        if(p1.getY()<miny)
            miny=p1.getY();
        if(p2.getY()<miny)
            miny=p2.getY();
        if(p2.getY()<miny)
            miny=p3.getY();
        if(p1.getY()>maxy)
            maxy=p1.getY();
        if(p2.getY()>maxy)
            maxy=p2.getY();
        if(p3.getY()>maxy)
            maxy=p3.getY();
        if(p.getX()>maxx ||p.getX()<minx){
            return false;
        }
        if(p.getY()>maxy ||p.getY()<miny){
            return false;
        }        
        
        // falta termina
        
        
        
        return true;
    }
}
