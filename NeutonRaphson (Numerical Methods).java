
public class NumericalMethod_NewtonRaphson {
    
    static double f(double x){
        //return x*x - 4*x - 10;
        return x*x - 3*x + 2;
    }
    
    static double fprime(double x){
        //return 2*x - 4;
        return 2*x - 3;
    }

    public static void main(String[] args) {

        double x1 = 0.0 , x2 = 0.0;
        
        do{
            
            x1 = x2;
            x2 = x1 - (f(x1)/fprime(x1));         
            
        }while(Math.abs((x2-x1)/(x2)) > 0.001);
        
        System.out.println(x2);

    }
    
}
