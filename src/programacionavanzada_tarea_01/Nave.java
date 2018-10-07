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
        this.importaString(s);
   
    }
    
    
    public void importaString(String c){
        char [] sc=c.toCharArray();
        int maxAlto =this.getAlto()-2;
        int maxAncho=this.getAncho()-1;
        int x=0, y=maxAlto;
        for(int i=0;i<sc.length;i++){
            if(sc[i]=='\n'){
                x=0;
                y--;
            }
            else
                x++;
            if(x<maxAncho && sc[i]!='\n')
                this.setPen(x, y,sc[i]);
        }
            
    }
    
   
}
