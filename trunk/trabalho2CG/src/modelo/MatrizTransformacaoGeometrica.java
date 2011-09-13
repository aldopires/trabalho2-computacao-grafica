/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Andre
 */
public class MatrizTransformacaoGeometrica {
    
    Vertice ponto = new Vertice();
    
    public Vertice escala(Vertice v, float escala){
        ponto.setX(v.getX()*escala);
        ponto.setY(v.getY()*escala);
        ponto.setZ(v.getZ()*escala);
        
        return ponto;
    }
    
    public Vertice tranlacao(Vertice v, float translacaoX, float translacaoY, float translacaoZ){
        ponto.setX(v.getX()+ translacaoX);
        ponto.setY(v.getY()+ translacaoY);
        ponto.setZ(v.getZ()+ translacaoZ);
        
        return ponto;
    }
    
    public Vertice rotacaoEixoX(Vertice v, double angulo){
        ponto.setX(v.getX());
        ponto.setY((float)((v.getY()* Math.cos(Math.toRadians(angulo)))+(v.getZ() * -Math.sin(Math.toRadians(angulo)))));
        ponto.setZ((float)((v.getY()* Math.sin(Math.toRadians(angulo)))+(v.getZ() * Math.cos(Math.toRadians(angulo)))));
        
        return ponto;
    }
    public Vertice rotacaoEixoY(Vertice v, double angulo){
        ponto.setX((float)((v.getX()* Math.cos(Math.toRadians(angulo)))+(v.getZ() * Math.sin(Math.toRadians(angulo)))));
        ponto.setY(v.getY());
        ponto.setZ((float)((v.getX()* -Math.sin(Math.toRadians(angulo)))+(v.getZ() * Math.cos(Math.toRadians(angulo)))));
        
        return ponto;
    }
    public Vertice rotacaoEixoZ(Vertice v, double angulo){
        ponto.setX((float)((v.getX()* Math.cos(Math.toRadians(angulo)))+(v.getY() * -Math.sin(Math.toRadians(angulo)))));
        ponto.setY((float)((v.getX()* Math.sin(Math.toRadians(angulo)))+(v.getY() * Math.cos(Math.toRadians(angulo)))));
        ponto.setZ(v.getZ());
        
        return ponto;
    }
}
