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

/**
 *
 * @author Diego
 */
public class Bloque extends Actor{

    private Mundo mundo;
    int desplazamiento=10;
    
    private final int ANCHO_LATERAL=10;
    
    public Bloque(Mundo mundo, BitMap bitmap) {
        super(mundo, bitmap);
        this.mundo=mundo;
        
    }
    
    public Rectangle getBoundsArriba(){
        return new Rectangle(this.x+ANCHO_LATERAL,this.y, this.getWidth()-2*ANCHO_LATERAL, this.getHeight()/2);
    }
    public Rectangle getBoundsAbajo(){
        return new Rectangle(this.x+ANCHO_LATERAL,this.y+this.getHeight()/2, this.getWidth()-2*ANCHO_LATERAL, this.getHeight()/2);
    }
    public Rectangle getBoundsIzquierda(){
        return new Rectangle(this.x,this.y, ANCHO_LATERAL, this.getHeight());
    }
    public Rectangle getBoundsDerecha(){
        return new Rectangle(this.getWidth()-ANCHO_LATERAL,this.y, ANCHO_LATERAL, this.getHeight());
    }
    
    
    public void iniciar(int x, int y){
        this.x=x;
        this.y=y;
    }

    @Override
    public void actualizar(long deltaTime) {
        this.golpear();
        
    }

    @Override
    public void recibirGolpe(Actor actor) {
       
    }
    
}
