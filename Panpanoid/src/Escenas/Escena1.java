/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Escenas;

import FRAMEWORK.GRAFICOS.Sprite;
import arkanoid.Barra;
import arkanoid.Bloque;
import arkanoid.Bola;
import arkanoid.Mundo;
import arkanoid.Recursos;

/**
 *
 * @author Diego
 */
public class Escena1 extends Escena {

    private Mundo mundo;
    
    private Bloque bloque;
    
    private Marcador marcador;
    private Encabezado encabezado;
    
    public Escena1(Mundo mundo) {
        super(mundo);
        this.mundo=mundo;
        
        Sprite spFondo=new Sprite(Recursos.fondo);
        mundo.stageManager.setFondo(spFondo);
        
        encabezado=new Encabezado(mundo,this);
        marcador=new Marcador(mundo,this);
        marcador.actualizar();
        
        mundo.getBarra().setVisible(true);
        mundo.getBola().setVisible(true);
    }
    

    @Override
    public void iniciar() {
       
        for (int i = 0; i < 14; i++) {
            bloque=new Bloque(mundo, Recursos.bloque);
            mundo.actorManager.add(bloque);
            bloque.iniciar(bloque.getWidth()*i , 200);
            mundo.getEmpanadas().add(bloque);
        }
        
        for (int i = 0; i < 14; i++) {
            bloque=new Bloque(mundo, Recursos.bloque);
            mundo.actorManager.add(bloque);
            bloque.iniciar(bloque.getWidth()*i , 200+bloque.getHeight());
            mundo.getEmpanadas().add(bloque);
        }
        
    }

    @Override
    public Escena siguienteEscena() {
        return new Escena2(mundo);
    }

    @Override
    public void finalizar() {
        this.finEscena=true;
        quitarActoresEscena();
    }

    @Override
    public void actualizar() {
        
        this.getMarcador().actualizar();
        this.getEncabezado().actualizarEscena("Escena 1");
        
        if(mundo.getBarra().getVida()==0){
            mundo.terminarJuego();
        }
     
    }
    
    public Marcador getMarcador() {
        return marcador;
    }

    public Encabezado getEncabezado() {
        return encabezado;
    }
    
}
