
package numerospseudoaleatorios;

import javax.swing.table.DefaultTableModel;

/************************************************************
 *                 Universidad del Valle                    *
 *                                                          *
 *                Numeros pseudoaleatorios                  *
 *                  INTERFAZ KOLMOGOROV                     *
 *                                                          *
 *                                                          *   
 *        Estudiantes                       Codigos         *
 * Luz Carime Lucumi Hernandez              1667564         *
 * Stiven Pinzón Triana                     1667614         *
 *                                                          *
 ************************************************************/

/**
 *
 * @author Luz Carime Lucumi®
 * @author Stiven®
 */
public class Kolmogorov extends javax.swing.JFrame {
    /**
     * Creates new form ChiCuadrado
     */
    DefaultTableModel modelo;
    
    public Kolmogorov(double[][] tabla, double cantidad) {
        
        initComponents();
        
        String titulo[]={"Rango Inferior", "Rango superior","FO","FOA","POA","PEA","|PEA-POA|"};
        String informacion[][]={};
        modelo= new DefaultTableModel(informacion, titulo);
        tblKol.setModel(modelo);
        
        double intervalo= 0,FO,FOA,POA,PEA,total,DMcalc=0;
        
        //Se llena la tabla
        for (int i = 0; i < 11; i++) {
            if(i<10){
                //Colocamos los valores correspondientes a la primer fila de la tabla
                if(i==0){
                    FO=tabla[0][0];
                    FOA=tabla[0][0];
                    POA=(double)FOA/cantidad;
                    PEA=intervalo+0.1;
                    total=Math.abs(PEA-POA);
                    Object informacion2[]={String.format("%.1f", intervalo),String.format("%.1f", intervalo+0.1),FO,FOA,POA,String.format("%.1f", PEA),String.format("%.3f", total)};
                    intervalo=intervalo+0.1;
                    modelo.addRow(informacion2);
                    tblKol.setModel(modelo);
                }
                //Calculamos los valores correspondientes a las filas siguientes
                else {
                    FO=tabla[i][0];
                    FOA=FO+(double)tblKol.getValueAt(i-1, 3);
                    POA=(double)FOA/cantidad;
                    PEA=intervalo+0.1;
                    total=Math.abs(PEA-POA);
                    Object informacion2[]={String.format("%.1f", intervalo),String.format("%.1f", intervalo+0.1),FO,FOA,POA,String.format("%.1f", PEA),String.format("%.3f", total)};
                    intervalo=intervalo+0.1;
                    modelo.addRow(informacion2);
                    tblKol.setModel(modelo);
                }
                //Comparamos para obtener el mayor valor de los resultantes en la última
                //columna (el valor DMcalc)
                if(DMcalc<total){
                    DMcalc=total;
                }
            }
            else{
                //Colocamos en la tabla el valor correspondiente a DMcalc
                Object informacion2[]={"","","","","","DMcalc",String.format("%.3f", DMcalc)};
                modelo.addRow(informacion2);
                tblKol.setModel(modelo);
                //Se valida si cumple o no con las condiciones para la hipótesis
                //referente a datos con la distribucion U(0,1)
                if(DMcalc<=0.043){
                    labelCumple.setVisible(true);
                    labelCumple1.setVisible(true);
                    labelCumple2.setVisible(false);
                    labelCumple3.setVisible(false);
                }
                else{
                    labelCumple2.setVisible(true);
                    labelCumple3.setVisible(true);
                    labelCumple.setVisible(false);
                    labelCumple1.setVisible(false);
                }
            }
        }
        
    }

