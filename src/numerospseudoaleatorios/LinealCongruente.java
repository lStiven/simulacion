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
        System.out.print("\n        VALORES DE RECURRENCIA       \n\n");
        //Imprimimir la semilla
        System.out.println("X(0) = " + xi);

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
                System.out.println("X(" + (i + 1) + ") = " + xi + " | Rn = " + rn);
                break;
            }
            // Agregar recurrencia al vector
            getNumeros().add(rn);
            //formula alterna
            //xi = (a + (c * xi)) % m;
            
            System.out.println("X(" + (i + 1) + ") = " + xi + " | Rn = " + rn);
            periodo++;
        }
        System.out.println("Periodo: " + periodo);
    }    

    public double getA() {
        return a;
    }

    public double getC() {
        return c;
    }

    public double getM() {
        return m;
    }

    public double getXi() {
        return xi;
    }

    public double getRn() {
        return rn;
    }

    public int getPeriodo() {
        return periodo;
    }
    
}
