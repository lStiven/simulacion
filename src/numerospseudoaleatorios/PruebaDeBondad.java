/* *
 *
 */
package numerospseudoaleatorios;

import java.util.Vector;

/**
 * @date 14/11/2019
 * @author Stiven®
 */
public class PruebaDeBondad {
    
    protected double xCal, num, gl, DMcal, DMcri;
    private Vector numeros = new Vector();
    protected double[][] tabla1 = new double[10][3];
    protected double[][] tabla2 = new double[10][5];
    protected double[][] serie1 = new double[5][5];
    protected double[][] serie2 = new double[5][5];
    
    public PruebaDeBondad(){
        
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
                tabla1[0][0] ++;tabla2[0][0] ++;
            } else if (num >= 0.1 && num < 0.2) {
                    tabla1[1][0] ++;tabla2[1][0] ++;
                } else if (num >= 0.2 && num < 0.3) {
                        tabla1[2][0] ++;tabla2[2][0] ++;
                    } else if (num >= 0.3 && num < 0.4) {
                            tabla1[3][0] ++;tabla2[3][0] ++;
                        } else if (num >= 0.4 && num < 0.5) {
                                tabla1[4][0] ++;tabla2[4][0] ++;
                            } else if (num >= 0.5 && num < 0.6) {
                                    tabla1[5][0] ++;tabla2[5][0] ++;
                                } else if (num >= 0.6 && num < 0.7) {
                                        tabla1[6][0] ++;tabla2[6][0] ++;
                                    } else if (num >= 0.7 && num < 0.8) {
                                            tabla1[7][0] ++;tabla2[7][0] ++;
                                        } else if (num >= 0.8 && num < 0.9) {
                                                tabla1[8][0] ++;tabla2[8][0] ++;
                                            } else {
                                                tabla1[9][0] ++;tabla2[9][0] ++;
                                            }
        }
        ChiCuadrado chi= new ChiCuadrado(tabla1, cnt);
        chi.setVisible(true);
        Kolmogorov kol= new Kolmogorov(tabla2, cnt);
        kol.setVisible(true);
    }
    
    public void probarCorrida(int cnt){
        double numero;
        String dato="";
        //Validan si se estuvo o no anteriormente en crecimiento o decrecimiento
        boolean cantidadP= false, cantidadN=false;
        //Conteo correspondiente a la cantidad de corridas positivas (mayor)
        //y negativas (menor)
        int mayor=0, menor=0, suma=0;
        for(int i=0;i<cnt; i++){
                //Se valida si se terminó el recorrido de datos
                if(i==(cnt-1)){
                    break;
                }
                if(i%40==0){
                    dato+="\n";
                }
                if(i==0){
                    dato+="* ";
                }
                //Impresion de valores '-' o '+' segun corresponda
                //Comparaciones para datos anteriores al último
                if(i<cnt-1){
                    numero=(double)numeros.elementAt(i+1);
                    if(numero<(double)numeros.elementAt(i)){
                        dato+="-  ";
                    }
                    else{
                        dato+="+  ";
                    }
                }
                //comparación para dato final recorrido
                else{
                    numero=(double)numeros.elementAt(i);
                        if(numero<(double)numeros.elementAt(i-1)){
                            System.out.print("- ");
                        }
                        else{
                            System.out.println("+ ");
                        }
                }
                
                /*CODIGO CORRESPONDIENTE A PRUEBA CORRIDAS*/
                //Comparo las posiciones con la siguiente para saber
                //existencia de corrida entre ellas (hasta la penúltima)
                if(i<(cnt-1)){
                    //Numero siguiente 
                    numero=(double)numeros.elementAt(i+1);
                    //comparamos si decrece y si el anterior no decreció
                    if(numero<(double)numeros.elementAt(i) && cantidadN==false){
                        cantidadN=true;
                        cantidadP=false;
                        menor++;
                    }
                    //comparamos si crece y si el anterior no creció
                    else if(numero>(double) numeros.elementAt(i) && cantidadP==false){
                        cantidadP=true;
                        cantidadN=false;
                        mayor++;
                    }
                }
                else{
                    //última posición 
                    numero=(double)numeros.elementAt(i);
                    //Comparamos si decrece respecto a la anterior
                    if(numero<(double)numeros.elementAt(i-1) && cantidadN==false){
                        menor++;
                    }
                    else{
                        mayor++;
                    }
                }
        }
        int totalCorridas = menor + mayor;
        double media = (2*(1000) - 1)/3;
        double varianza = Math.sqrt((16*1000)/90);
        double z = (totalCorridas - media)/varianza;
        
        Corrida corridas= new Corrida(dato,totalCorridas,media,varianza,z);
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
    
    /**
     * 
     * @param rn: recurrencia
     * @param k: nivel de significancia
     * @return 
     */
    public boolean asegurarDiferentes(double rn, int k){
        boolean diferentes = true;
        String evaluar = Double.toString(rn);
        /**
         * verificar que se agreguen correctamente los numeros
         */
        if((k+2) > evaluar.length()){
            evaluar = (String)evaluar.subSequence(2, evaluar.length());
        }else{
            evaluar = (String)evaluar.substring(2, (k+2));
        }
        /**
         * crear un arreglo de char y verificar cada elemento con el arreglo
         */
        char[] buscar = evaluar.toCharArray();
        for (int i = 0; i < evaluar.length(); i ++) {
            char numero = buscar[i];
            for(int j = (i+1); j < evaluar.length(); j++){
                if(numero == buscar[j]){
                    diferentes = false;
                    break;
                }
            }
        }
        return diferentes;
    }
    
    public boolean asegurarPar(double rn, int k){
        boolean par = false;
        String evaluar = Double.toString(rn);
        /**
         * verificar que se agreguen correctamente los numeros
         */
        if((k+2) > evaluar.length()){
            evaluar = (String)evaluar.subSequence(2, evaluar.length());
        }else{
            evaluar = (String)evaluar.substring(2, (k+2));
        }
        char[] buscar = evaluar.toCharArray();
        /**
         * si encuentra cualquier numero repetido, retorna true
         */
        for (int i = 0; i < evaluar.length(); i ++) {
            char numero = buscar[i];
            for(int j = (i+1); j < evaluar.length(); j++){
                if(numero == buscar[j]){
                    par = true;
                    break;
                }
            }
        }
        return par;
    }
    
    public boolean asegurarTrio(double rn, int k){
        boolean trio = false;
        String evaluar = Double.toString(rn);
        /**
         * verificar que se agreguen correctamente los numeros
         */
        if((k+2) > evaluar.length()){
            evaluar = (String)evaluar.subSequence(2, evaluar.length());
        }else{
            evaluar = (String)evaluar.substring(2, (k+2));
        }
        /**
         * crear un arreglo de char y verificar cada elemento con el arreglo
         */
        int cont = 1;
        char[] buscar = evaluar.toCharArray();
        for (int i = 0; i < evaluar.length(); i ++) {
            char numero = buscar[i];
            for(int j = (i+1); j < evaluar.length(); j++){
                if(numero == buscar[j]){
                    cont++;
                }
                if(cont == 3){
                    trio = true;
                    break;
                }
            }
        }
        return trio;
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
