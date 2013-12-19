/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Escenas;

import FRAMEWORK.GRAFICOS.Sprite;
import arkanoid.Mundo;
import arkanoid.Recursos;
/**
 *
 * @author Diego
 */
public class EscenaPrincipal extends Escena {
    private Mundo mundo;
    private Marcador marcador;
    private Encabezado encabezado;

    public EscenaPrincipal(Mundo mundo) {
        super(mundo);
        this.mundo=mundo;
        
        mundo.getBarra().setVisible(false);
        mundo.getBola().setVisible(false);
    }
    
    @Override
    public void iniciar() {
        Sprite spFondo=new Sprite(Recursos.fondoPrincipal);
        mundo.stageManager.setFondo(spFondo);
        
    }

    @Override
    public Escena siguienteEscena() {
        return new Escena1(mundo);
    }

    @Override
    public void actualizar() {
       
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
