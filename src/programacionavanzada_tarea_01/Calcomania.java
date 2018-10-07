/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programacionavanzada_tarea_01;

/**
 *
 * @author Ismael López Martínez
 * ejemplos de polimorfismo
 */
public class Calcomania extends Lienzo {
    
    public Calcomania(){
        super(110,110);
    }
    
    public Calcomania(int ancho, int alto){
        super(ancho,alto);
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

 class Tortuga extends Calcomania{

      public Tortuga(){
         super();
         String t= "  _____     ____\n" +
                   " /      \\  |  o | \n" +
                   "|        |/ ___\\| \n" +
                   "|_________/     \n" +
                   "|_|_| |_|_|";
         super.importaString(t);
     }
      
      
}

class Simbolo extends Calcomania{

      public Simbolo(){
         super();
         String p="        .-|-.\n" +
                  "       /  |  \\  \n" +
                  "      /  /|\\  ;\n" +
                  "       \\/ | \\/\n" +
                  "        '---'";
                 super.importaString(p);

     }
      
     
 
}

class Perro extends Calcomania{

      public Perro(){
         super();
         
        String p= "^..^____/\n" +
                  " -. ___ )\n" +
                  "  ||  ||";
        super.importaString(p);
      }
      
      
}

