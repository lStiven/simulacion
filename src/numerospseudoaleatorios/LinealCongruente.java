/*
 *
 *
 */
package numerospseudoaleatorios;

import java.util.Vector;

/************************************************************
 *                 Universidad del Valle                    *
 *                                                          *
 *                Numeros pseudoaleatorios                  *
 *              GENERADOR LINEAL CONGRUENTE                *
 *                                                          *
 *                                                          *   
 *        Estudiantes                       Codigos         *
 * Luz Carime Lucumi Hernandez              1667564         *
 * Stiven Pinzón Triana                     1667614         *
 *                                                          *
 ************************************************************/
/**
 * @date 8/11/2019
 * @author Luz Carime Lucumi®
 * @author Stiven®
 */
public class LinealCongruente extends PruebaDeBondad {

    private double a, c, m, xi, rn;
    private int periodo;
    String lc="";

    public LinealCongruente() {
    }
    
    public LinealCongruente(double a, double c, double m, double xi) {
        this.a = a;
        this.c = c;
        this.m = m;
        this.xi = xi;
        //Guardamos la semilla en una variable, para comparaciones posteriores
        //semilla = xi;
    }

    public void mostrarRecurrencia() {
        lc+="\n        VALORES DE RECURRENCIA       \n\n";
        //Imprimimir la semilla
        lc+="X(0) = " + xi+"\n";

        //For encargado de mostrar las recurrencias
        for (int i = 0; i < m; i ++) {

            /**
             * aplicar la formula correspondiente
             * generar el numero psudoaleatorio y el valor de rn
             */
            xi = ((a * xi) + c) % m;
            rn = xi / m;
            
            /**
             * verificar que la recurrencia actual no se haya generado
             */
            if (getNumeros().contains(rn)) {
                lc+="X(" + (i + 1) + ") = " + xi + " \r Rn = " + rn+"\n";
                break;
            }
            // Agregar recurrencia al vector
            getNumeros().add(rn);
            //formula alterna
            //xi = (a + (c * xi)) % m;
            
            lc+="X(" + (i + 1) + ") = " + xi + " | Rn = " + rn+"\n";
            periodo++;
        }
        lc+="Periodo: " + periodo+"\n";
        Generadores generadores= new Generadores(lc,true);
        generadores.setVisible(true);
    }

    // Retorna la cantidad de recurrencias generadas
    @Override
    public int totalRecurrencias() {
        return periodo;
    }
    
    
}
