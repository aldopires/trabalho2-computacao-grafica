/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.Color;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashSet;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
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
    
    public static Luz getLuz(){
        return cena.getLuz();
    }
    
    public static void setLuz(Luz l){
        cena.setLuz(l);
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
    
    
       public static void gravar() {
        FileOutputStream fo = null;
        ObjectOutputStream oos = null;
        try {
            String path = new java.io.File(".").getCanonicalPath();
            String nome = JOptionPane.showInputDialog("Nome do arquivo");
            File arquivo =new File(path + "/" + nome + ".cena");
            fo = new FileOutputStream(arquivo);
            oos = new ObjectOutputStream(fo);
            try {
                
                    oos.writeObject(cena);
                
            } catch (Exception ex) {
                System.out.println("erro:"+ex);
            }
            
            
            
        } catch (Exception ex) {
        } finally {
            try {
                oos.close();
                fo.close();
            } catch (IOException ex) {
                
            }
        }

    }

    public static void ler() {
        
        FileInputStream fo = null;
        ObjectInputStream oos = null;
        
        try {
            JFileChooser chooser = new JFileChooser(
                    new java.io.File(".").getCanonicalPath());

            chooser.setMultiSelectionEnabled(false);
            chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);


            String[] rjq = new String[]{"cena"};
            chooser.addChoosableFileFilter(
                    new FileNameExtensionFilter("cena file (*.cena)", rjq));
            
            int  option = chooser.showOpenDialog(null);

            if (option == JFileChooser.APPROVE_OPTION) {
                File arquivo = chooser.getSelectedFile();
                fo = new FileInputStream(arquivo);
                oos = new ObjectInputStream(fo);
            }
            try {
                    cena= (Cena) oos.readObject();
                    
            } catch (Exception ex) {
            }
        } catch (IOException ex) {
            System.out.println("Erro ao abrir arquivo.");;
        } finally {
            try {
                oos.close();
                fo.close();
            } catch (IOException ex) {
            }
        }
    }
    
    
    
}
