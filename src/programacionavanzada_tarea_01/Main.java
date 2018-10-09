/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programacionavanzada_tarea_01;

import java.io.BufferedReader;
import java.io.File;

import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        
    //        Nave miNave = new Nave();
    //        Espacio terrestre = new Espacio(miNave);
    //        System.out.println(terrestre);
    //
    //        terrestre.mueveNave(20, 20);
    //        System.out.println(terrestre);
    //        
    //        
    //        Nave otraNave = new Challenger();
    //        terrestre.agregaNave(otraNave);
    //        terrestre.mueveNave(80, 40);
    //        System.out.println(terrestre);
//    Path currentRelativePath = Paths.get("");
//    String ruta = currentRelativePath.toAbsolutePath().toString()
//            +File.separator
//            +"src"
//            +File.separator
//            +"numeros"
//            +File.separator ;
//    //System.out.println(s);
//    //System.out.println(leerArchivo(s));
//    String texto=leerArchivo(ruta+"1.txt");
//    Lienzo uno=Lienzo.lienzoFactory(texto.split(System.lineSeparator()));
//    texto=leerArchivo(ruta+"2.txt");
//    Lienzo dos=Lienzo.lienzoFactory(texto.split(System.lineSeparator()));
//    texto=leerArchivo(ruta+"3.txt");
//    Lienzo tres=Lienzo.lienzoFactory(texto.split(System.lineSeparator()));
//    texto=leerArchivo(ruta+"4.txt");
//    Lienzo cuatro=Lienzo.lienzoFactory(texto.split(System.lineSeparator()));
//    //System.out.println(texto);
//    //System.out.println(uno);
//    LienzoConMarco lcm=new LienzoConMarco(30,13);
//    lcm.agregaLienzo(1, 1, uno);
//    System.out.println(lcm);
//    lcm.agregaLienzo(1+lcm.getAncho(), 1, dos);
//    System.out.println(lcm);
//    lcm.agregaLienzo(1+lcm.getAncho(), 1, tres);
//    System.out.println(lcm);
//    //lcm.agregaLienzo(1+lcm.getAncho(), 1, cuatro);
//    //lcm.agregaLienzo(1+lcm.getAncho(), 1, dos);
//    //System.out.println(lcm);
//    //System.out.println(lcm);

    Reloj reloj= new Reloj();
    reloj.setHoraExacta(false);
    reloj.update();
    System.out.println(reloj);

    }
    
    public static String leerArchivo(String ruta){
        String contenido="";
        File file= new File(ruta);
        if(file.exists()){
            try {
                FileReader fileReader= new FileReader(file); 
                BufferedReader reader= new BufferedReader(fileReader);
                contenido=reader.readLine()+System.lineSeparator();
                String linea="";
                while((linea=reader.readLine())!=null){
                    contenido+=linea;
                    contenido+=System.lineSeparator();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
           
        }
        
        return contenido;
    }
    
}
