/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programacionavanzada_tarea_01;

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
           setPen(x,(int)xy,c);
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
          
          double pa=d*Math.cos(Math.toRadians(a));
          double pb=d*Math.sin(Math.toRadians(a));
          double x2=x1+Math.abs(pa);
          double y2=x2+Math.abs(pb);
          this.dibujaLinea(x1,y1,(int)x2,(int)y2,c);
          
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
    Genera un lienzo a partir de un arreglo de cadenas El lienzo tiene como ancho, el ancho de la cadena más grande 
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
          if(str.length>ancho)
              ancho=ancho;
      }
       Lienzo lienzo=new Lienzo(ancho,alto); 
       int maxAlto =alto-2;
        int maxAncho=ancho-1;
        int x=0,  y=maxAlto;
      for(String s:str){
           char [] sc=s.toCharArray();
            x=0;
            y--;       
         lienzo.setTexto(x, y, s);
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
        int maxAlto =this.getAlto()-2;
        int maxAncho=this.getAncho()-1;
        //int x=0, y=maxAlto;
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
   /***
    * Borra el contenido del lienzo
    */
   public void clear(){
       for(int y=0-1;y<this.alto-1;y++) 
                for(int x=0;x<ancho;x++)
                    this.setPen(x, y, ' ');
      
            
   }
   
  /***
   * Cambia el tamaño del lienzo Si se cambia a un tamaño más chico, el lienzo trunca caracteres sobrantes 
   * Si se cambia a un tamaño más grande, el lienzo tiene espacio vacios solamente
   */
   
   public void resize(){
       
   }
   
   /***
    * Agrega un lienzo la en la posición x, y 
    * Nota importante: El lienzo la tiene su posicion (0,0) en la posición (x,y) del lienzo anfitrión (del que recibe)
    * @param x
    * @param y
    * @param la 
    */
   public void agregaLienzo(int x,
                         int y,
                         Lienzo la){
       
   }
}