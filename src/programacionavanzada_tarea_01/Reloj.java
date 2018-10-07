/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programacionavanzada_tarea_01;

/**
 *
 * @author Ismael López Martínez
 */
public class Reloj extends Calcomania {
    
    
    private int hora;
    private boolean horaExacta;
    private int minutos;
    private int segundos;

    public Reloj(){
        
    }
    
    public int getHora() {
        return hora;
    }

    public boolean isHoraExacta() {
        return horaExacta;
    }

    public int getMinutos() {
        return minutos;
    }

    public int getSegundos() {
        return segundos;
    }
    
    
    
    @Override
    public void paint(){
        
    }
    
    public void setHoraExacta(boolean horaExacta){
        this.horaExacta=horaExacta;
    }
    
    @Override
    public String toString(){
        return "";
    }
    
    public void update(){
        
    }
}