    private Kolmogorov() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        label1 = new java.awt.Label();
        label2 = new java.awt.Label();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblKol = new javax.swing.JTable();
        label3 = new java.awt.Label();
        label4 = new java.awt.Label();
        label5 = new java.awt.Label();
        labelCumple = new java.awt.Label();
        label7 = new java.awt.Label();
        label8 = new java.awt.Label();
        label9 = new java.awt.Label();
        labelCumple1 = new java.awt.Label();
        label11 = new java.awt.Label();
        labelCumple2 = new java.awt.Label();
        labelCumple3 = new java.awt.Label();
        jLabel1 = new javax.swing.JLabel();

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

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 204));
        setMinimumSize(new java.awt.Dimension(600, 500));
        setPreferredSize(new java.awt.Dimension(740, 490));
        setResizable(false);
        getContentPane().setLayout(null);

        tblKol.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblKol.setEnabled(false);
        jScrollPane2.setViewportView(tblKol);
        if (tblKol.getColumnModel().getColumnCount() > 0) {
            tblKol.getColumnModel().getColumn(0).setResizable(false);
        }

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(30, 80, 550, 210);

        label3.setBackground(new java.awt.Color(255, 255, 255));
        label3.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        label3.setText("Grados de libertad (gl)");
        getContentPane().add(label3);
        label3.setBounds(410, 310, 196, 20);
        label3.getAccessibleContext().setAccessibleDescription("");

        label4.setBackground(new java.awt.Color(255, 255, 255));
        label4.setFont(new java.awt.Font("Ebrima", 1, 36)); // NOI18N
        label4.setText("PRUEBA KOLMOGOROV");
        getContentPane().add(label4);
        label4.setBounds(150, 10, 440, 51);

        label5.setBackground(new java.awt.Color(255, 255, 255));
        label5.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        label5.setText("999");
        getContentPane().add(label5);
        label5.setBounds(480, 330, 34, 28);

        labelCumple.setBackground(new java.awt.Color(255, 255, 255));
        labelCumple.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        labelCumple.setText("DMcalc <=  DMcrit");
        labelCumple.setVisible(false);
        getContentPane().add(labelCumple);
        labelCumple.setBounds(180, 380, 170, 28);
        labelCumple.getAccessibleContext().setAccessibleName("");

        label7.setBackground(new java.awt.Color(255, 255, 255));
        label7.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        label7.setText("0.043");
        getContentPane().add(label7);
        label7.setBounds(270, 330, 49, 28);

        label8.setBackground(new java.awt.Color(255, 255, 255));
        label8.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        label8.setForeground(new java.awt.Color(51, 51, 51));
        label8.setText("Nivel de confianza (a) ");
        getContentPane().add(label8);
        label8.setBounds(10, 310, 196, 20);

        label9.setBackground(new java.awt.Color(255, 255, 255));
        label9.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        label9.setText("0,05");
        getContentPane().add(label9);
        label9.setBounds(70, 330, 39, 28);

        labelCumple1.setBackground(new java.awt.Color(255, 255, 255));
        labelCumple1.setFont(new java.awt.Font("Ebrima", 2, 14)); // NOI18N
        labelCumple1.setText("Se acepta la hipótesis de que los datos tienen distribución U(0,1)");
        labelCumple1.setVisible(false);
        getContentPane().add(labelCumple1);
        labelCumple1.setBounds(50, 410, 400, 24);
        labelCumple1.getAccessibleContext().setAccessibleName("");

        label11.setBackground(new java.awt.Color(255, 255, 255));
        label11.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        label11.setText("DM crit ");
        getContentPane().add(label11);
        label11.setBounds(260, 310, 70, 20);

        labelCumple2.setBackground(new java.awt.Color(255, 255, 255));
        labelCumple2.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        labelCumple2.setText("DMcalc >  DMcrit");
        labelCumple2.setVisible(false);
        getContentPane().add(labelCumple2);
        labelCumple2.setBounds(180, 380, 166, 28);
        labelCumple2.getAccessibleContext().setAccessibleDescription("");

        labelCumple3.setBackground(new java.awt.Color(255, 255, 255));
        labelCumple3.setFont(new java.awt.Font("Ebrima", 2, 14)); // NOI18N
        labelCumple3.setText("NO se acepta la hipótesis de que los datos tienen distribución U(0,1)");
        labelCumple3.setVisible(false);
        getContentPane().add(labelCumple3);
        labelCumple3.setBounds(30, 410, 430, 24);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Kolmogorov.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 730, 490);

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
            java.util.logging.Logger.getLogger(Kolmogorov.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Kolmogorov.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Kolmogorov.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Kolmogorov.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Kolmogorov().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
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
    public static java.awt.Label labelCumple2;
    public static java.awt.Label labelCumple3;
    public static javax.swing.JTable tblKol;
    // End of variables declaration//GEN-END:variables
}
