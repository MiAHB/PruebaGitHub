/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Escenas;

import FRAMEWORK.GRAFICOS.Sprite;
import FRAMEWORK.LOGICA.ActorTexto;
import arkanoid.Mundo;
import arkanoid.Recursos;

/**
 *
 * @author Diego
 */
public class EscenaGameOver extends Escena {
    private ActorTexto tituloFin;
    private Mundo mundo;
    
    private Marcador marcador;
    private Encabezado encabezado;
    
    public EscenaGameOver(Mundo mundo){
        super(mundo);
        this.mundo=mundo;
        
        for (int i = 0; i < mundo.getEmpanadas().size(); i++) {
            mundo.getEmpanadas().get(i).setVisible(false);
        }
        
        mundo.getBola().setVisible(false);
        mundo.getBarra().setVisible(false);
    }

    @Override
    public void iniciar() {
        Sprite spFondo=new Sprite(Recursos.fondo3);
        mundo.stageManager.setFondo(spFondo);
        
    }

    @Override
    public Escena siguienteEscena() {
        return null;
    }

    @Override
    public void actualizar() {
        
        if (mundo.getKeyBoardHandler().isPulsada()){           
           this.finEscena=true;
           finalizar();
        }
        
    }

    @Override
    public void finalizar() {
        this.finEscena=true;
        quitarActoresEscena();
        
    }
    
    public Marcador getMarcador() {
        return marcador;
    }

    public Encabezado getEncabezado() {
        return encabezado;
    }
}
