/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.Color;
import java.util.HashSet;
import modelo.objeto2d.Objeto2d;
import modelo.objeto2d.Ponto2d;
import modelo.objeto3d.Objeto3d;
import visao.TelaPrincipal;

/**
 *
 * @author TyTu
 */
public class Controle {

    private static modelo.objeto2d.Objeto2d perfil2d;
    private static visao.CriarPerfil2d CriarPerfil2d;
    private static Cena cena = new Cena();
    private static TelaPrincipal tela;
    
    public static TelaPrincipal getTela(){
        return tela;
    }

    public static void LimpaCena() {
        cena = new Cena();
    }

    public static HashSet<Objeto3d> getCena() {
        return cena.getCena();
    }

    public static HashSet<Objeto2d> geraPerspectiva() {
        HashSet<Objeto2d> perpectiva = new HashSet<Objeto2d>();
        if (tela.isOcultacao()) {            
            for (Objeto3d o : cena.getCena()) {                
                perpectiva.add(new Converte3dPara2d().perspectivaSemEliminacaoFaceOculta(o, tela.getAlvyRay()));
            }
        }else{
            for (Objeto3d o : cena.getCena()) {
                perpectiva.add(new Converte3dPara2d().perspectivaComEliminacaoFaceOculta(o, tela.getAlvyRay()));
            }
        }

        return perpectiva;
    }

    public static Color getCor() {
        return cena.getCor();
    }

    public static void setCor(Color cor) {
        cena.setCor(cor);
    }

    public Controle() {
        tela = new TelaPrincipal();
        tela.setVisible(true);
    }

    public static void addPonto2d(int x, int y) {
        perfil2d.addPonto(new Ponto2d(x, y));
        CriarPerfil2d.desenha();
    }

    public static Objeto2d getPerfil2d() {
        return perfil2d;
    }

    public static void LimpaPerfil2d() {
        perfil2d = new Objeto2d();
    }

    public static void CriarPerfil2d() {
        CriarPerfil2d = new visao.CriarPerfil2d();
        CriarPerfil2d.setVisible(true);
        perfil2d = new Objeto2d();
    }

    public static void extrusao(double z) {


        Objeto3d obj = new Converte2dPara3d().extrusao(perfil2d, z);
        obj.setNome(cena.getCena().size()+"");
        cena.addObjeto(obj);
        
        tela.atualiza();

    }

    public static void revolucao(int grid) {

        Objeto3d obj = new Converte2dPara3d().revolucao(perfil2d, grid);
        obj.setNome(cena.getCena().size()+"");
        cena.addObjeto(obj);
        
        tela.atualiza();
    }
}
