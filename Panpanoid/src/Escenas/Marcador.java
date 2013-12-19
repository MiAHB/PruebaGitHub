package Escenas;

import FRAMEWORK.LOGICA.ActorTexto;
import FRAMEWORK.LOGICA.Game;
import java.awt.Color;

public class Marcador {
    private Game game;
    private Escena escena;
    private ActorTexto vidasJugador;
    private ActorTexto puntosJugador;
    
    public Marcador(Game game,Escena escena){
        this.game=game;
        this.escena=escena;
        
        vidasJugador=new ActorTexto(game,"");
        vidasJugador.setPosition(20,100);
        vidasJugador.setTamanio(20);
        vidasJugador.setColor(Color.red);
        escena.addActor(vidasJugador); 
        
        puntosJugador=new ActorTexto(game,"");
        puntosJugador.setPosition(20,130);
        puntosJugador.setTamanio(20);
        puntosJugador.setColor(Color.red);
        escena.addActor(puntosJugador); 
        
    }
            
    public void actualizar() {
        
        vidasJugador.setTexto("PUNTOS --> "+String.valueOf(escena.getMundo().getBarra().getPuntos()));
        puntosJugador.setTexto("VIDAS --> "+escena.getMundo().getBarra().getVida()+" vidas");
        
        
    }
}
