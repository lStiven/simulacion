/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package numerospseudoaleatorios;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author miime_000
 */
public class ChiCuadrado extends javax.swing.JFrame {
    /**
     * Creates new form ChiCuadrado
     */
    DefaultTableModel modelo;
    
    public ChiCuadrado(double[][] tabla, double cantidad) {
        
        initComponents();
        
        PruebaDeBondad prueba= new PruebaDeBondad();
        String cabecera[]={"Rango Inferior", "Rango superior","FO","FE","(FE-FO)²/FE"};
        String datos[][]={};
        
        
        modelo= new DefaultTableModel(datos, cabecera);
        tblChi.setModel(modelo);
        
        double intervalo= 0,contador=0,FO,FE,Chi;
        //Muestro los rangos
        for (int i = 0; i < 11; i++) {
            if(i<10){
                FO=tabla[i][0];
                FE=cantidad/10;
                Chi=Math.pow((FO-FE),2)/FE;
                contador+=Chi;
                Object datos2[]={String.format("%.1f", intervalo),String.format("%.1f", intervalo+0.1),FO,FE,Chi};
                intervalo=intervalo+0.1;
                modelo.addRow(datos2);
                tblChi.setModel(modelo);
            }
            else{
                Object datos2[]={"","","","Σ(FE-FO)²/FE",contador};
                modelo.addRow(datos2);
                tblChi.setModel(modelo);
                if(contador<=16.92){
                    
                }
            }
        }
    }

    private ChiCuadrado() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        label1 = new java.awt.Label();
        label2 = new java.awt.Label();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblChi = new javax.swing.JTable();
        label3 = new java.awt.Label();
        label4 = new java.awt.Label();
        label5 = new java.awt.Label();
        labelCumple = new java.awt.Label();
        label7 = new java.awt.Label();
        label8 = new java.awt.Label();
        label9 = new java.awt.Label();
        labelCumple1 = new java.awt.Label();
        label11 = new java.awt.Label();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        label1.setText("label1");

        label2.setText("label2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 204));
        setMinimumSize(new java.awt.Dimension(600, 500));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblChi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblChi.setEnabled(false);
        jScrollPane2.setViewportView(tblChi);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 550, 210));

        label3.setEnabled(false);
        label3.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        label3.setText("Grados de libertad (gl)");
        getContentPane().add(label3, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 310, -1, 20));
        label3.getAccessibleContext().setAccessibleDescription("");

        label4.setEnabled(false);
        label4.setFont(new java.awt.Font("Ebrima", 1, 36)); // NOI18N
        label4.setText("PRUEBA X²");
        getContentPane().add(label4, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 10, -1, -1));

        label5.setEnabled(false);
        label5.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        label5.setText("9");
        getContentPane().add(label5, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 330, -1, -1));

        labelCumple.setEnabled(false);
        labelCumple.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        labelCumple.setText("X² calc <=  X² crit");
        getContentPane().add(labelCumple, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 380, -1, -1));
        labelCumple.getAccessibleContext().setAccessibleName("");

        label7.setEnabled(false);
        label7.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        label7.setText("16,92");
        getContentPane().add(label7, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 330, -1, -1));

        label8.setEnabled(false);
        label8.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        label8.setForeground(new java.awt.Color(51, 51, 51));
        label8.setText("Nivel de confianza (a) ");
        getContentPane().add(label8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, -1, 20));

        label9.setEnabled(false);
        label9.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        label9.setText("0,05");
        getContentPane().add(label9, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 330, -1, -1));

        labelCumple1.setEnabled(false);
        labelCumple1.setFont(new java.awt.Font("Ebrima", 2, 14)); // NOI18N
        labelCumple1.setText("Se acepta la hipótesis de que los datos tienen distribución U(0,1)");
        getContentPane().add(labelCumple1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 410, -1, -1));
        labelCumple1.getAccessibleContext().setAccessibleName("");

        label11.setEnabled(false);
        label11.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        label11.setText("X² crit ");
        getContentPane().add(label11, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 310, 40, 20));

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
            java.util.logging.Logger.getLogger(ChiCuadrado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChiCuadrado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChiCuadrado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChiCuadrado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ChiCuadrado().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private java.awt.Label label1;
    private java.awt.Label label11;
    private java.awt.Label label2;
    private java.awt.Label label3;
    private java.awt.Label label4;
    private java.awt.Label label5;
    private java.awt.Label label7;
    private java.awt.Label label8;
    private java.awt.Label label9;
    public static java.awt.Label labelCumple;
    public static java.awt.Label labelCumple1;
    public static javax.swing.JTable tblChi;
    // End of variables declaration//GEN-END:variables
}
