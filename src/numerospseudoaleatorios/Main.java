/*
 *
 *
 */
package numerospseudoaleatorios;

import java.util.Scanner;

/**
 * @date 12/11/2019
 * @author Stiven®
 */
public class Main {

    public static void main(String[] args) {
        // TODO code application logic here
        double a, c, m, xi, cntPrueba;
        int e1, e2, e3;
        Scanner sc = new Scanner(System.in);

        System.out.print("        GENERADOR NUMEROS PSEUDOALEATORIOS       \n\n");

        //0<m
        System.out.print("m: ");
        m = sc.nextDouble();
        while (m <= 0) {
            System.out.println("'m' debe ser mayor a 0.");
            System.out.print("m: ");
            m = sc.nextDouble();
        }

        //0<a<m
        System.out.print("a: ");
        a = sc.nextDouble();
        while ((a <= 0) || (a > m)) {
            System.out.println("'a' debe ser mayor a 0 y menor a m.");
            System.out.print("a: ");
            a = sc.nextDouble();
        }

        //0<=c<m
        System.out.print("c: ");
        c = sc.nextDouble();
        while ((c < 0) || (c > m)) {
            System.out.println("'c' debe ser mayor/igual a 0 y menor a m.");
            System.out.print("c: ");
            c = sc.nextDouble();
        }

        //0<=xi<m
        System.out.print("Semilla: ");
        xi = sc.nextDouble();
        while ((xi < 0) || (xi >= m)) {
            System.out.println("'Semilla' debe ser mayor/igual a 0 y menor a m.");
            System.out.print("Semilla: ");
            xi = sc.nextDouble();
        }
        EstandarMinimo em = new EstandarMinimo(a, m, xi);
        LinealCongruente lc = new LinealCongruente(a, c, m, xi);

        /**
         * preguntar que metodo desea utilizar
         */
        do {
            System.out.println("1. Lineal Congruente\n2. Estandar Minimo");
            e1 = sc.nextInt();
            if (e1 == 1) {
                lc.mostrarRecurrencia();

            } else {
                if (e1 == 2) {
                    em.mostrarRecurrencias();

                } else {
                    System.out.println("Escoja un generador\n\n\n");
                }
            }
        } while (e1 < 1 || e1 > 2);

        /**
         * preguntar que tabla desea generar
         */
        System.out.println("        PRUEBA DE UNIFORMIDAD\n");
        do {
            System.out.println("Escoja un metodo para la prueba de uniformidad");
            System.out.println("1. Chi Cuadrado\n2. Kolmogorov-Smirnov");
            e2 = sc.nextInt();
            if (e2 == 1) {
                if (e1 == 1) {
                    do {
                        System.out.println("\nDigite la cantidad de datos para la prueba,"
                                + " recuerde que debe ser menor o igual a la cantidad de numeros generados");
                        System.out.println("Numeros generados: " + lc.totalRecurrencias());
                        cntPrueba = sc.nextInt();

                    } while (cntPrueba > lc.totalRecurrencias());
                    lc.llenarFO(cntPrueba);

                } else {
                    do {
                        System.out.println("\nDigite la cantidad de datos para la prueba,"
                                + " recuerde que debe ser menor o igual a la cantidad de numeros generados");
                        System.out.println("Numeros generados: " + em.totalRecurrencias());
                        cntPrueba = sc.nextInt();

                    } while (cntPrueba > em.totalRecurrencias());
                    em.llenarFO(cntPrueba);

                }

            } else {
                if (e2 == 2) {
                    if (e1 == 1) {
                        do {
                            System.out.println("\nDigite la cantidad de datos para la prueba,"
                                    + " recuerde que debe ser menor o igual a la cantidad de numeros generados");
                            System.out.println("Numeros generados: " + lc.totalRecurrencias());
                            cntPrueba = sc.nextInt();

                        } while (cntPrueba > lc.totalRecurrencias());
                        lc.llenarFO(cntPrueba);
                        lc.llenarTablaKolmogorov(cntPrueba);

                    } else {
                        do {
                            System.out.println("\nDigite la cantidad de datos para la prueba,"
                                    + " recuerde que debe ser menor o igual a la cantidad de numeros generados");
                            System.out.println("Numeros generados: " + em.totalRecurrencias());
                            cntPrueba = sc.nextInt();

                        } while (cntPrueba > em.totalRecurrencias());
                        em.llenarFO(cntPrueba);
                        em.llenarTablaKolmogorov(cntPrueba);

                    }
                } else {
                    System.out.println("Escoja un metodo para la prueba de uniformidad");
                    System.out.println("1. Chi Cuadrado\n2. Kolmogorov-Smirnov");
                    e2 = sc.nextInt();
                }
            }
        } while (e2 < 1 || e2 > 2);

    }

}
