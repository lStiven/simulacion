/* *
 *
 */
package numerospseudoaleatorios;

import java.util.Vector;

/************************************************************
 *                 Universidad del Valle                    *
 *                                                          *
 *                Numeros pseudoaleatorios                  *
 *                   PRUEBAS DE BONDAD                      *
 *                                                          *
 *                                                          *   
 *        Estudiantes                       Codigos         *
 * Luz Carime Lucumi Hernandez              1667564         *
 * Stiven Pinzón Triana                     1667614         *
 *                                                          *
 ************************************************************/

/**
 * @date 14/11/2019
 * @author Luz Carime Lucumi®
 * @author Stiven®
 */
public class PruebaDeBondad {

    protected double xCal, num, gl, DMcal, DMcri, c;
    private Vector numeros = new Vector();
    protected double[][] tabla1 = new double[10][3];
    protected double[][] tabla2 = new double[10][5];
    protected double[][] tablaPoker = new double[7][3];
    protected double[][] tablaSerie1 = new double[5][5];
    protected double[][] tablaSerie2 = new double[5][5];

    public PruebaDeBondad() {

    }

    public void llenarPokerFE(double cnt, int k) {
        switch (k) {
            case 5:
                //cartas: 1 -> todos diferentes
                tablaPoker[0][0] = 0.3024 * cnt;
                //cartas: 2 -> un par
                tablaPoker[1][0] = 0.5040 * cnt;
                //cartas: 3 -> trio
                tablaPoker[2][0] = 0.072 * cnt;
                //cartas: 4 -> dos pares
                tablaPoker[3][0] = 0.1080 * cnt;
                //cartas: 4 -> poker
                tablaPoker[4][0] = 0.00045 * cnt;
                //cartas: 5 -> full
                tablaPoker[5][0] = 0.009 * cnt;
                //cartas: 5 -> quintilla
                tablaPoker[6][0] = 0.0001 * cnt;
                break;
            case 4:
                //cartas: 1 -> todos diferentes
                tablaPoker[0][0] = 0.504 * cnt;
                //cartas: 2 -> un par
                tablaPoker[1][0] = 0.432 * cnt;
                //cartas: 3 -> trio
                tablaPoker[2][0] = 0.036 * cnt;
                //cartas: 4 -> dos pares
                tablaPoker[3][0] = 0.027 * cnt;
                //cartas: 4 -> poker
                tablaPoker[4][0] = 0.001 * cnt;
                break;
            case 3:
                //cartas: 1 -> todos diferentes
                tablaPoker[0][0] = 0.72 * cnt;
                //cartas: 2 -> un par
                tablaPoker[1][0] = 0.27 * cnt;
                //cartas: 3 -> trio
                tablaPoker[2][0] = 0.01 * cnt;
                break;
            case 2:
                //cartas: 1 -> todos diferentes
                tablaPoker[0][0] = 0.9 * cnt;
                //cartas: 2 -> un par
                tablaPoker[1][0] = 0.1 * cnt;
                break;
            default:
                break;
        }

    }

    public void llenarFO(double cnt) {
        // Guarda el valor de cada objeto del vector
        double num;
        /**
         * Validaciones para verificar en que rango se ubica el valor de la
         * recurrencia
         */
        for (int i = 0; i < cnt; i ++) {
            num = (double) numeros.elementAt(i);
            if (num >= 0 && num < 0.1) {
                tabla1[0][0] ++;
                tabla2[0][0] ++;
            } else if (num >= 0.1 && num < 0.2) {
                tabla1[1][0] ++;
                tabla2[1][0] ++;
            } else if (num >= 0.2 && num < 0.3) {
                tabla1[2][0] ++;
                tabla2[2][0] ++;
            } else if (num >= 0.3 && num < 0.4) {
                tabla1[3][0] ++;
                tabla2[3][0] ++;
            } else if (num >= 0.4 && num < 0.5) {
                tabla1[4][0] ++;
                tabla2[4][0] ++;
            } else if (num >= 0.5 && num < 0.6) {
                tabla1[5][0] ++;
                tabla2[5][0] ++;
            } else if (num >= 0.6 && num < 0.7) {
                tabla1[6][0] ++;
                tabla2[6][0] ++;
            } else if (num >= 0.7 && num < 0.8) {
                tabla1[7][0] ++;
                tabla2[7][0] ++;
            } else if (num >= 0.8 && num < 0.9) {
                tabla1[8][0] ++;
                tabla2[8][0] ++;
            } else {
                tabla1[9][0] ++;
                tabla2[9][0] ++;
            }
        }
        ChiCuadrado chi = new ChiCuadrado(tabla1, cnt);
        chi.setVisible(true);
        Kolmogorov kol = new Kolmogorov(tabla2, cnt);
        kol.setVisible(true);
    }

