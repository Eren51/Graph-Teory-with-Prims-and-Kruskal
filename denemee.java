
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class denemee {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method sSystem.out.println(args[0]);
		/*System.out.println("Please enter vertex size");
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		System.out.println("Min edge should be "+ (N-1));
		System.out.println("Max edge should be "+ N*(N-1)/2   );
		int e = sc.nextInt();
		*/
		String NN=args[0];
		String ee=args[1];
		int N=Integer.parseInt(NN);
		int e=Integer.parseInt(ee);
		String str = Integer.toString(N) +" "+Integer.toString(e)+"\n";
	    BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\Eren\\Desktop\\311\\graph1.txt"));
	
	    writer.write(str);
		int R =2;
		
		int[] intArray= new int[N] ;
		for (int i = 0; i < intArray.length; i++) {
		    intArray[i] = 0;
		    
		}
		
		List<int[]> combinations = generate(N, R);
		int initial=1;
		for(int i=0;i<e;) {
			Random rand = new Random();
			int randomIndex = rand.nextInt(combinations.size()); 	
			int[] a = combinations.get(randomIndex);
			
			if(checkEMPTY(intArray)) {
				if(initial==1) {
					intArray[a[0]]=1;
			 		intArray[a[1]]=1;
			        String randomElement = Integer.toString(a[0])+" "+Integer.toString(a[1])+" 1"+"\n";
			        combinations.remove(randomIndex);
			        System.out.printf(randomElement);
			        writer.write(randomElement);
			        i++;
			        initial++;
				}
				else {
					if(intArray[a[0]]==1 ^ intArray[a[1]]==1) {
					intArray[a[0]]=1;
			 		intArray[a[1]]=1;
			        String randomElement = Integer.toString(a[0])+" "+Integer.toString(a[1])+" 1"+"\n";
			        combinations.remove(randomIndex);
			        System.out.printf(randomElement);
			        writer.write(randomElement);
			        i++;
					}
				}
			 		
			 		
			 		
			    }
			else {
				String randomElement = Integer.toString(a[0])+" "+Integer.toString(a[1])+" 1"+"\n";
		        combinations.remove(randomIndex);
		        System.out.printf(randomElement);
		        writer.write(randomElement);
				i++;
			 	}
		}
		/*for (int[] combination : combinations) {
		    System.out.println(Arrays.toString(combination));
			
		    String a = Arrays.toString(combination);
			a=a.substring(1, a.length()-1);
			String [] elements=a.split(",");
			
		    writer.write(elements[0]+elements[1]+" "+"1"+"\n");
		}
		System.out.printf("generated %d combinations of %d items from %d ", combinations.size(), R, N);*/
	    writer.close();
	}

	private static long factorial(int v) {
		long result = 1;

        for (long factor = 2; factor <= v; factor++) {
            result *= factor;
        }

        return result;
	}
	private static boolean checkEMPTY(int[] a) {
		int i=0;
		
		boolean deneme = false;
		while(i<a.length) {
			if(a[i]!=1) {
				deneme=true;
				i++;
			}
			else {
				i++;
			}
				
		}
		
		return deneme;
	}
	/*private static void helper(List<int[]> combinations, int data[], int start, int end, int index) {
	    if (index == data.length) {
	        int[] combination = data.clone();
	        combinations.add(combination);
	    } else if (start <= end) {
	        data[index] = start;
	        helper(combinations, data, start + 1, end, index + 1);
	        helper(combinations, data, start + 1, end, index);
	    }
	}
	public static List<int[]> generate(int n, int r) {
	    List<int[]> combinations = new ArrayList<>();
	    helper(combinations, new int[r], 0, n-1, 0);
	    return combinations;
	}*/
	public static List<int[]> generate(int n, int r) {
	    List<int[]> combinations = new ArrayList<>();
	    int[] combination = new int[r];

	    // initialize with lowest lexicographic combination
	    for (int i = 0; i < r; i++) {
	        combination[i] = i;
	    }
	    
	    while (combination[r - 1] < n) {
	        combinations.add(combination.clone());

	         // generate next combination in lexicographic order
	        int t = r - 1;
	        while (t != 0 && combination[t] == n - r + t) {
	            t--;
	        }
	        combination[t]++;
	        for (int i = t + 1; i < r; i++) {
	            combination[i] = combination[i - 1] + 1;
	        }
	    }

	    return combinations;
	}
}





