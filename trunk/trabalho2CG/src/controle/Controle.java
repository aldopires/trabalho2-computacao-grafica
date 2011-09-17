/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.util.ArrayList;
import mod.AlvyRay;
import mod.Cena;
import mod.Objeto;
import mod.Ponto;
import visao.TelaInicial;


/**
 *
 * @author TyTu
 */
public  class Controle {

    public static void addObjeto(Objeto o) {
        cena.addObj(o);
    }
    private static Cena cena;
    private static TelaInicial t;

    public static Cena getCena() {
        return cena;
    }

    public static void Limpa() {
        cena.limpa();
    }

    /**
     * <h3> CenaPerspectiva</h3> <p>
     * Transforma os objetos da cena na visão em perspectiva<p>
     * 
     * @param VRP = posição do observador no mundo
     * @param P = Ponto para onde a câmera está apontada
     * @param viewUP  = vetor View-Up Usado para definir a direção vertical no plano de projeção <br>
     * <i>Coordenadas extremas da Viewport para onde o mundo será mapeado</i> <p>
     * @param minX = X minimo
     * @param minY = Y minimo
     * @param maxX = X maximo
     * @param maxY = Y maximo <br>
     * <i>(cu, cv) = centro da window </i> <p>
     * @param cu
     * @param cv
     * @param su = 1/2 largura da window
     * @param sv = 1/2 altura da window <br>
     * <i>Distâncias entre o observador e os planos de recorte frontal e traseiro </i> <p>
     * @param near = Zmin
     * @param far = Zmax
     * @param distancia  = distância entre o observador e o plano de projeção
     */
    public static ArrayList<Objeto> CenaPerspectiva(){
        ArrayList<Objeto> lista = new ArrayList<Objeto>();
        Ponto VRP = new Ponto(40, 20, 100);
        Ponto P = new Ponto(0, 0, 0); 
        Ponto viewUP = new Ponto(0, 1, 0); 
        double minX=0; 
        double minY=0; 
        double maxX=400; 
        double maxY=300; 
        double cu=0; 
        double cv=0; 
        double su=200; 
        double sv=150; 
        double near=70; 
        double far=130; 
        double distancia=100;
        AlvyRay objPerspectiva = new AlvyRay( VRP, P, viewUP, minX,  minY, maxX, maxY, cu, cv,su,sv,near,far,distancia);
        objPerspectiva.geraMtp();
        objPerspectiva.geraMto();
        System.out.println("ahhhhhhhhhh"+cena.getListObj().size() );
        for(int i=0;i<cena.getListObj().size();i++){
            lista.add(objPerspectiva.transformMtp(cena.getListObj().get(i)));
        }
        return lista;
    }
    
    
    public Controle() {
        cena = new Cena();
        t= new TelaInicial();
        t.setVisible(true);
    }
    
    
    
    
}
