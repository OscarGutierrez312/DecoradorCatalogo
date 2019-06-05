/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Decorador;

import java.awt.Graphics;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author oscar
 */
public class Decorado1 extends Decorado{
    

    public Decorado1(JPanel decorado){
        super(decorado);
    }    
    
    @Override
    public JPanel decorar() {
        decorado.add(new JLabel());
        return decorado;
    }
    
}
