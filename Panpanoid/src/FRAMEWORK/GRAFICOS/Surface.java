/**
 *
 * @author Rafael Pérez
 * DESARROLLO DE APLICACIONES MULTIPLATAFORMAS
 * COLEGIO STMA TRINIDAD DE SALAMANCA
 */
package FRAMEWORK.GRAFICOS;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;

public class Surface extends Canvas {   
    private Graphics2D grafico;
    public  BufferStrategy strategy;       

    public Surface(int ancho, int alto){
        setBounds(0,0,ancho,alto); 
        setIgnoreRepaint(true);
    }
    public BufferStrategy crearBufferStrategy(){
        createBufferStrategy(2);
        strategy=getBufferStrategy();
        grafico=(Graphics2D)strategy.getDrawGraphics();
        grafico.setColor(Color.yellow); 
        return strategy;
    }
} 