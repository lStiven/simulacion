/*
 *
 *
 */
package numerospseudoaleatorios;


/**
 * **********************************************************
 * Universidad del Valle * * Numeros pseudoaleatorios * GENERADOR DE ESTANDAR
 * MINIMO * * * Estudiantes Codigos * Luz Carime Lucumi Hernandez 1667564 *
 * Stiven Pinzón Triana 1667614 * *
 * **********************************************************
 */
/**
 * @date 8/11/2019
 * @author Luz Carime Lucumi®
 * @author Stiven®
 */
public class EstandarMinimo extends PruebaDeBondad{

    private double a, m, xi, q, r;
    private int periodo;

    public EstandarMinimo(){
        
    }
    public EstandarMinimo(double a, double m, double xi) {
        this.a = a;
        this.m = m;
        this.xi = xi;
        r = m % a;
        q = Math.floor(m / a);
    }

    public void mostrarRecurrencias() {
        System.out.print("\n        VALORES DE RECURRENCIA       \n\n");
        //Imprimir la semilla
        System.out.println("X(0) = " + xi);
        
        /**
         * Generar numeros
         */
        for (int i = 0; i < m; i ++) {
            //aux: guarda el numero generado por si en el metodo factorizado sigue siendo negativo
            double aux, rn;
            aux = xi;
            //formula estandar minimo factorizada
            xi = (a * (xi % q)) - r * (Math.floor(xi / q));
            if (xi < 0) {
                xi = xi + m;
                if (xi < 0) {
                    //formula estandar minimo
                    xi = (a * aux) % m;
                }
            }
            // generar rn
            rn = xi / m;
            /**
             * evaluar si la recurrencia generadas ya esta en el vector
             */
            if (getNumeros().contains(rn)) {
                System.out.println("X(" + (i + 1) + ") = " + xi + " | Rn = " + rn);
                break;
            }
            // Agregar recurrencia al vector
            getNumeros().add(rn); 
            System.out.println("X(" + (i + 1) + ") = " + xi + " | Rn = " + rn);
            periodo++;
        }
        System.out.println("Periodo: " + periodo);
    }

    public double getA() {
        return a;
    }

    public double getM() {
        return m;
    }

    public double getXi() {
        return xi;
    }

    public double getQ() {
        return q;
    }

    public double getR() {
        return r;
    }

    public int getPeriodo() {
        return periodo;
    }
 
}
