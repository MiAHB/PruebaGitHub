/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package arkanoid;

import FRAMEWORK.GRAFICOS.BitMap;
import FRAMEWORK.LOGICA.Actor;
import FRAMEWORK.LOGICA.Game;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

public class Barra extends Actor{

    private Mundo mundo;
    
    public Barra(Mundo mundo, BitMap bitMap) {
        super(mundo, bitMap);
        this.mundo=mundo;
        
    }
    
    public Rectangle getBounds(){
        return new Rectangle(this.x+5,this.y+3, this.getWidth()-10, this.getHeight()-8);
    }
    
    public Rectangle getBoundsIzquierda(){
        return new Rectangle(this.x+5,this.y+3, (this.getWidth()-10)/2, this.getHeight()-8);
    }
    public Rectangle getBoundsDerecha(){
        return new Rectangle((this.getWidth()-10)/2, this.y+3, (this.getWidth()-10)/2, this.getHeight()-8);
    }
    
    public void reiniciarBarra(){
        
        x=mundo.SCREEN_WIDTH/2-this.getWidth()/2;
        y=mundo.SCREEN_HEIGHT-mundo.SCREEN_HEIGHT/5;
        
    }

    @Override
    public void actualizar(long deltaTime) {
        int tecla;
        if (mundo.getKeyBoardHandler().isPulsada()){
                tecla=mundo.getKeyBoardHandler().getTecla();
                if (tecla==KeyEvent.VK_LEFT){
                    System.out.println("has pulsado ir a la izda");
                    
                    moverIzda();
                }
                if (tecla==KeyEvent.VK_RIGHT){
                    System.out.println("has pulsado ir a la DCHA");

                    moverDcha();
                }
                if (tecla==KeyEvent.VK_ESCAPE){
                    mundo.terminarJuego();
                }

            }
            
        golpear();
        
    }
    
    public void moverIzda(){
        if(x>0){
            this.x-=20;
        }
        else{
            this.x=0;
        }
    }
    
    public void moverDcha(){
        if(x<mundo.SCREEN_WIDTH-this.getWidth()){
            this.x+=20;
        }
        else{
            this.x=mundo.SCREEN_WIDTH-this.getWidth();
        }
    }

    @Override
    public void recibirGolpe(Actor actor) {
        
    }
    
}
