/**
 *
 * @author Rafael Pérez
 * DESARROLLO DE APLICACIONES MULTIPLATAFORMAS
 * COLEGIO STMA TRINIDAD DE SALAMANCA
 */

package FRAMEWORK.INPUT;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyBoardHandler  implements KeyListener{
    private int tecla;
    private boolean teclaPulsada;
    public KeyBoardHandler(){
        teclaPulsada=false;
    }
    @Override
    public synchronized void keyTyped(KeyEvent e) {
    }

    @Override
    public synchronized void keyPressed(KeyEvent e) {
        teclaPulsada=true;
        tecla=e.getKeyCode();
    }

    @Override
    public synchronized void keyReleased(KeyEvent e) {

    }
    public synchronized int getTecla(){
        teclaPulsada=false;
        return tecla;
    }
    public synchronized boolean isPulsada(){
        return teclaPulsada;
    }
    
}
