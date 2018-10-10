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
public class Nave extends LienzoConMarco {
    
    /***
     * Genera la vane de un tamaño personalizado por el usuario
     * @param ancho
     * @param alto 
     */
    protected Nave(int ancho, int alto){
        super(ancho,alto);
    }
    
   /***
    *  Genera la nave de un tamaño adecuado (20,32)
    */
     public Nave(){
        super(20,32);
        String s=
"       !\n" +
"       !\n" +
"       ^\n" +
"      / \\\n" +
"     /___\\\n" +
"    |=   =|\n" +
"    |     |\n" +
"    |     |\n" +
"    |     |\n" +
"    |     |\n" +
"    |     |\n" +
"    |     |\n" +
"    |     |\n" +
"    |     |\n" +
"    |     |\n" +
"   /|##!##|\\\n" +
"  / |##!##| \\\n" +
" /  |##!##|  \\\n" +
"|  / ^ | ^ \\  |\n" +
"| /  ( | )  \\ |\n" +
"|/   ( | )   \\|\n" +
"    ((   ))\n" +
"   ((  :  ))\n" +
"   ((  :  ))\n" +
"    ((   ))\n" +
"     (( ))\n" +
"      ( )\n" +
"       .\n" +
"       .\n" +
"       .\n";
       int y=this.getAlto()-2;;
        for(String texto:s.split("\n")){
            this.setTexto(1,y,texto);
            y--;
        }
   
    }
    
    
   
}
