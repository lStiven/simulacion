
package numerospseudoaleatorios;

/**
 *
 * @author Luz Carime Lucumi®
 * @author Stiven®
 */
public class Corrida extends javax.swing.JFrame {

    /**
     * Creates new form Corrida
     */
    public Corrida(String signo, int cantidad,double mediaC, double varianzaC, double zC) {
        initComponents();
        //Se muestra en cada label el datos calculado en la clase 'PruebaDeBondad'
        totalCorridas.setText(""+cantidad);
        media.setText(String.format("%.2f", mediaC));
        varianza.setText(String.format("%.2f", varianzaC));
        z.setText(String.format("%.2f", zC));
        TextAreaCorridas.append(signo);
    }

    private Corrida() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TextAreaCorridas = new java.awt.TextArea();
        label1 = new java.awt.Label();
        label2 = new java.awt.Label();
        label8 = new java.awt.Label();
        totalCorridas = new java.awt.Label();
        label11 = new java.awt.Label();
        media = new java.awt.Label();
        label3 = new java.awt.Label();
        varianza = new java.awt.Label();
        z = new java.awt.Label();
        label12 = new java.awt.Label();
        jLabel1 = new javax.swing.JLabel();

        setMinimumSize(new java.awt.Dimension(590, 455));
        setPreferredSize(new java.awt.Dimension(590, 455));
        setResizable(false);
        getContentPane().setLayout(null);
        getContentPane().add(TextAreaCorridas);
        TextAreaCorridas.setBounds(30, 90, 509, 228);

        label1.setBackground(new java.awt.Color(255, 255, 255));
        label1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        label1.setText("Comportamiento de crecimiento y decrecimiento.");
        getContentPane().add(label1);
        label1.setBounds(27, 61, 311, 23);

        label2.setBackground(new java.awt.Color(255, 255, 255));
        label2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        label2.setText("PRUEBA DE CORRIDAS");
        getContentPane().add(label2);
        label2.setBounds(178, 23, 211, 28);

        label8.setBackground(new java.awt.Color(255, 255, 255));
        label8.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        label8.setForeground(new java.awt.Color(51, 51, 51));
        label8.setText("Total corridas");
        getContentPane().add(label8);
        label8.setBounds(50, 340, 121, 20);

        totalCorridas.setBackground(new java.awt.Color(255, 255, 255));
        totalCorridas.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        getContentPane().add(totalCorridas);
        totalCorridas.setBounds(80, 370, 50, 28);

        label11.setBackground(new java.awt.Color(255, 255, 255));
        label11.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        label11.setText("Media");
        getContentPane().add(label11);
        label11.setBounds(210, 340, 60, 20);

        media.setBackground(new java.awt.Color(255, 255, 255));
        media.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        getContentPane().add(media);
        media.setBounds(209, 370, 60, 28);

        label3.setBackground(new java.awt.Color(255, 255, 255));
        label3.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        label3.setText("z");
        getContentPane().add(label3);
        label3.setBounds(460, 340, 20, 20);

        varianza.setBackground(new java.awt.Color(255, 255, 255));
        varianza.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        getContentPane().add(varianza);
        varianza.setBounds(330, 370, 60, 28);

        z.setBackground(new java.awt.Color(255, 255, 255));
        z.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        getContentPane().add(z);
        z.setBounds(440, 370, 60, 28);

        label12.setBackground(new java.awt.Color(255, 255, 255));
        label12.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        label12.setText("Varianza");
        getContentPane().add(label12);
        label12.setBounds(320, 340, 78, 20);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ChiCuadrado.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 580, 430);

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(Corrida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Corrida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Corrida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Corrida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Corrida().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.TextArea TextAreaCorridas;
    private javax.swing.JLabel jLabel1;
    private java.awt.Label label1;
    private java.awt.Label label11;
    private java.awt.Label label12;
    private java.awt.Label label2;
    private java.awt.Label label3;
    private java.awt.Label label8;
    private java.awt.Label media;
    private java.awt.Label totalCorridas;
    private java.awt.Label varianza;
    private java.awt.Label z;
    // End of variables declaration//GEN-END:variables
}
