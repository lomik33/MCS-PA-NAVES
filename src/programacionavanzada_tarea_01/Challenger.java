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
public class Challenger extends Nave {
    
    /***
     * Genera otra nave y utiliza un tamaño adecuado contenerla
     */
    public Challenger(){
        super(24,24);
         String s="      (=========)\n" +
"      |=========|\n" +
"      |====_====|\n" +
"      |== / \\ ==|\n" +
"      |= / _ \\ =|\n" +
"   _  |=| ( ) |=|\n" +
"  /=\\ |=|     |=| /=\\\n" +
"  |=| |=| USA |=| |=|\n" +
"  |=| |=|  _  |=| |=|\n" +
"  |=| |=| | | |=| |=|\n" +
"  |=| |=| | | |=| |=|\n" +
"  |=| |=| | | |=| |=|\n" +
"  |=| |/  | |  \\| |=|\n" +
"  |=|/    | |    \\|=|\n" +
"  |=/NASA |_| NASA\\=|\n" +
"  |(_______________)|\n" +
"  |=| |_|__|__|_| |=|\n" +
"  |=|   ( ) ( )   |=|\n" +
" /===\\           /===\\\n" +
"|||||||         |||||||\n" +
"-------         -------\n" +
" (~~~)           (~~~)\n";
       int y=this.getAlto()-2;;
        for(String texto:s.split("\n")){
            this.setTexto(1,y,texto);
            y--;
        }
    }
    
    
}
