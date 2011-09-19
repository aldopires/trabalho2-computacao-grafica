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
public class Converte2dPara3d {
    
    public Objeto3d extrusao(Objeto2d obj2d, double z) {
        Objeto3d obj= new Objeto3d();
            
        for(Face2d f:obj2d.getFaces()){
            
            Face3d faceSuperior= converte(f, 0);
            
            Face3d faceInferior= converte(((Face2d) f.clone()).inverteFace(), z);
            
            Face3d f1= new Face3d(converte(f.getP1(), 0), converte(f.getP1(), z), converte(f.getP2(), z));
            Face3d f2= new Face3d(converte(f.getP2(), z), converte(f.getP2(), 0), converte(f.getP1(), z));
            Face3d f3= new Face3d(converte(f.getP2(), 0), converte(f.getP2(), z), converte(f.getP3(), z));
            Face3d f4= new Face3d(converte(f.getP3(), z), converte(f.getP3(), 0), converte(f.getP1(), z));
            Face3d f5= new Face3d(converte(f.getP3(), 0), converte(f.getP3(), z), converte(f.getP1(), z));
            Face3d f6= new Face3d(converte(f.getP1(), z), converte(f.getP1(), 0), converte(f.getP3(), z));
            
            
            obj.addFace(faceSuperior);
            obj.addFace(f1);
            obj.addFace(f2);
            obj.addFace(f3);
            obj.addFace(f4);
            obj.addFace(f5);
            obj.addFace(f6);
            obj.addFace(faceInferior);
        }
        
       return obj;
    }
    
    public Objeto3d revolucao(Objeto2d obj2d, int grid){
        Objeto3d obj= converte(obj2d,0);
        Objeto3d aux2=obj;
        double angulo= 360/grid;
        for(int i=0;i<grid;i++){            
            for(Face3d f:aux2.getFaces()){
                Face3d f1=new Face3d(
                        f.getP2(), 
                        f.getP1(), 
                        f.getP1().rotacaoEixoYsemTranslacao(angulo));
                Face3d f2=new Face3d(
                        f.getP1().rotacaoEixoYsemTranslacao(angulo), 
                        f.getP2().rotacaoEixoYsemTranslacao(angulo), 
                        f.getP2());
                Face3d f3=new Face3d(
                        f.getP3(), 
                        f.getP2(), 
                        f.getP2().rotacaoEixoYsemTranslacao(angulo));
                Face3d f4=new Face3d(
                        f.getP2().rotacaoEixoYsemTranslacao(angulo), 
                        f.getP3().rotacaoEixoYsemTranslacao(angulo), 
                        f.getP3());
                Face3d f5=new Face3d(
                        f.getP1(), 
                        f.getP3(), 
                        f.getP3().rotacaoEixoYsemTranslacao(angulo));
                Face3d f6=new Face3d(
                        f.getP3().rotacaoEixoYsemTranslacao(angulo), 
                        f.getP1().rotacaoEixoYsemTranslacao(angulo), 
                        f.getP1());
                obj.addFace(f1);
                obj.addFace(f2);
                obj.addFace(f3);
                obj.addFace(f4);
                obj.addFace(f5);
                obj.addFace(f6);
                
            }
            aux2=((Objeto3d)aux2.clone());
            aux2.rotacaoEixoYsemTranslacao(angulo);
        }
        
        return obj;
    }
    
    private Ponto3d converte(Ponto2d p, double z){
        return new Ponto3d(p.getX(), p.getY(), z);
    }
    
    private Face3d converte(Face2d f,double z){
        return new Face3d(converte(f.getP1(), z), converte(f.getP2(), z), converte(f.getP3(), z));
    }
    
    private Objeto3d converte(Objeto2d obj2d, double z){        
        Objeto3d obj3d= new Objeto3d();
        for(Face2d f: obj2d.getFaces()){
            obj3d.addFace(converte(f,z));
        }
        
        return obj3d;
                
    }
    
    

   
    
}
