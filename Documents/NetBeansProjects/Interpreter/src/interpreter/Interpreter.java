/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package interpreter;

import java.util.ArrayList;
import java.io.*;

/**
 *
 * @author oscar
 */
public class Interpreter {
    String expresion[];
    Expresion raiz, temp, temp1;
    
    public void operacion(String Archivo) {
        leerArchivo(Archivo);
        
        
        raiz=getExpresion(expresion[0]);
        /*
        if(isOperador(expresion[2])){
            temp=getExpresion(expresion[2]);
            raiz.setRight(temp);
        }else{
            raiz.setRight(getExpresion(expresion[2]));
            raiz.getRight().setValue(expresion[2]);
        }
        if(isOperador(expresion[1])){
            temp=getExpresion(expresion[1]);
            raiz.setLeft(temp);
        }else{
            raiz.setLeft(getExpresion(expresion[1]));
            raiz.getLeft().setValue(expresion[1]);
        }*/
        int n=1;
        
        temp=raiz;
        for(int i=1;i<expresion.length;i++){
            
            if(n==2){
                if(isOperador(expresion[i])){
                    
                    temp.setRight(getExpresion(expresion[i]));
                    temp=temp.getRight();
                }else{
                    
                    temp.setRight(new ExpresionNumber());
                    temp.getRight().setValue(expresion[i]);
                }
                n=1;
            }else{
                if(n==1){
                   if(isOperador(expresion[i])){
                        temp.setLeft(getExpresion(expresion[i]));
                        temp=temp.getLeft();
                    }else{
                        temp.setLeft(getExpresion(expresion[i]));
                        temp.getLeft().setValue(expresion[i]);
                    }   
                n=2;
                }
            
            }
        }
       
       
       System.out.println(raiz.evaluate());
    }
    
    public boolean isOperador(String caracter){
        boolean operador;
        if(caracter.contains("+") || caracter.contains("-") || caracter.contains("*") || caracter.contains("/")){
            operador=true;
        }else{
            operador=false;
        }
        return operador;
    }
                
    public void leerArchivo(String ruta){
        String auxiliar="", temp="";
        try{
            FileReader leer=new FileReader(ruta);
            BufferedReader buffer=new BufferedReader(leer);
            while((temp=buffer.readLine())!=null){
                auxiliar=auxiliar+temp;
            }
            
            buffer.close();
        }catch(IOException ex){
            System.out.println("No funciona");
        }
        expresion=auxiliar.split(" ");
        String aux;
        
        for(int i=0;i<(int)(expresion.length/2);i++){
            aux=expresion[i];
            expresion[i]=expresion[expresion.length-(i+1)];
            expresion[expresion.length-(i+1)]=aux;
            
        }
        for(int i=0;i<expresion.length;i++){
            //System.out.println(expresion[i]+" ");
        }
        
    }
    
    public Expresion getExpresion(String expresion){
        Expresion exp, temp = null;
        
        if(isOperador(expresion)){
            if(expresion.contains("+")){
                
                temp=new ExpresionPlus();
            }
            if(expresion.contains("-")){
                
                temp=new ExpresionMinus();
            }
            if(expresion.contains("*")){
                
                temp=new ExpresionPor();
            }
            if(expresion.contains("/")){
                
                temp=new ExpresionDivide();
            }
        }
        else{
            
            temp=new ExpresionNumber();
        }
        exp=temp;
        return exp;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Interpreter it=new Interpreter();
        it.operacion("./src/expresion.in");
    }
    
}
