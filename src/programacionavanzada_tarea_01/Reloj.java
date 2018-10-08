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
                this.hora=now.getHour();
                this.minutos=now.getMinute();
                this.segundos=now.getSecond();
        }else{
            this.hora=12;
            this.minutos=30;
            this.segundos=45;
        }
    }
    
//    @Override
//    public String toString(){
//        return "";
//    }
    /***
     * Actualiza los gráficos que generan al reloj 
     * Primero borra todo el contenido del lienzo 
     * Posteriormente renderiza el reloj obteniendo la hora, minuto y segundo con los métodos getHora(), getMinutos(), getSegundos()
     */
    public void update(){
        this.clear();
        
        
    }
}
