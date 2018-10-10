/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programacionavanzada_tarea_01;

/**
 *La clase espacio representa una escena espacial de un tamaño 100, 100 
 * La escena depende del autor pero incluye a la tierra y objetos iniciales.
 * @author Ismael López Martínez
 */
public class Espacio extends Lienzo {
    
    private Nave miNave;
    private Lienzo tierra;
    
    public Espacio(Nave miNave){
        super(100,100);  
        tierra= new Tierra(); 
        this.estadoInicial();
        this.agregaNave(miNave);     
        
    }
    
    
    
    /***
   * Agrega o actualiza la nave que está en el espacio y la dibuja en la posición 0,0 del espacio 
     * @param miNave
   */
   public void agregaNave(Nave miNave){
       this.estadoInicial();    
       this.miNave=miNave;
       this.agregaLienzo(0, 0, miNave); 
       
   }
   
   /***
    *  Regresa la nave que actualmente está en el espacio  
     * @return 
   */

    public Nave getMiNave() {
        return miNave;
    }
   
   /***
    * Dibuja la escena espacial sin la nave.
    */
   public void estadoInicial(){
       this.clear();
       this.agregaLienzo(40, 40, tierra);            
       
   }
   
   /***
    * Mueve la nave actual a la posición x, y
    * @param x
    * @param y 
    */
   public void mueveNave(int x, int y){
    this.estadoInicial();
        /*Si es mayor el tamaño entonces lo ajusto*/
        int xtotal = x + miNave.getAncho();
        int ytotal = y + miNave.getAlto();
        if (ytotal > this.getAlto() || xtotal > this.getAncho()) {
            resize(xtotal, ytotal);
        }
        
       for(int x1=0;x1<miNave.getAncho();x1++)
        for(int y1=0;y1<miNave.getAlto();y1++)
             //this.getLienzo()[x1+x][y1+y]=miNave.getLienzo()[x1][y1];
            this.setPen(x1+x,y1+y,miNave.getPen(x1,y1));
   }
   
    
}
