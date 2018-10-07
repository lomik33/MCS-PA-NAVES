/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programacionavanzada_tarea_01;

/**
 *
 * @author CoreMac
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        //Calcomania calcomania= new NaveEspacial();
        //System.out.println(  calcomania);
        /* Create and display the form */
        /*java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Pantalla().setVisible(true);
            }
        });*/
        
        Nave miNave = new Nave();
        Espacio terrestre = new Espacio(miNave);
        System.out.println(terrestre);

        terrestre.mueveNave(20, 20);
        System.out.println(terrestre);
        
        
         Nave otraNave = new Challenger();
        terrestre.agregaNave(otraNave);
        terrestre.mueveNave(80, 40);
        System.out.println(terrestre);
    }
    
}
