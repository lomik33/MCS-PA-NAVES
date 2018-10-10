/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programacionavanzada_tarea_01;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Ismael López Martínez
 */
public class Reloj extends Lienzo {
    
    private static final float dosPi = (float)(2.0 * Math.PI);
    private static final float tresPi = (float)(3.0 * Math.PI);
    private static final float rad = (float)(Math.PI / 30.0);
    
    private int hora;
    private boolean horaExacta;
    private int minutos;
    private int segundos;

    /***
     * Dibuja un reloj analógico en un lienzo con dos tipos de funciones La hora actual Una hora ficticia
     El constructor por defecto inicializa la hora de prueba a las 12:30:45 El tamaño del lienzo depende de reloj que se dibuje
     */
    public Reloj(){
        super();
        this.hora=12;
        this.minutos=30;
        this.segundos=45;
        
    }
    
     /***
      * Obtiene la hora del objeto.
      * @return 
      */
    public int getHora() {
        return hora;
    }

    /***
      * Indica el estatus actual de horaExacta
      * @return 
      */
    public boolean isHoraExacta() {
        return horaExacta;
    }

    /***
      * Obtiene los minutos del objeto.
      * @return 
      */
    public int getMinutos() {
        return minutos;
    }
    
    /***
      * Obtiene los segundos del objeto.
      * @return 
      */

    public int getSegundos() {
        return segundos;
    }
    
//   /***
//    * Reescritura del metodo paint que representa la hora en la consola
//    */ 
//    @Override
//    public void paint(){
//        
//    }
    /***
     * Indica si la hora que dará el reloj será la hora del sistema si es verdadero o la hora de prueba si es falso
     * @param horaExacta 
     */
    public void setHoraExacta(boolean horaExacta){
        this.horaExacta=horaExacta;
        if(horaExacta){
            	LocalDateTime now = LocalDateTime.now();
                this.hora=Integer.parseInt(now.format(DateTimeFormatter.ofPattern("hh")));
                this.minutos=now.getMinute();
                this.segundos=now.getSecond();
        }else{
            this.hora=12;
            this.minutos=30;
            this.segundos=45;
        }
    }
    
    @Override
    public void paint(){
        this.update();
        super.paint();
    }
    /***
     * Actualiza los gráficos que generan al reloj 
     * Primero borra todo el contenido del lienzo 
     * Posteriormente renderiza el reloj obteniendo la hora, minuto y segundo con los métodos getHora(), getMinutos(), getSegundos()
     */
    public void update(){
        this.clear();
        int x=this.getAncho()/2;
        int y=this.getAlto()/2;
        this.dibujaCirculo(x, y, 20,'I');
        double gradosHora=getGradosHora(this.hora);
        this.dibujaLinea(40, 40,10 , gradosHora,'h');
        //System.out.println("hora"+ hora+ "grados "+gradosHora);        
        double gradosMinuto=getGradosMinutoSegundo(this.minutos);
        //System.out.println("minutos"+ minutos+ "grados "+gradosMinuto);
        this.dibujaLinea(40, 40,15 , gradosMinuto,'m');
        double gradosSegundo=getGradosMinutoSegundo(this.segundos);
        this.dibujaLinea(40, 40,15 , gradosSegundo,'s');
        //System.out.println("segundos"+ segundos+ "grados "+gradosSegundo);
        
       // this.dibujaLinea(40, 40,15 , gradosHora '.');
       
    }
    
    @Override
    public String toString(){
        this.update();
        return super.toString();
    }
    
   /***
    * Utilitario para saber los grados de hora
    *
    */ 
    private int getGradosHora(int xhora){        
        int centinela=0;
        int hi=3;
        while(hi!=xhora)
        {   hi--; 
            if(hi==0)
                hi=12;
            centinela+=30;            
        }
        return centinela;
    }
    
     /***
    * Utilitario para saber los grados de min
    *
    */ 
    private int getGradosMinutoSegundo(int ms){        
        int centinela=0;
        int hi=15;
        while(hi!=ms)
        {   hi--; 
            if(hi==0)
                hi=60;
            centinela+=6;            
        }
        return centinela;
    }
    

    
}
