/*
 *
 *
 */
package numerospseudoaleatorios;

import java.util.Vector;

/**
 * @date 14/11/2019
 * @author Luz Carime Lucumi®
 * @author Stiven®
 */
public class PruebaDeBondad {

    protected double xCal, num, gl, DMcal, DMcri;
    private Vector numeros = new Vector();
    protected double[][] tabla1 = new double[10][3];
    protected double[][] tabla2 = new double[10][5];
    protected double[][] serie1 = new double[5][5];
    protected double[][] serie2 = new double[5][5];

    public PruebaDeBondad() {

    }

    public void llenarFO(double cnt) {

        /**
         * Validaciones para verificar en que rango se ubica el valor de la
         * recurrencia
         */
        for (int i = 0; i < cnt; i ++) {
            num = (double) getNumeros().elementAt(i);
            if (num >= 0 && num < 0.1) {
                tabla1[0][0] ++;
                tabla2[0][0] ++;
            } else {
                if (num >= 0.1 && num < 0.2) {
                    tabla1[1][0] ++;
                    tabla2[1][0] ++;
                } else {
                    if (num >= 0.2 && num < 0.3) {
                        tabla1[2][0] ++;
                        tabla2[2][0] ++;
                    } else {
                        if (num >= 0.3 && num < 0.4) {
                            tabla1[3][0] ++;
                            tabla2[3][0] ++;
                        } else {
                            if (num >= 0.4 && num < 0.5) {
                                tabla1[4][0] ++;
                                tabla2[4][0] ++;
                            } else {
                                if (num >= 0.5 && num < 0.6) {
                                    tabla1[5][0] ++;
                                    tabla2[5][0] ++;
                                } else {
                                    if (num >= 0.6 && num < 0.7) {
                                        tabla1[6][0] ++;
                                        tabla2[6][0] ++;
                                    } else {
                                        if (num >= 0.7 && num < 0.8) {
                                            tabla1[7][0] ++;
                                            tabla2[7][0] ++;
                                        } else {
                                            if (num >= 0.8 && num < 0.9) {
                                                tabla1[8][0] ++;
                                                tabla2[8][0] ++;
                                            } else {
                                                tabla1[9][0] ++;
                                                tabla2[9][0] ++;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public void llenarTablaChi(double cnt) {
        /**
         * llenado de la tabla1
         */
        for (int i = 0; i < 10; i ++) {

            //llenar columna FE
            tabla1[i][1] = cnt / (10);
            // Chi Cuadrado por intervalo y X^2 calculado
            tabla1[i][2] = Math.pow(tabla1[i][0] - tabla1[i][1], 2) / tabla1[i][1];
        }

        // Imprime la tabla1
        for (int i = 0; i < 10; i ++) {
            for (int j = 0; j < 3; j ++) {
                System.out.print(tabla1[i][j] + " ");

            }
            System.out.println("");
            xCal = xCal + tabla1[i][2];
        }
        System.out.println("Chi Cuadrado Calculado: " + xCal);
    }

    public void llenarTablaKolmogorov(double cnt) {
        /**
         * llenar el resto de la tabla
         */

        for (int i = 0; i < 10; i ++) {
            /**
             * primera fila de la tabla
             */
            if (i == 0) {
                //FOA
                tabla2[0][1] = tabla2[0][0];
                //POA
                tabla2[0][2] = tabla2[0][0] / cnt;
                //PEA
                tabla2[0][3] = (0.1);
                //|PEA - POA|
                tabla2[0][4] = Math.abs((tabla2[0][3] - tabla2[0][2]));
                
            } else {

                //FOA
                tabla2[i][1] = tabla2[i - 1][1] + tabla2[i][0];
                //POA
                tabla2[i][2] = tabla2[i][1] / cnt;
                //PEA
                tabla2[i][3] = tabla2[i - 1][3] + (0.1);
                //|PEA - POA|
                tabla2[i][4] = Math.abs((tabla2[i][3] - tabla2[i][2]));
            }
            if(tabla2[i][4] > DMcal){
                DMcal = tabla2[i][4];
            }
        }

        for (int i = 0; i < 10; i ++) {
            for (int j = 0; j < 5; j ++) {
                System.out.print(tabla2[i][j] + " ");
            }
            System.out.println("");
        }

        System.out.println("DMcalculado = " + DMcal);
    }
    
    public int totalRecurrencias() {
        return getNumeros().size();
    }
    
    /**
     * @return the numeros
     */
    public Vector getNumeros() {
        return numeros;
    }

}
