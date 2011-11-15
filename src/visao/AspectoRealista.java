/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * AspectoRealista.java
 *
 * Created on 15/11/2011, 15:41:55
 */
package visao;

import controlador.Raio;
import controlador.Vetor;
import java.awt.Color;
import java.awt.Graphics;
import java.util.HashSet;
import modelo.objeto3d.Face3d;
import modelo.objeto3d.Objeto3d;
import modelo.objeto3d.Ponto3d;

/**
 *
 * @author Marcos
 */
public class AspectoRealista extends javax.swing.JFrame {

    HashSet<Objeto3d> cena;

    /** Creates new form AspectoRealista */
    public AspectoRealista() {
        initComponents();
    }
    
    double zMin = Double.MAX_VALUE, zMax = Double.MIN_VALUE;

    AspectoRealista(HashSet<Objeto3d> cena, double xMin, double xMax, double yMin, double yMax) {
        initComponents();
        this.cena = cena;
        
       







        /*************************************************************/
//        int x=0,y=0;
//        for(int i=(int) xMin;i<(int)xMax;i++){
//            y=0;
//            for(int j=(int)yMin;j<(int) yMax;j++){
//                
//                
//                y++;
//            }
//            x++;
//        }
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Painel = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        Painel.setBackground(new java.awt.Color(255, 255, 255));
        Painel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Painel.setMinimumSize(new java.awt.Dimension(50, 50));
        Painel.setPreferredSize(new java.awt.Dimension(400, 300));

        javax.swing.GroupLayout PainelLayout = new javax.swing.GroupLayout(Painel);
        Painel.setLayout(PainelLayout);
        PainelLayout.setHorizontalGroup(
            PainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 398, Short.MAX_VALUE)
        );
        PainelLayout.setVerticalGroup(
            PainelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 298, Short.MAX_VALUE)
        );

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Painel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addContainerGap(161, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Painel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 187, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
// TODO add your handling code here:
     Graphics g = Painel.getGraphics();
        g.setColor(Color.red);
        //varrer em x
        //varrer em y
        //montar o vetor de zmax-zmin
        //verificar se tem intersecção com o objeto
        //se tiver procura a face q tem intersecção
        //encontra o ponto q tem intersecção
        //calcula a cor dele
        //não tem colocar a cor de fundo

        /************************************************************/
        for (Objeto3d obj : cena) {
            for (Face3d face : obj.getFaces()) {
                if (zMin > face.getP1().getZ()) {
                    zMin = face.getP1().getZ();
                }
                if (zMin > face.getP2().getZ()) {
                    zMin = face.getP2().getZ();
                }
                if (zMin > face.getP3().getZ()) {
                    zMin = face.getP3().getZ();
                }
                if (zMax < face.getP1().getZ()) {
                    zMax = face.getP1().getZ();
                }
                if (zMax < face.getP2().getZ()) {
                    zMax = face.getP2().getZ();
                }
                if (zMax < face.getP3().getZ()) {
                    zMax = face.getP3().getZ();
                }
            }
        }
HashSet<Ponto3d> listaPonto3d = new HashSet<Ponto3d>();
        for (int i = 0; i < 400; i++) { //varre o tamanho em x
            for (int j = 0; j < 300; j++) { //varre o tamanho em y
                
                Vetor vetor = new Vetor(new Ponto3d(i, j, zMin), new Ponto3d(i, j, zMax)); //define o vetor
                Raio raio = new Raio(new Ponto3d(i, j, zMin), vetor);
                
                for (Objeto3d obj : cena) {
                    for (Face3d face : obj.getFaces()) { //procura uma face que tem intersecção
                        Ponto3d intersecao = face.getIntersecao(raio);
                        if(intersecao!=null){
                            System.out.println("x="+i+" y="+j);
                            System.out.println("interseccao=" + intersecao);
                            g.setColor(Color.red);
                            g.drawLine((int)intersecao.getX(), (int)intersecao.getY(), (int)intersecao.getX(), (int)intersecao.getY());
                            listaPonto3d.add(intersecao);
                        }
                        intersecao = face.getIntersecao2(raio);
                        if(intersecao!=null){
                            System.out.println("x="+i+" y="+j);
                            System.out.println("interseccao2=" + intersecao);                   
                            g.setColor(Color.blue);
                            g.drawLine((int)intersecao.getX(), (int)intersecao.getY(), (int)intersecao.getX(), (int)intersecao.getY());
                            listaPonto3d.add(intersecao);
                        }
                    }
                }

            }
        }
//        g.setColor(Color.GREEN);
//        for(Ponto3d l1:listaPonto3d){
//            for(Ponto3d l2:listaPonto3d){
//                g.drawLine((int)l1.getX(), (int) l1.getY(), (int) l2.getX(), (int) l2.getY());
//            }
//        }
}//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AspectoRealista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AspectoRealista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AspectoRealista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AspectoRealista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new AspectoRealista().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Painel;
    private javax.swing.JButton jButton1;
    // End of variables declaration//GEN-END:variables
}
