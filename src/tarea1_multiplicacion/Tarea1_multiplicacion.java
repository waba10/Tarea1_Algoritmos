/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea1_multiplicacion;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author HP PC
 */
public class Tarea1_multiplicacion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException{
        // TODO code application logic here
        ArrayList<Integer> number_one = new ArrayList<Integer>();
        ArrayList<Integer> number_two = new ArrayList<Integer>();
        int aux=20, aux2=0, multiplicacion=0;
        int[] numeros = new int[20];
        Random rand= new Random();
        int n1= rand.nextInt(10);
        int n2= rand.nextInt(10);
        for (int i = 0; i < 10; i++) {
            number_one.add(rand.nextInt(10));    
        }
        for (int i = 0; i < 10; i++) {
            number_two.add(rand.nextInt(10));  
        }
        for (int i = 0; i < 20; i++) {
            numeros[i]=0;
        }
        System.out.println(number_one);
        System.out.println(number_two);
        long inicio = System.currentTimeMillis();
        Thread.sleep(2000);
 
        for (int i = 9; i >= 0; i--) {
            aux--;
            aux2=aux;
            for (int j = 9; j >= 0; j--) {                
                multiplicacion= number_one.get(i)*number_two.get(j);                
                //System.out.println("resultado de :" + number_one.get(i) + "x "+number_two.get(j)+ " es "+ multiplicacion );
                if(numeros[aux2]+multiplicacion>9){
                    //System.out.println("entra al primer if ya que la suma de "+ numeros[aux2]+ "y " + multiplicacion + "es "+ (numeros[aux2]+multiplicacion) );
                    int residuo=(numeros[aux2]+multiplicacion)%10;
                    //System.out.println("el residuo es " + residuo);
                    
                    
                    int division=(numeros[aux2]+(multiplicacion))/10;
                    numeros[aux2]=residuo;
                    /*System.out.println("el valor que queda guardado es "+ (numeros[aux2]));
                    System.out.println("el resultado de division es " + division);*/
                    int aux3=aux2-1;
                    if(numeros[aux3]+division>9){
                        int suma=numeros[aux3]+division;
                            /*System.out.println("otro if, y el valor de la division es "+ division);
                            System.out.println("el valor en numeros[aux3] es "+ numeros[aux3]);
                            System.out.println("el valor de la suma es "+ suma);*/
                            int residuo2=suma%10;
                            
                            //System.out.println("el valor que queda guardado es "+ residuo2);
                            division=(suma)/10;
                            numeros[aux3]=residuo2;
                            //System.out.println("el valor que queda para seguir sumando es " + division);
                            aux3=aux3-1;
                            numeros[aux3]+=division;
                        while(numeros[aux3]>9){
                            int residuo3= numeros[aux3]%10;
                            division=numeros[aux3]/10;
                            numeros[aux3]=residuo3;
                            aux3=aux3-1;
                            numeros[aux3]+=division;
                            
                            /*int suma=numeros[aux3]+division;
                            System.out.println("otro if, y el valor de la division es "+ division);
                            System.out.println("el valor en numeros[aux3] es "+ numeros[aux3]);
                            System.out.println("el valor de la suma es "+ suma);
                            int residuo2=suma%10;
                            
                            System.out.println("el valor que queda guardado es "+ residuo2);
                            division=(suma)/10;
                            numeros[aux3]=residuo2;
                            System.out.println("el valor que queda para seguir sumando es " + division);
                            aux3=aux3-1;
                            numeros[aux3]+=division;*/
                        }
                    }
                    else{
                        numeros[aux2-1]=numeros[aux2-1]+division;
                    }                    
                }
                else{
                    numeros[aux2]+=multiplicacion;
                }
                
                aux2--;
            }
        }
        long fin = System.currentTimeMillis();
        double tiempo = (double) ((fin - inicio)/1000);
         
        
        
        System.out.print("La respuesta es: ");
        for (int i = 0; i < 20; i++) {
            System.out.print(numeros[i]);
        }
        System.out.println("");
        System.out.println(tiempo +" segundos");
    }
    
}
