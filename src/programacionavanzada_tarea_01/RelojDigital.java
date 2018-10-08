/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programacionavanzada_tarea_01;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author Ismael López Martínez
 */
public class RelojDigital extends Reloj {
 
    private Lienzo[] numeros;
    private Lienzo dosPuntos;
    
    /***
     * Este constructor modifica su tamaño con el método resize para que el reloj digital sea de un tamaño adecuado para la representación.
     */
    public RelojDigital(){
        super();
        numeros= new Lienzo[10];
        Path currentRelativePath = Paths.get("");
         String ruta = currentRelativePath.toAbsolutePath().toString()
            +File.separator
            +"src"
            +File.separator
            +"numeros"
            +File.separator ;
            numeros[0]=Lienzo.lienzoFactory(Main.leerArchivo(ruta+"0.txt").split(System.lineSeparator()));
            numeros[1]=Lienzo.lienzoFactory(Main.leerArchivo(ruta+"1.txt").split(System.lineSeparator()));
            numeros[2]=Lienzo.lienzoFactory(Main.leerArchivo(ruta+"2.txt").split(System.lineSeparator()));
            numeros[3]=Lienzo.lienzoFactory(Main.leerArchivo(ruta+"3.txt").split(System.lineSeparator()));
            numeros[4]=Lienzo.lienzoFactory(Main.leerArchivo(ruta+"4.txt").split(System.lineSeparator()));
            numeros[5]=Lienzo.lienzoFactory(Main.leerArchivo(ruta+"5.txt").split(System.lineSeparator()));
            numeros[6]=Lienzo.lienzoFactory(Main.leerArchivo(ruta+"6.txt").split(System.lineSeparator()));
            numeros[7]=Lienzo.lienzoFactory(Main.leerArchivo(ruta+"7.txt").split(System.lineSeparator()));
            numeros[8]=Lienzo.lienzoFactory(Main.leerArchivo(ruta+"8.txt").split(System.lineSeparator()));
            numeros[9]=Lienzo.lienzoFactory(Main.leerArchivo(ruta+"9.txt").split(System.lineSeparator()));
            dosPuntos=Lienzo.lienzoFactory(Main.leerArchivo(ruta+"dosPuntos.txt").split(System.lineSeparator()));
   
   
    }
    /***
     * Actualiza los gráficos que generan al reloj 
     * Primero borra todo el contenido del lienzo 
     * Posteriormente renderiza el reloj obteniendo la hora, minuto y segundo con los métodos getHora(), getMinutos(), getSegundos()
     */
    @Override
    public void update(){
       this.clear();
       char[] horaStr=Integer.toString( this.getHora()).toCharArray();
       char[] minutosStr=Integer.toString( this.getMinutos()).toCharArray();
       char[] segundosStr=Integer.toString( this.getSegundos()).toCharArray();
       int x=0;
       for(Character h :horaStr ){
           //es el lienzo que le corresponde segun la hora que tenga actual
           Lienzo numero=numeros[Integer.parseInt(h.toString())];
           this.agregaLienzo(x, 1, numero );
           x+=numero.getAncho();
       }
       this.agregaLienzo(x, 1, dosPuntos );
       x+=dosPuntos.getAncho();
       for(Character m :minutosStr ){
           //es el lienzo que le corresponde segun la hora que tenga actual
           Lienzo numero=numeros[Integer.parseInt(m.toString())];
           this.agregaLienzo(x, 1, numero );
           x+=numero.getAncho();
       }
       this.agregaLienzo(x, 1, dosPuntos );
       x+=dosPuntos.getAncho();
       for(Character s :segundosStr ){
           //es el lienzo que le corresponde segun la hora que tenga actual
           Lienzo numero=numeros[Integer.parseInt(s.toString())];
           this.agregaLienzo(x, 1, numero );
           x+=numero.getAncho();
       }
    }
}
