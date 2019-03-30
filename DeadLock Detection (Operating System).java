package deadlock;

import java.io.*; 
import java.util.*; 

public class DeadLock {

    static HashMap<Integer, Character> hmap;
    static HashMap<Character, Integer> rhmap;
    
    public static void main(String args[]) 
    { 
        
        hmap = new HashMap<Integer, Character>();
        rhmap = new HashMap<Character, Integer>();
       

        hmap.put(0, 'R');
        hmap.put(1, 'A');
        hmap.put(2, 'C');
        hmap.put(3, 'S');
        hmap.put(4, 'D');
        hmap.put(5, 'T');
        hmap.put(6, 'B');
        hmap.put(7, 'E');
        hmap.put(8, 'F');
        hmap.put(9, 'U');
        hmap.put(10, 'V');
        hmap.put(11, 'W');
        hmap.put(12, 'G');
        
        rhmap.put('R',0);
        rhmap.put('A',1);
        rhmap.put('C',2);
        rhmap.put('S',3);
        rhmap.put('D',4);
        rhmap.put('T',5);
        rhmap.put('B',6);
        rhmap.put('E',7);
        rhmap.put('F',8);
        rhmap.put('U',9);
        rhmap.put('V',10);
        rhmap.put('W',11);
        rhmap.put('G',12);
        
        
        Graph g = new Graph(13); 
        
  
        g.addEdge(rhmap.get('R'), rhmap.get('A')); 
        g.addEdge(rhmap.get('A'), rhmap.get('S')); 
        g.addEdge(rhmap.get('C'), rhmap.get('S')); 
        g.addEdge(rhmap.get('F'),rhmap.get('S') ); 
        g.addEdge(rhmap.get('W'),rhmap.get('F') ); 
        g.addEdge(rhmap.get('D'),rhmap.get('S') );  
        g.addEdge(rhmap.get('D'),rhmap.get('T') ); 
        g.addEdge(rhmap.get('U'),rhmap.get('D') ); 
        g.addEdge(rhmap.get('G'),rhmap.get('U') ); 
        g.addEdge(rhmap.get('V'), rhmap.get('G'));
        g.addEdge(rhmap.get('E'),rhmap.get('V') );
        g.addEdge(rhmap.get('T'), rhmap.get('E'));
        g.addEdge(rhmap.get('B'), rhmap.get('T'));
  
  
        g.DFS(); 
    } 
    
    static class Graph{
    
        private int V;   

           private LinkedList<Integer> adj[]; 

           Graph(int v) 
           { 
               V = v; 
               adj = new LinkedList[v]; 
               for (int i=0; i<v; ++i) 
                   adj[i] = new LinkedList(); 
           } 

           void addEdge(int v, int w) 
           {         
               adj[v].add(w);   

           } 

           List<String> abc = new ArrayList<String>(); 
           
           void DFSUtil(int v,boolean visited[]) 
           { 
               visited[v] = true; 
               
               abc.add(hmap.get(v)+"");

               Iterator<Integer> i = adj[v].listIterator(); 
               
               
               List<String> c = new ArrayList<String>(); 
               
               while (i.hasNext()){ 
                   int n = i.next();
                   c.add(""+hmap.get(n));
                   if (!visited[n]) 
                       DFSUtil(n,visited); 
               }
               
               for(int k=0;k<c.size();k++ ){
                   //System.out.print(c.get(k)+" ");
                   abc.add(c.get(k)+"");
               }
               //System.out.println(" ");
               
               if(abc.size()>1 && abc.get(0).equalsIgnoreCase(abc.get(abc.size()-1))){
                        System.out.print("Dead Lock on Cycle: ");
                        for(int k=0;k<abc.size();k++ ){
                        System.out.print(abc.get(k)+" ");
                    }
               }
               
               abc.clear();
                              
               
           } 

           void DFS(){ 
               
               boolean visited[] = new boolean[V]; 

               for (int i=0; i<V; ++i) 
                   if (visited[i] == false) 
                       DFSUtil(i, visited); 
           }
    }    
}


