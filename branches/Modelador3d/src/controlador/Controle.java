/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import modelo.objeto2d.Objeto2d;
import modelo.objeto2d.Ponto2d;
import modelo.objeto3d.Objeto3d;
import visao.JPanelXY;
import visao.TelaPrincipal;

/**
 *
 * @author TyTu
 */
public class  Controle {
    
    private static modelo.objeto2d.Objeto2d perfil2d;
    private static visao.CriarPerfil2d CriarPerfil2d;
    private static Cena cena= new Cena();
    private static TelaPrincipal tela;

    public Controle() {
        tela=new TelaPrincipal();
        tela.setVisible(true);
    }
    
    
    

    public static void addPonto2d(int x, int y) {
        perfil2d.addPonto(new Ponto2d(x, y));
        CriarPerfil2d.desenha();
    }

    public static Objeto2d getPerfil2d() {
        return perfil2d;
    }

    public static void LimpaPerfil2d(){
        perfil2d=new Objeto2d();
    }
        
    public static void CriarPerfil2d(){
        CriarPerfil2d = new visao.CriarPerfil2d();
        CriarPerfil2d.setVisible(true);
        perfil2d=new Objeto2d();
    }
    
    public static void extrusao(double z){
        
        
        Objeto3d obj= new Converte2dPara3d().extrusao(perfil2d, z);
        cena.addObjeto(obj);   
        
        
        JPanelXY painel =new JPanelXY(new Converte3dPara2d().XYsemEliminacao(obj));     
        tela.addPainel("XY",painel);        
        painel =new JPanelXY(new Converte3dPara2d().XZsemEliminacao(obj));
        tela.addPainel("XZ",painel);
        painel =new JPanelXY(new Converte3dPara2d().YZsemEliminacao(obj));
        tela.addPainel("YZ",painel);
         
         
    }
    
    public static void revolucao(int grid){
                       
        Objeto3d obj= new Converte2dPara3d().revolucao(perfil2d, grid);
        cena.addObjeto(obj);   
        
        JPanelXY painel =new JPanelXY(new Converte3dPara2d().XYsemEliminacao(obj));           
        tela.addPainel("XY",painel);
        painel =new JPanelXY(new Converte3dPara2d().XZsemEliminacao(obj));
        tela.addPainel("XZ",painel);
        painel =new JPanelXY(new Converte3dPara2d().YZsemEliminacao(obj));
        tela.addPainel("YZ",painel);
    }
    
}
