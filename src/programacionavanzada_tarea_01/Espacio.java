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
public class Espacio extends LienzoConMarco {
    
    private Nave miNave;
    
    public Espacio(Nave miNave){
        super(100,80);
        this.agregaNave(miNave);
    }
    
    
    
    /***
   * Agrega una calcomania al lienzo.
   * @param x
   * @param y
   * @param c 
   */
   public void agregaNave(Nave c){
       
        this.miNave=c;
        this.estadoInicial();
   }

    public Nave getMiNae() {
        return miNave;
    }
   
   
   public void estadoInicial(){
       this.clear();
       mueveNave(1,1);
   }
   
   public void mueveNave(int x, int y){
    
       for(int x1=0;x1<miNave.getAncho();x1++)
        for(int y1=0;y1<miNave.getAlto();y1++)
             this.getLienzo()[x1+x][y1+y]=miNave.getLienzo()[x1][y1];
   }
   
    
}
