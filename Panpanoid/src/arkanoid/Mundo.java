/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package arkanoid;

import Escenas.Escena;
import Escenas.Escena1;
import Escenas.Escena2;
import Escenas.EscenaGameOver;
import Escenas.EscenaPrincipal;
import FRAMEWORK.LOGICA.Game;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

/**
 *
 * @author Diego
 */
public class Mundo extends Game {

    private Barra barra;
    private Bola bola;
    
    ArrayList<Bloque> empanadas=new ArrayList();
    Escena escenaActual;
    
    
    @Override
    public void principal() {
        
        this.setName("PANPANOID");
        
        barra=new Barra(this, Recursos.barra);
        this.actorManager.add(barra);
        
        bola=new Bola(this, Recursos.bola, barra, empanadas);
        this.actorManager.add(bola);
        
        barra.setVida(3);
        barra.setPuntos(0);
        
        
        EscenaPrincipal escenaPrincipal=new EscenaPrincipal(this);
        escenaPrincipal.iniciar();
        
        
        escenaActual=escenaPrincipal;
        
        while(!this.isFin()){
            if(empanadas.isEmpty() && !(escenaActual instanceof EscenaGameOver) && !(escenaActual instanceof EscenaPrincipal)){
                escenaActual.finalizar();
            }
            
            if (escenaActual.isFin()){
                escenaActual.finalizar();
                escenaActual=escenaActual.siguienteEscena();
                
                if (escenaActual==null){
                    this.terminarJuego();
                }
                else{ 
                    escenaActual.iniciar();
                    bola.reiniciarBola();
                }
            } 
            
            
            if(this.getKeyBoardHandler().isPulsada()){
               
                if(escenaActual instanceof EscenaPrincipal){
                    escenaActual.finalizar();
                }
                this.reanudarJuego();
               
            }
            
    
            if(barra.getVida()==0){
                escenaActual=new EscenaGameOver(this);
                escenaActual.iniciar();
                
                for (int i = 0; i < actorManager.getListaActores().size(); i++) {
                    actorManager.del(actorManager.getListaActores().get(i));
                }
            }
            if(escenaActual!=null)
                escenaActual.actualizar();
            
            this.actualizar();
            
        }
        
    }
    
    public Barra getBarra() {
        return barra;
    }
    
    public Bola getBola() {
        return bola;
    }
    
    public ArrayList<Bloque> getEmpanadas() {
        return empanadas;
    }
    
}
