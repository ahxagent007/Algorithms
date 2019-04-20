package bankers;


public class Bankers {


    public static void main(String[] args) {
        
        int Process = 7;
        int Resource [] = {20, 19, 16}; 
        int Available [] = new int[3];
        int Allocation [][] = {{1, 1, 1}, {2, 3, 3}, {3, 0, 5}, {2, 2, 0}, {3, 1, 0}, {1, 2, 1}, {1, 1, 1}};
        int Max [][] = {{7, 5, 6}, {5, 8, 5}, {9, 2, 8}, {8, 8, 6}, {14, 4, 5}, {4, 6, 3}, {2, 9, 2}};
        //int Need [][] = {{6, 4, 5}, {3, 5, 2}, {6, 2, 3}, {6, 6, 6}, {11, 3, 5}, {3, 4, 2}, {1, 8, 1}};
        int Need [][] = new int[Process][3];
        
        for(int i=0;i<Process;i++){
            Need[i][0] = Max[i][0] - Allocation[i][0];
            Need[i][1] = Max[i][1] - Allocation[i][1];
            Need[i][2] = Max[i][2] - Allocation[i][2];
        }
        
        System.out.println("NEED MATRIX:");
        for(int i=0;i<Process;i++){
            System.out.println(" "+Need[i][0]+" "+Need[i][1]+" "+Need[i][2]);
        }
        
        int a = 0, b = 0, c = 0;
        
        for(int i=0;i<Process;i++){
            a += Allocation[i][0];
            b += Allocation[i][1];
            c += Allocation[i][2];
        }
        
        Available [0] =  Resource[0] - a;
        Available [1] =  Resource[1] - b;
        Available [2] =  Resource[2] - c;
        
        System.out.println("Available Resource : "+Available[0]+" "+Available[1]+" "+Available[2]);
        
        int processDone[] = {-1, -1, -1, -1, -1, -1, -1};
        int i = 0 , tempP = 0;
        
        while(true){
            int index = 0;
            if(i>=Process){
                index = i%Process;
                
            }else{
                index = i;
            }
            //System.out.println("index = "+index+" tempP = "+tempP);
            System.out.println("Available Resource : "+Available[0]+" "+Available[1]+" "+Available[2]);
            if(processDone[index] == -1){
                if(Need[index][0]<= Available[0] && Need[index][1]<= Available[1] && Need[index][2]<= Available[2]){
                    processDone [index] = 1;
                    Available[0] += Allocation[index][0];
                    Available[1] += Allocation[index][1];
                    Available[2] += Allocation[index][2];
                    tempP++;
                    i++;
                    System.out.print("P"+(index+1));
                }else{
                    i++;
                }
            }else{
                i++;
            }
            
            if(tempP >= Process ){
                break;
            }
            System.out.print(" >> ");
        }
        
    }
    
}
