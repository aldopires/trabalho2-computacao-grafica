/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalho2cg;


import modelo.MatrizTransformacaoGeometrica;
import modelo.Vertice;
import visao.TelaInicial;


/**
 *
 * @author Heitor
 */
public class Trabalho2CG {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Coordenada tica = new Coordenada(2, 3, 4);
        //System.out.println(tica.toString());

        MatrizTransformacaoGeometrica m = new MatrizTransformacaoGeometrica();
        Vertice A = new Vertice(4, 3, 0);
        A=m.rotacaoEixoZ(A, 90);
        System.out.println("x: "+A.getX()+"y: "+A.getY()+"z: "+A.getZ());
        
       

        TelaInicial vai = new TelaInicial();
        vai.setVisible(true);

        
    }
}
