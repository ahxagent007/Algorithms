package numericalmethods_lagrange.interpolation;

import java.util.Scanner;

public class NumericalMethods_LagrangeInterpolation {


    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        
        System.out.println("Enter the term you want to get input: ");
        int n= kb.nextInt();
        double x[] = new double[n];
        double y[] = new double[n];
        System.out.println("Enter the values of x & y: ");
        for(int i=0; i<n; i++){
            x[i] = kb.nextDouble();
            y[i] = kb.nextDouble();
        }
        
        System.out.println("Enter the value for which you want to find the value of y: ");
        double k = kb.nextDouble();
        double fnl = 0;
        for(int i=0;i<n;i++){
            double a = 1;
            double b = 1;
            for(int j=0;j<n;j++){
                if(j!=i){
                    a *=(k-x[j]);
                    b *= (x[i]-x[j]);
                }
            }
            fnl += (a/b)*y[i];
        }
        System.out.println("Value of y: "+fnl);
    }    
}

/*
4
5 12
6 13
9 14
11 16
10
*/
