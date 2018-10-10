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
public class Tierra extends Lienzo {
    
    public Tierra(){
        super(38,20);
        String tierra="               ____\n" +
"          .-'\"\"p 8o\"\"`-.\n" +
"       .-'8888P'Y.`Y[ ' `-.\n" +
"     ,']88888b.J8oo_      '`.\n" +
"   ,' ,88888888888[\"        Y`.\n" +
"  /   8888888888P            Y8\\\n" +
" /    Y8888888P'             ]88\\\n" +
":     `Y88'   P              `888:\n" +
":       Y8.oP '- >            Y88:\n" +
"|          `Yb  __             `'|\n" +
":            `'d8888bo.          :\n" +
":             d88888888ooo.      ;\n" +
" \\            Y88888888888P     /\n" +
"  \\            `Y88888888P     /\n" +
"   `.            d88888P'    ,'\n" +
"     `.          888PP'    ,'\n" +
"       `-.      d8P'    ,-'   \n" +
"          `-.,,_'__,,.-'";
        
       int y=this.getAlto()-2;;
        for(String texto:tierra.split("\n")){
            this.setTexto(1,y,texto);
            y--;
        }
    }
}
