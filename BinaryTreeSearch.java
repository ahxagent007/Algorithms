public class BinarySearchAlgoDS {

    public static void main(String[] args) {        
        int []arr = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23};
        int n =21;        
        int a = BinarySearchAlgo(arr,n);
        if(a == -1){
            System.out.println("Not Found");	
	}else{
            System.out.println("Found at Index: "+a);
	}
    }    
    static public int BinarySearchAlgo(int []arr,int item){
        int low = 0;
        int high = arr.length-1;                
        while(low <= high){
            int xMid = (low+high)/2;            
            if(item == arr[xMid]){
                return xMid;
            }else if(item > arr[xMid]){
                low = xMid + 1;
            }else if(item < arr[xMid]){
                high = xMid - 1;
            }
        }        
        return -1;
    }
}
