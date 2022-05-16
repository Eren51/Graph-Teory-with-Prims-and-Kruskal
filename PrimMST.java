import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class PrimMST extends Graph{
	
	static int[][] weight;
	private static long startTime = System.currentTimeMillis();
	static int a , b , w , i ,e , v;
	int cost;
	int[] key;
	int[] included;

	public PrimMST(int v) {
		super(v);
		cost = 0;
		key = new int[v];
		for(int i = 0; i<v; i++)	key[i] = Integer.MAX_VALUE;
		included = new int[v];
	}
	
	int extractMin(){
		int min=Integer.MAX_VALUE;
		int index=-1;
		for(int i=0;i<v;i++){
			if(included[i]==0 && key[i]<min){
				min = key[i];
				index=i;
			}
		}
		return index;
	}
	
	void Prim(int[][] weight, int start){
		key[start]=0;
		vertex[start].parent=null;
		int u = extractMin();
		while(u!=-1){
			cost+=key[u];
			for(Vertex ver:vertex[u].adj){
				if(included[ver.data]==0 && weight[u][ver.data]<key[ver.data]){
					ver.parent=vertex[u];
					key[ver.data]=weight[u][ver.data];
				}
			}
			included[u]=1;
			u=extractMin();
		}
		System.out.println("Cost: "+cost);
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
  		 	v =Integer.parseInt(tokens[0]);
  		 	e =Integer.parseInt(tokens[1]);
  		 	weight = new int[v][v];
  		 	PrimMST g = new PrimMST(v);
  		 	
           while ((str = buffer.readLine()) != null) {
        	   	  
        		 if(i<e) {
        	     String[] tokenn;
        		 tokenn=str.split(" "); 
        		 a=Integer.parseInt(tokenn[0]);
        		 b=Integer.parseInt(tokenn[1]);
        		 w=Integer.parseInt(tokenn[2]);
        		

        		 weight[a][b]=w;
        		 weight[b][a]=w;
        		 g.addEdge(a, b);
        		 i++;
        		 }
        		 
        	 }
           int start = 0;
           g.Prim(weight,start);
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
		    String filename= "C:\\Users\\Eren\\Desktop\\311\\Prims_vertex_"+args[0]+".txt";
		   FileWriter fw = new FileWriter(filename,true); //the true will append the new data
		   //fw.write(v);
		   fw.write(e+" "+(endTime - startTime)+"\n");//appends the string to the file
		   fw.close();
		}
		catch(IOException ioe)
		{
		    System.err.println("IOException: " + ioe.getMessage());
		}
	}
}