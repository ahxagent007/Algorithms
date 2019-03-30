
public class Numerical_PolynomialRegression {

    public static void main(String[] args) {
        
        int n = 4;
        int poly = 2;
        //double matrix[][] = {{1,1,-1,9},{0,1,3,3},{-1,0,-2,2}};
        //double matrix2[][] = {{1,1,-1,9},{0,1,3,3},{-1,0,-2,2}};
        double matrixArray[][] = new double[poly+1][4];
        double x[] = {1,2,3,4};
        double y[] = {6,11,18,27};
        double ex[] = {80,40,-40,-120,-200,-208};
        double ey[] = {6.47,6.24,5.72,5.09,4.30,3.33};
        
        double co[] = new double[poly+1];
        
        //matrixArray(ex, ey, matrixArray,poly+1,n);
        matrixArray(x, y, matrixArray,poly+1,n);
        Gauss(matrixArray,poly+1,co);
        
        System.out.println("");
        for(int i=0;i<poly+1;i++){
            System.out.print(co[i]+" ");
        }
        
    }
    
    public static void matrixArray( double x[],double y[],double matrixArray[][],int m,int n){
        
        double pow;
        double yArray[] = new double[m];
    
        for(int i=0;i<m;i++){
            for(int j=0;j<m;j++){
                matrixArray[i][j] = 0.0;
                pow = i+j;
                for(int k=0;k<n;k++){
                    matrixArray[i][j] += Math.pow(x[k], pow);
                    //System.out.println(matrixArray[i][j]);
                }
            }
        }
        
        /*for(int i=0;i<matrixArray.length;i++){
            for(int j=0;j<matrixArray[0].length;j++){
                System.out.print(matrixArray[i][j]+" ");
            }
            System.out.println("");
        }*/
        
        for(int i=0;i<m;i++){
            yArray[i] = 0.0;
            pow = i;
            for(int j=0;j<n;j++){
                yArray[i] += y[j]* Math.pow(x[j], pow);
            }
            matrixArray[i][3] = yArray[i];
        }


    }    
    
    
    public static void Gauss(double matrixArray[][], int m, double coefficient[]){
    
        for(int i=0;i<m;i++){
            for(int j=0;j<m;j++){
                if(j>i){
                    double c = matrixArray[j][i]/matrixArray[i][i];
                    for(int k=0;k<=m;k++){
                        matrixArray[j][k] -= c*matrixArray[i][k];
                    }
                }
            }
        }
    
        /*for(int i=0;i<matrixArray.length;i++){
            for(int j=0;j<=matrixArray.length;j++){
                System.out.print(matrixArray[i][j]+" ");
            }
            System.out.println("");
        }*/     
        
        
        coefficient[m-1] = matrixArray[m-1][m+1-1]/matrixArray[m-1][m-1];
        
        for(int i=m-1;i>=0;i--){
            double sum = 0.0;
            for(int j=i+1;j<=m-1;j++){
                sum += matrixArray[i][j]*coefficient[j];
            }
            coefficient[i] = (matrixArray[i][m+1-1]-sum)/matrixArray[i][i];
        }
    }
}
