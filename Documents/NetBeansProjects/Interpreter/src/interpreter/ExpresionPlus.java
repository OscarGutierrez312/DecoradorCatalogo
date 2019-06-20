/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interpreter;

/**
 *
 * @author daza
 */
public class ExpresionPlus extends Expresion{

    @Override
    public int evaluate() {
        //System.out.println("suma: "+this.left.evaluate() + this.right.evaluate());
        return this.left.evaluate() + this.right.evaluate();
    }
    
}
