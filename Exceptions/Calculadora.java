package calculadora;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author tulio.henry
 */
public class Calculadora{

     public static double calcular(double a, double b, char operacao)
             throws InvalidOperationException{
         
         switch(operacao){
             case '+':
                return a+b; 
             case '-':
                 return a-b;
             case '*':
                 return a*b;
             case '/':
                 if(b == 0){
                     throw new ArithmeticException("Divisao por Zero!");
                 }
                 return a/b;
             default: 
                 throw new InvalidOperationException("Operaçao inválida: "+ operacao);
         }
     }
     
}
