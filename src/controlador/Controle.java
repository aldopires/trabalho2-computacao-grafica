/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.HashSet;
import modelo.objeto2d.Objeto2d;
import modelo.objeto2d.Ponto2d;
import modelo.objeto3d.Objeto3d;
import modelo.objeto3d.Ponto3d;
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

    public static void LimpaCena() {
        cena = new Cena();
    }

    public static HashSet<Objeto3d> getCena() {
        return cena.getCena();
    }

    public static void geraTela() {

        HashSet<Objeto2d> xy = new HashSet<Objeto2d>();
        HashSet<Objeto2d> xz = new HashSet<Objeto2d>();
        HashSet<Objeto2d> yz = new HashSet<Objeto2d>();
        if (tela.isOcultacao()) {
            for (Objeto3d o : cena.getCena()) {
                xy.add(Converte3dPara2d.XYsemEliminacao(o));
                xz.add(Converte3dPara2d.XZsemEliminacao(o));
                yz.add(Converte3dPara2d.YZsemEliminacao(o));
            }
        }else{
            for (Objeto3d o : cena.getCena()) {
                xy.add(Converte3dPara2d.XYcommEliminacao(o, new Ponto3d(10, 10, 500)));
                xz.add(Converte3dPara2d.XZcomEliminacao(o,new Ponto3d(10, 500, 10)));
                yz.add(Converte3dPara2d.YZcomEliminacao(o,new Ponto3d(500, 10, 10)));
            }
        }

        tela.setObj(xy, xz, yz);
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
        cena.addObjeto(obj);
        
        tela.atualiza();

        geraTela();

    }

    public static void revolucao(int grid) {

        Objeto3d obj = new Converte2dPara3d().revolucao(perfil2d, grid);
        cena.addObjeto(obj);
        
        tela.atualiza();

        geraTela();
    }
}
