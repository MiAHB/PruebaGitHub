/**
 *
 * @author Rafael Pérez
 * DESARROLLO DE APLICACIONES MULTIPLATAFORMAS
 * COLEGIO STMA TRINIDAD DE SALAMANCA
 */
package FRAMEWORK.LOGICA;

import FRAMEWORK.GRAFICOS.BitMap;
import FRAMEWORK.GRAFICOS.Sprite;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;

public abstract class Actor{ 
    protected static long AMILISEGUNDOS=1000000L;
    protected long tickTime=0;
    protected long TICK=10*AMILISEGUNDOS;
    protected int x,y,dx,dy;
    private Sprite sprite;
    
    protected boolean activo=true;
    protected boolean visible=true; 
    
    protected int vida;
    protected int puntos;
   
    private Game game;
  
    
    public Actor(Game game){//Para cadenas de texto
        this.game=game;
    }
    
    public Actor(Game game, BitMap bitMap){
        this.game=game;
        sprite=new Sprite(bitMap);
    }
    
    public Rectangle getBounds(){
        return new Rectangle(this.x,this.y, this.getWidth(), this.getHeight());
    }
    
    public void setPuntos(int puntos){
        this.puntos=puntos;
    }
    public int getPuntos(){
        return puntos;
    }
    public void setVida(int vida){
        this.vida=vida;
    }
    public int getVida(){
        return vida;
    }
    public void setActivo(boolean activo){
        this.activo=activo;
    }
    public boolean isActivo(){
        return activo;
    }
    public void setVisible(boolean visible){
        this.visible=visible;
    }
    public boolean isVisible(){
        return visible;
    }
    
    public void setPosition(int x, int y) {this.x=x; this.y=y;}

    public void addX(int c) { this.x += c;}
    public void addY(int c) { this.y += c;}   

    public void setDx(int valor){dx=valor;}
    public void setDy(int valor){dy=valor;} 
    public int getDx(){return dx;}
    public int getDy(){return dy;}
    
    public int getX() {return x;}
    public int getY() {return y;}
            
    public abstract void actualizar(long deltaTime);
    
    public  void dibujar(Graphics g){
        if (sprite==null) return;//caso cadena de texto
        if (visible){
            sprite.setPosition(x, y);
            sprite.dibujar(g);
        }    
    }
    
    public int getWidth() {
        return sprite.getWidth();
    }
    public int getHeight() {
        return sprite.getHeight();
    }
    
    public abstract void recibirGolpe(Actor actor);//el que golpea
    
    public Actor golpear(){
        //actor-->el que choca; return-->con el que choca
        Actor actorGolpeado=null,otroActor;
        Actor actorQueGopea=this;
        int n=game.actorManager.numeroActores();
        ArrayList<Actor> lista=game.actorManager.getListaActores();
        //0 es el escenario
        for (int i=0;i<lista.size();i++){          
            otroActor=lista.get(i);
            if (actorQueGopea==otroActor) continue;
            if (actorQueGopea.activo && otroActor.activo){
                if (CollisionManager.colision(actorQueGopea,otroActor)) {
                    actorGolpeado=otroActor;
                    actorGolpeado.recibirGolpe(actorQueGopea);
                }
            }
        }//fin fori  
        return actorGolpeado;//devuelve referencia con el que choca
     }
    public Game getGame(){
        return game;
    }
}