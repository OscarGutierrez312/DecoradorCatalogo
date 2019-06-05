/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Decorador;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author oscar
 */
public class Decorado1 extends Decorado implements Runnable{
    private boolean decorado;
    private  Canvas canvas1;
    private Graphics g;
    private Graphics decoracion;
    private BufferedImage dobleBuffer;
    private Thread dibujo;
    public Decorado1(){
        super();
        dibujo=new Thread(this);
        canvas1=new Canvas();
        canvas1.setSize(180, 345);
        dobleBuffer=new BufferedImage(canvas1.getWidth(), canvas1.getHeight(), BufferedImage.TYPE_INT_ARGB);
        g=dobleBuffer.getGraphics();
        decoracion=canvas1.getGraphics();
        
        personaje.add(canvas1);
    }

    
       
    
    
    @Override
    public JPanel decorar() {
        
        return personaje;
    }

    @Override
    public void run() {
        while(true){
            dibujar();
        }
    }

    public Thread getDibujo() {
        return dibujo;
    }

    public void setDibujo(Thread dibujo) {
        this.dibujo = dibujo;
    }
    
    
    private void dibujar() {
        g.drawImage(anim.getImage(), 0, 0, canvas1);
        System.out.print("Dibujando");
        if(decorado){
            g.drawImage(new ImageIcon("./img/fondodecorador.jpg").getImage(),0,0,null);
        }
        decoracion.drawImage(dobleBuffer,0,0,canvas1);
    }
    
}
