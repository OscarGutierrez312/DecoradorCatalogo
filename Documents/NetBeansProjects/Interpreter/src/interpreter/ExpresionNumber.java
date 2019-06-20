/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interpreter;

/**
 *
 * @author daza
 */
public class ExpresionNumber extends Expresion{

    @Override
    public int evaluate() {
        return Integer.parseInt(this.value);
    }
    
}
