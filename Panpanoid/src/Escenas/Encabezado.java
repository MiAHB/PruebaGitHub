
package Escenas;

import FRAMEWORK.LOGICA.ActorTexto;
import FRAMEWORK.LOGICA.Game;
import java.awt.Color;

 
public class Encabezado {

     ActorTexto titulo1;
     ActorTexto titulo2;
     ActorTexto numeroEscena;
    
    public Encabezado(Game game, Escena escena){
        titulo1=new ActorTexto(game,"PANPANOID, EL ATAQUE DE LOS PANES");
        titulo1.setPosition(game.SCREEN_WIDTH/2-280,70);
        titulo1.setColor(Color.CYAN);
        escena.addActor(titulo1);
        
        titulo2=new ActorTexto(game,"Destruye todas las empanadas");
        titulo2.setPosition(game.SCREEN_WIDTH/2-220,130);
        titulo2.setColor(Color.yellow);
        escena.addActor(titulo2);
        
        numeroEscena=new ActorTexto(game,"");
        numeroEscena.setPosition(20,30);
        numeroEscena.setTamanio(20);
        numeroEscena.setColor(Color.white);
        escena.addActor(numeroEscena); 
        
    }
    
    public void actualizarEscena(String texto) {
        numeroEscena.setTexto(texto);
        
    }
}
