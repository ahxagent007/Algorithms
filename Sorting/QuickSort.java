

public class QuickSort {
    public static void main(String[] args) {        
        int Arr[] = {4,2,1,5,3};
        
        QS(Arr,0,Arr.length-1);
        
        for(int i=0;i<Arr.length;i++){
            System.out.print(Arr[i]+" ");                    
        }
        System.out.println("");

    }    
    public static void QS(int a[],int s,int e){
        if(s<e){
            int p = partition(a, s, e);
            QS(a, s, p-1);          
            QS(a, p+1, e);
        }
    }
    public static int partition(int a[],int s,int e){
        int x = a[e];
        int i = s-1;

        int j;
        for(j=s;j<e;j++){
            if(a[j]<=x){
                i++;

                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }
        int temp = a[i+1];
        a[i+1] = a[e];
        a[e] = temp;

        return i+1;
    }    
}
