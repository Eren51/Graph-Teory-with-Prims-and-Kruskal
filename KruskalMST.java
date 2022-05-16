import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Checker implements Comparator<int[]>{
	public int compare(int[] o1, int[] o2) {
		return Integer.compare(o1[2], o2[2]);
	}
}

public class KruskalMST extends Graph{
	private static long startTime = System.currentTimeMillis();
	static int a , b , w , i ,e , v;

	int cost;
	boolean cycle;

	public KruskalMST(int v) {
		super(v);
		cost = 0;
		cycle = false;
	}
	
	void Kruskal(int[][] edges){
		for(int i = 0; i<edges.length; i++){
			int a = edges[i][0], b = edges[i][1], w = edges[i][2];
			if(a==b)	continue;//loop
			addEdge(a, b);
			if(!isCycle()){
				//System.out.println(a+" "+b+" "+w+" added");
				cost+=w;
			}else{
				vertex[a].adj.removeLast();
				vertex[b].adj.removeLast();
			}
		}
		System.out.println("Cost: "+cost);
	}
	
	void reset(){
		for(int i = 0; i<v; i++)
			vertex[i].color = 0;
		cycle = false;
	}
	
	boolean isCycle(){
		reset();
		for(int i=0;i<v && !cycle;i++){
	        if(vertex[i].color==0)
	            DFSVisit(i);
	    }
		return cycle;
	}
	
	void DFSVisit(int u){
		vertex[u].color=1;
		for(Vertex v: vertex[u].adj){
			if(cycle)	break;
			if(v.color==2){//cycle
				cycle = true;
				return;
			}
			if(v.color==0){
				DFSVisit(v.data);
			}
		}
		vertex[u].color=2;
	}
	
	public static void main(String[] args){
		try (BufferedReader buffer = new BufferedReader(
                new FileReader("C:\\Users\\Eren\\Desktop\\311\\graph1.txt"))) {

           String str;

           // Condition check via buffer.readLine() method
           // holding true upto that the while loop runs
           i=0;
           str = buffer.readLine();
           String[] tokens;  
           tokens=str.split(" ");
  		   int v =Integer.parseInt(tokens[0]);
  		   int e =Integer.parseInt(tokens[1]);
		int[][] edges = new int[e][3];
		//edge from a[0] to a[1] with weight a[2]
		while ((str = buffer.readLine()) != null) {
  	   	  
   		 if(i<e) {
   	     String[] tokenn;
   		 tokenn=str.split(" "); 
   		 a=Integer.parseInt(tokenn[0]);
   		 b=Integer.parseInt(tokenn[1]);
   		 w=Integer.parseInt(tokenn[2]);
			edges[i][0] = a;
			edges[i][1] = b;
			edges[i][2] = w;
			i++;
		}
		
		}
		Arrays.sort(edges,new Checker());
		KruskalMST g = new KruskalMST(v);
		g.Kruskal(edges);
		buffer.close();
		}
	       

	       // Catch block to handle the exceptions
	       catch (IOException ev) {

	           // Print the line number here exception occured
	           // using printStackTrace() method
	           ev.printStackTrace();
	       }
		    long endTime = System.currentTimeMillis();
		    
			System.out.println("It took " + (endTime - startTime) + " milliseconds");
			try
			{
			    String filename= "C:\\Users\\Eren\\Desktop\\311\\Kruskal_vertex_"+args[0]+".txt";
			    FileWriter fw = new FileWriter(filename,true); //the true will append the new data
			    fw.write(args[1]+" "+(endTime - startTime)+"\n");//appends the string to the file
			    fw.close();
			}
			catch(IOException ioe)
			{
			    System.err.println("IOException: " + ioe.getMessage());
			}
		
	}
}
/*
SAMPLE CASE
5 8
0 1 1
0 2 4
0 4 2
2 4 3
1 4 3
3 1 3
3 2 1
3 4 2
*/
