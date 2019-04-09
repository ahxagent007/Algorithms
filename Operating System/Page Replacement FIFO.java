package paging;


public class Paging {

    public static void main(String[] args) {
        // TODO code application logic here
        //fifo
        
        int reference_string[] = {7,0,1,2,0,3,0,4,2,3,0,3,0,3,2,1,2,0,1,7,0,1};
        int frame = 3;
        
        int pageFault = 0;
        int pageHit = 0;
        
        int ram [][] = new int[frame][2];
        
        for(int i=0;i<frame;i++){
            ram[i][0] = -1;
            ram[i][1] = 0;
        }
        
        for(int i=0;i<reference_string.length;i++){
            
            int ramIndex = -1;
            
            for(int j=0;j<frame;j++){
                if(ram[j][0] == -1){
                    ram[j][0] = reference_string[i]; 
                    ram[j][1]++;
                    ramIndex = -2;
                    pageFault++;
                    print(ram, frame);
                    break;
                }
            }
            
            if(ramIndex == -2 ){
                continue;
            }else{
                for(int j=0;j<frame;j++){
                    if(ram[j][0] == reference_string[i]){
                        pageHit++;
                        ramIndex = j;
                        ram = updateRam(ram,frame);
                        print(ram, frame);
                        break;
                    }
                }
                
                if(ramIndex < 0){
                    int c_max = -1;
                    int c_max_index = -1;
                    
                    for(int j=0;j<frame;j++){
                        if(c_max < ram[j][1]){
                            c_max = ram[j][1];
                            c_max_index = j;
                        }
                    }                    
                    ram[c_max_index][0] = reference_string[i];
                    ram[c_max_index][1] = 0;
                    pageFault++;
                    updateRam(ram, frame);
                    print(ram, frame);
                    
                }
                
            }       
            
        }

        System.out.println("Page Fault : "+pageFault);
        System.out.println("Fault percentage : "+(pageFault*100/reference_string.length)+" %");
        //System.out.println("Page Hit : "+pageHit);
        
        
    }
    
    public static int[][] updateRam(int ram[][], int frame) {
        for(int i=0;i<frame;i++){
            ram[i][1]++;
        }
        
        return ram;
    }
    
    public static void print(int ram[][], int frame) {
        for(int i=0;i<frame;i++){
            System.out.print(ram[i][0] + " ");
        }
        System.out.println("");
        
    }
    
    
    
}
