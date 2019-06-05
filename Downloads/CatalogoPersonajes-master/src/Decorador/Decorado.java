/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Decorador;

import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author oscar
 */
public abstract class Decorado implements Component{
    protected JPanel decorado;
    
    public Decorado(JPanel componente){
        this.decorado=componente;
    }
}
