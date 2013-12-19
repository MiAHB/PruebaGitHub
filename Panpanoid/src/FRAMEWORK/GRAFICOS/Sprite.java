/**
 *
 * @author Rafael Pérez
 * DESARROLLO DE APLICACIONES MULTIPLATAFORMAS
 * COLEGIO STMA TRINIDAD DE SALAMANCA
 */
package FRAMEWORK.GRAFICOS;

import java.awt.Graphics;

public class Sprite{
    private int x, y;//posicion del sprite en pantalla
    private int width,height;
    private BitMap bitMap;
    
    public Sprite(BitMap bitMap){        
        this.bitMap=bitMap;
        width = bitMap.getWidth();
        height = bitMap.getHeight();
    } 
    public void dibujar(Graphics g){
         g.drawImage(bitMap.getImage(), x, y, null);
    }
    
    public void setPosition(int x, int y){
        this.x = x; this.y = y;  
    }
    
    public void setX(int x) { this.x = x;}
    public void setY(int y) { this.y = y;}
    public int getX(){ return x;}
    public int getY(){ return y;}
    public int getWidth() { return width;}
    public int getHeight() { return height;}
   
}
