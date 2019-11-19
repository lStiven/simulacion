/*
 *
 *
 */
package numerospseudoaleatorios;

/**
 * @date 18/11/2019
 * @author Stiven®
 */
public class NewMain {

    
    public static void main(String[] args) {
        // TODO code application logic here
        
        PruebaDeBondad pb = new PruebaDeBondad();
        double numero = 0.1111;
        System.out.println(pb.asegurarDiferentes(numero, 4));
        System.out.println(pb.asegurarPar(numero, 4));
        System.out.println(pb.asegurarTrio(numero, 4));
    }

}
