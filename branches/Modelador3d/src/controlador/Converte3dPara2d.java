/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import modelo.objeto2d.Face2d;
import modelo.objeto2d.Objeto2d;
import modelo.objeto2d.Ponto2d;
import modelo.objeto3d.Face3d;
import modelo.objeto3d.Objeto3d;
import modelo.objeto3d.Ponto3d;

/**
 *
 * @author TyTu
 */
public class Converte3dPara2d {
    
    public Objeto2d XYsemEliminacao(Objeto3d obj3d){
        Objeto2d retorno=new Objeto2d();        
        for(Face3d f: obj3d.getFaces()){
            retorno.addFace(converteSemZ(f));
        }
        return retorno;
    }
    
    public Objeto2d XZsemEliminacao(Objeto3d obj3d){
        Objeto2d retorno=new Objeto2d();        
        for(Face3d f: obj3d.getFaces()){
            retorno.addFace(converteSemY(f));
        }
        return retorno;
    }
    
    public Objeto2d YZsemEliminacao(Objeto3d obj3d){
        Objeto2d retorno=new Objeto2d();        
        for(Face3d f: obj3d.getFaces()){
            retorno.addFace(converteSemX(f));
        }
        return retorno;
    }
    
    public Objeto2d XYcommEliminacao(Objeto3d obj3d,Ponto3d observador){
        obj3d=obj3d.clone();
        obj3d.elminacaoFaceOculta(observador);
        Objeto2d retorno=new Objeto2d();        
        for(Face3d f: obj3d.getFaces()){
            retorno.addFace(converteSemZ(f));
        }
        return retorno;
    }
    
    public Objeto2d XZcomEliminacao(Objeto3d obj3d,Ponto3d observador){
        obj3d=obj3d.clone();
        obj3d.elminacaoFaceOculta(observador);
        Objeto2d retorno=new Objeto2d();        
        for(Face3d f: obj3d.getFaces()){
            retorno.addFace(converteSemY(f));
        }
        return retorno;
    }
    
    public Objeto2d YZcomEliminacao(Objeto3d obj3d,Ponto3d observador){
        obj3d=obj3d.clone();
        obj3d.elminacaoFaceOculta(observador);
        Objeto2d retorno=new Objeto2d();        
        for(Face3d f: obj3d.getFaces()){
            retorno.addFace(converteSemX(f));
        }
        return retorno;
    }
    
    private Ponto2d converteSemZ(Ponto3d p3d){
        return new Ponto2d(p3d.getX(), p3d.getY());
    }
    
    private Ponto2d converteSemX(Ponto3d p3d){
        return new Ponto2d(p3d.getY(), p3d.getZ());
    }
    
    private Ponto2d converteSemY(Ponto3d p3d){
        return new Ponto2d(p3d.getX(), p3d.getZ());
    }
    
    private Face2d converteSemZ(Face3d p3d){
        return new Face2d(converteSemZ(p3d.getP1()),converteSemZ(p3d.getP2()),converteSemZ(p3d.getP3()));
    }
    
    private Face2d converteSemY(Face3d p3d){
        return new Face2d(converteSemY(p3d.getP1()),converteSemY(p3d.getP2()),converteSemY(p3d.getP3()));
    }
    
    private Face2d converteSemX(Face3d p3d){
        return new Face2d(converteSemX(p3d.getP1()),converteSemX(p3d.getP2()),converteSemX(p3d.getP3()));
    }
    
}
