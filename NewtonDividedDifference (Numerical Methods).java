package numericalmethods_newton.divide.difference;

import java.util.Scanner;

public class NumericalMethods_newtonDivideDifference {

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        
        System.out.println("Enter the term you want to get input: ");
        int n = kb.nextInt();
        
        int x[] = new int[10];
        int y[] = new int[10];
        
        System.out.println("Enter the value of x & y: ");
        
        for(int i=01;i<=n;i++){
            x[i] = kb.nextInt();
            y[i] = kb.nextInt();
        }
        
        System.out.println("Enter the value for which you want to find the value of y: ");
        int k = kb.nextInt();
        
        int difference[] = new int[10];
        int firstPart = y[1],secondPart = 0,commonPart, ek = 1;
        
        do{
            for(int i=1; i<=(n-1);i++){
                difference[i] = (y[i+1]-y[i])/(x[i+ek]-x[i]);
                y[i] = difference[i];
            }
            commonPart = 1;
            for(int i=1;i<=ek;i++){
                commonPart *= (k-x[i]);
            }
            secondPart += (y[1] * commonPart);
            n--;
            ek++;
        }while(n!=0);
        firstPart += secondPart;
        System.out.println(firstPart);
        
    }
    
}