    public void probarCorrida(int cnt) {
        double numero;
        String dato = "";
        //Validan si se estuvo o no anteriormente en crecimiento o decrecimiento
        boolean cantidadP = false, cantidadN = false;
        //Conteo correspondiente a la cantidad de corridas positivas (mayor)
        //y negativas (menor)
        int mayor = 0, menor = 0, suma = 0;
        for (int i = 0; i < cnt; i ++) {
            //Se valida si se terminó el recorrido de datos
            if (i == (cnt - 1)) {
                break;
            }
            if (i % 40 == 0) {
                dato += "\n";
            }
            if (i == 0) {
                dato += "* ";
            }
            //Impresion de valores '-' o '+' segun corresponda
            //Comparaciones para datos anteriores al último
            if (i < cnt - 1) {
                numero = (double) numeros.elementAt(i + 1);
                if (numero < (double) numeros.elementAt(i)) {
                    dato += "-  ";
                } else {
                    dato += "+  ";
                }
            } //comparación para dato final recorrido
            else {
                numero = (double) numeros.elementAt(i);
                if (numero < (double) numeros.elementAt(i - 1)) {
                    System.out.print("- ");
                } else {
                    System.out.println("+ ");
                }
            }

            /*CODIGO CORRESPONDIENTE A PRUEBA CORRIDAS*/
            //Comparo las posiciones con la siguiente para saber
            //existencia de corrida entre ellas (hasta la penúltima)
            if (i < (cnt - 1)) {
                //Numero siguiente 
                numero = (double) numeros.elementAt(i + 1);
                //comparamos si decrece y si el anterior no decreció
                if (numero < (double) numeros.elementAt(i) && cantidadN == false) {
                    cantidadN = true;
                    cantidadP = false;
                    menor ++;
                } //comparamos si crece y si el anterior no creció
                else if (numero > (double) numeros.elementAt(i) && cantidadP == false) {
                    cantidadP = true;
                    cantidadN = false;
                    mayor ++;
                }
            } else {
                //última posición 
                numero = (double) numeros.elementAt(i);
                //Comparamos si decrece respecto a la anterior
                if (numero < (double) numeros.elementAt(i - 1) && cantidadN == false) {
                    menor ++;
                } else {
                    mayor ++;
                }
            }
        }
        int totalCorridas = menor + mayor;
        double media = (2 * (1000) - 1) / 3;
        double varianza = Math.sqrt((16 * 1000) / 90);
        double z = (totalCorridas - media) / varianza;

        Corrida corridas = new Corrida(dato, totalCorridas, media, varianza, z);
        corridas.setVisible(true);
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
            if (tabla2[i][4] > DMcal) {
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

    /**
     *
     * @param cnt: cantidad de recurrencias a evaluar
     * @param k: nivel de significancia
     */
    public void probarIndependenciaPoker(int cnt, int k) {

        llenarPokerFE(cnt, k);
        double numero, diferentes = 0, par = 0, trio = 0, dosPares = 0, poker = 0, full = 0, quintilla = 0;
        for (int i = 0; i < cnt; i ++) {
            System.out.println(numeros.elementAt(i));
            numero = (double) numeros.elementAt(i);
            if (asegurarQuintilla(numero, k)) {
                quintilla ++;
                tablaPoker[6][1] ++;
                System.out.println("quintilla");
            } else if (asegurarFull(numero, k)) {
                full ++;
                tablaPoker[5][1] ++;
                System.out.println("full");
            } else if (asegurarPoker(numero, k)) {
                poker ++;
                tablaPoker[4][1] ++;
                System.out.println("poker");
            } else if (asegurarDosPares(numero, k)) {
                dosPares ++;
                tablaPoker[3][1] ++;
                System.out.println("dosPares");
            } else if (asegurarTrio(numero, k)) {
                trio ++;
                tablaPoker[2][1] ++;
                System.out.println("trio");
            } else if (asegurarPar(numero, k)) {
                par ++;
                tablaPoker[1][1] ++;
                System.out.println("par");
            } else {
                diferentes ++;
                tablaPoker[0][1] ++;
                System.out.println("diferentes");
            }
        }
        System.out.println("Quintilla: " + quintilla);
        System.out.println("Poker: " + poker);
        System.out.println("Full: " + full);
        System.out.println("Trio: " + trio);
        System.out.println("Dos Pares: " + dosPares);
        System.out.println("Diferentes: " + diferentes);
        System.out.println("Par: " + par);

        for (int i = 0; i < 7; i ++) {
            for (int j = 0; j < 3; j ++) {
                if (tablaPoker[i][1] != 0) {
                    tablaPoker[i][2] = Math.pow(tablaPoker[i][1] - tablaPoker[i][0], 2) / tablaPoker[i][0];
                    c = c + tablaPoker[i][2];
                }
            }
        }
        for (int i = 0; i < 7; i ++) {
            for (int j = 0; j < 3; j ++) {
                System.out.print(tablaPoker[i][j] + "\t");
            }
            System.out.println("");
        }

        System.out.println("\nC: " + c);

    }

    /**
     *
     * @param rn: recurrencia
     * @param k: nivel de significancia
     * @return
     */
    public boolean asegurarDiferentes(double rn, int k) {
        boolean diferentes = true;
        String evaluar = Double.toString(rn);
        /**
         * verificar que se agreguen correctamente los numeros
         */
        if ((k + 2) > evaluar.length()) {
            evaluar = (String) evaluar.subSequence(2, evaluar.length());
        } else {
            evaluar = (String) evaluar.substring(2, (k + 2));
        }
        /**
         * crear un arreglo de char y verificar cada elemento con el arreglo
         */
        char[] buscar = evaluar.toCharArray();
        for (int i = 0; i < evaluar.length(); i ++) {
            char numero = buscar[i];
            for (int j = (i + 1); j < evaluar.length(); j ++) {
                if (numero == buscar[j]) {
                    diferentes = false;
                    break;
                }
            }
        }
        return diferentes;
    }

    public boolean asegurarPar(double rn, int k) {
        boolean par = false;
        String evaluar = Double.toString(rn);
        /**
         * verificar que se agreguen correctamente los numeros
         */
        if ((k + 2) > evaluar.length()) {
            evaluar = (String) evaluar.subSequence(2, evaluar.length());
        } else {
            evaluar = (String) evaluar.substring(2, (k + 2));
        }
        char[] buscar = evaluar.toCharArray();
        /**
         * si encuentra cualquier numero repetido, retorna true
         */
        for (int i = 0; i < evaluar.length(); i ++) {
            char numero = buscar[i];
            for (int j = (i + 1); j < evaluar.length(); j ++) {
                if (numero == buscar[j]) {
                    par = true;
                    break;
                }
            }
        }
        return par;
    }

    public boolean asegurarTrio(double rn, int k) {
        boolean trio = false;
        String evaluar = Double.toString(rn);
        /**
         * verificar que se agreguen correctamente los numeros
         */
        if ((k + 2) > evaluar.length()) {
            evaluar = (String) evaluar.subSequence(2, evaluar.length());
        } else {
            evaluar = (String) evaluar.substring(2, (k + 2));
        }
        /**
         * crear un arreglo de char y verificar cada elemento con el arreglo
         */
        int cont = 1;
        char[] buscar = evaluar.toCharArray();
        for (int i = 0; i < evaluar.length(); i ++) {
            char numero = buscar[i];
            for (int j = (i + 1); j < evaluar.length(); j ++) {
                if (numero == buscar[j]) {
                    cont ++;
                }
                if (cont == 3) {
                    trio = true;
                    break;
                }
            }
            cont = 1;
        }
        return trio;
    }

    public boolean asegurarDosPares(double rn, int k) {
        boolean dosPar = false;
        String evaluar = Double.toString(rn);
        /**
         * verificar que se agreguen correctamente los numeros
         */
        if ((k + 2) > evaluar.length()) {
            evaluar = (String) evaluar.subSequence(2, evaluar.length());
        } else {
            evaluar = (String) evaluar.substring(2, (k + 2));
        }
        char[] buscar = evaluar.toCharArray();
        /**
         * si encuentra cualquier numero repetido, retorna true
         */
        char primerPar = 'x';
        int cont = 0;
        for (int i = 0; i < evaluar.length(); i ++) {
            char numero = buscar[i];
            for (int j = (i + 1); j < evaluar.length(); j ++) {
                if (numero == buscar[j]) {
                    if (numero == primerPar) {

                    } else {
                        cont ++;
                        primerPar = numero;
                    }
                }
                if (cont == 2) {
                    dosPar = true;
                    break;
                }
            }
        }
        return dosPar;
    }

    public boolean asegurarFull(double rn, int k) {
        boolean full = false;
        String evaluar = Double.toString(rn);
        /**
         * verificar que se agreguen correctamente los numeros
         */
        if ((k + 2) > evaluar.length()) {
            evaluar = (String) evaluar.subSequence(2, evaluar.length());
        } else {
            evaluar = (String) evaluar.substring(2, (k + 2));
        }
        /**
         * crear un arreglo de char y verificar cada elemento con el arreglo
         * verificar si existen un par y un trio, diferenciando el numero
         * repetido(num)
         */
        boolean par = false, trio = false;
        char num = 'x';
        int cont = 1;
        char[] buscar = evaluar.toCharArray();
        for (int i = 0; i < evaluar.length(); i ++) {
            char numero = buscar[i];
            for (int j = (i + 1); j < evaluar.length(); j ++) {
                if (numero == buscar[j]) {
                    if (numero == num) {
                        j = evaluar.length();
                    } else {
                        cont ++;
                    }
                    if (cont == 3) {
                        num = numero;
                        trio = true;
                        j = evaluar.length();
                    }
                }
            }
            if (cont == 2) {
                par = true;
            }
            if (trio && par) {
                return true;
            }
            cont = 1;
        }
        return full;
    }

    public boolean asegurarPoker(double rn, int k) {
        boolean poker = false;
        String evaluar = Double.toString(rn);
        /**
         * verificar que se agreguen correctamente los numeros
         */
        if ((k + 2) > evaluar.length()) {
            evaluar = (String) evaluar.subSequence(2, evaluar.length());
        } else {
            evaluar = (String) evaluar.substring(2, (k + 2));
        }
        /**
         * crear un arreglo de char y verificar cada elemento con el arreglo
         */
        int cont = 1;
        char[] buscar = evaluar.toCharArray();
        for (int i = 0; i < evaluar.length(); i ++) {
            char numero = buscar[i];
            for (int j = (i + 1); j < evaluar.length(); j ++) {
                if (numero == buscar[j]) {
                    cont ++;
                }
                if (cont == 4) {
                    poker = true;
                    break;
                }
            }
            cont = 1;
        }
        return poker;
    }

    public boolean asegurarQuintilla(double rn, int k) {
        boolean quintilla = false;
        String evaluar = Double.toString(rn);
        /**
         * verificar que se agreguen correctamente los numeros
         */
        if ((k + 2) > evaluar.length()) {
            evaluar = (String) evaluar.subSequence(2, evaluar.length());
        } else {
            evaluar = (String) evaluar.substring(2, (k + 2));
        }
        /**
         * crear un arreglo de char y verificar cada elemento con el arreglo
         */
        int cont = 1;
        char[] buscar = evaluar.toCharArray();
        for (int i = 0; i < evaluar.length(); i ++) {
            char numero = buscar[i];
            for (int j = (i + 1); j < evaluar.length(); j ++) {
                if (numero == buscar[j]) {
                    cont ++;
                }
                if (cont == 5) {
                    quintilla = true;
                    break;
                }
            }
            cont = 1;
        }
        return quintilla;
    }

    public void serie(double cnt) {
        double num1, num2;
        int fila = 0, columna = 0;
        for (int i = 0; i < cnt; i ++) {
            num1 = (double) numeros.elementAt(i);
            num2 = (double) numeros.elementAt(i + 1);
            //Validaciones para posicionar de filas (fila), con num1 como 
            //primer elemento del par
            if (num1 >= 0 && num1 < 0.2) {
                fila = 0;
            } else if (num1 >= 0.2 && num1 < 0.4) {
                fila = 1;
            } else if (num1 >= 0.4 && num1 < 0.6) {
                fila = 2;
            } else if (num1 >= 0.6 && num1 < 0.8) {
                fila = 3;
            } else if (num1 >= 0.8 && num1 < 1) {
                fila = 4;
            }
            //Validaciones para posicionar columnas (columna), con num2 como 
            //segundo elemento del par
            if (num2 >= 0 && num2 < 0.2) {
                columna = 0;
            } else if (num2 >= 0.2 && num2 < 0.4) {
                columna = 1;
            } else if (num2 >= 0.4 && num2 < 0.6) {
                columna = 2;
            } else if (num2 >= 0.6 && num2 < 0.8) {
                columna = 3;
            } else if (num2 >= 0.8 && num2 < 1) {
                columna = 4;
            }

            tablaSerie1[fila][columna] ++;
            i ++;
        }

        double FE = cnt / 25;

        for (int j = 0; j < 5; j ++) {
            for (int k = 0; k < 5; k ++) {
                tablaSerie2[j][k] = (Math.pow(FE - tablaSerie1[j][k], 2)) / FE;
            }
        }

        SeriesTabla1 serie = new SeriesTabla1(tablaSerie1, (int) cnt);
        serie.setVisible(true);

        SeriesTabla2 serie1 = new SeriesTabla2(tablaSerie2, (int) cnt);
        serie1.setVisible(true);
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
