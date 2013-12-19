/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package arkanoid;

import FRAMEWORK.GRAFICOS.BitMap;
import FRAMEWORK.LOGICA.Actor;
import java.awt.Rectangle;
import java.util.ArrayList;

/**
 *
 * @author Diego
 */
public class Bola extends Actor {

    private Mundo mundo;
    private Barra barra;
    
    private ArrayList<Bloque> empanadas;
    
    private int desplazamiento=10;
    
    public Bola(Mundo mundo, BitMap bitMap, Barra barra, ArrayList<Bloque> empanadas) {
        super(mundo, bitMap);
        this.mundo=mundo;
        this.barra=barra;
        this.empanadas=empanadas;
        reiniciarBola();
    }
    
    public void reiniciarBola(){
        barra.reiniciarBarra();
        mundo.pausarJuego();
        x=mundo.SCREEN_WIDTH/2-this.getWidth()/2;
        y=mundo.SCREEN_HEIGHT-mundo.SCREEN_HEIGHT/5-Recursos.barra.getHeight();
        desplazamiento=(int)(Math.random()*10-5+1)+5;
        dx=5;
        dy=desplazamiento;
        
        
    }

    @Override
    public void actualizar(long deltaTime) {

        tickTime += deltaTime; 
        if (tickTime > TICK) {            
            tickTime -= TICK;
            mover();            
        }   
    
    }
    
    public void mover(){
        int xa=x,ya=y; 
        this.addX(dx);
        this.addY(dy);
  
        //COMPROBAR SI CHOCA CON LOS BORDES DE LA PANTALLA
        if (this.x<0){//borde izdo
             x=xa; dx=desplazamiento;//
        }
        if (this.x+this.getWidth()>mundo.SCREEN_WIDTH){//borde dcho
             x=xa; dx=-desplazamiento;
        }
        if (this.y+this.getHeight()>mundo.SCREEN_HEIGHT){//borde inferior
             
            reiniciarBola();
            barra.setVida(barra.getVida()-1);
           
        }
        if (this.y<0){//borde superior
             y=ya; dy=desplazamiento;
        }
    }

    @Override
    public void recibirGolpe(Actor actor) {
        
        // actor es la barra o bloque
        
        if(actor instanceof Barra){
            dy=-desplazamiento;
            System.out.println("Choque de BOLA con barra");
            
            if(chocaBarraDerecha()){
                System.out.println("CHOcaaaa barra derechaaaaa");
                dx=desplazamiento;
            }
            if(chocaBarraIzquierda()){
                dx=-desplazamiento;
            }
        }
        if(actor instanceof Bloque){
            
            puntos=barra.getPuntos()+100;
            barra.setPuntos(puntos);
            
            // Si golpea con la parte arriba
            if(chocaArriba()){
                dy=-desplazamiento;
            }
            
            // Si golpea con la parte abajo
            if(chocaAbajo()){
                dy=desplazamiento;
            }
            
            // Si golpea con la parte izquierda
            if(chocaIzquierda()){
                dx=-desplazamiento;
            }
            
            // Si golpea con la parte derecha
            if(chocaDerecha()){
                dx=desplazamiento;
            }
            
            System.out.println("Choque de BOLA con bloque");
            actor.setVisible(false);
            actor.setActivo(false);
            
            this.empanadas.remove((Bloque)actor);
        }
        
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(this.x+5,this.y+5, this.getWidth()-8, this.getHeight()-8);
    }
    
    public boolean chocaArriba(){
        boolean hayColision=false;
        
        for (int i = 0; i < empanadas.size(); i++) {
            if(this.getBounds().intersects(empanadas.get(i).getBoundsArriba())){
                hayColision=true;
            }
        }
        
        
        return hayColision;
    }
    public boolean chocaAbajo(){
        boolean hayColision=false;
        
        for (int i = 0; i < empanadas.size(); i++) {
            if(this.getBounds().intersects(empanadas.get(i).getBoundsAbajo())){
                hayColision=true;
            }
        }
        
        return hayColision;
    }
    public boolean chocaIzquierda(){
        boolean hayColision=false;
        
        for (int i = 0; i < empanadas.size(); i++) {
            if(this.getBounds().intersects(empanadas.get(i).getBoundsIzquierda())){
                hayColision=true;
            }
        }
        
        return hayColision;
    }
    public boolean chocaDerecha(){
        boolean hayColision=false;
        
        for (int i = 0; i < empanadas.size(); i++) {
            if(this.getBounds().intersects(empanadas.get(i).getBoundsDerecha())){
                hayColision=true;
            }
        }
        
        return hayColision;
    }
    
    public boolean chocaBarraDerecha(){
        boolean hayColision=false;
        if(!this.getBounds().intersects(barra.getBoundsDerecha())){
            hayColision=true;
        }
        return hayColision;
    }
    
    public boolean chocaBarraIzquierda(){
        boolean hayColision=false;
        if(this.getBounds().intersects(barra.getBoundsIzquierda())){
            hayColision=true;
        }
        return hayColision;
    }
    
}
