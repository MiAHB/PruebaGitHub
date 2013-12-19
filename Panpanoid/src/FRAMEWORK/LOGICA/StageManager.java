/**
 *
 * @author Rafael Pérez
 * DESARROLLO DE APLICACIONES MULTIPLATAFORMAS
 * COLEGIO STMA TRINIDAD DE SALAMANCA
 */
package FRAMEWORK.LOGICA;

import FRAMEWORK.GRAFICOS.Sprite;
import java.awt.Color;
import java.awt.Graphics2D;

public class StageManager {
    private Game game;   
    private Graphics2D g;
    private Sprite spFondo;
    public StageManager(Game game){
        this.game=game;
        this.g=game.getGraficos();           
    }
    public void dibujar(){
        Actor item;
        game.actorManager.rewind();
        if (spFondo==null){
            g.setColor(Color.black);
            g.fillRect(0,0, game.SCREEN_WIDTH, game.SCREEN_HEIGHT);
        }
        else
            spFondo.dibujar(g);
        while((item=game.actorManager.current())!=null){
            item.dibujar(g);//en el buffer
            game.actorManager.next();
        }    
    }   
    public void setFondo(Sprite fondo){
        spFondo=fondo;
    }
}
