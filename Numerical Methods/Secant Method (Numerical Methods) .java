package numericalmethods_secant;

public class NumericalMethods_Secant {

    static double f(double x){
        //return x*x - 4*x - 10;
        return x*x - 3*x + 2;
    }
    
    public static void main(String[] args) {
        
        double x1 = 10.0,x2 = -10.0,x3;
        
        double error = 0.001;
        
        do{
            double f1 = f(x1);
            double f2 = f(x2);
            
            x3 = (x1*f2 - x2*f1)/(f2 - f1);
            
            x1 = x2;
            x2 = x3;
        
        }while(Math.abs((x2-x1)/(x2)) > error);
        
        System.out.println(x3);
        
        
    }
    
}
