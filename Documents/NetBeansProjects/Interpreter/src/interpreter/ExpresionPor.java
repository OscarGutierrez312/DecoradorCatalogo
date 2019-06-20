/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package interpreter;

/**
 *
 * @author oscar
 */
public class ExpresionPor extends Expresion{
    @Override
    public int evaluate() {
       // System.out.println("por: "+this.left.evaluate() * this.right.evaluate());
        return this.left.evaluate() * this.right.evaluate();
    }
    
}
