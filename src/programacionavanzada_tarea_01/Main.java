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
 * @author Ismael López Martínez
 * Tarea 1 Programación Avanzada MCA
 * 10-10-2018
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    // TODO code application logic here
        Reloj miReloj = new Reloj();
        miReloj.setHoraExacta(false);
        System.out.println(miReloj);
        
        Reloj miOtroReloj = new RelojDigital();
        miOtroReloj.setHoraExacta(true);
        System.out.println(miOtroReloj);
        
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
