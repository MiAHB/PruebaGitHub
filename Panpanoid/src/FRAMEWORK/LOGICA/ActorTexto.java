/**
 *
 * @author Rafael Pérez
 * DESARROLLO DE APLICACIONES MULTIPLATAFORMAS
 * COLEGIO STMA TRINIDAD DE SALAMANCA
 */
package FRAMEWORK.LOGICA;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class ActorTexto extends Actor{
    private String cadena;
    private Color color;
    private int tamanio;
    private Font fuente;

    public ActorTexto(Game game,String cadena){
        super(game);
        activo=false;
        this.cadena=cadena;
        tamanio=30;
    }

    public void setPosition(int x, int y){
        this.x = x; this.y = y;  
    }
    public void setTamanio(int tamanio){
        this.tamanio=tamanio;
    }
    public void setColor(Color color){
        this.color=color;
    }
    public void setTexto(String cadena){
        this.cadena=cadena;
    }
    @Override
    public void dibujar(Graphics g){
        g.setColor(color);
        fuente=new Font("Arial",Font.BOLD,tamanio);
        g.setFont(fuente);
        g.drawString(cadena, x, y);
    }

    @Override
    public void recibirGolpe(Actor actor) {
        
    }

    @Override
    public void actualizar(long deltaTime) {
        
    }
    
}
