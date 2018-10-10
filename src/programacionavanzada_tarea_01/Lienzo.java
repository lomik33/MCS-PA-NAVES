/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programacionavanzada_tarea_01;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Lienzo {

    /***
     * Retorna el ancho del lienzo
     * @return 
     */
    public int getAncho() {
        return ancho;
    }
    /***
     * Retorno el alto del lienzo
     * @return 
     */
    public int getAlto() {
        return alto;
    }

//    Atributos de la clase
    public char[][] getLienzo() {
        return lienzo;
    }
    private int ancho;
    private int alto;
    private char [][] lienzo;
    
    
// Constructores
    /***
     * Construye un lienzo por defecto de 80 caracteres de ancho por 80 caracteres de alto
     */
    public Lienzo() {
        //this(200, 200);
        this(80, 80);
        
    }
    /***
     * Construye un lienzo de tamaño ancho x alto
     * @param ancho
     * @param alto 
     */
    public Lienzo(int ancho, int alto){
        this.ancho=ancho;
        this.alto=alto;
        lienzo = new char[ancho][alto];
        for(int i = 0; i < ancho; i++) {
            for(int j = 0; j < alto; j++) {
                lienzo[i][j]=' ';
            }
        }
    }
    
    
/***
 Pone en una posicion del lienzo y escribe un caracter 
     * @param x
     * @param y
     * @param c
 */ 
    public  void setPen(int x, int y, char c) {
       // Coloca el caracter c en la posición x,y
       lienzo[x][y]=c;
    }
    
    
    /***
    **Dibuja el lienzo en la consola
     */
    
    public void paint() {
       
     for(int y=alto-1;y>=0;y--) {
         for(int x=0;x<ancho;x++)
             System.out.print(lienzo[x][y]);
         System.out.println();

     }    
    }
             
     
     /**
      * Dibuja la pendiente en una línea
      * @param x1
      * @param y1
      * @param x2
      * @param y2
      * @param c 
      */
    public void dibujaLinea(int x1, int y1, int x2, int y2, char c){

        int xswap=x1;
        int yswap=y1;
        if(x1>x2){
            x1=x2;
            x2=xswap;
            y1=y2;
            y2=yswap;
        }
        if(y1>y2){
            y1=y2;
            y2=yswap;
            x1=x2;
            x2=xswap;
            
        }
        //System.out.printf("Trazando linea: x1: %s y1: %s x2: %s y2: %s%s",x1,y1,x2,y2,System.lineSeparator());

        if(x1==x2){
            for(int y=y1;y<=y2;y++)
                   setPen(x1,y,c);
     
        }else{
        
            
        //Pendiente m
        double m=(double)(y2-y1)/(x2-x1);
        //System.out.println(m);
        for(int x=x1;x<=x2;x++){
           double xy=m*(x-x1)+y1;
           //System.out.println(xy);
           setPen(x,(int)Math.round(xy),c);
        }
    }
   }
    /***
     * Dibuja circulo 
     * @param x1
     * @param y1
     * @param r
     * @param c 
     */
    
    public void dibujaCirculo(int x1, int y1, int r, char c){
        
        double dos_pi=Math.PI*2;
        
        for(double t=0; t<=dos_pi;t+=.01){
           double x=x1+r*Math.cos(t);
           double y=y1+r*Math.sin(t);
           this.setPen((int)x,(int)y,c);
        }
    }
    
    /***
     * Dibuja un circulo que pasa por el centro de una recta
     * @param x1
     * @param y1
     * @param x2
     * @param y2
     * @param c 
     */
    
    public void dibujaCirculo(int x1, int y1, int x2, int y2, char c){
        
         double xc=((double)x2+x1)/2;
         double yc=((double)y2+y1)/2;
         this.dibujaCirculo((int)xc,(int)yc,x1-(int)xc,c);
    }
    
    /***
     * Dibuja una linea en base a una distancia y un angulo
     * @param x1
     * @param y1
     * @param d
     * @param a
     * @param c 
     */
      public void dibujaLinea(int x1, int y1, double d, double a, char c){
          
          //double m=(double)(y2-y1)/(x2-x1);
          //Se calcula en base a la distancia en linea recta
          //int x2=x1+d;
          //pendiente de cualquier recta es lo mismo que la tangente del angulo que se forma en la recta
          //double m=Math.tan(a);
          //(y-y1)=m(x-x1)
          //double y2=m*(x1-x2);
          /*
          double pa=d*Math.cos(Math.toRadians(a));
          double pb=d*Math.sin(Math.toRadians(a));
          double x2=x1+Math.abs(pa);
          double y2=x2+Math.abs(pb);*/
          
          //this.setPen((int)x1,(int)y1,c);
          double x2=0;
          double y2=0;
          for(double t=0; t<=a;t+=.01){
            x2=x1+d*Math.cos(Math.toRadians(t));
            y2=y1+d*Math.sin(Math.toRadians(t));
         }
         //System.out.printf("x1: %s y1: %s x2: %s y2: %s%s",x1,y1,x2,y2,System.lineSeparator());
         this.dibujaLinea(x1,y1,(int)Math.round(x2),(int)Math.round(y2),c);
      }
      
      
      /***
       *Dibuja un sector de un circulo en base a un angulo inical y uno final 
       * @param x1
       * @param y1
       * @param radio
       * @param anguloInicial
       * @param anguloFinal
       * @param c 
       */
    public void dibujaSector(int x1,int y1, int radio, int anguloInicial, int anguloFinal ,char c){

        this.setPen((int)x1,(int)y1,c);
        for(double t=anguloInicial; t<=anguloFinal;t+=.01){
           double x=x1+radio*Math.cos(Math.toRadians(t));
           double y=y1+radio*Math.sin(Math.toRadians(t));
           this.setPen((int)x,(int)y,c);
        }
        
        
        
    }    
    
    @Override
        public String toString(){
            String r="";
            for(int y=alto-1;y>=0;y--) {
                for(int x=0;x<ancho;x++)
                    r+=lienzo[x][y];//Concatenar carecteres de la matriz
               r+="\r\n";
              }
            return r;
        }
        
  
   
   /***
    Genera un lienzo a partir de un arreglo de cadenas 
    * El lienzo tiene como ancho, el ancho de la cadena más grande 
    * El lienzo tiene de alto, el número de cadenas presente en el arreglo 
    * Uso String [] strImagen = { " ,-,", "/.(", "\\ {", " `-`" }; 
    * Lienzo luna = Lienzo.LienzoFactory(strImagen);
    * @param str
    * @return 
    */
   public static Lienzo lienzoFactory(String[] str){
      int alto=str.length;
      int ancho=0;
      for(String s:str){
          if(s.length()>ancho)
              ancho=s.length();
      }
       Lienzo lienzo=new Lienzo(ancho,alto); 
       int maxAlto =alto-1;
       int x=0,  y=maxAlto;
       for(String s:str){
           lienzo.setTexto(x, y, s);  
           x=0;   y--; 
       }
       return lienzo;
   }
   
   /***
    * Coloca una cadena etiqueta en la posición (x, y) 
     * @param x
     * @param y
     * @param c
    */
   public void setTexto(int x, int y,String c){
        char [] sc=c.toCharArray();
      
        int maxAncho=this.getAncho()-1;
        int maxAlto=this.getAlto()-1;
        //int x=0, y=maxAlto;
        for(int i=0;i<sc.length;i++){          
            if(x+i<=maxAncho&&y<=maxAlto)
                this.setPen(x+i, y,sc[i]);
        }
            
    }
   /***
    * Borra el contenido del lienzo
    */
   public void clear(){
       for(int y=0;y<this.alto;y++) 
                for(int x=0;x<ancho;x++)
                    this.setPen(x, y, ' ');
      
            
   }
   
  /***
   * Cambia el tamaño del lienzo Si se cambia a un tamaño más chico, el lienzo trunca caracteres sobrantes 
   * Si se cambia a un tamaño más grande, el lienzo tiene espacio vacios solamente
     * @param ancho
     * @param alto
   */
   
   public void resize(int ancho, int alto){
          char[][] nuevoLienzo = new char[ancho][alto];
           for(int i = 0; i < ancho; i++) {
            for(int j = 0; j < alto; j++) {
                nuevoLienzo[i][j]=' ';
            }
        }
          for(int ix=0;ix<this.getAncho();ix++){  
                for(int iy=0;iy<this.getAlto();iy++){
                    if(!(ix>=ancho||iy>=alto))
                        nuevoLienzo[ix][iy]=this.lienzo[ix][iy];
                }
          }
          this.alto=alto;
          this.ancho=ancho;
          lienzo=nuevoLienzo;
                
   }
   
   /***
    * Agrega un lienzo la en la posición x, y 
    * Nota importante: El lienzo la tiene su posicion (0,0) en la posición (x,y) del lienzo anfitrión (del que recibe)
    * @param x
    * @param y
    * @param la 
    */
    public void agregaLienzo(int x, int y, Lienzo la) {
        /*Si es mayor el tamaño entonces lo ajusto*/
        int xtotal = x + la.getAncho();
        int ytotal = y + la.getAlto();
        if (ytotal > this.getAlto() || xtotal > this.getAncho()) {
            resize(xtotal, ytotal);
        }

        for (int ix = 0; ix < la.getAncho(); ix++) {
            for (int iy = 0; iy < la.getAlto(); iy++) {
                this.lienzo[x + ix][y + iy] = la.getLienzo()[ix][iy];
            }
        }

        //System.out.printf("Se agrego al lienzo de tamaño: %dx%d un lienzo de %dx%d %s", this.getAncho(), this.getAlto(), la.getAncho(), la.getAlto(), System.lineSeparator());

    }
    
    
    /**
     * Utilitario para leer un archivo y regresar el contenido en una cadena de texto a partir de una ruta
     * @param ruta
     * @return 
     */
    public static String leerArchivo(String ruta){
        String contenido="";
        File file= new File(ruta);
        if(file.exists()){
            try {
                FileReader fileReader= new FileReader(file); 
                BufferedReader reader= new BufferedReader(fileReader);
                contenido=reader.readLine()+System.lineSeparator();
                String linea="";
                while((linea=reader.readLine())!=null){
                    contenido+=linea;
                    contenido+=System.lineSeparator();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
           
        }
        
        return contenido;
    }
    
    /***
     * Obtiene el caracter del lienzo en la posición x, y Si el caracter x, y esta fuera del lienzo retorna 0
     * @param x
     * @param y
     * @return 
     */
    public char getPen(int x, int y) {
            return lienzo[x][y];
        }
}