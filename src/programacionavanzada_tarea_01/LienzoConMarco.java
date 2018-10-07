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
public class LienzoConMarco extends Lienzo {
     
   public LienzoConMarco(){
       super();
       this.dibujaMarco();
       

   }
   
   @Override
   public void clear(){
       super.clear();
       this.dibujaMarco();
   }
   
   public LienzoConMarco(int ancho, int alto){
       super(ancho,alto);
       this.dibujaMarco();
   }
   
   public void dibujaMarco(){
       int ancho=this.getAncho();
       int alto=this.getAlto();
       //linea de abajo
       this.dibujaLinea(0, 0, ancho-1, 0,'.');
       //linea de arriba
       this.dibujaLinea(0, alto-1, ancho-1, alto-1, '.');
       this.dibujaLinea(0, 0, 0, alto-1, '|');
       this.dibujaLinea(ancho-1, 0, ancho-1, alto-1, '|');

   }
    
}
