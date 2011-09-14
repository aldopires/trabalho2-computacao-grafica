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
    
    public void translacao(Objeto obj, Vertice translacao){
        Vertice aux;
        for(int i=0;i<obj.getFaces().size();i++){
            
            for(int n=0;n<obj.getFaces().get(i).getArestas().size();n++){
                
                aux=obj.getFaces().get(i).getArestas().get(n).getV1();
                aux.setX(aux.getX()+translacao.getX());
                aux.setY(aux.getY()+translacao.getY());
                aux.setZ(aux.getZ()+translacao.getZ());
                aux=obj.getFaces().get(i).getArestas().get(n).getV2();
                aux.setX(aux.getX()+translacao.getX());
                aux.setY(aux.getY()+translacao.getY());
                aux.setZ(aux.getZ()+translacao.getZ());
            }
            
        }
       
    }
    
    public void rotacaoEixoX(Objeto obj, double angulo){
        Vertice centro= new Vertice(obj.getCentro());
        // tranladar o centro do objeto para a origem

        obj.setCentro(new Vertice(obj.getCentro().getX()*-1, obj.getCentro().getY()*-1,obj.getCentro().getZ()*-1));
        translacao(obj, obj.getCentro());
        // aplicar rotaçao
        for(int i=0;i<obj.getFaces().size();i++){
            
            for(int n=0;n<obj.getFaces().get(i).getArestas().size();n++){
                Vertice ponto, aux;
                aux=new Vertice();
                // calculando para o primeiro vertice
                ponto=obj.getFaces().get(i).getArestas().get(n).getV1();
                aux.setX(ponto.getX());
                aux.setY((float)((ponto.getY()* Math.cos(Math.toRadians(angulo)))+(ponto.getZ() * -Math.sin(Math.toRadians(angulo)))));
                aux.setZ((float)((ponto.getY()* Math.sin(Math.toRadians(angulo)))+(ponto.getZ() * Math.cos(Math.toRadians(angulo)))));
                obj.getFaces().get(i).getArestas().get(n).setV1(aux);
                // calculando para o segundo vertice
                aux=new Vertice();
                ponto=obj.getFaces().get(i).getArestas().get(n).getV2();
                aux.setX(ponto.getX());
                aux.setY((float)((ponto.getY()* Math.cos(Math.toRadians(angulo)))+(ponto.getZ() * -Math.sin(Math.toRadians(angulo)))));
                aux.setZ((float)((ponto.getY()* Math.sin(Math.toRadians(angulo)))+(ponto.getZ() * Math.cos(Math.toRadians(angulo)))));
                obj.getFaces().get(i).getArestas().get(n).setV2(aux);
            }
        }
        translacao(obj,centro);
    }
    
    public void rotacaoEixoY(Objeto obj, double angulo){
        
        Vertice centro= new Vertice(obj.getCentro());
        // tranladar o centro do objeto para a origem
        
        obj.setCentro(new Vertice(obj.getCentro().getX()*-1, obj.getCentro().getY()*-1,obj.getCentro().getZ()*-1));
        translacao(obj, obj.getCentro());
        
        // aplicar rotaçao
        for(int i=0;i<obj.getFaces().size();i++){
            
            for(int n=0;n<obj.getFaces().get(i).getArestas().size();n++){
                Vertice ponto, aux;
                aux=new Vertice();
                // calculando para o primeiro vertice
                ponto=obj.getFaces().get(i).getArestas().get(n).getV1();
                aux.setX((float)((ponto.getX()* Math.cos(Math.toRadians(angulo)))+(ponto.getZ() * Math.sin(Math.toRadians(angulo)))));
                aux.setY(ponto.getY());
                aux.setZ((float)((ponto.getX()* -Math.sin(Math.toRadians(angulo)))+(ponto.getZ() * Math.cos(Math.toRadians(angulo)))));
                obj.getFaces().get(i).getArestas().get(n).setV1(aux);
                // calculando para o segundo vertice
                aux=new Vertice();
                ponto=obj.getFaces().get(i).getArestas().get(n).getV2();
                aux.setX((float)((ponto.getX()* Math.cos(Math.toRadians(angulo)))+(ponto.getZ() * Math.sin(Math.toRadians(angulo)))));
                aux.setY(ponto.getY());
                aux.setZ((float)((ponto.getX()* -Math.sin(Math.toRadians(angulo)))+(ponto.getZ() * Math.cos(Math.toRadians(angulo)))));
                obj.getFaces().get(i).getArestas().get(n).setV2(aux);
            }
        }
        translacao(obj,centro);
    }
    
    public void rotacaoEixoZ(Objeto obj, double angulo){
        
        Vertice centro= new Vertice(obj.getCentro());
        System.out.println("centro: "+centro.toString());
        // tranladar o centro do objeto para a origem
        
        obj.setCentro(new Vertice(obj.getCentro().getX()*-1, obj.getCentro().getY()*-1,obj.getCentro().getZ()*-1));
        translacao(obj, obj.getCentro());
        
        // aplicar rotaçao
        for(int i=0;i<obj.getFaces().size();i++){
            
            for(int n=0;n<obj.getFaces().get(i).getArestas().size();n++){
                Vertice ponto, aux;
                aux=new Vertice();
                // calculando para o primeiro vertice
                ponto=obj.getFaces().get(i).getArestas().get(n).getV1();
                aux.setX((float)((ponto.getX()* Math.cos(Math.toRadians(angulo)))+(ponto.getY() * (-1*Math.sin(Math.toRadians(angulo))))));
                aux.setY((float)((ponto.getX()* Math.sin(Math.toRadians(angulo)))+(ponto.getY() * Math.cos(Math.toRadians(angulo)))));
                aux.setZ(ponto.getZ());
                obj.getFaces().get(i).getArestas().get(n).setV1(aux);
                // calculando para o segundo vertice
                aux=new Vertice();
                ponto=obj.getFaces().get(i).getArestas().get(n).getV2();
                aux.setX((float)((ponto.getX()* Math.cos(Math.toRadians(angulo)))+(ponto.getY() * (-1*Math.sin(Math.toRadians(angulo))))));
                aux.setY((float)((ponto.getX()* Math.sin(Math.toRadians(angulo)))+(ponto.getY() * Math.cos(Math.toRadians(angulo)))));
                aux.setZ(ponto.getZ());
                obj.getFaces().get(i).getArestas().get(n).setV2(aux);
            }
        }
       translacao(obj,centro);
    }
}
