/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Escenas;

import FRAMEWORK.LOGICA.Actor;
import arkanoid.Bloque;
import arkanoid.Mundo;
import java.util.ArrayList;

/**
 *
 * @author Diego
 */
public abstract class Escena {
    
    private Mundo mundo;
    private ArrayList<Actor> actoresEscena;
    ArrayList<Bloque> empanadas=new ArrayList();
    
    protected boolean finEscena;
    
    public Escena(Mundo mundo){
        this.mundo=mundo;
        actoresEscena=new ArrayList<Actor>();
    }
    
    public abstract void finalizar();
    
    public boolean isFin(){
        return finEscena;
    }
    
    public void addActor(Actor actor){
        actoresEscena.add(actor);
        mundo.actorManager.add(actor);
    }
    
    public void quitarActoresEscena(){
        for (int i=0;i<actoresEscena.size();i++){
            mundo.actorManager.del(actoresEscena.get(i));
        }
    }
    
    public Mundo getMundo() {
        return mundo;
    }
    
    public abstract void iniciar();
    
    public abstract void actualizar();
    
    public abstract Escena siguienteEscena();
    
}
